import java.util.*;

/**
 * @author han56
 * @description 功能描述【矿山后端对齐回溯测试算法部分】
 * @create 2021/10/27 上午8:50
 */
public class TestForKsDistribute {

    /*
    * 最终组合结果集
    * */
    List<List<Integer>> res = new LinkedList<>();

    /*
    * 列表index结果集
    * */
    List<List<Integer>> pathIndexRes = new LinkedList<>();

    List<Integer> sList = new ArrayList<Integer>(){{
        add(1);add(2);add(3);add(4);add(7);add(8);
    }};

    List<Integer> tList = new ArrayList<Integer>(){{
        add(4);add(1);add(2);add(4);add(6);add(8);
    }};

    List<Integer> uList = new ArrayList<Integer>(){{
        add(5);add(4);add(1);add(3);add(1);
    }};

    List<Integer> vList = new ArrayList<Integer>(){{
        add(6);add(1);add(5);add(8);add(7);add(2);
    }};

    List<Integer> yList = new ArrayList<Integer>(){{
        add(7);add(1);add(8);add(6);add(5);add(4);
    }};

    List<List<Integer>> pathSum = new ArrayList<List<Integer>>(){{
        add(sList);add(tList);add(uList);add(vList);add(yList);
    }};

    public List<List<Integer>> test(){

        TestForKsDistribute test = new TestForKsDistribute();
        List<List<Integer>> testPathList=test.combineListIndex(5,3);
        System.out.println("====所有路径索引集合====");
        for (List<Integer> integers:testPathList)
            System.out.println(integers);
        System.out.println("====完毕====");
        LinkedList<Integer> track = new LinkedList<>();
        for (List<Integer> path:testPathList)
           backtrack(path,track,pathSum,0);
        return res;
    }

    public void backtrack(List<Integer> pathIndexList,LinkedList<Integer> track,List<List<Integer>> allPathList,int start){
        if (track.size()==pathIndexList.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        if (start==pathIndexList.size())
            return;
        int index=pathIndexList.get(start);
        List<Integer> temp= allPathList.get(index);
        Collections.sort(temp);
        for (int i:temp){
            if (!isBiggerElent(track,i))
                return;
            if (!isValid(track,i))
                continue;
            track.add(i);
            backtrack(pathIndexList, track, allPathList, start+1);
            track.removeLast();
        }
    }
    /*
    * 对list index进行回溯组合
    * */
    public List<List<Integer>> combineListIndex(int n,int k){
        if (k<3||n<0)
            return pathIndexRes;
        LinkedList<Integer> track = new LinkedList<>();
        pathIndexBackTrack(n,k,0,track);
        return pathIndexRes;
    }

    public void pathIndexBackTrack(int n,int k,int start,LinkedList<Integer> track){
        if (k == track.size()){
            pathIndexRes.add(new LinkedList<>(track));
            return;
        }
        for (int i=start;i<n;i++){
            track.add(i);
            pathIndexBackTrack(n, k, i+1, track);
            track.removeLast();
        }
    }

    public static boolean isBiggerElent(LinkedList<Integer> track,int i){
        for (int num:track)
            if (i>num)
                return false;
        return true;
    }

    public static boolean isValid(LinkedList<Integer> track,int i){
        if (track.isEmpty())
            return true;
        return track.contains(i);
    }

    public static void main(String[] args) {
        TestForKsDistribute test = new TestForKsDistribute();
        List<List<Integer>> r = test.test();
        for (List<Integer> integers:r)
            System.out.println(integers);

    }


}
