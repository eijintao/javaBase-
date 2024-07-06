package com.java.base.mathAndDataStructures;

/**
 * mjt 梅锦涛
 * 2024/3/4
 *
 * @author mjt
 */
public class LinkedTest {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        // 创建一个简单的链表 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 反转链表
        head = reverseList(head);

        // 打印反转后的链表
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}