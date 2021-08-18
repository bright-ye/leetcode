package 链表;

import org.junit.Test;

public class 移除链表元素 {

    @Test
    public void test1(){

    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != val) {
                pre = cur;
                cur = cur.next;
            } else {
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
