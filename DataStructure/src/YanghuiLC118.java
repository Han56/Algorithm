import java.util.ArrayList;
import java.util.List;

/**
 * @author han56
 * @description 功能描述：118题杨辉三角
 * @create 2021/9/16 上午8:27
 */
public class YanghuiLC118 {

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> list = generate(numRows);
    }

    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> resList = new ArrayList<>();
        //base case
        if (numRows == 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);resList.add(list);
            return resList;
        }
        int[][] data = new int[numRows][numRows];
        for (int i=0;i<numRows;i++){
            List<Integer> tmpList = new ArrayList<>();
            for (int j=0;j<=i;j++){
                if (i==j||j==0)
                    data[i][j] = 1;
                else {
                    data[i][j] = data[i-1][j]+data[i-1][j-1];
                }
                tmpList.add(data[i][j]);
            }
            resList.add(tmpList);
        }
        return resList;
    }

}
