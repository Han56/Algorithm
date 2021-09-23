/**
 * @author han56
 * @description 动态规划 删除获得点数
 * @create 2021/9/11 下午8:40
 */
public class LeetCode740DeletePoint {

    public static void main(String[] args) {
        int[] nums = {3,4,2};
        System.out.println(sum(nums));
    }

    public static int sum(int[] nums){

        int L = nums.length;
        if (L==0){
            return 0;
        }else if (L==1){
            return nums[0];
        }
        int[] dp = new int[L+1];
        dp[0]=0;
        for (int i=0;i<L;i++){
            int res = 0;
            res = nums[i];
            int low = res-1;
            int high = res+1;
            for (int j=0;j<L;j++){
                if ((nums[j]!=low||nums[j]!=high)&&j!=i){
                    res = res+nums[j];
                }
            }
            dp[i+1] = Math.max(dp[i],res);
        }
        return dp[L];
    }

}
