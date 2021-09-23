import java.util.Arrays;

/**
 * @author han56
 * @description 【力扣88】合并两个有序数组
 * @create 2021/9/13 下午7:31
 */
public class AggregationTwoListLC88 {

    public static void main(String[] args) {
        int m=0,n=5;
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {1,2,3,4,5};
        int[] res = aggregate(m,n,nums1,nums2);
        for(int num:res)
            System.out.print(num);
    }

    public static int[] aggregate(int m,int n,int[] nums1,int[] nums2){

        if (n==0) {
            if (m!=0)
              Arrays.sort(nums1);
            else
                return new int[]{0};
        }else {
            System.arraycopy(nums2,0,nums1,m,n);
            Arrays.sort(nums1);
        }

        return nums1;

    }

}
