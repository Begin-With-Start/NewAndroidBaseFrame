package demo.minifly.com.newandroidframe.application.core;

/**
 * @author 空袭xian.liu@chemayi.com
 * @date 2014-11-19 下午3:09:39
 * @description
 */
public interface IPreference {
    <T extends Object> T getValue(String key, T defaultValue);

    void saveValue(String key, Object value);

    void removeValue(String key);

    void removeAllValues();
}
