package test_2020_0303;

public class AntiOrder {
    public int count(int[] A, int n) {
        int counts = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j]) {
                    counts++;
                }
            }
        }
        return counts;
    }
}