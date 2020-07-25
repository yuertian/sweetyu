package test_2020_0725;

public class MergeTwoListNode {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode newHead = null;
        ListNode newTail = null;

        while (list1 != null && list2 != null) {
            // 对比两链表的头结点，找到目标节点
            ListNode p = list1.val < list2.val ? list1 : list2;
            //并更新链表头结点
            if (p == list1) {
                list1 = list1.next;
            }
            if (p == list2){
                list2 = list2.next;
            }
            // 将目标节点插入新链表的尾部；
            // 这里要判断新链表是否为空
            // 如果新链表为空，要插入的目标节点就为头结点
            if (newHead == null) {
                newHead = p;
                newTail = p;
            } else {
                // 不为空，直接尾插
                newTail.next = p;
                newTail = p;
            }
        } // 循环结束，至少有一个链表为空
        // 将另一个不为空的链表直接尾插到新链表中
        if (list1 == null) {
            newTail.next = list2;
        } else {
            newTail.next = list1;
        }

        return newHead;
    }
}
