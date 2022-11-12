package com.luo.test1;

/**
 * @author luozstart
 * @create 2022-11-09 9:54
 */
public class Test2 {
    public static void main(String[] args) {
        int x =100;
        for (int i=3;i<=x;i++){
            for (int j = 1; j <=Math.sqrt(i); j++) {
                if (i%j==0&&j!=1) {
                    break;
                }
                if (j==(int) (Math.sqrt(i))){
                    System.out.println(i);
                }
            }
        }
    }
}
