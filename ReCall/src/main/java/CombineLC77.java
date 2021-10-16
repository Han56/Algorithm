import java.util.LinkedList;
import java.util.List;

/**
 * @author han56
 * @description 功能描述 【回溯算法】组合 leetCode 77题
 * @create 2021/10/11 下午7:37
 */
public class CombineLC77 {

    //记录结果集
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> conbim(int n,int k){
        if (k<=0||n<=0)
            return res;
        backtrack(n,k,1,track);
        return res;
    }

    public void backtrack(int n,int k,int start,LinkedList<Integer> track){
        //到达叶子节点更新res
        if (k== track.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i=start;i<=n;i++){
            //做选择
            track.add(i);
            //递归回溯
            backtrack(n,k,i+1,track);
            //撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        CombineLC77 combineLC77 = new CombineLC77();
        List<List<Integer>> printList = combineLC77.conbim(4,2);
        //打印输出测试
        for (List<Integer> list:printList)
            System.out.println(list);
    }

}
