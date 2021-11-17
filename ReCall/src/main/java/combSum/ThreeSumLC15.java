package combSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author han56
 * @description 功能描述
 * @create 2021/11/13 上午9:32
 * leetcode 15题 三数之和
 */
public class ThreeSumLC15 {

    List<List<Integer>> res=  new LinkedList<>();

    public List<List<Integer>> threeSum(int[] nums){
        //base case
        if (nums.length<3)
            return res;
        LinkedList<Integer> track=new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums,3,0,track);
        return res;
    }

    public void backtrack(int[] nums,int k,int start,LinkedList<Integer> track){
        if (track.size()==k&&isValid(0,track)){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i=start;i< nums.length;i++){
            if (i>start&&nums[i-1]==nums[i])
                continue;
            //做选择
            track.add(nums[i]);
            backtrack(nums, k, i+1, track);
            //撤销选择
            track.removeLast();
        }

    }
    /*
    * 判断列表中元素之和是否等于0
    * */
    public boolean isValid(int target,LinkedList<Integer> track){
        int sum=0;
        for (int i:track)
            sum=sum+i;
        return sum == target;
    }

    public static void main(String[] args) {
        ThreeSumLC15 lc15 = new ThreeSumLC15();
        int[] nums={34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        List<List<Integer>> res1= lc15.threeSum(nums);
        //print to test
        for (List<Integer> list:res1)
            System.out.println(list);
    }

}
