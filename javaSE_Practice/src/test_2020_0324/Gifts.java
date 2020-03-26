package test_2020_0324;

import java.util.Arrays;

public class Gifts {
    public int getValue(int[] gifts, int n) {
        Arrays.sort(gifts);
        int ans = gifts[n/2];
        int num = 0;
        for(int i = 0; i < gifts.length; i++) {
            if(gifts[i] == ans) {
                num++;
            }
        }
        return num <= n/2 ? 0 : ans;
    }
}
