/**
 * @author han56
 * @description 大数问题
 * @create 2021/9/11 下午4:14
 */
public class MeiTuan1 {

    public static void main(String[] args) {
        String numStr = "22222560355653567544656788765544346578777867654";
        System.out.println(numStr.length());
        System.out.println(helper(numStr));
    }

    public static int helper(String numStr){
        int res=0;
        //base case
        char[] i = numStr.toCharArray();

        for (int x=0;x<i.length-1;x++){
            for (int y=x+1;y<=i.length;y++){
                long num1 = Long.parseLong(numStr.substring(x,y));
                if (22%num1==0)
                    res++;
            }
        }
        return res;
    }

}
