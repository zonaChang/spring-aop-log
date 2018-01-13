package com.cez.study.spring.log;

import lombok.Data;

import org.apache.log4j.Level;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @desc: 
 * @auth: zona
 * @createTime: 2017年6月22日 下午6:50:58
 * @修订一：
 * 		日期：2017年6月22日 下午3:53:34
 * 		需求：将类名从BussinessFilter修改为LogFilter
 * 		理由：该filter可针对任意自定义日志级别。当再新建日志级别时只需要在该filter中添加对应日志级别的相关信息即可
 * 		
 */
@Data
public class LogFilter extends Filter{

	boolean acceptOnMatch = false;  
	
	// levelMin 和 levelMax是在日志配置文件中配置的
    private String levelMin;  
    private String levelMax;  
      
    @Override  
    public int decide(LoggingEvent lgEvent) {
    	
        int inputLevel = lgEvent.getLevel().toInt();  
        return inputLevel>=getLevel(levelMin) && inputLevel <= getLevel(levelMax)  ? 0 : -1;
    }
      
    private int getLevel(String level){  
        int type = -10;
        switch (level.toUpperCase()) {
		case "BUSINESSLEVELLOG":
			type = BusinessLevelLog.BUSINESS_INT;
			break;
		case "INFO":
			type = Level.INFO_INT;
			break;
		case "DEBUG":
			type = Level.DEBUG_INT;
			break;
		case "WARN":
			type = Level.WARN_INT;
			break;
		case "ERROR":
			type = Level.ERROR_INT;
			break;
		case "FATAL":
			type = Level.FATAL_INT;
			break;
		case "OFF":
			type = Level.OFF_INT;
			break;
		case "ALL":
			type = Level.ALL_INT;
			break;
		default:
			type = Level.OFF_INT;
			break;
		}
        return type;  
    }  
}
