package com.ls.aspect.anno;

import com.ls.enums.TestModelEnum;
import com.ls.enums.TestOperationType;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface ServiceLog {
    /**
     *  模块名称
     * @return
     */
    TestModelEnum moduleName();

    /**
     * 操作类型：增删改查等等
     * @return
     */
    TestOperationType opType();


    /**
     * 标题：新增设备/删除设备...
     */
    String title();
    /**
     * 详细内容
     */
    String detail();
}
