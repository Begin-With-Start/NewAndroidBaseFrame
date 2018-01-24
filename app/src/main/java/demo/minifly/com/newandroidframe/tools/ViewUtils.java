package demo.minifly.com.newandroidframe.tools;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 空袭
 * @date 2015-7-31 下午3:17:58
 * @description 跟Activity相关的帮助类
 */
public class ViewUtils {

    /**
     * 获得string文件中的字符串
     *
     * @param resId
     * @return
     */
    public static String getResourceStr(Context context, int resId) {
        return context.getResources().getString(resId);
    }

    /**
     * 获得格式化后的字条串
     *
     * @param resId
     * @param args
     * @return
     */
    public static String getResourceStr(Context context, int resId, Object... args) {
        return String.format(getResourceStr(context, resId), args);
    }


    /**
     * 获得布局文件的view的id
     *
     * @param resourceName 資源名 默認layout
     * @return
     */
    public static int getResId(Context context, String resourceName) {
        return context.getResources().getIdentifier(resourceName, "layout", context.getPackageName());
    }

    /**
     * 获得布局文件的view的id
     *
     * @param resourceName  资源名
     * @param resParentName 资源存放的上级目录
     * @return
     */
    public static int getResId(Context context, String resourceName, String resParentName) {
        return context.getResources().getIdentifier(resourceName, resParentName, context.getPackageName());
    }

    /**
     * 打开软键盘
     */
    public static void openKeyBoard(final Context mContext, int time) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }, time);
    }

    /**
     * 关闭软键盘
     *
     */
    public static void hideKeyBoard(FragmentActivity mContext) {
        InputMethodManager inputMsg = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMsg.isActive()) { // 隐藏软键盘
            View curView = mContext.getCurrentFocus();
            if (curView != null) {
                inputMsg.hideSoftInputFromWindow(curView.getWindowToken(), 0);
            }
        }
    }

    /**
     * 获得ListView的高度
     *
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        if (listView == null || listView.getAdapter() == null) {
            return;
        }
        int totalHeight = getListViewHeight(listView);
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listView.getAdapter().getCount() + 1));
        listView.setLayoutParams(params);
    }

    public static int getListViewHeight(ListView listView) {
        return getListViewHeight(listView, false);
    }

    public static int getListViewHeight(ListView listView, boolean isMeasured) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return 0;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (isMeasured) {
                listItem.measure(0, 0);
            }
            totalHeight += listItem.getMeasuredHeight();
        }
        return totalHeight;
    }

    //判断是否能上拉加载，ListView高度大于窗体高度则可以 有要包括listview的高度，还有actionBar和其他高度（比如ScrollViewPager框架的Tablayout高度）
    public static boolean isLoadEnable(Context mContext, ListView listView, int otherHeight) {//仅适用于有ActionBar和TabLayout的页面
        boolean isPullEnable = true;
        int mHeight = otherHeight + getListViewHeight(listView, true);
        if (mHeight < ScreenUtils.getScreenHeight(mContext)) {
            isPullEnable = false;
        }
        return isPullEnable;
    }

    /**
     * 默认包括ActionBar和Tablayout以及listView高度
     *
     * @param mContext
     * @param listView
     * @return
     */
    public static boolean isLoadEnable(Context mContext, ListView listView) {//仅适用于有ActionBar和TabLayout的页面
        int otherHeight = 0;
        int actionBarHeight = ConvertUtils.dip2px(mContext, 48);
        int tabLayHeight = actionBarHeight;
        otherHeight = actionBarHeight + tabLayHeight;
        return isLoadEnable(mContext, listView, otherHeight);
    }

    /**
     * 使当前Layout展开数据
     *
     * @param layout
     */
    public static void setLayoutHeightBasedOnChildren(LinearLayout layout) {
        int num = layout.getChildCount();
        if (num == 0) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < num; i++) {
            // View listItem = layout.getChildAt(i);
            // listItem.measure(0, 0);
            totalHeight += 250;
        }
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.height = totalHeight;
        layout.setLayoutParams(params);
    }

    /**
     * 使当前GrieView展开数据
     *
     * @param gridView
     */
    public static void setGridViewHeightBasedOnChildren(GridView gridView) {
        ListAdapter listAdapter = gridView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, gridView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight / 4;// + (gridView.getgetDividerHeight() *
        // (listAdapter.getCount() + 1));
        gridView.setLayoutParams(params);
    }

    /**
     * 获得Html格式的Spanned对象
     *
     * @param resource
     * @param id
     * @param objects
     * @return
     */
    public static Spanned getSpannedHtml(Resources resource, int id, Object... objects) {
        return Html.fromHtml(String.format(resource.getString(id), objects));
    }

    /**
     * 获得资源数组
     *
     * @param context
     * @param resId
     * @return
     */
    public static String[] getResourceArray(Context context, int resId) {
        return context.getResources().getStringArray(resId);
    }

    /**
     * 设置值后，光标自动到最后
     *
     * @param mEditTv
     * @param str
     */
    public static void setSpanText(TextView mEditTv, String str) {
        mEditTv.setText(str);
        CharSequence text = mEditTv.getText();
        if (text instanceof Spannable) {
            Spannable spanText = (Spannable) text;
            Selection.setSelection(spanText, text.length());
        }
    }

    /**
     * @param convertView
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <V extends View> V getElement(View convertView, int id) {
        View targetView = convertView.findViewById(id);
        return (V) targetView;
    }
}
