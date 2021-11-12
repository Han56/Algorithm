package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    /*
     * 剑指Offer 第六题：从尾到头打印链表
     * */
    public static int[] reversePrint(ListNode head){


        //base case
        if (head==null)
            return new int[0];
        List<Integer> res = new ArrayList<>();
        ListNode p = head;
        while (p!=null){
            res.add(p.val);
            p=p.next;
        }
        //reverse list
        int[] resArr = new int[res.size()];
        for (int i=0;i< res.size();i++)
            resArr[i]=res.get(res.size()-1-i);
        return resArr;
    }

    @Test
    public void testRotateRight(){
        ListNode lisNode = new ListNode(1);
        lisNode.next = new ListNode(3);
        lisNode.next.next = new ListNode(2);
        int[] res=reversePrint(lisNode);
        for (int k:res)
            System.out.print(k);
    }

}
