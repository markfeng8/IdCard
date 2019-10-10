package com.zw_idcard_test.tools;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lvzhongyi
 *         description
 *         date 2015/10/23 0023
 *         email 1179524193@qq.cn
 */
public abstract class ReadRunnableControl implements Runnable  {
    boolean stop = false;

    /**
     * 停止线程
     */
    public synchronized void setStop() {
        this.stop = true;
    }

    /**
     * 清理串口数据
     *
     * @param in 串口输入流
     */
    public void clearSerialPortData(InputStream in) throws IOException {
//        byte[] z = new byte[1300];
        while (in.available() > 0) {
            in.read();
//            in.read(z);
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//            }
        }

    }
}
