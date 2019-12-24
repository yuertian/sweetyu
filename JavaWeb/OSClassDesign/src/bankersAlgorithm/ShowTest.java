package bankersAlgorithm;

import java.util.Arrays;

public class ShowTest {
    //打印出所有可用资源

    public static void showInit() {

        int[] r = Init.resourceSum();
        System.out.print("系统中各资源总数R = ");
        System.out.println(Arrays.toString(r));

        int[] p = Init.proNeedMax();
        System.out.print("各类进程对各种资源的最大需求数P = ");
        System.out.println(Arrays.toString(r));

    }

}
