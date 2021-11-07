package test;

import org.junit.Test;

/**
 * @author han56
 * @description 功能描述
 * 【双指针-快慢指针】力扣26题，删除有序数组中的重复项
 * @create 2021/11/6 上午9:39
 */
public class RemoveDupli {

    public static int removeDupilcates(int[] nums){
        //base case
        if (nums.length==0||nums.length==1)
            return nums.length;
        //当nums.length>1时
        int slow=0,fast=1;
        while (fast< nums.length){
            if (nums[fast]>nums[slow]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

    @Test
    public void test(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDupilcates(nums);
        System.out.println(k);
    }

}
