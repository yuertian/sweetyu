package test_2020_0721;

import java.util.Stack;
import java.util.ArrayList;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PrintListFromTailToHead {
    // 1.利用栈的先进后出原理
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> st = new Stack<>();
        while(listNode != null) {
            st.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!st.empty()) {
            list.add(st.pop());
        }

        return list;
    }

    // 2.逆置数组，前后交换
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
        return list;
    }

    // 3.递归方式
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        printListFromTailToHeadCore(list, listNode);
        return list;
    }
    public void printListFromTailToHeadCore(ArrayList<Integer> list, ListNode listNode) {
        if (listNode == null) {
            return;
        }
        printListFromTailToHeadCore(list, listNode.next);
        list.add(listNode.val);
    }
}
