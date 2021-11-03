package NqueenQuestions;

/**
 * @author han56
 * @description 功能描述 【回溯算法】力扣37题 解数独
 * @create 2021/10/22 上午9:27
 */
public class Sudoku {

    public boolean backtrack(char[][] board,int i,int j){
        int m=9,n=9;
        if (j==n)
            return backtrack(board,i+1,0);
        if (i==m)
            return true;
        if (board[i][j]!='.')
            return backtrack(board,i,j+1);
        for (char ch='1';ch<='9';ch++){
            if (!isValid(board,i,j,ch))
                continue;
            board[i][j]=ch;
            if (backtrack(board,i,j+1))
                return true;
            board[i][j]='.';
        }
        return false;
    }

    public static boolean isValid(char[][] board,int r,int c,char n){
        for (int i=0;i<9;i++){
            if (board[r][i]==n)
                return false;
            if (board[i][c]==n)
                return false;
            if (board[(r/3)*3+i/3][(c/3)*3+i%3]==n)
                return false;
        }
        return true;
    }

    public void outBackTrack(char[][] board,int i,int j){
        int m=9,n=9;
        if (j==n)
            outBackTrack(board, i+1, 0);
        if (i==m)
            return;
        if (board[i][j]!='.')
            outBackTrack(board, i, j+1);
        for (char ch='1';ch<='9';ch++){
            if (!isValid(board,i,j,ch))
                continue;
            board[i][j]=ch;
            outBackTrack(board, i, j+1);
            board[i][j]='.';
        }
    }


    public static void main(String[] args) {

        //声明一个 9*9 的 char 类型数组
        char[][] boards = {{'5','3','.','.','7','.','.','.','.'},
                           {'6','.','.','1','9','5','.','.','.'},
                           {'.','9','8','.','.','.','.','6','.'},
                           {'8','.','.','.','6','.','.','.','3'},
                           {'4','.','.','8','.','3','.','.','1'},
                           {'7','.','.','.','2','.','.','.','6'},
                           {'.','6','.','.','.','.','2','8','.'},
                           {'.','.','.','4','1','9','.','.','5'},
                           {'.','.','.','.','8','.','.','7','9'}
        };
        Sudoku sudoku = new Sudoku();
/*        boolean isUsed = sudoku.backtrack(boards,0,0);
        System.out.println(isUsed);*/
        sudoku.outBackTrack(boards,0,0);
        for (char[] board : boards) {
            for (char c : board) System.out.print(c+" ");
            System.out.println();
        }
    }


}
