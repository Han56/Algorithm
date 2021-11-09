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

    /*
    * 【双指针问题——左右指针】力扣27题 移除元素
    * */

    public static int removeElement(int[] nums,int val){
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    /*
    * 【双指针问题——快慢指针】颜色分类
    * */
    public static int[] colorSort(int[] nums){
        //base case
        if (nums.length==1)
            return nums;
        int slow=0;
        for (int color=0;color<3;color++){
            int fast=slow+1;
            while (fast< nums.length){
                if (nums[slow]==color)
                    slow++;
                else {
                    if (nums[fast]==color){
                        int temp = nums[slow];
                        nums[slow]=nums[fast];
                        nums[fast]=temp;slow++;
                    }
                }
                fast++;
            }
        }
        return nums;
    }

    @Test
    public void test(){
        int[] nums = {2,0,1};
        int[] res = colorSort(nums);
        for (int i:res)
            System.out.print(" "+i);
    }

}
