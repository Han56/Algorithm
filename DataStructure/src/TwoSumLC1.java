import java.util.HashMap;
import java.util.Map;

/**
 * @author han56
 * @description 【力扣1】两数之和——哈希表解法
 * @create 2021/9/13 下午7:06
 */
public class TwoSumLC1 {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

    }

    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i]))
                return new int[]{map.get(target-nums[i]),i};
            map.put(nums[i],i);
        }
        throw  new IllegalArgumentException("no output");
    }
}
