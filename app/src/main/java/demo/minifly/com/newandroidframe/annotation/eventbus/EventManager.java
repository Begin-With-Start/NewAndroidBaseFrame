package demo.minifly.com.newandroidframe.annotation.eventbus;

import de.greenrobot.event.EventBus;

/**
 * Created by feng.gao on 2017/11/2.
 * eventBus统一管理
 */

public class EventManager {
	/**
	 * 注册
	 * @param object
	 */
	public static void register(Object object) {
		if (!EventBus.getDefault().isRegistered(object)) {
			EventBus.getDefault().register(object);
		}
	}

	/**
	 * 注销
	 * @param object
	 */
	public static void unregister(Object object) {
		if (EventBus.getDefault().isRegistered(object)) {
			EventBus.getDefault().unregister(object);
		}
	}

	/**
	 * 发送消息
	 * @param object
	 */
	public static void post(Object object) {
		EventBus.getDefault().post(object);
	}
}
