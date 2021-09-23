import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author han56
 * @description 198【动态规划】打家劫舍
 * @create 2021/9/11 下午7:18
 */
public class RobLeetCode198 {

    public static void main(String[] args) {
        int[] nums = {2,7,9,12,1};
        System.out.println(sum(nums));
    }

    public static int sum(int[] nums){
        int length = nums.length;
        //base case
        if (length==1){
            return nums[0];
        }else if (length==2){
            return Math.max(nums[0],nums[1]);
        }else if (length==0){
            return 0;
        }
        int[] cash = new int[length+1];
        cash[0] = 0;
        cash[1] = nums[0];
        //状态转移方程
        for (int i=2;i<=length;i++){
            cash[i] = Math.max(nums[i-1] + cash[i-2],cash[i-1]);
        }
        return cash[length];
    }


}
