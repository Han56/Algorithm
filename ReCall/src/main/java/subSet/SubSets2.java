package subSet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author han56
 * @description 功能描述【力扣90题】回溯求子集2 nums数组存在重复元素
 * @create 2021/10/21 上午9:11
 */
public class SubSets2 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subset2(int[] nums){
        if (nums.length==0)
            return res;
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(track,0,nums);
        return res;
    }

    public void backtrack(LinkedList<Integer> track,int start,int[] nums){
        if (!res.contains(track))
             res.add(new LinkedList<>(track));

        for (int i=start;i< nums.length;i++){
            track.add(nums[i]);
            backtrack(track,i+1,nums);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2};
        SubSets2 subSets2 = new SubSets2();
        List<List<Integer>> lists = subSets2.subset2(nums);
        for (List<Integer> list:lists)
            System.out.println(list);
    }

}
