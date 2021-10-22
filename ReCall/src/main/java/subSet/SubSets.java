package subSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author han56
 * @description 功能描述【力扣78】回溯-求子集
 * @create 2021/10/5 下午7:45
 */
public class SubSets {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path= new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        SubSets subSets = new SubSets();
        List<List<Integer>> lists = subSets.subSets(nums);
        for (List<Integer> list:lists)
            System.out.println(list);
    }

    public List<List<Integer>> subSets(int[] nums) {
        if (nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        subsetsHelper(nums, 0);
        return result;
    }

    private void subsetsHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }

}
