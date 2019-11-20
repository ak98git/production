package com.top.common.constant;

/**
 * Description:
 *
 * 定义系统通用的一些常量字符串、整数等
 * @author Super.vae
 * @date 2019/10/24 21:42
 */
public class BaseConstants {
	
	public static final String SYS_UTF8_ENCODE = "UTF-8";
	
	/** 系统默认接口调用成功状态码：0  */
	public static final String SYS_SUCCESS_CODE = "0";
	
	/** 代还模块缓存key前缀：bm-repay-  */
	public static final String CACHE_REPAY_PREFIX_KEY = "bm-repay-";

	/** 系统默认分页插件中的Key  */
	public static final String SYS_DEFAULT_PAGE_NAME = "page";

	/** 系统默认接口成功信息  */
	public final static String SYS_SUCCESS_MESSAGE = "操作成功";

	/** 系统默认接口失败信息  */
	public final static String SYS_ERROR_MESSAGE = "系统错误";

	/** 系统默认接口响应码字符串  */
	public final static String SYS_RESP_CODE_NAME = "code";

	/** 系统默认接口响应消息字符串  */
	public final static String SYS_RESP_MESSAGE_NAME = "message";

	/** 判断接口调用是否成功的响应标识字段  */
	public final static String SYS_RESP_SUCCESS_FLAG = "success";

	/** 敏感信息加密参数key  */
	public final static String DATA_SECRET_KEY = "BANMA-BAOLI-REPAY-2020";
	
	/** 默认斑码保理主体的代理编号：  */
	public final static String AGENT_BAOLI_CODE = "1986738797";
	
	/** 标识系统已有的各个银行简码信息常量值：  */
	public final static String SYS_BANK_CODES = "0000000000";
	
	/** 创建代还计划时相关的参数key值 -start */
	public final static String PLAN_CONFIG_PARAM = CACHE_REPAY_PREFIX_KEY+"plan-config-param";
	public final static String maxPeriodsOfDay = "maxPeriodsOfDay"; // 一天最大计划笔数
	public final static String firstHourOfDay = "firstHourOfDay"; // 每天计划开始的时间
	public final static String hourOfDayLimit = "hourOfDayLimit"; // 判断当天创建的计划是从当天开始还是第二天开始，超过时从第二天开始
	public final static String lastHourOfDay = "lastHourOfDay"; // 当天计划最后还款时间，超过从第二天开始
	public final static String balanceDefaultPercentage = "balancePercentage"; // 使用可用余额的百分比，默认80%
	public final static String userDefaultRate = "userDefaultRate"; // 用户默认费率
	public final static String maxSinglePayAmount = "maxSinglePayAmount"; // 单笔最大计划金额
	public static final String bigMaxSinglePayAmount = "bigMaxSinglePayAmount";
	public final static String minSinglePayAmount = "minSinglePayAmount"; // 单笔最低计划金额
	public final static String singlePayCostAmount = "singlePayCostAmount"; // 用户默认单笔成本
	public final static String intervalsTimeMin = "intervalsTimeMin"; // 时间间隔最小值
	public final static String intervalsTimeMax = "intervalsTimeMax"; // 时间间隔最大值
	/** 创建代还计划时相关的参数key值 -end */
	
	/** 联系我们的基础信息的参数key值-start  */
	public final static String CONTACT_US_INFO = CACHE_REPAY_PREFIX_KEY+"contact-us-info";
	public final static String contactMobile = "contactMobile";
	public final static String contactWx = "contactWx";
	/** 联系我们的基础信息的参数key值-end  */
	
	/** 系统默认通道的参数key值-start  */
	public final static String DEFAULT_CHANNEL = CACHE_REPAY_PREFIX_KEY+"default-channel";
	public final static String repayChannelCode = "repayChannelCode";
	/** 系统默认通道的参数key值-end  */
	
	/** 系统所有代还通道的参数key值-start  */
	public final static String REPAY_CHANNELS = CACHE_REPAY_PREFIX_KEY+"repay-channels";
	/** 系统所有代还通道的参数key值-end  */
	
	/** 落地商户省份城市信息的参数key值-start  */
	public final static String REPAY_PROVINCES = CACHE_REPAY_PREFIX_KEY+"repay-province-";
	/** 落地商户省份城市信息的参数key值-end  */
	
	/** 短信通道基础信息的参数key值-start  */
	public final static String SMS_CHANNELS = CACHE_REPAY_PREFIX_KEY+"sms-baseinfo";
	public final static String smsSign = "smsSign";
	/** 短信通道基础信息的参数key值-end  */
	
	/** 用户结算信息的参数key值前缀-start  */
	public final static String ACCOUNT_SETTLES = CACHE_REPAY_PREFIX_KEY+"total-settles";
	/** 用户结算信息的参数key值前缀-end  */
	
	/** 用户结算信息的参数key值前缀-start  */
	public final static String SCHEDULED_TASK_SWITCH = CACHE_REPAY_PREFIX_KEY+"task-switch";
	public final static String taskSwitch = "taskSwitch";
	/** 用户结算信息的参数key值前缀-end  */
	
	/** 所有会员记录信息的参数key值前缀-start  */
	public final static String ALL_MEMBER_INFOS = CACHE_REPAY_PREFIX_KEY+"all-memberinfos";
	/** 所有会员记录信息的参数key值前缀-end  */

}
