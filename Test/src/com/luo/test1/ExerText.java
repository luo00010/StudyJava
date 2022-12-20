package com.luo.test1;

/**
 * @author xxx
 * @create 2022-12-20 11:32
 */
import java.util.Random;
import java.util.Scanner;
public class ExerText {
    public static void main(String[] args) {
        System.out.println("数学计算能力训练系统");
        System.out.println("学号:210699999"+"\t"+"姓名:张三");
        ExerText aadd  =new ExerText();
        boolean isFlag = true;
        while (isFlag){
            Scanner scan=new Scanner(System.in);
            System.out.println("1-加法. 2-减法. 3-乘法. 4-除法. 0-退出");
            int x = -1;
            try {
                x = scan.nextInt();
                switch (x){
                    case 1:
                        aadd.add();
                        break;
                    case 2:
                        aadd.minus();
                        break;
                    case 3:
                        aadd.multiply();
                        break;
                    case 4:
                        aadd.division();
                        break;
                    case 0:
                        isFlag = false;
                        break;
                    default:
                        System.out.println("输入有误");
                }
            } catch (Exception e) {
                System.out.println("输入有误");
            }
        }
    }

    Random random=new Random();
    public void add(){
        System.out.println("加法闯关开始咯：(输入0退出闯关)");
        Scanner scanner = null;
        int a = random.nextInt(50)+1;
        int b = random.nextInt(50)+1;
        int answer = -1;
        while (true) {
            scanner = new Scanner(System.in);
            try {
                System.out.println(a + "\t+\t" + b + "=?");
                System.out.println("输入你的答案");
                answer = scanner.nextInt();
                if (answer==0) break;
                if (answer!=a+b) {System.out.println("输入有误");
                    continue;
                }
                System.out.println("输入正确,继续闯关");
                a = random.nextInt(50)+1;
                b = random.nextInt(50)+1;
            } catch (Exception e) {
                System.out.println("请输入整数");
            }
        }
        System.out.println("结束闯关");
    }
    public void minus(){
        int a=random.nextInt(49)+2;
        int b=random.nextInt(a-1)+1;
        Scanner scanner = null;
        int answer = -1;
        while (true) {
            scanner = new Scanner(System.in);
            try {
                System.out.println(a + "\t-\t" + b + "=?");
                System.out.println("输入你的答案");
                answer = scanner.nextInt();
                if (answer==0) break;
                if (answer!=a-b) {System.out.println("输入有误");
                    continue;
                }
                System.out.println("输入正确,继续闯关");
                a = random.nextInt(49)+2;
                b = random.nextInt(a-1)+1;
            } catch (Exception e) {
                System.out.println("请输入整数");
            }
        }
        System.out.println("结束闯关");
    }
    public void multiply(){
        int a=random.nextInt(50)+1;
        int b=random.nextInt(50)+1;
        Scanner scanner = null;
        int answer = -1;
        while (true) {
            scanner = new Scanner(System.in);
            try {
                System.out.println(a + "\t*\t" + b + "=?");
                System.out.println("输入你的答案");
                answer = scanner.nextInt();
                if (answer==0) break;
                if (answer!=a*b) {System.out.println("输入有误");
                    continue;
                }
                System.out.println("输入正确,继续闯关");
                a = random.nextInt(50)+1;
                b = random.nextInt(50)+1;
            } catch (Exception e) {
                System.out.println("请输入整数");
            }
        }
        System.out.println("结束闯关");
    }
    public void division(){
        int a=random.nextInt(50)+1;
        int b=random.nextInt(a)+1;
        while ((a%b)!=0){
            b=random.nextInt(a)+1;
        }
        Scanner scanner = null;
        int answer = -1;
        while (true) {
            scanner = new Scanner(System.in);
            try {
                System.out.println(a + "\t/\t" + b + "=?");
                System.out.println("输入你的答案");
                answer = scanner.nextInt();
                if (answer==0) break;
                if (answer!=a/b) {System.out.println("输入有误");
                    continue;
                }
                System.out.println("输入正确,继续闯关");
                a=random.nextInt(50)+1;
                b=random.nextInt(a)+1;
                while ((a%b)!=0){
                    b=random.nextInt(a)+1;
                }
            } catch (Exception e) {
                System.out.println("请输入整数");
            }
        }
        System.out.println("结束闯关");
    }

}

