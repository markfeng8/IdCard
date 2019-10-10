package com.zw_idcard_test.tools;

import com.zw_idcard_test.SerialPort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * @author lvzhongyi
 * description 读卡信息的帮助类
 * date 2015/10/23 0023
 * email 1179524193@qq.cn
 */
public class CardHelper {
    private static final ExecutorService SERVICE = Executors.newSingleThreadExecutor();
    private static ReadIdRunnable readIdRunnable;
    private static ReadInfoRunnable readInfoRunnable;

    /**
     * 得到卡体管理号
     *
     * @param port       串口对象{@link SerialPort}
     * @param outTime    超时时间
     * @param readResult 读卡结果{@link ReadIdResult}
     */
    public static void getCardId(SerialPort port, int outTime, int intervalTime, ReadIdResult readResult) {
        readIdRunnable = new ReadIdRunnable(port, outTime, intervalTime, readResult);
        SERVICE.execute(readIdRunnable);
    }

    /**
     * 得到身份证信息
     *
     * @param port           串口对象{@link SerialPort}
     * @param outTime        超时时间
     * @param readInfoResult 读卡结果{@link ReadInfoResult}
     */
    public static void getCardInfo(SerialPort port, int outTime, int intervalTime, ReadInfoResult readInfoResult) {
        readInfoRunnable = new ReadInfoRunnable(port, outTime, intervalTime, readInfoResult);
        SERVICE.execute(readInfoRunnable);
    }

    public static void stops() {
        if (readIdRunnable != null)
            readIdRunnable.setStop();
        if (readInfoRunnable != null)
            readInfoRunnable.setStop();
    }
}
