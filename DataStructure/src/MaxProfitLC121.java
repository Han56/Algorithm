import java.util.*;

/**
 * @author han56
 * @description 功能描述：【力扣121】股票最佳利润
 * @create 2021/9/14 下午8:25
 */
public class MaxProfitLC121 {
    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        System.out.println(max(price));
    }

    public static int max(int[] price){
        int length = price.length;
        //base case
        if (length==1)
            return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] y = new int[length];
        for (int i=0;i<length;i++){
            map.put(price[i],0);
            for (int j=i+1;j<length;j++){
                int profit = price[j]-price[i];
                if (profit>0)
                    map.replace(price[i],Math.max(map.get(price[i]),profit));
            }
            y[i] = map.get(price[i]);
        }
        Arrays.sort(y);
        return y[length-1];
    }
}
