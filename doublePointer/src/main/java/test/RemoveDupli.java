package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    /*
    * 【双指针问题——左右指针】验证回文串
    * */
    public static boolean isPalindrome(String s){

        //对字符串s预处理操作
        s=s.toLowerCase();
        String s1=s.replaceAll("\\p{Punct}", "");
        char[] chars = s1.toCharArray();
        //base case
        if (chars.length==1){
            return true;
        }
        //算法核心
        int left=0,right=chars.length-1;
        while (left<right){
            if (chars[left]==' ') {
                left++;
                continue;
            }
            if (chars[right]==' ') {
                right--;
                continue;
            }
            if (chars[left]!=chars[right])
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    /*
    * 数组问题：力扣349题
    * 两个数组的交集
    * */
    public static int[] intersection(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res=new ArrayList<>();
        for (int i=0;i< nums1.length;i++){
            if (i>0&&nums1[i-1]==nums1[i])
                continue;
            for (int k : nums2) {
                if (k == nums1[i]){
                    res.add(nums1[i]);
                    break;
                }
            }
        }
        int[] resArr=new int[res.size()];
        for (int i=0;i<res.size();i++)
            resArr[i]=res.get(i);
        return resArr;
    }

    @Test
    public void test(){
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        int[] res = intersection(nums1,nums2);
        for (int k:res)
            System.out.print(" "+k);
    }

}
