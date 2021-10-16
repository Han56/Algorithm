import java.util.*;

/**
 * @author han56
 * @description 功能描述【力扣22题】回溯算法 括号生成
 * @create 2021/10/13 下午8:49
 */
public class GenerateParenthesis {

    List<String> res = new LinkedList<>();

    public List<String> generateParentThesis(int n){
        if (n==0)
            return res;
        StringBuilder track = new StringBuilder();
        backtrack(n,n,track,res);
        return res;
    }

    public void backtrack(int left,int right,StringBuilder track,List<String> res){
        if (left<0||right<0)
            return;
        if (right<left)
            return;
        if (left==0&&right==0){
            res.add(track.toString());
            return;
        }

        track.append("(");
        backtrack(left-1,right,track,res);
        track.deleteCharAt(track.length()-1);

        track.append(")");
        backtrack(left,right-1,track,res);
        track.deleteCharAt(track.length()-1);
    }


    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list = generateParenthesis.generateParentThesis(3);
        System.out.println(list);
    }

}
