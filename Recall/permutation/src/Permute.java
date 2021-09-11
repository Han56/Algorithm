import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author han56
 * @description 回溯算法之全排列问题
 * @create 2021/8/14 上午8:44
 */
public class Permute {

    public static List<List<Integer>> results = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute(nums);
        cout(results);
    }

    public static List<List<Integer>> permute(int[] nums){

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return results;
    }

    public static void backtrack(int[] nums,LinkedList<Integer> track){
        //结束条件
        if (nums.length == track.size()){
            results.add(track);
            return;
        }
        for (int num : nums) {
            //排除不合法的选择
            if (track.contains(num))
                continue;
            //做选择
            track.add(num);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    public static void cout(List<List<Integer>> res){
        HashMap<String,List<Integer>> map = new HashMap<>();
        if (res.size()>0){
            for (List<Integer> integers : res) {
                map.put("排列",integers);
            }
        }
    }

}
