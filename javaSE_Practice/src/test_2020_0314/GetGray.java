package test_2020_0314;

public class GetGray {
    public String[] getGray(int n) {
        // write code here
        int m = 1 << n;
        String[] str = new String[m];
        if (n == 1) {
            str[0] = "0";
            str[1] = "1";
            return str;
        }
        String[] temp = getGray(n - 1);
        int j = 0;
        for (int i =0; i < m; i++) {
            if (i < m /2) {
                str[i] = "0" + temp[j++];
            } else {
                str[i] = "1" + temp[--j];
            }
        }
        return str;
    }
}
