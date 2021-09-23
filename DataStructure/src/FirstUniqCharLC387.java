import java.util.HashMap;
import java.util.Map;

/**
 * @author han56
 * @description 【力扣387】字符串中的第一个唯一字符
 * @create 2021/9/17 上午9:22
 */
public class FirstUniqCharLC387 {

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(uniqCharPos(s));
    }

    public static int uniqCharPos(String s){
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
