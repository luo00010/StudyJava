package com.luo.exerDay25;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author luozstart
 * @create 2022-12-22 15:22
 */
public class Exer {
    //遍历Map的Key集,value集,key-value集，使用上泛型
    @Test
    public void test1(){
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.print(stringIntegerEntry.getKey()+"  ");
            System.out.println(stringIntegerEntry.getValue());
        }
    }

    //写出使用Iterator和增强for循环遍历List<String>的代码
    @Test
    public void test2(){
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (String str : list){
            System.out.println(str);
        }
    }

    //提供一个方法，用于遍历HashMap<String,String>中的所有value，并存放在list中返回
    @Test
    public void test3(){
        HashMap<String, String> map = new HashMap<>();
        map.put("a","aa");
        map.put("b","bb");
        map.put("c","cc");
        map.put("d","dd");

        Collection<String> collection = map.values();
        ArrayList<String> list = new ArrayList<>();
        for (String str : collection){
            list.add(str);
        }

        for (String str :list){
            System.out.println(str);
        }
    }

    //创建一个于a.txt文件同目录下的另一个文件b.txt
    @Test
    public void test4() throws IOException {
        File file = new File("a.txt");
        System.out.println(file.createNewFile());
        String absolutePath = file.getParent();
        File file1= null;
//        char[] c = new char[4];
//        c[0]='A';
//        c[1]='A';
//        c[2]='A';
//        c[3]='A';
        for(int i=0;i<100;i++) {
//            //file1 = new File(absolutePath + "\\aaaaa.txt");
//            if (c[3]!='z'){
//                c[3]++;
//            }else if (c[2]!='z'){
//                c[2]++;
//            }else if (c[1]!='z'){
//                c[1]++;
//            }else c[0]++;
//            String str = new String(c);
//            file1 = new File(absolutePath + "\\"+str+".txt");
//            System.out.println(file1.createNewFile());
        }
    }


    public int test5(int[] nums){
        ArrayList<Integer> list =new ArrayList();
        Arrays.sort(nums);
        for (int x : nums){
            list.add(x);
        }
        int[] x = new int[nums.length/2];
        int index =0;
        int max=0;
        for(int j=0;j<nums.length/2;j++){
            int y=list.get(list.size()-1);
            for(int i=list.size()-2;i>=0;i--){
                int z =gcd(y,list.get(i));
                if(max<=z){
                    max = z;
                    index = i;

                }
            }
            x[j] = max;
            System.out.println(x[j]);
            list.remove(list.size()-1);
            list.remove(index);
            max=0;
        }

        Arrays.sort(x);
        int sum=0;
        for(int i=0;i<x.length;i++){
            sum +=x[i]*(i+1);
        }
        return sum;
    }
    public  int gcd(int x,int y){
        int min = x<y?x:y;
        min = x+y-min-min;
        for(int i=min;i>0;i--){
            if(x%i==0&&y%i==0) return i;
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {697035,181412,384958,575458};
        Exer exer = new Exer();
        int i = exer.test5(nums);
        System.out.println(i);
        System.out.println(exer.gcd(697035,575458));
    }
}
