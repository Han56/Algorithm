import java.util.Stack;

/**
 * @author han56
 * @description 功能描述：【力扣232】用stack实现queue
 * @create 2021/9/20 下午3:12
 */
public class MyQueue {
    private final Stack<Integer> a;// 输入栈
    private final Stack<Integer> b;// 输出栈

    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.push(x);
    }

    public int pop() {
        // 如果b栈为空，则将a栈全部弹出并压入b栈中，然后b.pop()
        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    public int peek() {
        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}
