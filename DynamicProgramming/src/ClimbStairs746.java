/**
 * @author han56
 * @description 【动态规划】爬楼梯746题
 * @create 2021/9/11 上午8:46
 */
public class ClimbStairs746 {


    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCost(cost));
    }

    public static int minCost(int[] cost){
        int costLength = cost.length;
        if (costLength == 0 || costLength == 1){
            return 0;
        }else if(costLength == 2){
            return Math.min(cost[0],cost[1]);
        }
        int[] dp = new int[costLength+2];
        for (int i=3;i<dp.length;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-2],dp[i-2]+cost[i-3]);
        }
        return dp[costLength+1];
    }



}
