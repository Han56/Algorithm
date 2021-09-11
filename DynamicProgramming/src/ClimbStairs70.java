/**
 * @author han56
 * @description 力扣70题 爬楼梯【动态规划】
 * @create 2021/9/10 下午7:39
 */
public class ClimbStairs70 {


    public static void main(String[] args) {
        int n = 45;
        int[] memo = new int[n+1];
        System.out.println(digui(memo,n));
    }


    public static int digui(int[] memo,int n){
        //base case
        if (n==0){
            return 0;
        }else if (n==1){
            return 1;
        }else if (n==2){
            return 2;
        }else {
            if (memo[n]!=0)
                return memo[n];
            memo[n] = digui(memo,n-1)+digui(memo,n-2);
        }
        return memo[n];
    }


}
