package LeetCode_19_1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int x : nums) {
            result ^= x;
        }
        return result;
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }

        public Node copyRandomList(Node head) {
            //先创建一个 HashMap，key 是旧的节点，value 是旧的节点对应的新节点
            HashMap<Node,Node> hashMap = new HashMap<>();
            for (Node cur = head; cur != null; cur = cur.next) {
                //把旧链表的节点依次以键值对的形式插入进来
                hashMap.put(cur, new Node(cur.val, null, null));
            }
            //再次遍历旧的链表，根据刚才得到的HashMap
            //就能够把 next 和 random 都指到正确的地方
            for (Node cur = head; cur != null; cur = cur.next) {
                hashMap.get(cur).next = hashMap.get(cur.next);
                hashMap.get(cur).random = hashMap.get(cur.random);
            }
            return hashMap.get(head);
        }

        public int numJewelsInStones(String J, String S) {
            //创建一个set来保存所有的宝石
            Set<Character> set = new HashSet<>();
            //遍历 J，把所有的宝石加入到set中，
            for (int i = 0; i < J.length(); i++) {
                set.add(J.charAt(i));
            }
            //遍历 S，取出每个字符，看看是不是宝石
            //如果是宝石，就 count += 1
            int count = 0;
            for (int i = 0; i < S.length(); i++) {
                if (set.contains(S.charAt(i))) {
                    count++;
                }
            }
            return count;
        }
        
    }
}
