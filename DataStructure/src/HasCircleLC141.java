/**
 * @author han56
 * @description 【力扣141题】判断链表 是否含有环
 * @create 2021/9/18 下午4:05
 */
public class HasCircleLC141 {

    public static void main(String[] args) {

        LisNode lisNode = new LisNode(1);
        lisNode.next = new LisNode(2);
/*        lisNode.next.next = new LisNode(3);
        lisNode.next.next.next = new LisNode(4);
        lisNode.next.next.next.next = new LisNode(5);*/

        LisNode res = deleteBackNNode(lisNode,2);

        outListNode(res);

    }

    public static void outListNode(LisNode head){
        LisNode fast=head;
        while (fast!=null){
            System.out.println(" "+fast.val);
            fast = fast.next;
        }
    }

    static class LisNode{
        int val;
        LisNode next;
        LisNode(int x){
            val = x;
            next = null;
        }
    }
    /*
    * 判断是否链表含有环
    * */
    public static boolean hasYuan(LisNode head){
        LisNode fast ,slow;
        fast = slow = head;
        while (fast!=null&&fast.next!=null){
            //快指针每次走两步
            fast = fast.next.next;
            //慢指针每次走一步
            slow = slow.next;
            if (slow ==  fast) return true;
        }
        return false;
    }

    /*
    * 删除无环链表中的倒数第n个结点
    * */
    public static LisNode deleteBackNNode(LisNode head,int n){
        LisNode first = head;
        //走n步
        for(int i=0;i<n;i++){
            first = first.next;
        }
        if(first==null){
            return head.next;
        }else{
            LisNode second = head;
            while(first.next!=null){
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
        }
        return head;
    }

}
