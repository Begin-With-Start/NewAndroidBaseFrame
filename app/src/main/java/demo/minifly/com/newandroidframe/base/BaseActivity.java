package demo.minifly.com.newandroidframe.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;

import demo.minifly.com.newandroidframe.R;
import demo.minifly.com.newandroidframe.annotation.BindEventBus;
import demo.minifly.com.newandroidframe.annotation.eventbus.EventManager;
import demo.minifly.com.newandroidframe.tools.ProgressDialogUtils;
import demo.minifly.com.newandroidframe.tools.SharedPreferencesHelper;
import demo.minifly.com.newandroidframe.tools.ToastUtils;

public class BaseActivity extends AppCompatActivity{
    public SharedPreferencesHelper sp = null;
    public Context mContext;
    protected  ProgressDialogUtils progressDialogUtils = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= 19) {
            // 设置沉浸式
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // android:background="@color/white_color"
            // android:clipToPadding="true"
            // android:fitsSystemWindows="true"
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        mContext = this;

        try {
            // 设置小米和魅族手机的状态栏变灰
            MyApplication.getApplicationInstance().setStatusDark(this, true);
        }
        catch (Exception e) {

        }

        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventManager.register(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Common.getInstance().removeActivity(this);
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventManager.unregister(this);
        }
    }

    // 代替findViewById
    public <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    // 弹出Toast
    public void toastAtTop(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToastAtTop(msg);
            }
        });
    }

    public void toastAtTop(final int resource) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToastAtTop(resource);
            }
        });
    }

    // 弹出Toast
    public void toast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(msg);
            }
        });
    }

    public void toast(final int resource) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(resource);
            }
        });
    }

    // 打开一个Activity传递一个Bundle
    public void startActivity(Class<? extends Activity> target, Bundle bundle, boolean finish) {
        if (Common.getInstance().isNotFastClick()) {
            Intent intent = new Intent(this, target);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            startActivity(intent);
            overridePendingTransition(R.anim.comm_slide_in_from_right, R.anim.comm_scale_out);
            if (finish) {
                finish();
            }
        }
    }

    // 打开一个Activity传递一个字符串
    public void startActivity(Class<? extends Activity> target, String passDataKey, String value, boolean finish) {
        if (Common.getInstance().isNotFastClick()) {
            Intent intent = new Intent(this, target);
            if (passDataKey != null && value != null) {
                intent.putExtra(passDataKey, value);
            }
            startActivity(intent);
            overridePendingTransition(R.anim.comm_slide_in_from_right, R.anim.comm_scale_out);
            if (finish) {
                finish();
            }
        }
    }

    // 打开一个Activity传递一个boolean类型
    public void startActivity(Class<? extends Activity> target, String passDataKey, boolean value, boolean finish) {
        if (Common.getInstance().isNotFastClick()) {
            Intent intent = new Intent(this, target);
            if (passDataKey != null) {
                intent.putExtra(passDataKey, value);
            }
            startActivity(intent);
            overridePendingTransition(R.anim.comm_slide_in_from_right, R.anim.comm_scale_out);
            if (finish) {
                finish();
            }
        }
    }

    // 打开一个Activity传递一个ArrayList
    public void startActivity(Class<? extends Activity> target, String passDataKey, ArrayList<String> list, boolean finish) {
        if (Common.getInstance().isNotFastClick()) {
            Intent intent = new Intent(this, target);
            if (passDataKey != null) {
                intent.putStringArrayListExtra(passDataKey, list);
            }
            startActivity(intent);
            overridePendingTransition(R.anim.comm_slide_in_from_right, R.anim.comm_scale_out);
            if (finish) {
                finish();
            }
        }
    }

    // 打开一个Activity
    public void startActivityForResult(Class<? extends Activity> target, int requestCode, Bundle bundle) {
        if (Common.getInstance().isNotFastClick()) {
            Intent intent = new Intent(this, target);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            startActivityForResult(intent, requestCode);
            overridePendingTransition(R.anim.comm_slide_in_from_right, R.anim.comm_scale_out);
        }
    }

    // 获取上个界面传过来的Bundle
    public Bundle getBundle() {
        try {
            Intent it = getIntent();
            if (it != null && it.getExtras() != null) {
                return it.getExtras();
            }
        } catch (Exception e) {

        }

        return null;
    }

    public void finishActivity() {
        finish();
        overridePendingTransition(R.anim.comm_scale_in, R.anim.comm_slide_out_to_right);
    }

    public void finishActivityForResult(int resultCode, Bundle bundle) {
        Intent intent1 = new Intent();
        if (bundle != null) {
            intent1.putExtras(bundle);
        }
        setResult(resultCode, intent1);
        finish();
        overridePendingTransition(R.anim.comm_scale_in, R.anim.comm_slide_out_to_right);
    }

    public void finishActivityForResult(int resultCode) {
        finishActivityForResult(resultCode, null);
    }

    // 隐藏软键盘
    public void hideSoftKeyBoard(EditText editText) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //隐藏键盘
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    // 显示软键盘
    public void showSoftKeyBoard(EditText editText) {
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //显示键盘
        imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
    }

    // 保存到剪切板
    public void saveToClipboard(String text) {
        ClipboardManager c = (ClipboardManager) getSystemService(Service.CLIPBOARD_SERVICE);
        c.setText(text);
        toast("已复制到剪切板");
    }

    //获取随机数， 参数为返回随机数的长度
    public String generateRandomString(int length) {
        String allChar = "0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }

    // 显示ProgressDialog
    public void showProgressDialog() {
        progressDialogUtils = ProgressDialogUtils.show(mContext);
    }

    // 显示ProgressDialog
    public void showProgressDialog(String text) {
        progressDialogUtils = ProgressDialogUtils.show(mContext,text);
    }

    // 隐藏ProgressDialog
    public void dismissProgress() {
        if (progressDialogUtils != null && progressDialogUtils.isShowing()) {
            progressDialogUtils.dismiss();
        }
    }

    //改变progress上文字
    public void setProgressDialogText(String text){
        if (progressDialogUtils != null){
            progressDialogUtils.setTextHint(text);
        }
    }


    public Display getScreenParams() {
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        return display;
    }

}
