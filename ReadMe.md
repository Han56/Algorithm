# 日常算法练习 #

## 2020年10月9日 ##

### 两数之和 ###
题目描述：
给定一组数组 int[] nums={2,7,11,15}; 和一个目标值target=9
找到数组中两个数和为target 并返回它们的下标

暴力法解决：（即两个for循环）
代码：

```java
package com;


public class BinarySum {

    public static int[] ana(int target, int[] nums){
        //找出数组中和为target的两个数，并返回这两个数的下标
        int[] rest=new int[2];
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    rest[0]=i;
                    rest[1]=j;
                    return rest;
                }
            }
        }
        return rest;
    }
    public static void main(String[] args) {
        //给定一个数组+一个tartget
        int[] nums={2,7,11,15};
        int target=9;
        int[] rest;
        rest=ana(target,nums);
        for (int i=0;i<rest.length;i++){
            System.out.println(rest[i]);
        }
    }
}

```

