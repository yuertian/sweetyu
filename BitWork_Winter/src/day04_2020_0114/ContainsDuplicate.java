package day04_2020_0114;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i =0; i < nums.length; i++) {
            if (set.contains(nums[i]) == false) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}
