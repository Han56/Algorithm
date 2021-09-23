import java.util.HashMap;
import java.util.Map;

/**
 * @author han56
 * @description 【力扣242】有效的字母异位词
 * @create 2021/9/17 下午2:53
 */
public class IsAnagram {

    public static void main(String[] args) {
        String s = "rat",t="car";
        System.out.println(anagram(s,t));
    }
    public static boolean anagram(String s,String t){
        //将String To CharArray
        char[] sCharSet = s.toCharArray();
        char[] rCharSet = t.toCharArray();
        //base case
        if (sCharSet.length!=rCharSet.length)
            return false;
        //将 sCharSet 遍历进入 Map 并做计数处理
        Map<Character,Integer> sMap = new HashMap<>();
        for (char sChar:sCharSet)
            sMap.put(sChar,sMap.getOrDefault(sChar,0)+1);
        //遍历 rCharSet
        for (char rChar:rCharSet){
            if (sMap.containsKey(rChar)&&sMap.get(rChar)>0){
                sMap.replace(rChar,sMap.get(rChar)-1);
            }else {
                return false;
            }
        }
        return true;
    }

}
