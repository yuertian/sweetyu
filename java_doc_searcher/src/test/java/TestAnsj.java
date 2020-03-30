import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

public class TestAnsj {
    public static void main(String[] args) {
        String str = "TFBOYS的易烊千玺真的太可了，大佬就是大佬，" +
                "中戏双料第一，八千万的粉丝不是吹的";
        // 通过刚才的这个 parse 方法就直接分完，再通过 getTerms 就得到分词结果
        List<Term> terms = ToAnalysis.parse(str).getTerms();
        for (Term term : terms) {
            System.out.println(term.getName());
        }
    }
}
