import java.util.HashMap;
import java.util.Map;

/**
 * @author han56
 * @description 力扣【383题】赎金信
 * @create 2021/9/17 下午2:26
 */
public class CanConstructLC383 {

    public static void main(String[] args) {
        String ransomNote="aa",magazine="aab";
        System.out.println(can(ransomNote,magazine));
    }

    public static boolean can(String ransomNote,String magazine){
        //对字符串进行处理变成 char组
        char[] ransomCharSet = ransomNote.toCharArray();
        char[] magazineCharSet = magazine.toCharArray();
        //将magazineCharSet存入哈希表1
        Map<Character,Integer> magaMap = new HashMap<>();
        for (char m : magazineCharSet) {
            magaMap.put(m,magaMap.getOrDefault(m,0)+1);
        }
        //循环遍历ransomCharSet,如果magaMap中存在这个字符，则将其对应的V-1，如果V=0则返回false
        for (char r:ransomCharSet){
            if (magaMap.containsKey(r)&&magaMap.get(r)>0){
                magaMap.replace(r,magaMap.get(r)-1);
            }else {
                return false;
            }
        }
        return true;
    }

}
