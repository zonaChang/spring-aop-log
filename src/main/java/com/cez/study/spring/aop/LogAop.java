package com.cez.study.spring.aop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.cez.study.spring.log.BusinessLevelLog;

/**
 * @desc: 记录输入输出参数日志
 * @auth: zona
 * @createTime: 2017年6月21日 下午4:55:41
 */
@Component
public class LogAop {
	
	/**
	 * 
	 * @desc: 控制层使用的环绕通知
	 * @auth: zona
	 * @createTime:2017年6月22日 下午9:09:37 
	 * @param point
	 * @return
	 * @throws Throwable
	 */
    public Object controllerAroundMethod(ProceedingJoinPoint point) throws Throwable {
    	
    	String target = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
		Object[] args = point.getArgs();
		String[] paramsName =  ((MethodSignature) point.getSignature()).getParameterNames();
		StringBuffer sb = new StringBuffer("【 ");
		for (int i=0; i< paramsName.length; i++) {
			sb.append(" ").append(paramsName[i]).append(" = ").append(args[i]).append(",");
		}
		sb.deleteCharAt(sb.length()-1).append("】");
		BusinessLevelLog.outLog(target +" controllerAroundMethod aopBefore 入参：" + sb.toString());
		
		// 注意： 修改返回值时， 不能修改返回值类型。  最好规定返回值统一
		Map<String, Object> result = (Map<String, Object>) point.proceed(); //获取被切函数的 返回值
        result.put("add", "我是后置添加的信息");
        BusinessLevelLog.outLog(target +" controllerAroundMethod aopAfter 出参：" + result);
        return result;
    }
    
    /**
     * 
     * @desc: 一般方法使用的环绕通知
     * @auth: zona
     * @createTime:2017年6月22日 下午9:10:13 
     * @param point
     * @return
     * @throws Throwable
     */
    public Object commonAroundMethod(ProceedingJoinPoint point) throws Throwable {
    	
    	String target = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
    	Object[] args = point.getArgs();
    	String[] paramsName =  ((MethodSignature) point.getSignature()).getParameterNames();
    	StringBuffer sb = new StringBuffer("【 ");
    	if(args != null && paramsName != null && args.length > 0 && paramsName.length > 0) {
    		for (int i=0; i< paramsName.length; i++) {
    			sb.append(" ").append(paramsName[i]).append(" = ").append(args[i]).append(",");
    		}
    		sb.deleteCharAt(sb.length()-1);
    	}
    	sb.append("】");
    	BusinessLevelLog.outLog(target +" commonAroundMethod aopBefore 入参：" + sb.toString());
    	Object result = point.proceed();
    	BusinessLevelLog.outLog(target +" commonAroundMethod aopAfter 出参：" + result);
    	return result;
    }
    
    
}
