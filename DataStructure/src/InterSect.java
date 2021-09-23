import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author han56
 * @description 【力扣360】两个数组的交集
 * @create 2021/9/14 下午7:07
 */
public class InterSect {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        Arrays.sort(nums2);
        int[] sect = InSect(nums2, nums1);
        for (int res:sect)
            System.out.println(res);
    }

    public static int[] InSect(int[] small,int[] big){

        if (small.length==0||big.length==0)
            return new int[]{};
        Map<Integer,Integer> map = new HashMap<>();
        int flag=0;
        for (int i=0;i<small.length;i++){
            int mid,low = 0,high= big.length-1;
            while (low<=high){
                mid = (low+high)/2;
                if (small[i]==big[mid]&& !map.containsValue(small[i])){
                    map.put(flag,small[i]);
                    flag++;
                }

                else if (small[i]<big[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
        }
        int[] res = new int[map.size()];
        for (int i=0;i<map.size();i++)
            res[i] = map.get(i);
        return res;
    }

}
