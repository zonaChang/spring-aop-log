package com.cez.study.spring.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @desc: 自定义业务基本日志
 * @auth: zona
 * @createTime: 2017年6月22日 下午6:23:59
 */
public class BusinessLevelLog extends Level{

	/**  */
	private static final long serialVersionUID = -4079978408316475097L;
	
	private static final Logger LOGGER = Logger.getLogger(BusinessLevelLog.class);
	// 日志名称
	public static final String LOG_NAME = "businessLevelLog";
	//  当前日志的权重
	public static final int BUSINESS_INT = INFO_INT + 1000;
	
	public static final Level business = new BusinessLevelLog(BUSINESS_INT, LOG_NAME, BUSINESS_INT);
	
	protected BusinessLevelLog(int level, String levelStr, int syslogEquivalent) {
		super(level, levelStr, syslogEquivalent);
	}
	
	public static void outLog(Object logInfo) {
		LOGGER.log(business, logInfo);
	}

}
