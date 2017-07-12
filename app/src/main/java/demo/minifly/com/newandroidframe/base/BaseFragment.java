package demo.minifly.com.newandroidframe.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;

import demo.minifly.com.newandroidframe.R;
import demo.minifly.com.newandroidframe.tools.SharedPreferencesHelper;
import demo.minifly.com.newandroidframe.tools.ToastUtils;

public abstract class BaseFragment extends Fragment implements PublicMethodInterface{
    public SharedPreferencesHelper sp;
    public Activity mActivity;
    public ProgressDialog mProgressDialog;
    IntentFilter filter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mActivity = getActivity();
        } catch (Exception e) {
			e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
		super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 退出时统一释放资源
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle();
    }

    // 代替findViewById
    public <T extends View> T findView(View v, int id) {
        return (T) v.findViewById(id);
    }


    // 弹出Toast
    public void toastAtTop(final String msg) {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToastAtTop(msg);
            }
        });
    }

    public void toastAtTop(final int resource) {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToastAtTop(resource);
            }
        });
    }

    // 弹出Toast
    public void toast(final String msg) {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(msg);
            }
        });
    }

    public void toast(final int resource) {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(resource);
            }
        });
    }

    // 打开一个Activity传递一个Bundle
    public void startActivity(Class<? extends Activity> target, Bundle bundle, boolean finish) {
        if (Common.getInstance().isNotFastClick()) {
            Intent intent = new Intent(mActivity, target);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            mActivity.startActivity(intent);
            mActivity.overridePendingTransition(R.anim.comm_slide_in_from_right, R.anim.comm_scale_out);
            if (finish) {
                mActivity.finish();
            }
        }
    }

    // 打开一个Activity传递一个Bundle
    public void startActivityWithoutFastClick(Class<? extends Activity> target, Bundle bundle, boolean finish) {
        Intent intent = new Intent(mActivity, target);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        mActivity.startActivity(intent);
        mActivity.overridePendingTransition(R.anim.comm_slide_in_from_right, R.anim.comm_scale_out);
        if (finish) {
            mActivity.finish();
        }
    }

    // 打开一个Activity传递一个字符串
    public void startActivity(Class<? extends Activity> target, String passDataKey, String value, boolean finish) {
        if (Common.getInstance().isNotFastClick()) {
            Intent intent = new Intent(mActivity, target);
            if (passDataKey != null && value != null) {
                intent.putExtra(passDataKey, value);
            }
            startActivity(intent);
            mActivity.overridePendingTransition(R.anim.comm_slide_in_from_right, R.anim.comm_scale_out);
            if (finish) {
                mActivity.finish();
            }
        }
    }

    // 打开一个Activity传递一个boolean类型
    public void startActivity(Class<? extends Activity> target, String passDataKey, boolean value, boolean finish) {
        if (Common.getInstance().isNotFastClick()) {
            Intent intent = new Intent(mActivity, target);
            if (passDataKey != null) {
                intent.putExtra(passDataKey, value);
            }
            startActivity(intent);
            mActivity.overridePendingTransition(R.anim.comm_slide_in_from_right, R.anim.comm_scale_out);
            if (finish) {
                mActivity.finish();
            }
        }
    }

    // 打开一个Activity传递一个ArrayList
    public void startActivity(Class<? extends Activity> target, String passDataKey, ArrayList<String> list, boolean finish) {
        if (Common.getInstance().isNotFastClick()) {
            Intent intent = new Intent(mActivity, target);
            if (passDataKey != null) {
                intent.putStringArrayListExtra(passDataKey, list);
            }
            startActivity(intent);
            mActivity.overridePendingTransition(R.anim.comm_slide_in_from_right, R.anim.comm_scale_out);
            if (finish) {
                mActivity.finish();
            }
        }
    }

    // 打开一个Activity
    public void startActivityForResult(Class<? extends Activity> target, int requestCode, Bundle bundle) {
        if (Common.getInstance().isNotFastClick()) {
            Intent intent = new Intent(mActivity, target);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            startActivityForResult(intent, requestCode);
            mActivity.overridePendingTransition(R.anim.comm_slide_in_from_right, R.anim.comm_scale_out);
        }
    }

    public void finishActivity() {
        mActivity.finish();
        mActivity.overridePendingTransition(R.anim.comm_scale_in, R.anim.comm_slide_out_to_right);
    }

    // 隐藏软键盘
    public void hideSoftKeyBoard(EditText editText) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        //隐藏键盘
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    // 显示软键盘
    public void showSoftKeyBoard(EditText editText) {
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        //显示键盘
        imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
    }

    public DisplayMetrics getScreenParams() {
        DisplayMetrics dm = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    // 保存到剪切板
    public void saveToClipboard(String text) {
        ClipboardManager c = (ClipboardManager) mActivity.getSystemService(Service.CLIPBOARD_SERVICE);
        c.setText(text);
        toast("已复制到剪切板");
    }

    // 显示ProgressDialog
    public void showProgressDialog(String text) {
        if (mProgressDialog == null || !mProgressDialog.isShowing()) {
            mProgressDialog = new ProgressDialog(mActivity);
            mProgressDialog.setMessage(text);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mActivity);
        } else if (mProgressDialog.isShowing()) {
            return;
        }
        mProgressDialog.setMessage("请求中");
        mProgressDialog.show();
    }

    // 隐藏ProgressDialog
    public void dismissProgressDialog() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
            }
        } catch (Exception e) {
			e.printStackTrace();
        }
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

}
