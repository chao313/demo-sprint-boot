package demo.spring.boot.demospringboot.framework;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ErrorResponse<T> {
    private String code;// 状态码
    private HttpServletRequest request;// 存放请求
    private String msg;// 存放返回的消息
    private List<Exception> error = new ArrayList<>();// 存放错误的信息

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Exception> getError() {
        return error;
    }

    public void setError(List<Exception> error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code='" + code + '\'' +
                ", request=" + request +
                ", msg='" + msg + '\'' +
                ", error=" + error +
                '}';
    }
}
