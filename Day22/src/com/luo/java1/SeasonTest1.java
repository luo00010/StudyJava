package com.luo.java1;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承java.lang.Enum类
 *
 * @author luozstart
 * @create 2022-11-19 13:47
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 winter = Season1.WINTER;
        //toString();
        System.out.println(winter);

        //values():返回枚举类的对象的数组
        Season1[] values = Season1.values();
        for (int i =0;i<values.length;i++){
            System.out.println(values[i]);
        }

        //valueOf(String objName):返回枚举类中对象名时objName的对象,找不到则报异常
        Season1 winter1 = Season1.valueOf("WINTER");
        System.out.println(winter1);

    }
}

interface Info{
    void show();
}


enum Season1 implements Info{
    //1.提供当前枚举类的对象，多个对象之间用“，”隔开，末尾对象";"结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天春天");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天夏天");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天秋天");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天冬天");
        }
    };

    //2.声明Season对象的属性：private final修饰
    private final String seasonNmae;
    private final String seasonDesc;

    //3.私有化类的构造器，并给对象属性赋值
    private Season1(String seasonNmae, String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonNmae = seasonNmae;
    }

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonNmae(){
        return seasonNmae;
    }
    public String getSeasonDesc(){
        return seasonDesc;
    }

    //4.其他诉求2：toString,此时默认重写toString方法，打印枚举类的属性的名字，如有特殊需求可以再次重写

//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonNmae='" + seasonNmae + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
