import java.util.LinkedList;
import java.util.List;

/**
 * @author han56
 * @description 功能描述【力扣51】N皇后问题
 * @create 2021/10/4 下午8:29
 */
public class NQueens {

    static int N = 4;

    public static void main(String[] args) {
        //创建一个N*N的二维数组
        char[][] board = new char[N][N];
        //初始化数组
        initBoard(board);
        backtrack(board,0);
    }

    public static void backtrack(char[][] board,int row){
        //触发结束条件
        if (row == board.length){
            //输出次数的board
            cout(board);
            return;
        }
        int n = board.length;
        for (int col=0;col<n;col++){
            //剪枝
            if (!isValid(board,row,col))
                continue;
            //做选择
            board[row][col] = 'Q';
            //进入下一行决策
            backtrack(board,row+1);
            //撤销选择
            board[row][col] = '.';
        }
    }

    public static void cout(char[][] board){
        if (board.length>0){
            System.out.println("输出一种策略");
            for (int i=0;i<N;i++){
                for (int k=0;k<board[i].length;k++){
                    System.out.print(board[i][k]+" ");
//                    StringBuilder stringBuffer = new StringBuilder();
//                    stringBuffer.append(board[i][k]);
                }
                System.out.println();
            }
        }
    }

    public static boolean isValid(char[][] board,int row,int col){
        int n = board.length;
        //检查一列是否有皇后互相冲突
        for (int i=0;i<row;i++){
            if (board[i][col] == 'Q'){
                return false;
            }
        }
        //检查右上方是否有冲突
        for (int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        //检查左上方是否有冲突
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        //如果都符合 返回true
        return true;
    }

    public static void initBoard(char[][] board){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                board[i][j]='.';
            }
        }
        System.out.println("棋盘初始化完成");
    }
}
