package com.luo.test1;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author luozstart
 * @create 2022-12-08 18:15
 */
public class Test4 {
    public static void main(String[] args) {
        char[] c = new char[3];
        c[0]='A';
        c[1]=0;
        c[2]='B';
        String x = "DEF";
        System.out.println(new String(c));
        StringBuilder s =new StringBuilder(new String(c));
        System.out.println(s);
        for (int i =0;i<s.length();i++){
            if (c[i]==0){
                s.delete(i,i+1);
            }
        }
        System.out.println(s);
        System.out.println(new String(s));
        x = x+new String(c);
        System.out.println(x);
    }
    @Test
    public void tset1(){
        String s = "(()(";
        System.out.println(isValid(s));
    }
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        char[] x=new char[s.length()/2];
        x[0]=s.charAt(0);
        int k=0;
        for(int i=1;i<s.length();i++){
            if(k==-1){
                if(i==(s.length()-1)||isFlag(s.charAt(i))<0){
                    return false;
                }
                k++;
                x[k]=s.charAt(i);
                i++;
            }
            if(isFlag(s.charAt(i))+isFlag(x[k])==0){
                if(isFlag(x[k])<0) return false;
                k--;
            }else{
                if(isFlag(s.charAt(i))<0) return false;
                if(i==s.length()-1) return false;
                k++;
                if(k==s.length()/2) return false;
                x[k]=s.charAt(i);
            }
        }
        return true;
    }

    public int isFlag(char a){
        switch(a){
            case '(':
                return 1;
            case ')':
                return -1;
            case '{':
                return 2;
            case '}':
                return -2;
            case '[':
                return 3;
            case ']':
                return -3;
        }
        return 0;
    }

    @Test
    public void test2(){
        int[] nums2={1};
        int[] nums1={2,3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double x=2;
        if(nums1.length==0||nums2.length==0){
            if(nums1.length==0){
                if(nums2.length%2==0){
                    return (nums2[nums2.length/2-1]+nums2[nums2.length/2])/x;
                }else{
                    return nums2[nums2.length/2];
                }
            }else {
                if(nums1.length%2==0){
                    return (nums1[nums1.length/2-1]+nums1[nums1.length/2])/x;
                }else{
                    return nums1[nums1.length/2];
                }
            }
        }
        int y=nums1.length+nums2.length;
        int a=0;    //nums1
        int b=0;    //nums2
        int c=0;
        int z=y/2+1;
        if((y)%2==0){
            int d = 0;
            while(a+b+1!=z){
                if (a<nums1.length&&b<nums2.length){
                    if(nums1[a]>nums2[b]){
                        c=nums2[b];
                        b++;
                    }else {
                        c=nums1[a];
                        a++;
                    }
                }else if (a==nums1.length){
                    c=nums2[b];
                    b++;
                }else {
                    c=nums1[a];
                    a++;
                }

            }
            if (a<nums1.length&&b<nums2.length) {
                if (nums1[a] > nums2[b]) {
                    d = nums2[b];
                } else {
                    d = nums1[a];
                }
            }else {
                if (a==nums1.length){
                    d=nums2[b];
                }else d=nums1[a];
            }
            return (c+d)/x;
        }else{
            while(a+b!=z){
                if (a<nums1.length&&b<nums2.length){
                    if(nums1[a]>nums2[b]){
                        c=nums2[b];
                        b++;
                    }else {
                        c=nums1[a];
                        a++;
                    }
                }else if (a==nums1.length){
                    c=nums2[b];
                    b++;
                }else {
                    c=nums1[a];
                    a++;
                }
            }
            return c;
        }
    }
    @Test
    public void test3(){
        String s="deeee";
        System.out.println(validPalindrome(s));
    }
    public boolean validPalindrome(String s) {
        char[] c=s.toCharArray();
        int k=0;
        int x=isFlag(c,0,c.length-1);
        if(x!=-1){
            if(isFlag(c,x+1,c.length-x-1)==-1||isFlag(c,x,c.length-x-2)==-1) return true;
            else return false;
        }
        return true;
    }
    public int isFlag(char[] c,int l,int r){
        for(int i=l;i<=(l+r)/2;i++){
            if(c[l]!=c[r]) return l;
            l++;
            r--;
        }
        return -1;
    }
    @Test
    public void test4(){
        int nums[]={3,3};
        int[] x = twoSum(nums,6);
        for (int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] x=new int[nums.length];
        for (int i=0;i<x.length;i++){
            x[i]=nums[i];
        }
        int[] arr=new int[2];
        int l = 0;
        int r = nums.length-1;
        Arrays.sort(nums);
        while(l<r){
            if(nums[l]+nums[r]>target){
                r--;
            }
            if(nums[l]+nums[r]<target){
                l++;
            }
            if(nums[l]+nums[r]==target){
                arr[0]=Arrays.binarySearch(x,nums[l]);
                if (nums[l]==nums[r]){
                    arr[1]=Arrays.binarySearch(x,l+1,nums.length,nums[r]);
                }else  arr[1]=Arrays.binarySearch(x,nums[r]);
                break;
            }
        }
        return arr;
    }
    @Test
    public void  test5(){
        String s = "abc";
        System.out.println(isUnique(s));
    }
    public boolean isUnique(String astr) {
        int x='z'-'A'+1;
        boolean[] isUn=new boolean[x];
        char[] c=astr.toCharArray();
        for(int i=0;i<c.length;i++){
            if(isUn[c[i]%x]){
                return false;
            }else{
                isUn[c[i]%x]=true;
            }
        }
        return true;
    }
    @Test
    public void test6(){
        String s="123";
        System.out.println(Integer.parseInt(s));
        System.out.println((int) 'a');
        System.out.println((int)'z');
    }

    @Test
    public void test7(){
        String s = "leetcode";
        System.out.println(getLucky(s,2));
    }
    public int getLucky(String s, int k) {
        char[] c = s.toCharArray();
        long x =0;
        long  temp=0;
        for(int i=0;i<c.length;i++){
            temp=c[i]-'a'+1;
            if(temp>=10){
                x=x*100+temp;
            }else x=x*10+temp;
        }
        System.out.println(x);
        temp=0;
        for(int i=0;i<k;i++){
            while(x!=0){
                temp+=x%10;
                x/=10;
            }
            x = temp;
            temp=0;
        }
        return (int) x;
    }
}
