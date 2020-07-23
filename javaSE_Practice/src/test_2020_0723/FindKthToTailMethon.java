package test_2020_0723;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class FindKthToTailMethon {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k < 0) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (k > 0 && fast != null) {
            k--;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return k > 0 ? null : slow;
    }
}
