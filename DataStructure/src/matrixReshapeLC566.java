/**
 * @author han56
 * @description 功能描述：lc重塑数组566
 * @create 2021/9/15 下午7:51
 */
public class matrixReshapeLC566 {
    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        int[][] res = reshape(nums,1,4);
        for (int[] re : res)
            for (int j = 0; j < res[0].length; j++)
                System.out.print(re[j]);
    }
    public static int[][] reshape(int[][] mat,int r,int c){
        //获取数组的元素总数 通过行列乘积得到
        int x = mat.length*mat[0].length;
        if (x!=r*c)
            return mat;
        int[][] reshape_nums = new int[r][c];
        for (int i=0;i<x;i++){
            reshape_nums[i/c][i%c] = mat[i/mat[0].length][i%mat[0].length];
        }
        return reshape_nums;
    }
}
