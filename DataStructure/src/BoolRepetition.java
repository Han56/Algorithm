import java.util.Arrays;

/**
 * @author han56
 * @description 【力扣217数据结构】判断是否存在重复元素  需要先排序再判断 否则两次循环超时
 * @create 2021/9/12 下午7:28
 */
public class BoolRepetition {

    public static void main(String[] args) {
        int[] nums = {1,3,4,3,2,4,2};
        System.out.println(isRepetition(nums));
    }

    public static boolean isRepetition(int[] nums){
        int L = nums.length;
        Arrays.sort(nums);
        for (int i=0;i<L;i++){
            if (i+1<L){
                if (nums[i]==nums[i+1])
                    return true;
            }
        }
        return false;
    }


}
