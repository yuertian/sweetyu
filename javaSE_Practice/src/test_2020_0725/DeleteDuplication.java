package test_2020_0725;

public class DeleteDuplication {
    public ListNode deleteDuplication1(ListNode pHead){
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = new ListNode(-1);
        head.next = pHead;

        ListNode pre = head;
        ListNode cur = pre.next;

        while (cur != null) {
            // 找到重复的起始位置
            while (cur.next != null && cur.val != cur.next.val) {
                cur = cur.next;
                pre = pre.next;
            }
            // 找到重复的范围
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;//此时，cur指向重复节点的最后一个
            }
            // 去重，且重复节点不保留
            if (pre.next != cur) {
                // 如果保留，则是 pre.next = cur;
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return head.next;
    }

    public ListNode deleteDuplication2(ListNode pHead){
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        ListNode cur = pHead;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                } // 循环结束cur指向重复节点的最后一个
                cur = cur.next; //删除最后一个重复节点
            } else {
                // 将不重复的节点尾插到新链表
                tail.next = new ListNode(cur.val);
                tail = tail.next;
                cur = cur.next;
            }
        }
        return head.next;
    }
}
