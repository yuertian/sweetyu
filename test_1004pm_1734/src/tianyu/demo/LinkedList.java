package tianyu.demo;

class LinkedNode {
    public int data = 0;
    public LinkedNode next = null;

    //通过构造函数设置节点的data值
    public LinkedNode(int data)
    {
        this.data = data;
    }

//    //通过构造方法设置节点的next
//    public LinkedNode(LinkedNode next) {
//        this.next = next;
//    }
}


public class LinkedList {
    private LinkedNode head = null;

    //头插
    public void addFirst(int elem) {
        LinkedNode node = new LinkedNode(elem);
        //先考虑空链表情况
        if (this.head == null) {
            this.head = node;
            return;
        }
        //非空链表，让要插入节点作为链表的头节点
        //节点的具体内容被封装，无法直接赋值
        //node.next = this.head;
        node.next = head;
        this.head = node;
        return;
    }

    //尾插
    public void addLast(int elem) {
        LinkedNode node = new LinkedNode(elem);
        if (this.head == null) {
            this.head = node;
            return;
        }
        LinkedNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //任意指定位置插入
    public void addIndex(int index, int elem) {
        LinkedNode node = new LinkedNode(elem);
        int size = getLength();
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addFirst(elem);
            return;
        }
        if (index == size) {
            addLast(elem);
            return;
        }
        //在指定位置插入元素，先找到当前节点的前一个节点
        LinkedNode prev = getNodePos(index - 1);
        node.next = prev.next;
        prev.next = node;
    }

    public int getLength() {
        int size = 0;
        for (LinkedNode node = this.head;
             node.next != null; node = node.next) {
            size++;
        }
        return size;
    }

    public LinkedNode getNodePos(int index) {
        LinkedNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //判断元素是否在链表中
    public boolean contains(int toFind) {
        for (LinkedNode node = this.head;
             node.next != null; node = node.next) {
            if (toFind == node.data){
                return true;
            }
        }
        return false;
    }

    //按值删除指定节点
    public void toRemoveNum(int toRemove) {
        //首先考虑空链表的情况
        if (this.head == null) {
            return;
        }
        //考虑要删的是头结点情况
        if (head.data == toRemove) {
            this.head = head.next;
            return;
        }
        //按值删，先找到要删节点的前一个节点
        LinkedNode prev = searchPrev(toRemove);
        LinkedNode nodeToRemove = prev.next;
        prev.next = nodeToRemove.next;

    }

    public LinkedNode searchPrev(int toRemove) {
        //判断是否为空链表
        if (this.head == null) {
            return null;
        }
        for (LinkedNode prev = this.head;
             prev.next != null; prev = prev.next) {
            if (toRemove == prev.next.data) {
                return prev;
            }
        }
        return null;
    }

    //按位删除
    public void toRemovePos(int index) {
        int size = getLength();
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            this.head = head.next;
            return;
        }
        LinkedNode prev = getNodePos(index - 1);
        LinkedNode node = prev.next;
        prev.next = node.next;
    }

    public void toRemoveAll(int toRemove) {
        //先处理链表为空的情况
        if (this.head == null) {
            return;
        }
        //要找到删除节点的前一个节点
        LinkedNode prev = head;
        LinkedNode cur = prev.next;
        while (cur != null) {
            if (cur.data == toRemove) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        //最后处理头节点
        if (head.data == toRemove) {
            this.head = head.next;
            return;
        }
    }

    //逆置单链表
    public LinkedNode reverseList() {
        LinkedNode cur = head;
        LinkedNode prev = null;
        while (cur != null) {
            LinkedNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public LinkedNode middleNode() {
        LinkedNode cur = head;
        LinkedNode prev = head;
        while (cur != null || cur.next != null) {
            cur = cur.next.next;
            prev = prev.next;
        }
        return prev;
    }

    public LinkedNode FindKthToTail(int k) {

        int size = getLength();
        LinkedNode cur = head;
        LinkedNode prev = head;
        int steps = size - k;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            prev = prev.next;
            cur = cur.next;
        }
        return prev;
    }

    public void display() {
        //打印链表中的所有元素
        System.out.print("[");
        for(LinkedNode node = this.head;
            node != null; node = node.next){
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = null;
        ListNode newTail = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {//就把cur1插入新链表尾部
                //如果新链表是空链表，就把cur1指向的节点插入新链表的尾部
                if (newHead == null) {
                    newHead = cur1;
                    newTail = cur1;
                    cur1 = cur1.next;
                } else {  //如果不为空，就把cur1指向的节点插入mewTail后面,并更新指向
                    newTail.next = cur1;
                    newTail = newTail.next;
                    cur1 = cur1.next;
                }
            } else {
                //就把cur2指向的节点插入到新链表的尾部
                if (newHead == null) {//新链表为空
                    newHead = cur2;
                    newTail = cur2;
                    cur2 =cur2.next;
                } else {//新链表不为空
                    newTail.next = cur2;
                    newTail = newTail.next;
                    cur2 = cur2.next;
                }
            }
        }
        //判定哪个链表先到达结尾
        if (cur1 == null) {//cur2还有剩余，全部插入新链表尾部
            newTail.next = cur2;
        } else {//cur1还有剩余，全部插入新链表尾部
            newTail.next = cur1;
        }
        return newHead;
    }

    //以x为基准，分割链表
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null) {//链表为空
            return null;
        }
        if (pHead.next == null) {//只有一个元素
            return pHead;
        }
        //创建两个新的链表分别保存比X小和比X大的元素
        ListNode smallHead = new ListNode(-1);//傀儡节点
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        for (ListNode cur = pHead;
             cur != null; cur = cur.next) {
            if (cur.val < x) {
                //插入到smallTail 后面
                smallTail.next= new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                //插入到 bigTail 后面
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        //循环结束，将两个链表连起来
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    //删除所有重复节点，重复节点不保留
    public ListNode deleteDuplication(ListNode pHead)
    {
        //创建一个新的链表来保存不重复的元素
        ListNode newHead = new ListNode(-1);//傀儡节点
        ListNode newTail = newHead;
        ListNode cur = pHead;
        while (cur != null) {//把cur指向的若干个重复节点跳过去
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }//循环结束，cur指向的指向的是这片重复元素的最后一个
                //再多走一步，cur指向的就是不重复的元素了
                cur = cur.next;
            } else {
                //当前节点是不重复节点，把它插入到新链表的尾部
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;//每插入一个节点，cur继续向后走
            }
        }//所有节点遍历结束
        return newHead.next;
    }

    //判断回文
    public boolean chkPalindrome(ListNode A) {
        // write code here
        if (A == null) { //此处假设空链表为回文
            return true;
        }
        if (A.next == null) {//只有一个元素，就是回文
            return true;
        }
        //找中间节点，将后半部分逆置，在进行前后对比
        int len = size(A);
        int steps = len / 2;
        ListNode B = A;
        for (int i = 0; i < steps; i++) {
            B = B.next;
        }//循环结束，B指向链表中间节点
        //以B为头结点，逆置后半段
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                B = cur;//让B指向新链表的头部
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }//逆置结束
        //对比两个链表内容是否相同
        while (B != null) {
            if (A.val != B.val) {
                return false;//对应元素不相等，一定不是回文
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }
    public int size(ListNode A) {
        int size = 0;
        for (ListNode cur = A;
             cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    //判断是否相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //先分别求两个链表的长度
        int lenA = size(headA);
        int lenB = size(headB);
        //让长的先走差值步
        if (lenA > lenB) {
            for (int i = 0; i < (lenA - lenB); i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < (lenB - lenA); i++) {
                headB = headB.next;
            }
        }
        //分别让两个链表同时移动，判断两节点是否相同
        while (headA != null && headB != null) {
            if (headA == headB) {//找到相同节点
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;//循环结束，没有找到
    }

    //判断是否带环
    public boolean hasCycle(ListNode head) {
        //先判断链表是否为空
        if (head == null) {
            return false;
        }
        //创建两个快慢指针，如果带环，fast和slow一定会相遇
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //找到入环的第一个节点
    public ListNode detectCycle(ListNode head) {
        //从链表头部出发，到入环的第一个节点的距离
        //和从快慢指针交汇处，到入环的第一个节点的距离相等
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        //找到快慢指针交汇的节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;//不带环
        }
        //循环结束，快慢指针重合
        //创建两个新的指针从链表头部和快慢指针重合的节点同时移动，直到相遇
        ListNode cur1 = head;
        ListNode cur2 = fast;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //循环结束，cur1和cur2重合
        return cur1;
    }

}
