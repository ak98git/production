package com.top.common.constant;

/**
 * enum枚举类
 * 存储系统所有相关的状态码，根据业务模块进行划分：
 * 0：请求成功 -1：系统错误 -2~-99：系统默认配置信息错误
 * 用户相关模块-10000开始
 * -1xxx 用户模块相关错误码
 * ...
 * 按层次递增定义不同类型的错误码
 * @author Super.vae
 */
public enum RespCodeEnum {

	/**
	 *
	 */
	SYS_SUCCESS("0", "操作成功"),
	SYS_ERROR("-1", "系统异常"),
	SYS_AGENTID_ERROR("-2", "代理ID有误"),
	SYS_MEMBER_ERROR("-3", "会员信息有误"),
	SYS_RATE_ERROR("-4", "费率信息有误"),
	SYS_NETWORK_ERROR("-5", "网络连接失败"),
	SYS_DATAPARSE_ERROR("-6", "数据解析失败"),
	SYS_REQPARAM_ERROR("-7", "请求参数有误"),
	SYS_DBDATA_ERROR("-8", "数据冲突异常"),
	SYS_HANDLE_TIPS("-9", "操作失败"),

	USER_NOLOGIN("-10000", "请先登录"),
	USER_RELOGIN("-10001", "信息有误，请重新登录"),
	USER_HAS_REGIST("-10003", "此用户已注册"),
	USER_RECOMMEND_ERROR("-10004", "推荐人信息不存在"),
	USER_OLDPWD_ERROR("-10005", "旧密码有误"),
	USER_MOBILE_NOEXIT("-10006", "请检查手机号是否正确"),
	USER_LOGIN_FAIL("-10007", "账号或密码错误"),
	USER_DISABLE("-10008", "账号已被禁用"),
	USER_AUTHENTICATION("-10009","账号实名认证未通过"),
	
	CARD_CHECK_USERNAME("-20000", "只能绑与实名认证同名的卡"),
	CARD_BINDPARAM_ERROR("-20001", "绑卡参数解析错误"),
	CARD_BINDID_ERROR("-20002", "绑卡记录ID有误"),
	CARD_BINDINFO_ERROR("-20003", "绑卡信息有误"),
	CARD_SETTLEINFO_ERROR("-20004", "结算卡信息有误"),
	CARD_NOT_SUPORT("-20005", "此卡不支持，请换卡"),
	CARD_VALID_ERROR("-20006", "卡有效期格式有误"),
	
	PLAN_EXIT_PAYING("-30000", "该卡已存在进行中的计划，不能重复创建"),
	PLAN_CARD_BINDFAIL("-30001", "该卡在此通道尚未绑卡成功"),
	PLAN_DAY_GTZERO("-30002", "还款天数必须大于等于1"),
	PLAN_CREATE_REPAYMENTDAY("-30003", "还款日当天不能创建计划"),
	PLAN_MAX_PAYMONEY("-30004", "单笔超过最大限额，请增加天数"),
	PLAN_MIN_PAYMONEY("-30005", "单笔低于最大限额，请减少天数"),
	PLAN_OVER_REPAYMENTDAY("-30006", "计划超过还款日，请减少天数"),
	PLAN_CREATE_PARAM_ERROR("-30007", "创建计划的参数有误"),
	PLAN_ORDERID_NOEXIST("-30008", "该订单号不存在"),
	PLAN_BILL_REPAY_DAYERROR("-30009", "账单日或还款日有误"),
	
	PAY_ORDER_NOEXIST("-40000", "该订单号不存在"),
	
	INSETTLE_WITHDRAW_APPYING("-50000", "当前已存在进行中的提现记录"),
	INSETTLE_WITHDRAW_OVER("-50001", "申请的提现金额超额"),
	
	CHANNEL_ERROR("-98000", "通道错误信息"),
	UNKNOW_ERROR("-99999", "未知错误");
	
	private String code;
	private String message;
	
	private RespCodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
