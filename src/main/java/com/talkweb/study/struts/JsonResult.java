package com.talkweb.study.struts;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 包含 Ajax 请求处理结果的通用结构。该结构包含
 * {@link #success}, {@link #message}, {@link #data} 三个属性。
 *
 * @author yiding.he
 */
public class JsonResult implements Result {

    public static final Logger log = LoggerFactory.getLogger(JsonResult.class);

    public static final JsonResult SUCCESS = new JsonResult();

    public static JsonResult fail(final String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(false);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    public static JsonResult fail(String message, int code) {
        return fail(message).put("code", code);
    }

    //////////////////////////////////////////////

    /**
     * 请求是否成功处理
     */
    private boolean success = true;

    /**
     * 处理成功或失败时的相关信息
     */
    private String message = null;

    /**
     * 返回值
     */
    private Map<String, Object> data = new HashMap<String, Object>();

    public JsonResult() {
    }

    public JsonResult(Map<String, Object> data) {
        this.data = data;
    }

    public JsonResult(final String name, final Object value) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put(name, value);
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public JsonResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public JsonResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
    /////////////////////////////////////////

    public JsonResult put(String name, Object value) {
        data.put(name, value);
        return this;
    }

    public Object get(String name) {
        return data.get(name);
    }

    public void execute(ActionInvocation actionInvocation) throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json");

        PrintWriter writer = response.getWriter();
        writer.write(new Gson().toJson(this));
        writer.flush();
    }

    /**
     * 以特定类型获取返回值属性
     *
     * @param key  属性名
     * @param type 属性值
     * @param <T>  属性值类型
     *
     * @return 如果属性所代表的 JsonElement 对象能够被转化成 T 对象的话，则返回一个包含了属性值的 T 对象。
     */
    public <T> T getObject(String key, Class<T> type) {
        Object o = data.get(key);
        if (o == null) {
            return null;
        }

        if (type.isAssignableFrom(o.getClass())) {
            return (T) o;
        } else if (o instanceof JsonElement) {
            JsonElement obj = (JsonElement) o;
            return new Gson().fromJson(obj, type);
        }

        log.debug("Unmatched Type: value of type "
                + o.getClass() + " cannot be cast to " + type);
        return null;

    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
