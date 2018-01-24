package demo.minifly.com.newandroidframe.application;

/**
 * author ：minifly
 * date: 2017/7/12
 * time: 16:15
 * desc: application自定义
 * 注意：1.不能缓存数据，app到后台之后，会重新创建application，数据会被初始化。
 *      2.执行顺序  构造函数，attachbasecontext，oncreate·
 *      3.继承链
 */
public class MainApplication extends ManageApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationInitializer.initialize(instance);
    }
}
