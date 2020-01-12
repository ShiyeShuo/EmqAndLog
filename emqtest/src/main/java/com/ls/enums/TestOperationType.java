package com.ls.enums;

import java.util.HashMap;
import java.util.Map;

public enum TestOperationType {
    TYPE_OTHER(0, "其他操作"),
    TYPE_ADD(1, "新增操作"),
    TYPE_UPDATE(2, "修改操作"),
    TYPE_DELETE(3, "删除操作");
    private int opType;
    private String opName;
    TestOperationType(int opType,String opName){
        this.opType = opType;
        this.opName = opName;
    }

    public int getOpType() {
        return opType;
    }

    public void setOpType(int opType) {
        this.opType = opType;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    /**
     * 获取所有操作类型数据
     *
     * @return
     */
    public static Map<Integer, String> getAllModuleEnum() {
        Map<Integer, String> map = new HashMap<>();
        TestOperationType[] values = TestOperationType.values();
        for (TestOperationType testOperationType : values) {
            map.put(testOperationType.getOpType(), testOperationType.getOpName());
        }
        return map;
    }
    /**
     * 根据操作类型代码获取操作类型名称
     *
     * @param code
     * @return
     */
    public static String getOperationName(int code){
        TestOperationType[] values = TestOperationType.values();
        for (TestOperationType testOperationType : values) {
            if (testOperationType.opType == code) {
                return testOperationType.opName;
            }
        }
        return null;
    }
}
