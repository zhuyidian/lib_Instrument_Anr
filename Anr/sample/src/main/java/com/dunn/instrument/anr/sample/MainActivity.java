package com.dunn.instrument.anr.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends Activity {
    public static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ApiCrash.crashInit(getApplication());
        //ApiAnrWatchDog.anrInit(getApplicationContext());
        //ApiMethodChoreographer.methodInit();
        //ApiMethodChoreographer.choreographerInit();
        //ApiThread.threadInit();
        //ApiIO.ioStart();
    }

    public void click(View view) {
        Log.i(TAG,"click:");
        //ApiLogger.logOut("logger日志测试");
        //ApiExcel.excelInfo();
        //ApiExcel.excelSubmit();
        //ApiCrash.nativeCrashTest();
        //smallBuffer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ApiLogger.loggerRelease();
    }

    //------------------------------------TEST--------------------------------
    //IO Test
    /**
     * 监控读的 buffer 比较小，400
     */
    private void smallBuffer() {
        // I/Choreographer: Skipped 82 frames!
        // The application may be doing too much work on its main thread.
        // 对接的 sdk 业务方，腾讯新闻，腾讯QQ 是不允许在主线程中做 IO 操作
        // 其他业务不允许长时间的 IO 操作，主线程的 IO 操作耗时超过 100ms 会警告，腾讯微视，腾讯体育，腾讯视频
        long startTime = System.currentTimeMillis();
        try {
            File file = new File("sdcard/a_long.txt");
            byte[] buf = new byte[400];
            FileInputStream fis = new FileInputStream(file);
            int count = 0;
            while ((count = fis.read(buf)) != -1) {
                // Log.e("TAG", "read -> " + count);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TAG","文件读操作：e"+e);
        }

        Log.e("TAG","总的操作时间："+(System.currentTimeMillis() - startTime));
    }
}
