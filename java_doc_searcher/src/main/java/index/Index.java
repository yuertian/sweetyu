package index;

import common.DocInfo;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Index {
    // word 这个词在 docID 文档中对应的权重weight是多少
    static public class Weight {
        public String word;
        public int docId;
        // weight 生成公式：10 * 标题中出现的 word 次数 + 正文中 word 出现的次数
        public int weight;
    }

    // 索引类需要包含两方面内容：正排索引，倒排索引
    // 正排索引是 docId => DocInfo 直接把 docID 作为数组下标就可以了
    private ArrayList<DocInfo> forwardIndex = new ArrayList<DocInfo>();
    // 倒排索引 词 => 一组docID
    // 不光能得到每个词在哪些文档中出现过，还想知道这个词在该文档中的权重
    private HashMap<String, ArrayList<Weight>> invertedIndex = new HashMap<String, ArrayList<Weight>>();

    // Index 类需要提供的方法：
    // 查正排
    public DocInfo getDocInfo(int docId) {
        return forwardIndex.get(docId);
    }

    // 查倒排
    public ArrayList<Weight> getInverted(String term) {
        return invertedIndex.get(term);
    }

    // 构建索引，把 raw_data.txt 文件内容读取出来，加载到内存上面的树结构中
    // 索引模块中最复杂的部分
    public void build(String inputPath) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("build start!");

        // 1. 打开文件，并按行读取文件内容
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(inputPath)));
        // 2. 读取到每一行
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            // 3. 构造正排索引的过程：按照 \3 来切分，切分结果构造成一个 DocInfo 对象，并加入到正排索引中
            DocInfo docInfo = buildForward(line);
            // 4. 构造倒排索引的过程：把 DocInfo 对象里面的内容进一步处理，构造出倒排
            buildInverted(docInfo);
            System.out.println("Build " + docInfo.getTitle() + " done!");
        }

        long finishTime = System.currentTimeMillis();
        System.out.println("build finish!    time: " + (finishTime - startTime) + "ms" );
    }

    private void buildInverted(DocInfo docInfo) {
        class WordCnt {
            public int titleCount;
            public int contentCount;

            public WordCnt(int titleCount, int contetCount) {
                this.titleCount = titleCount;
                this.contentCount = contetCount;
            }
        }
        HashMap<String, WordCnt> wordCntHashMap = new HashMap<String, WordCnt>();
        //  前 4 个操作都是为了给后面计算权重做铺垫
        // 针对 DocInfo 中的 title 和 Content 进行分词，再根据分词结果构建出 Weight对象，更新倒排
        // 1. 先针对标题分词
        List<Term> titleTerms = ToAnalysis.parse(docInfo.getTitle()).getTerms();
        // 2. 遍历分词结果，统计标题中每个词出现的次数
        for (Term term : titleTerms) {
            // 此处 word 已经全部被转成小写了
            String word = term.getName();
            WordCnt wordCnt = wordCntHashMap.get(word);
            if (wordCnt == null) {
                // 当前这个词在哈希表中不存在
                wordCntHashMap.put(word, new WordCnt(1, 0));
            } else {
                // 当这个词在哈希表中存在，直接修改 titleCount 即可
                wordCnt.titleCount++;
            }
        }
        // 3. 再针对正文分词
        List<Term> contentTerms = ToAnalysis.parse(docInfo.getContent()).getTerms();
        // 4. 遍历分词结果，统计正文中每个词出现的次数
        for (Term term : contentTerms) {
            String word = term.getName();
            WordCnt wordCnt = wordCntHashMap.get(word);
            if (wordCnt == null) {
                // 当这个词在哈希表中不存在
                wordCntHashMap.put(word, new WordCnt(0, 1));
            } else {
                // 这个词在哈希表中已经存在，修改 contentCount 即可
                wordCnt.contentCount++;
            }
        }// 把这连个部分的结果整理到一个 HashMap 中，词 -> （标题中的出现次数，正文中的出现次数）
        // 5. 遍历 HashMap，依次构建 Weight 对象并更新倒排索引的映射关系
        for (HashMap.Entry<String, WordCnt> entry : wordCntHashMap.entrySet()) {
            Weight weight = new Weight();
            weight.word = entry.getKey();
            weight.docId = docInfo.getDocId();
            // weight = 标题中出现的次数 * 10 + 正文中出现的次数
            weight.weight = entry.getValue().titleCount * 10 + entry.getValue().contentCount;
            // weight 加入到倒排索引中，倒排索引是一个 HashMap，value 就是 Weight 构成的 ArrayList
            // 先根据这个词，找到 HashMap 中对应的 这个 ArrayList，称为 "倒排拉链"
            ArrayList<Weight> invertedList = invertedIndex.get(entry.getKey());
            if (invertedList == null) {
                // 当前这个键值对不存在，就新加入一个键值对即可
                invertedList = new ArrayList<Weight>();
                invertedIndex.put(entry.getKey(), invertedList);
            }
            // 写到这一步，invertedList 就已经是一个合法的 ArrayList 了，就可以把 weight 直接加入即可
            invertedList.add(weight);
        }
    }

    private DocInfo buildForward(String line) {
        // 把这一行文本按照 \3 切分
        // 分出来的三个部分就是一个文档的 标题，URL，正文
        String[] tokens = line.split("\3");
        if (tokens.length != 3) {
            // 发现文件格式有问题
            // 当前场景下有 1w 多个文件，如果某个文件出现格式问题
            // 不应该让某个问题影响到整体的索引构建
            // 此处我们的处理方式仅仅打印日志
            System.out.println("文件格式存在问题：" + line);
            return null;
        }
        // 把新的 docInfo 插入到数组的末尾
        // 如果数组是 0 个元素，新的元素下标就是 0
        DocInfo docInfo = new DocInfo();
        // id 就是正排索引的下标
        docInfo.setDocId(forwardIndex.size());
        docInfo.setTitle(tokens[0]);
        docInfo.setUrl(tokens[1]);
        docInfo.setContent(tokens[2]);
        forwardIndex.add(docInfo);
        return docInfo;
    }
}
