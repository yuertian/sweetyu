import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

public class TestAnsj {
    public static void main(String[] args) {
        String str = "你以为只是蜷缩在看不见的角落里，" +
                "他却提着灯对你说：我可以坐在你旁边吗？";
        // 通过刚才的这个 parse 方法就直接分完，再通过 getTerms 就得到分词结果
        List<Term> terms = ToAnalysis.parse(str).getTerms();
        for (Term term : terms) {
            System.out.println(term.getName());
        }
    }
}
