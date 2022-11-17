package com.luo.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author luozstart
 * @create 2022-11-14 22:27
 */
public class CompareTest {
    //Comparator接口的使用：定制排序
    //2.重写compare(Object o1,Object o2)方法，比较o1,o2的大小
    //如果方法返回正整数，则表示o1大于o2
    //如果返回0，表示相等；
    //返回负整数，表示o1小于o2.
    @Test
    public void test1(){
        String[] arr = {"AA","DD","FF","EE","CC","BB"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return  -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        int[][] boxTypes = {{4,3},{2,2},{3,1},{1,8}};
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -(o1[1]-o2[1]);
            }
        });
        for(int i=0;i<boxTypes.length;i++){
            for (int j = 0; j < boxTypes[i].length; j++) {
                System.out.print(boxTypes[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
