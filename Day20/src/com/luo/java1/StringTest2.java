package com.luo.java1;

import java.util.Arrays;

/**
 * String常见的算法题
 *
 * @author luozstart
 * @create 2022-11-12 12:41
 */
public class StringTest2 {
    //模拟一个trim方法，去除字符串两端的空格
    public String trimTest(String str){
        int l=str.length();
        String str2=str;
        while (true){
            if (str2.charAt(0)==' '){
                str2 = str2.substring(1);   //截取除首个为空格的字符串为新的字符串
            }else break;
        }
        while (true){
            if (str2.charAt(str2.length()-1)==' '){
                str2 = str2.substring(0,str2.length()-1);       //删除最后一个字符
            }else break;
        }
        return str2;

    }

    /**
     * 将一个字符串指定部分进行反转
     * @param str
     * @param left  开始的索引
     * @param right 结束的索引(包含)
     * @return
     */
    //将一个字符串指定部分进行反转
    public String reversalString(String str,int left,int right){
        char[] c = str.toCharArray();
        for (int i=left;i<=(left+right)/2;i++){
            char tmpe = c[i];
            c[i] = c[right];
            c[right] = tmpe;
            right--;
        }
        return new String(c);
    }

    /**
     * 获取一个字符串在另一个字符串中出现的次数
     * @param str
     * @param str2
     * @return
     */
    //获取一个字符串在另一个字符串中出现的次数
    public int findNum(String str,String str2){
        if (str.length()<str2.length()) return 0;
        str=str+" ";
        int num =0;
        for (int i=0;i<str.length()-str2.length();i++){
            if (str.substring(i,i+str2.length()).equals(str2)){
                num++;
                i=i+str2.length()-1;
            }
        }
        return num;
    }

    /**
     * 获取两个字符串中最大相同子串
     * @param str1
     * @param str2
     * @return
     */
    //获取两个字符串中最大相同子串
    public String findString(String str1,String str2){
        if (str1.length()<str2.length()){
            String str = str1;
            str1 = str2;
            str2 = str;
        }
//        str1 = str1+" ";
//        str2 = str2+" ";
        for (int i = str2.length();i>0;i--){
            for (int j=0;j<=str2.length()-i;j++){
                   for (int z = 0;z<=str1.length()-i;z++){
                       if (str2.substring(j,j+i).equals(str1.substring(z,z+i))){
                           return str2.substring(j,j+i);
                       }
                   }
            }
        }
        return " ";
    }

    /**
     *  对字符串中字符进行自然顺序排序
     * @param str
     * @return
     */
    //对字符串中字符进行自然顺序排序
    public String sortString(String str){
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static void main(String[] args) {
        StringTest2 s = new StringTest2();

        //测试首位去空格
        String s1 = "  hel lo wold ";
        String s2 =s.trimTest(s1);
        System.out.println(s2);

        //测试字符串中间反转
        String s3 = "wodeshijie";
        String s4 = s.reversalString(s3,3,6);
        System.out.println(s4);

        //测试找字串出现次数
        String s5 = "abkkcadkabkebfkabkskab";
        int num = s.findNum(s5,"ab");
        System.out.println(num);

        //测试最大字串
        String s6 = "abcwerthelloyuiodef";
        String s7 = "cvhellobnm";
        System.out.println(s.findString(s6, s7));

        //测试排序
        String s8 = "bcdajkl";
        System.out.println(s.sortString(s8));
    }
}
