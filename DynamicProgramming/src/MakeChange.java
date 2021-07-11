import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author han56
 * @description 功能描述：动态规划零钱找零问题
 * @create 2021/7/10 下午9:03
 */
public class MakeChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount=11;
        System.out.println(digui(amount,coins));
    }

    public static int digui(int amount,int[] coins){
        int[] dp = new int[amount+1];
        for (int i=0;i<amount+1;i++){
            dp[i]=amount+1;
        }
        //base case
        dp[0]=0;
        //最外层for循环所有状态的所有取值
        for (int i=0;i<dp.length;i++){
            //内层for循环求所有选择的最小值
            for (int coin:coins){
                if (i-coin<0)
                    break;
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return (dp[amount] == amount+1)?-1:dp[amount];
    }



}
