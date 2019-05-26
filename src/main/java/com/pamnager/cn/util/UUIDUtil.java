package com.pamnager.cn.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * UUID工具类
 */
public class UUIDUtil {


    private static final String BASE_NAME = "es";


    /**UUID全局唯一标识符号，是指在一台机器上生成的数字
     * 他保证在同一时空中的所有机器都是唯一的
     * 用到了以太网地址，纳秒级时间，芯片ID码和许多可能的数字
     */

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static StringBuffer buf = new StringBuffer();

    //锁对象
    private static Lock lock = new ReentrantLock();


    /**
     * 随机产生32位16进制的随机数
     * @return
     */
    public static String getRandom32PK(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     * 随机产生19位长度字符串，以时间开头
     * @return
     */
    public static String getRandomBeginTimePk(){

        lock.lock();
        Date date = new Date();
        String timeStr = sdf.format(date);

        String random32 = getRandom32PK();
        Random random = new Random();
        buf.setLength(0);
        int n;
        for (int i = 0; i< 2; i++){
            n = random.nextInt(random32.length()) -1;
            if (n < 0){
                n = 0;
            }
            buf.append(random32.substring(n, n+1));
        }
        lock.unlock();
        return timeStr + buf.toString();
    }


    /**
     * 随机产生32位16进制字符串，以时间开头
     * @return
     */

    public static String getRandom32BeginTimePK() {
        lock.lock(); //加锁
        Date d = new Date();
        String timeStr = sdf.format(d);
        String random32 = getRandom32PK();
        lock.unlock();
        return timeStr + random32.substring(17, random32.length());
    }


    /**
     * 随机产生32位16进制字符串，以时间结尾
     * @return
     */
    public static String getRandom32EndTimePK() {
        lock.lock(); //加锁
        Date d = new Date();
        String timeStr = sdf.format(d);
        String random32 = getRandom32PK();
        lock.unlock();
        return random32.substring(0, random32.length() - 17) + timeStr;
    }

    public final static String generateWithSeq() {
        return Long.toString(System.currentTimeMillis() * 1000000
                + new AtomicLong(1).incrementAndGet());
    }



}
