package com.yur.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonResponse<T> {

    private boolean success = true;

    private Object msg = null;

    private int count = 0;

    private List<T> data = Collections.emptyList();

    private final String SUC = "操作成功!";
    private final String FAIL = "操作失败!";


    public CommonResponse(boolean success, Object msg) {
        super();
        this.success = success;
        if (msg != null && StringUtils.isNotBlank(msg.toString())) {
            this.msg = msg;
        } else {
            if(success) {
                this.msg = SUC;
            } else {
                this.msg = FAIL;
            }
        }

    }

    public CommonResponse(boolean success, int count, List<T> data, Object msg) {
        super();
        this.success = success;
        this.data = data;
        if (msg != null && StringUtils.isNotBlank(msg.toString())) {
            this.msg = msg;
        } else {
            if(success) {
                this.msg = SUC;
            } else {
                this.msg = FAIL;
            }
        }
    }

    /**
     * 使用是否成功标志及字符串数据创建通用json对象。,<br/>
     * 例如<br/>
     * 传入参数(true,"userId","00212","userName","admin","age","23")创建出以下格式返回对象:<br/>
     * @param success
     * @param args
     */
    public CommonResponse(boolean success, Object... args) {
        super();
        this.success = success;
        Map<String, Object> map = new HashMap<String, Object>();
        if (args != null && args.length>0) {
            for (int i = 0; i < args.length - 1; i++) {
                if (i % 2 == 0) {
                    if (args[i] != null && args[i + 1] != null) {
                        map.put(args[i].toString(), args[i + 1]);
                    }
                }
            }
            this.msg = map;
        }else{
            if(success) {
                this.msg = SUC;
            } else {
                this.msg = FAIL;
            }
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
