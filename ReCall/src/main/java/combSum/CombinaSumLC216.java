package combSum;

import java.util.LinkedList;
import java.util.List;

/**
 * @author han56
 * @description 功能描述 【回溯算法】组合总和3
 * @create 2021/10/20 上午8:53
 */
public class CombinaSumLC216 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> comninationSum3(int k,int n){
        if (n<=0||k<=0)
            return res;
        //定义选择数组
        LinkedList<Integer> track = new LinkedList<>();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        backtrack(nums,0,0,track,n,k);
        return res;
    }

    public void backtrack(int[] nums,int start,int sum,LinkedList<Integer> track,int n,int k){
        if (track.size()==k&&sum==n){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i=start;i< nums.length;i++){
            if (sum+nums[i]>n)
                break;
            track.add(nums[i]);
            backtrack(nums,i+1,sum+nums[i],track,n,k);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinaSumLC216 lc216 = new CombinaSumLC216();
        List<List<Integer>> lists = lc216.comninationSum3(3,9);
        for (List<Integer> list:lists)
            System.out.println(list);
    }

}
