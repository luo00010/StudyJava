package com.luo.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author luozstart
 * @create 2022-11-14 16:20
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate(){
        Date date1 = new Date(2022-1900,11-1,14);//减去偏移量
        System.out.println(date1);
    }

    /*
    LocalDate,LocalTime,LocalDateTime的使用
        1.LocalDateTime相较于LocalDate，LocalTime，使用频率更高

     */
    @Test
    public void test1(){
        //1.实例化方式一:now():获取当前日期，时期，日期+时间；
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //2.of():手动指定的年，月，日，时，分，秒。没有偏移量。
        LocalDateTime localDateTimeof = LocalDateTime.of(2022, 11, 14, 16, 42);
        System.out.println(localDateTimeof);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());

        //体现不可变性
        //withXxx();设置一些值
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(12);
        System.out.println(localDateTime);      //当前的时间
        System.out.println(localDateTime1);     //修改的时间

        //pulsXxx();增加操作
        LocalDateTime localDateTime2 = localDateTime.plusDays(10);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //minusXxx();减少操作
        LocalDateTime localDateTime3 = localDateTime.minusDays(6);
        System.out.println(localDateTime3);
    }

    //Instant 瞬时
    @Test
    public void test2(){
        //now():获取本初子午线的时间
        Instant instant = Instant.now();//算的是本初子午线的时间
        System.out.println(instant);

        //解决时区问题，增加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取子1970年1月1日0时0分0秒 开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        Instant instant1 = Instant.ofEpochMilli(1550475314878L);
        System.out.println(instant1);
    }


    //DateTimeFormatter:格式化或解析日期，时间（类似于SimpleDateFormat）
    @Test
    public void test3(){
        //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        //格式化：日期-->字符串
        LocalDateTime now = LocalDateTime.now();
        String str = formatter.format(now);
        System.out.println(now);
        System.out.println(str);

        //解析
        TemporalAccessor parse = formatter.parse("2022-11-14T21:06:02.936");
        System.out.println(parse);

//      方式二：
//      本地化相关的格式,如:ofLocalizedDateTime()
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String str2 = formatter1.format(now);
        System.out.println(str2);

//      方式三：自定义的格式。如：ofPatterrn("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter2.format(LocalDateTime.now());
        System.out.println(str4);

    }
}
