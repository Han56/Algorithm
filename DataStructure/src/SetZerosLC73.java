import java.util.HashMap;

/**
 * @author han56
 * @description 【力扣73题】矩阵置0
 * @create 2021/9/16 下午8:11
 */
public class SetZerosLC73 {

    public static void main(String[] args) {
        int[][] nums = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        int[][] res = set(nums);
        for (int[] re : res)
            for (int j = 0; j < res[0].length; j++)
                System.out.print(re[j] + " ");
    }

    public static int[][] set(int[][] nums){
        HashMap<Integer,String> map = new HashMap<>();
        int flag = 0;
        for (int i=0;i< nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                if (nums[i][j]==0){
                    //将i,j转化为 "i*j" 字符串形式存储
                    flag++;
                    map.put(flag,i+" "+j);
                }
            }
        }
        //if flag!=0 说明此时数组存在 待处理元素
        if (flag!=0){
            //解析位置信息
            for (int i=1;i<=flag;i++){
                String pos = map.get(i);
                String[] strings = pos.split(" ");
                int r = Integer.parseInt(strings[0]);
                int c = Integer.parseInt(strings[1]);
                //将待处理行列置零
                for (int j=0;j<nums[0].length;j++)
                    nums[r][j] = 0;
                for (int rr=0;rr<nums.length;rr++)
                    nums[rr][c]=0;
            }
        }
        return nums;
    }

}
