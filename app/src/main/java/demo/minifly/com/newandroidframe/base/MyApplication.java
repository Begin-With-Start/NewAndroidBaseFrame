package demo.minifly.com.newandroidframe.base;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
 */
public class MyApplication extends Application {
    private static MyApplication instance;
    public static SharedPreferencesHelper sp = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        sp = new SharedPreferencesHelper(this);
    }


    public static MyApplication getApplicationInstance(){
        return instance;
    }


    public void setStatusDark(Activity activity, boolean isDark) {
        setMeizuStatusBarDarkIcon(activity, isDark);
        setMiuiStatusBarDarkMode(activity, isDark);
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
