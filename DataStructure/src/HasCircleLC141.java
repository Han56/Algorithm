/**
 * @author han56
 * @description 【力扣141题】判断链表 是否含有环
 * @create 2021/9/18 下午4:05
 */
public class HasCircleLC141 {

    public static void main(String[] args) {

    }

    static class LisNode{
        int val;
        LisNode next;
        LisNode(int x){
            val = x;
            next = null;
        }
    }
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

}
