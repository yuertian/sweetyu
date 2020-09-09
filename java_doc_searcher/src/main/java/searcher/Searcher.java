package searcher;

import common.DocInfo;
import index.Index;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Searcher {
    private Index index = new Index();

    public Searcher() throws IOException {
        index.build("F:\\proDoc\\raw_data.txt");
    }

    public List<Result> search(String query) {
        // 1.分词：针对查询词进行分词
        List<Term> terms = ToAnalysis.parse(query).getTerms();

        // 2.触发：针对查询词的分词结果依次查找倒排索引，得到一大堆相关的 docID
        // 这个ArrayList 中就保存了每个分词结果对应的倒排拉链的整体结果
        ArrayList<Index.Weight> allTokenResult = new ArrayList<>();
        for (Term term : terms) {
            // 此时这个word 的内容已经全为小写了，在索引中的内容也是小写的
            String word = term.getName();
            List<Index.Weight> invertedList = index.getInverted(word);
            if (invertedList == null) {
                continue;
            }
            allTokenResult.addAll(invertedList);
        }

        // 3.排序：按照权重对所有的倒排拉链的结果进行降序排序
        // 匿名内部类
        allTokenResult.sort(new Comparator<Index.Weight>() {
            @Override
            public int compare(Index.Weight o1, Index.Weight o2) {
                // 如果 o1 < o2，返回 < 0 的数
                // 如果 o1 > o2，返回 > 0 的数
                // 如果 o1 = o2，返回 0
                return o2.weight - o1.weight; // 降序
                // return o1.weight - o2.weight; //升序
            }
        });

        // 4.包装结果：根据刚才查找到的docID 在正排索引中查找 docInfo，包装成 Result对象
        ArrayList<Result> results = new ArrayList<>();
        for (Index.Weight weight : allTokenResult) {
            // 根据weight 中包含的docID 找到对应的 DocInfo 对象
            DocInfo docInfo = index.getDocInfo(weight.docId);
            Result result = new Result();
            result.setTitle(docInfo.getTitle());
            result.setShowUrl(docInfo.getUrl());
            result.setClickUrl(docInfo.getUrl());
            // GenDesc 方法是从正文中摘取一段信息。
            // 根据当前这个词，找到它在正文中出现的位置，再把这个位置周围的文本都获取到
            result.setDesc(GenDesc(docInfo.getContent(), weight.word));
            results.add(result);
        }
        return results;
    }

    // 这个方法是根据当前的词，提取正文中的一部分内容作为描述
    private String GenDesc(String content, String word) {
        // 查找 word 在 content中出现的位置
        // 此时word里的内容已经小写了，content里的内容还是大小写都有
        int firstPos = content.toLowerCase().indexOf(word);
        if (firstPos == -1) {
            // 极端情况下，某个词只在标题中出现，而没有在正文中出现，所以找不到
            return "";
        }
        // 从 firstPos 开始往前找50个字符，作为描述开始，如果前面不足50个，就从头开始
        int descBeg = firstPos < 50 ? 0 : firstPos - 50;
        // 从描述开始往后找150个字符作为整个描述内容，如果后面不足150个，就把剩下的都算上
        if (descBeg + 160 > content.length()) {
            return content.substring(descBeg);
        }
        return content.substring(descBeg, descBeg + 150) + "...";
    }
}
