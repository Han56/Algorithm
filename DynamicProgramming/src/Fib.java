import java.util.ArrayList;

/**
 * @author han56
 * @description 带备忘录功能的斐波那契问题解决方案
 * @create 2021/7/10 下午7:08
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(digui(25));
//        System.out.println(lowToUp(20));
//        System.out.println(theBestLowToUp(20));
    }

    public static int digui(int N){
//        if (N == 0)
//            return 0;
        //初始化数组全为0,在java中，默认都为0
        int[] memo = new int[N+1];
        //进行带备忘录的递归
        return helper(memo,N);
    }

    public static int helper(int[] memo,int n){
        //基本问题
        if (n==0){
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }
        //如果之前已经算过了那么memo[n]不是0，直接返回，节省时间
        if (memo[n]!=0) return memo[n];
        //如果没算过，那么递归计算
        memo[n] = helper(memo,n-1)+helper(memo,n-2)+helper(memo,n-3);
        return memo[n];
    }


    //自低向上的动态规划算法
    public static int lowToUp(int N){
        if (N==0)
            return 0;
        if (N==1||N==2)
            return 1;
        int[] vector = new int[N+1];
        //base case
        vector[1]=vector[2]=1;
        for (int i=3;i<=N;i++){
            vector[i]=vector[i-1]+vector[i-2];
        }
        return vector[N];
    }
    //最好的自低向上动态规划算法
    public static int theBestLowToUp(int N) {
        if (N == 0)
            return 0;
        if (N==1||N==2)
            return 1;
        int prev=1,curr=1;
        for (int i=3;i<=N;i++){
            int sum=prev+curr;
            prev=curr;
            curr=sum;
        }
        return curr;
    }
}
