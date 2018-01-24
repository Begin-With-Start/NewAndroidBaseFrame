package demo.minifly.com.newandroidframe.application;

import android.app.Application;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author minifly
 * @date 2018年
 * @description
 */
public class ApplicationInitializer {
    /**
     * 防止未初始化完成导致后面空指针死机
     */
    public static volatile AtomicBoolean initialized = new AtomicBoolean();

    public static void initialize(final Application application) {
        // TestinAgent.init(application, "95d1346291c0472778f162d8feb5cf5a",
        try {
//            CMYCrashHandler crashHandler = new CMYCrashHandler(application);
            // 设置该CrashHandler为程序的默认处理器
//            Thread.setDefaultUncaughtExceptionHandler(crashHandler);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        init(application);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }).start();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /**
     * 初始化一些必须在主线程中初始化的东西
     * 图片服务的加载
     * 百度统计/bugly等等
     */
    private synchronized static void init(Application application) {
        // ImageLoaderConfiguration config = new
        // ImageLoaderConfiguration.Builder(application)//
        // .threadPriority(Thread.NORM_PRIORITY - 2)//
        // // .denyCacheImageMultipleSizesInMemory()//
        // .memoryCache(new WeakMemoryCache())//
        // .diskCacheFileNameGenerator(new Md5FileNameGenerator())//
        // .tasksProcessingOrder(QueueProcessingType.LIFO)//
        // // .writeDebugLogs()//
        // .build();
        // ImageLoader.getInstance().init(config);
        initialized.set(true);
    }

    public static boolean isInitialized() {
        return initialized.get();
    }
}