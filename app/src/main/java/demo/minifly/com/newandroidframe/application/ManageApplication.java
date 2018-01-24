package demo.minifly.com.newandroidframe.application;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.support.multidex.MultiDexApplication;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import demo.minifly.com.newandroidframe.tools.SharedPreferencesHelper;

/**
 * author ：minifly
 * date: 2017/7/12
 * time: 16:15
 * desc: application自定义
 * 注意：1.不能缓存数据，app到后台之后，会重新创建application，数据会被初始化。
 *      2.执行顺序  构造函数，attachbasecontext，oncreate·
 *      3.继承链
 */
public class ManageApplication extends MultiDexApplication {
    protected static ManageApplication instance;
    public static SharedPreferencesHelper sp = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        sp = new SharedPreferencesHelper(this);
        Log.d("Framework", "oncreate");
    }

    public static ManageApplication getApplicationInstance(){
        return instance;
    }


    public void setStatusDark(Activity activity, boolean isDark) {
        setMeizuStatusBarDarkIcon(activity, isDark);
        setMiuiStatusBarDarkMode(activity, isDark);
    }

    @Override
    public void onTerminate() {
        // 程序终止的时候执行
        Log.d("Framework", "onTerminate");
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        // 低内存的时候执行
        Log.d("Framework", "onLowMemory");
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        // 程序在内存清理的时候执行
        Log.d("Framework", "onTrimMemory");
        super.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d("Framework", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    // 获取版本名
    public String getVersionName() {
        PackageManager packageManager = getPackageManager();
        PackageInfo packageInfo;
        String versionName = "";
        try {
            packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 小米状态栏定制
     * @param activity
     * @param darkmode
     * @return
     */
    private boolean setMiuiStatusBarDarkMode(Activity activity, boolean darkmode) {
        try {
            Class<? extends Window> clazz = activity.getWindow().getClass();
            int darkModeFlag = 0;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(activity.getWindow(), darkmode ? darkModeFlag : 0, darkModeFlag);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 魅族的状态栏定制
     * @param activity
     * @param dark
     * @return
     */
    private boolean setMeizuStatusBarDarkIcon(Activity activity, boolean dark) {
        boolean result = false;
        if (activity != null) {
            try {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                activity.getWindow().setAttributes(lp);
                result = true;
            } catch (Exception e) {
            }
        }
        return result;
    }
}
