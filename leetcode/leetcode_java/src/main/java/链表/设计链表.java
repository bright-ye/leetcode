package 链表;

public class 设计链表 {

    class MyLinkedList {

        private ListNode head;

        private ListNode tail;

        /** Initialize your data structure here. */
        public MyLinkedList() {

        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            ListNode node = head;
            for(int i = 0;i<index;i++){
                if(node == null){
                    return -1;
                }
                node = node.next;
            }
            return node.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            ListNode node = new ListNode(val, head);
            head = node;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index == 0){
                addAtHead(val);
                return;
            }
            ListNode pNode = head;
            ListNode qNode = head.next;
            int i = 0;
            for(;i<index;i++){
                if(qNode == null){
                    break;
                }
            }
            if(i < index){
                
            }

        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {

        }
    }

}
