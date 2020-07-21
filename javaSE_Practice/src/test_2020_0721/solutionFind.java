package test_2020_0721;

public class solutionFind {
    public boolean Find(int target, int [][] array) {
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (target > array[i][j]) {
                //排除当前行
                i++;
            } else if (target < array[i][j]) {
                //排除当前列
                j--;
            } else {
                //找到
                return true;
            }
        }
        return false;
    }
}
