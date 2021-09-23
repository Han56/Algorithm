package ana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public  static  int rank(int key,int[] a){

        int low=0;
        int high=a.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (key<a[mid])
                high=mid-1;
            else if (key>a[mid])
                low=mid+1;
            else
                return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> list=new ArrayList<Integer>();
        while (scan.hasNextInt()){
            list.add(scan.nextInt());
        }
        System.out.println("输入结束，输入数据已经存入list中，接下来将存入a数组中");
        int[] a = new int[list.size()];
        for (int i=0;i<list.size();i++){
            a[i]=list.get(i);
        }
        System.out.println("存入a数组成功！对a进行排序");
        Arrays.sort(a);
        rank(5,a);
        scan.close();
    }

}
