package demo.minifly.com.newandroidframe.constant;


public class Constant {
    // TODO: 2016/10/20  全局长期保存的数据
    public static final String sp_Token = "sp_token";
    public static final String sp_Env = "sp_env"; // 当前是那个环境
    public static final String sp_Address_Version = "sp_address_version";
    public static final String sp_RegistrationID = "sp_RegistrationID";  //极光推送

    // 当前在某个环境的常量
    public static final String ENV_DEV = "env_dev";
    public static final String ENV_CIT = "env_cit";
    public static final String ENV_SIT = "env_sit";
    public static final String ENV_UAT = "env_uat";
    public static final String ENV_RELEASE = "env_release";
    public static final String ENV_DEFAULT = "env_dev"; // 默认环境，更改默认环境只需要改这个就可以了

    // 不同环境的base URL
    public static final String URL_BASE_DEV = "http://192.168.6.24:8080/";
    public static final String URL_BASE_CIT = "http://192.168.6.31:8080/";
    public static final String URL_BASE_SIT = "http://sit.xxxxx";
    public static final String URL_BASE_UAT = "http://uat.xxx";
    public static final String URL_BASE_RELEASE = "http://release.xxxxx";

    /**
     * 常用常量
     */
    public static final int TERMS_SYSTEM_SERVICE = 0;//系统服务条款


    /**
     * 微信登录
     */
    public static final String URL_LOGIN_APP = "gateway/router/login.appLogin/v1.0";
    /**
     * 用户名密码登录
     */
    public static final String URL_LOGIN_ACCOUNT = "gateway/router/login.account/v1.0";
    /**
     * 登出
     */
    public static final String URL_LOGIN_OUT = "gateway/router/user.loginOut/v1.0";
    /**
     * 账号锁定解锁(手动锁定解锁)
     */
    public static final String URL_ACCOUNT_LOCK = "gateway/router/user.accountLock/v1.0";
    /**
     * 账号解锁查询(手动解锁)
     */
    public static final String URL_GET_ACCOUNT_LOCK = "gateway/router/user.getAccountLock/v1.0";
    /**
     * 绑定设备
     */
    public static final String URL_LOGIN_BIND = "gateway/router/login.bind/v1.0";
    /**
     * 获取短信验证码(验证图片验证码,发送短信验证码)
     */
    public static final String URL_GET_SMS_VERIFICATION ="gateway/router/register.verifyCodeSms/v1.0";
    /**
     * 获取图片验证码
     */
    public static final String URL_GET_IMAGE_VERIFICATION = "gateway/login/getImageVerification/v1.0";
    /**
     * 验证手机短信验证码
     */
    public static final String URL_CHECK_VERIFY_CODE = "gateway/router/register.checkVerifyCode/v1.0";
    /**
     * 修改密码
     */
    public static final String URL_UPDATE_PASSWORD = "gateway/router/modify.updatePassword/v1.0";
    /**
     * 保存注册信息
     */
    public static final String URL_RECEIVE_REGISTER_INFO = "gateway/router/register.receiveRegisterInfo/v1.0";
    //验证身份证
    public static final String URL_CHECK_ID_CARD = "gateway/router/register.checkIdCard/v1.0";
    //服务认证邀请
    public static final String URL_CREATE_INVITE = "gateway/router/invite.createInvite/v1.0";
    //验证邀请码是否有效
    public static final String URL_CHECK_INVITE_CODE = "gateway/router/register.checkInviteCode/v1.0";

    /**
     * 验证手机端扫的二维码(扫码登录功能)
     */
    public static final String URL_VALIDATE_SCAN_CODE = "gateway/router/user.validateScanCode/v1.0";
    /**
     * 手机端确认登录(扫码登录功能)
     */
    public static final String URL_CONFIRM_LOGIN = "gateway/router/user.confirmLogin/v1.0";
    /**
     * 上传图片接口
     */
    public static final String URL_UPLOAD_FILE = "gateway/uploads?type=avatar";


    /**
     * 微信
     */
    public static final String APP_ID = "wxfbf6e942942b21cc";

    /**
     * 通过微信登录的code和邀请码获取用户的登录状态
     */
    public static final String APP_LOGIN = "applogin";


    public static final String UNOINPAYMODE = "" ;//银联支付模式
    /**
     * 支付宝获取订单信息
     */
    public static final String ALIPAY = "pay/mobilePay";

    /**
     * 获取省市区列表数据接口
     */
    public static final String GET_ROUTER_AREA = "gateway/router/icArea.listAllAreas/v1.0";

    /**
     * 地址列表版本号
     */
    public static final String GET_ADDRESS_VERSION = "gateway/router/icArea.getVersion/v1.0";

    /**
     * 添加往来单位
     */
    public static final String ADD_CURRENT_UNIT = "gateway/router/contactUnits.saveContactUnits/v1.0";

    /**
     * 编辑往来单位
     */
    public static final String EDIT_CURRENT_UNIT = "gateway/router/contactUnits.selectContactUnits/v1.0";

    /**
     * 删除往来单位
     */
    public static final String DELETE_CURRENT_UNIT = "gateway/router/contactUnits.deleteContactsUnit/v1.0";

    /**
     * 获取所有往来单位列表数据
     */
    public static final String GET_CURRENT_UNIT = "gateway/router/contactUnits.selectContactUnits/v1.0";

    public static final String KEY_LOGIN_MOBILE = "key_login_mobile";
    public static final String KEY_LOGIN_IMAGE_CODE = "key_login_image_code";
    public static final String KEY_LOGIN_SMS_CODE = "key_login_sms_code";
    public static final String KEY_UPLOAD_LIST = "key_upload_list";
    public static final String KEY_LOCK_ACCOUNT_STATE = "key_lock_account_state";

    /**
     * 校验店铺名字是否存在
     */
    //校验是否存在该店铺
    public static final String CHECK_STORE_IS_THRER = "gateway/router/activeShop.checkShopIsAtByName/v1.0";

    /**
     * 校验仓库名字是否存在
     */
    public static final String CHECK_WAREHOUSE_NAME_IS_THERE = "gateway/router/activeWarehouse.checkWarehouseIsAtByName/v1.0";

    /**
     * 获取平台列表
     */
    public static final String GET_PLATFORM_LIST = "gateway/router/platformAuth.getPlatforms/v1.0";

    /**
     * 获取第四级地址列表接口
     */
    public static final String GET_FOUR_ADDRESS_LIST = "gateway/router/icArea.getArea/v1.0";

    /**
     * 激活店铺
     */
    public static final String ACTIVATION_STORE = "gateway/router/activeShop.activeShop/v1.0";

    /**
     * 激活仓库
     */
    public static final String ACTIVATION_WAREHOUSE = "gateway/router/activeWarehouse.activeStock/v1.0";
    /**
     * 获取淘宝授权的链接
     */
    public static final String GET_TAOBAO_AUTH = "gateway/router/platformAuth.getAuthUrl/v1.0";
}
