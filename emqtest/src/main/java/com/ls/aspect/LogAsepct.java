package com.ls.aspect;

import com.ls.aspect.anno.ServiceLog;
import com.ls.enums.TestModelEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class LogAsepct {
    @Pointcut("@annotation(com.ls.aspect.anno.ServiceLog)")
    public void logCut(){}
    @Around("logCut()")
    public Object sendLog(ProceedingJoinPoint pjp) throws Throwable{
        Object object = pjp.proceed();
        Method method = getMethod(pjp);
        ServiceLog serviceLog =method.getAnnotation(ServiceLog.class);
        System.out.println(serviceLog.moduleName().getModuleName());
        System.out.println(serviceLog.opType().getOpName());
        System.out.println(serviceLog.title());
        System.out.println(serviceLog.detail());
        return object;
    }

    private Method getMethod(ProceedingJoinPoint pjp) {
        // 拦截的实体类，就是当前正在执行的controller
        Object target =pjp.getTarget();
        MethodSignature msig = null;
        // 拦截的方法名称。当前正在执行的方法
        String methodName =pjp.getSignature().getName();
        // 拦截的放参数类型
        Signature sig = pjp.getSignature();
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();
        // 获得被拦截的方法
        Method method = null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (SecurityException e1) {
            e1.printStackTrace();
        }
        return method;
    }
}
