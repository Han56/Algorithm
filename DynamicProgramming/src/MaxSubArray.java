/**
 * @author han56
 * @description 力扣【53】动态规划 最大子序和
 * @create 2021/9/12 下午8:14
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-1,-2};
        System.out.println(max(nums));
    }

    public static int max(int[] nums){
        int L = nums.length;
        //base case
        if (L==0)
            return 0;
        if (L==1)
            return nums[0];
        int[] dp = new int[L];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i=1;i<L;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(dp[i],res);
        }
        return res;
    }

}
