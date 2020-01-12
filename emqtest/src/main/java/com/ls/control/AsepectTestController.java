package com.ls.control;

import com.ls.aspect.anno.ServiceLog;
import com.ls.entity.Message;
import com.ls.entity.Role;
import com.ls.enums.TestModelEnum;
import com.ls.enums.TestOperationType;
import com.ls.service.AspectServcieTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

@RestController
@RequestMapping("aspectTest")
public class AsepectTestController {
    @Autowired
    private AspectServcieTest aspectServcieTest;
    @RequestMapping("get")
    public Message getMessage(@RequestParam int id){
        Message message = aspectServcieTest.getMessage(id);
        return message;
    }
    @RequestMapping("addRole")
    @ServiceLog(moduleName = TestModelEnum.MODULE_USER_ROLE,opType = TestOperationType.TYPE_ADD,title = "添加角色",detail="")
    public void addRole(@RequestBody Role role){

        try {
            //获取注解实例
            ServiceLog serviceLog = AsepectTestController.class.getMethod("addRole",Role.class).getAnnotation(ServiceLog.class);
            //获取 foo 这个代理实例所持有的 InvocationHandler
            InvocationHandler h = Proxy.getInvocationHandler(serviceLog);
            // 获取 AnnotationInvocationHandler 的 memberValues 字段
            Field hField = null;
            hField = h.getClass().getDeclaredField("memberValues");
            // 因为这个字段事 private final 修饰，所以要打开权限
            hField.setAccessible(true);
            // 获取 memberValues
            Map memberValues = (Map) hField.get(h);
            // 修改 value 属性值
            memberValues.put("detail", "新增了一个角色，角色名字是系统管理员");
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }


        aspectServcieTest.addRole(role);
    }

}
