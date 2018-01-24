package demo.minifly.com.newandroidframe.base;

import android.app.Activity;

import java.util.ArrayList;

public class Common {
    private static Common instance;
    // Activity栈  activity栈管理
    private static ArrayList<Activity> activityList;


    // 获取单例
    public static Common getInstance() {
        synchronized (Common.class) {
            if (instance == null) {
                instance = new Common();
                activityList = new ArrayList<>();
            }
        }

        return instance;
    }


    //判断zxing扫描页面参数
    String captureWhere = null;

    public void setCaptureWhere(String where) {
        captureWhere = where;
    }

    public String getCaptureWhere() {
        return captureWhere;
    }

    // 把Activity添加进栈
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    // 把Activity从栈中移除
    public void removeActivity(Activity activity) {
        try {
            activityList.remove(activity);
        } catch (Exception e) {

        }
    }

    // 结束栈中的所有Activity
    public void finishAllActivity() {
        if (activityList != null && activityList.size() != 0) {
            for (int i = 0; i < activityList.size(); i++) {
                try {
                    activityList.get(i).finish();
                } catch (Exception e) {

                }
            }
        }
    }

    long lastClickTime = 0;

    // 判断是不是快速点击，返回true表示不是
    public boolean isNotFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime >= 400) {
            lastClickTime = time;
            return true;
        } else {
            return false;
        }
    }

}