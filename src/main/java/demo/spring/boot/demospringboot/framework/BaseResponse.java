package demo.spring.boot.demospringboot.framework;

import java.util.ArrayList;
import java.util.List;

public class BaseResponse<T> {
	private String code;// 状态码
	private T data;// 存放的数据
	private String msg;// 存放返回的消息
	private List<Exception> error = new ArrayList<>();// 存放错误的信息

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<Exception> getError() {
		return error;
	}

	public void setError(List<Exception> error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "BaseResponse [code=" + code + ", data=" + data + ", msg=" + msg + ", error=" + error + "]";
	}

}
