//import java.util.Deque;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//
///**
// * @author han56
// * @description 功能描述 【力扣20题】有效的括号
// * 首先尝试仅用哈希表解决:无法解决，解答错误，必须使用栈才能解决
// * 官方用栈做
// * @create 2021/9/20 上午10:41
// */
//public class KuohaoIsValidLC20 {
//
//    public static void main(String[] args) {
//        String s = "()[]{}";
//        boolean b = isValid(s);
//        System.out.println(b);
//    }
//
//    public static boolean isValid(String s){
//        int n = s.length();
//        if (n%2!=0){
//            return false;
//        }
//
//        Map<Character,Character> pairs = new HashMap<>(){{
//            put(')','(');put(']','[');put('}','{');
//        }};
//        Deque<Character> stack = new LinkedList<>();
//        for (int i=0;i<n;i++){
//            char c = s.charAt(i);
//            if (pairs.containsKey(c)){
//                if (stack.isEmpty()||stack.peek()!=pairs.get(c)) {
//                    return false;
//                }
//                stack.pop();
//            }else {
//                stack.push(c);
//            }
//        }
//        return stack.isEmpty();
//    }
//
//}
