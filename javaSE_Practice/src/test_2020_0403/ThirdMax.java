package test_2020_0403;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(3, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                if (i1 == Integer.MIN_VALUE) {
                    return -1;
                }
                if (i2 == Integer.MIN_VALUE) {
                    return 1;
                }
                return i1 - i2;
            }
        });
        for (Integer number : nums) {
            if (queue.contains(number)) {
                continue;
            }
            if (queue.size() != 3) {
                queue.offer(number);
            } else if (number > queue.peek()) {
                queue.poll();
                queue.offer(number);
            }
        }
        if (queue.size() == 2) {
            int first = queue.poll();
            int second = queue.poll();
            return second;
        }
        if (queue.size() == 1) {
            return queue.poll();
        }
        return queue.peek();
    }
}


//
//class Solution {
//    public int thirdMax(int[] nums) {
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(3);
//        for (Integer number : nums) {
//            if (queue.contains(number)) {
//                continue;
//            }
//            if (queue.size() != 3) {
//                queue.offer(number);
//            } else if (number > queue.peek()) {
//                queue.poll();
//                queue.offer(number);
//            }
//        }
//        if (queue.size() == 2) {
//            int first = queue.poll();
//            int second = queue.poll();
//            return second;
//        }
//        if (queue.size() == 1) {
//            return queue.poll();
//        }
//        return queue.peek();
//    }
//}
//
////    普通解法
//class Solution {
//    public int thirdMax(int[] nums) {
//        Integer thirdMax = null;
//        Integer secondMax = null;
//        Integer max = null;
//        for (Integer number : nums) {
//            if (number.equals(thirdMax) || number.equals(secondMax) || number.equals(max)) {
//                continue;
//            }
//            if (thirdMax == null || number > thirdMax) {
//                max = secondMax;
//                secondMax = thirdMax;
//                thirdMax = number;
//            } else if (secondMax == null || number > secondMax) {
//                max = secondMax;
//                secondMax = number;
//            } else if (max == null || number > max) {
//                max = number;
//            }
//        }
//        if (max == null) {
//            return thirdMax;
//        }
//        return max;
//    }
//}