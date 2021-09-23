import java.util.HashMap;

/**
 * @author han56
 * @description 力扣【36题 有效的数独】
 * @create 2021/9/16 下午7:16
 */
public class IsValidSudokuLC36 {

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','7','.','.','.','.','.',},
                {'6','.','.','1','8','7','.','.','.',},
                {'.','8','7','.','.','.','.','6','.',},
                {'8','.','.','.','6','.','.','.','3',},
                {'4','.','.','8','.','3','.','.','1',},
                {'7','.','.','.','2','.','.','.','6',},
                {'.','6','.','.','.','.','2','8','.',},
                {'.','.','.','4','1','7','.','.','5',},
                {'.','.','.','.','8','.','.','.','8',},
        };
        boolean valid = isValid(board);
        System.out.println(valid);
    }
    public static boolean isValid(char[][] board){
        //initial data
        HashMap<Integer,Integer>[] rows = new HashMap[9];
        HashMap<Integer,Integer>[] columns = new HashMap[9];
        HashMap<Integer,Integer>[] boxs = new HashMap[9];
        for (int i=0;i<9;i++){
            rows[i] = new HashMap<Integer,Integer>();
            columns[i] = new HashMap<Integer,Integer>();
            boxs[i] = new HashMap<Integer,Integer>();
        }

        //循环二维数组判断
        for (int r=0;r<9;r++){
            for (int c=0;c<9;c++){
                char value = board[r][c];
                if (value!='.'){
                    //这一句可以保证 3×3 的区域的值相同
                    int box_index = (r/3)*3+c/3;
                    /*
                    getOrDefault的意思是：获取指定key对应的value，如果不存在映射关系则返回默认值，比如我们设置成0
                    也就是说如果没有映射关系说明map中之前没有这个数值，所以 +1
                    */
                    rows[r].put((int) value,rows[r].getOrDefault((int) value,0)+1);
                    columns[c].put((int) value,columns[c].getOrDefault((int) value,0)+1);
                    boxs[box_index].put((int) value,boxs[box_index].getOrDefault((int) value,0)+1);

                    //检查之前是否存在，存在则直接返回失败
                    if (rows[r].get((int) value)>1||columns[c].get((int) value)>1||boxs[box_index].get((int) value)>1)
                        return false;
                }
            }
        }
        return true;
    }



}
