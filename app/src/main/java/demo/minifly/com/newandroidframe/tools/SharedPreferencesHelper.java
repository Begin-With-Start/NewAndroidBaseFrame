package demo.minifly.com.newandroidframe.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesHelper {

	SharedPreferences sp;
	Editor editor;

	Context conext;

	public SharedPreferencesHelper(Context context) {
		this.conext = context;
		sp = context.getSharedPreferences("yuepai", 0);
		editor = sp.edit();
	}

	public void putValue(String key, String value) {
		editor.putString(key, value);
		editor.commit();
	}

	public String getValue(String key) {
		// 第二个参数是默认值， 如果取的时候发现没数据，那就会自动设置为空
		return sp.getString(key, "1");
	}
	public String getValue(String key, String defaultValue) {
		return sp.getString(key, defaultValue);
	}

	public void putIntValue(String key, int value) {
		editor.putInt(key, value);
		editor.commit();
	}

	public int getIntValue(String key) {
		// 第二个参数是默认值， 如果取的时候发现没数据，那就会自动设置为空
		return sp.getInt(key, -1);
	}

	public void putBooleanValue(String key, boolean value) {
		editor.putBoolean(key, value);
		editor.commit();
	}

	public boolean getBooleanValue(String key) {
		// 第二个参数是默认值， 如果取的时候发现没数据，那就会自动设置为空
		return sp.getBoolean(key, false);
	}
	public boolean getBoolValue(String key) {
		// 第二个参数是默认值， 如果取的时候发现没数据，那就会自动设置为空
		return sp.getBoolean(key, true);
	}
	public void deleteValue(Context context, String key) {
		sp = context.getSharedPreferences("yuepai", 0);
		editor = sp.edit();
		editor.remove(key);
		editor.commit();
	}
}
