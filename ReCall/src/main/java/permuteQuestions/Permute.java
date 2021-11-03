package permuteQuestions;

import java.util.LinkedList;
import java.util.List;

/**
 * @author han56
 * @description 回溯算法【力扣46】全排列问题
 * @create 2021/10/3 下午8:35
 */
public class Permute {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permu(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums,track);
        return res;
    }

    public void backTrack(int[] nums,LinkedList<Integer> track){
        if (track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num))
                continue;
            track.add(num);
            backTrack(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permute permute = new Permute();
        List<List<Integer>> res_list = permute.permu(nums);
        System.out.println(res_list);
    }

}
