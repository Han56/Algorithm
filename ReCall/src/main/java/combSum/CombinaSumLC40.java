package combSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author han56
 * @description 功能描述【回溯算法】组合总和2
 * @create 2021/10/17 下午7:39
 */
public class CombinaSumLC40 {

    List<List<Integer>> res = new LinkedList<>();

    /*
    * 回溯入口
    * */
    public List<List<Integer>> combinaSum2(int[] nums,int target){
        if (target<=0)
            return res;
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(target,0,nums,0,track);
        return res;
    }

    public void backtrack(int target,int start,int[] nums,int sum,LinkedList<Integer> track){
        if (sum==target){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i=start;i< nums.length;i++){
            //做选择
            if (sum+nums[i]>target)
                break;
            //剪枝 否则第172个测试用例无法通过
            if (i>start&&nums[i]==nums[i-1])
                continue;
            track.add(nums[i]);
            backtrack(target, i+1, nums, sum+nums[i], track);
            //撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        CombinaSumLC40 lc40 = new CombinaSumLC40();
        List<List<Integer>> list1 = lc40.combinaSum2(nums,8);
        for (List<Integer> list:list1)
            System.out.println(list);
    }

}
