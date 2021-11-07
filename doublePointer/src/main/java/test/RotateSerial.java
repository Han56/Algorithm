package test;

import org.junit.Test;

/**
 * @author han56
 * @description 功能描述
 * 【力扣旋转链表系列】
 * @create 2021/11/7 上午9:58
 */
public class RotateSerial {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static void outListNode(ListNode head){
        ListNode fast=head;
        while (fast!=null){
            System.out.println(" "+fast.val);
            fast = fast.next;
        }
    }

    public static ListNode rotateRight(ListNode head,int k){
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    @Test
    public void testRotateRight(){
        ListNode lisNode = new ListNode(1);
        lisNode.next = new ListNode(2);
        lisNode.next.next = new ListNode(3);
/*        lisNode.next.next.next = new ListNode(4);
        lisNode.next.next.next.next = new ListNode(5);*/
        ListNode res = rotateRight(lisNode,2000000000);
        outListNode(res);
    }

}
