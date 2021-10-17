import java.util.LinkedList;
import java.util.List;

/**
 * @author han56
 * @description 功能描述【回溯算法】力扣47题，全排列二：输入重复的数组
 * @create 2021/10/17 上午9:37
 */
public class PermuteUniQLC47 {

    List<List<Integer>> res  = new LinkedList<>();
    boolean[] isVis;

    /*
    * 回溯入口
    * */
    public List<List<Integer>> permuteUniq(int[] nums){
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        isVis = new boolean[nums.length];
        //进入递归
        backtrack(nums,track);
        return res;
    }

    /*
    * 回溯模板
    * */
    public void backtrack(int[] nums,LinkedList<Integer> track){
        if (nums.length == track.size()&& !res.contains(track)){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i=0;i< nums.length;i++) {
            if (isVis[i])
                continue;
            //做选择
            track.add(nums[i]);
            isVis[i] = true;
            //递归
            backtrack(nums, track);
            //撤销选择
            track.removeLast();
            isVis[i]=false;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        PermuteUniQLC47 qlc47 = new PermuteUniQLC47();
        List<List<Integer>> list = qlc47.permuteUniq(nums);
        for (List<Integer> list1:list)
            System.out.println(list1);
    }

}
