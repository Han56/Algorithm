import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author han56
 * @description 功能描述【回溯】组合总和
 * @create 2021/10/17 上午11:03
 */
public class CombinaSumLC39 {

    List<List<Integer>> res = new LinkedList<>();


    public List<List<Integer>> combinationSum(int[] nums,int target){
        if (target<=0)
            return res;
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(target,0,track,0,nums);
        return  res;
    }

    public void backtrack(int target,int start,LinkedList<Integer> track ,int sum,int[] nums){
        //装载res的条件为是否等于target
        if (sum==target){
            res.add(new LinkedList<>(track));
            return;
        }
        //令i从start开始循环
        for (int i=start;i<nums.length;i++){
            //做选择
            if (sum<=target){
                track.add(nums[i]);
                backtrack(target,i,track,sum+nums[i],nums);
                //撤销选择
            }else {
                break;
            }
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums={2,3,6,7};
        CombinaSumLC39 lc39 = new CombinaSumLC39();
        List<List<Integer>> lists = lc39.combinationSum(nums,7);
        for (List<Integer> list:lists)
            System.out.println(list);
    }

}
