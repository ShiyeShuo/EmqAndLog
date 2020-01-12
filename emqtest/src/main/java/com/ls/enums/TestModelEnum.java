package com.ls.enums;

import java.util.HashMap;
import java.util.Map;

public enum TestModelEnum {
    MODULE_USER_ROLE(1001,"角色管理"),
    MODULE_USER_SP(1002,"权限管理"),
    MODULE_USER_USER_MANAGER(1003,"用户管理");
    /** 模块编码 */
    private int moduleType;
    /** 模块名称 */
    private String moduleName;

    TestModelEnum(int moduleType, String moduleName) {
        this.moduleType = moduleType;
        this.moduleName = moduleName;
    }

    public int getModuleType() {
        return moduleType;
    }

    public void setModuleType(int moduleType) {
        this.moduleType = moduleType;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    /**
     * 获取所有操作类型数据
     *
     * @return
     */
    public static Map<Integer, String> getAllModuleEnum() {
        Map<Integer, String> map = new HashMap<>();
        CoshipOperationType[] values = CoshipOperationType.values();
        for (CoshipOperationType operationType : values) {
            map.put(operationType.getOpType(), operationType.getOpName());
        }
        return map;
    }

    /**
     * 根据操作类型代码获取操作类型名称
     *
     * @param code
     * @return
     */
    public static String getModuleNameByCode(int code) {
        TestModelEnum[] values = TestModelEnum.values();
        for (TestModelEnum testModelEnum : values) {
           if (testModelEnum.moduleType == code) {
                return testModelEnum.moduleName;
            }
        }
        return null;
    }
}
