import java.util.ArrayList;
import java.util.List;

/**
 * @author han56
 * @description 功能描述【回溯算法】LeetCode17题 电话号码组合
 * @create 2021/10/15 下午8:08
 */
public class LetterLC17 {

    /*
    * 结果集
    * */
    List<String> res = new ArrayList<>();

    /*
    * 根据输入字符串动态组合字母字符串
    * */
    public static String setLettersCombine(String phoneNumber){
        String allLetters = "abcdefghijklmnopqrstuvwxyz";
        char[] numCharArray = phoneNumber.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:numCharArray){
            //将c转换为int类型
            int numInt = Integer.parseInt(String.valueOf(c));
            stringBuilder.append(allLetters, 3*(numInt-2), 3*(numInt-2)+3);
        }
        return stringBuilder.toString();
    }

    //回溯入口方法
    public List<String> letterCombinations(String digits){
        if (digits.length()==0)
            return res;
        String path = setLettersCombine(digits);
        StringBuilder track = new StringBuilder();
        //进入回溯递归
        backtrack(path.length(),digits.length(),0,track,path);
        return res;
    }

    //回溯模板
    public void backtrack(int pathLength,int digitLength,int start,StringBuilder track,String path){
        //如果track的长度等于digits的长度，则将结果添加到res中
        if (track.length()==digitLength){
            res.add(track.toString());
            return;
        }

        //i 从 start 开始递增
        for (int i=start;i<pathLength;i++){

            //做选择
            track.append(path.charAt(i));
            //递归
            backtrack(pathLength,digitLength,(i/3+1)*3,track,path);
            //撤销选择
            track.deleteCharAt(track.length()-1);

        }

    }


    public static void main(String[] args) {

        LetterLC17 lc17 = new LetterLC17();
        List<String> list = lc17.letterCombinations("23");
        System.out.println(list);

    }

}
