package test;

import org.junit.Test;

/**
 * @author han56
 * @description 功能描述
 * 两数之和系列问题
 * @create 2021/11/4 上午9:10
 */
public class TwoSumSerial {

    /*
    * 力扣167题  两数之和2——有序数组 【双指针——左右指针】
    * 类似二分查找
    * */
    @Test
    public void twoSum1(){
        int[] nums={2,7,11,15};
        int target = 9;
        int[] res = twoSumLR(nums,target);
        for (int i:res)
            System.out.print(" "+i);
    }

    public int[] twoSumLR(int[] nums,int target){
        int left=0,right= nums.length-1;
        while (left<right){
            int sum=nums[left]+nums[right];
            if (sum==target){
                return new int[]{left+1,right+1};
            }
            else if (sum<target)
                left++;
            else right--;
        }
        return new int[]{-1,1};
    }

}
