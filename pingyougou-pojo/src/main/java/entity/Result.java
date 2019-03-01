package entity;

import java.io.Serializable;

/**
 * 返回结果封装
 * @author wuchaoqun
 *
 */
public class Result implements Serializable{
	
	private boolean success; //是否成功
	private String message;  //返回信息
	
	
	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public final boolean isSuccess() {
		return success;
	}
	public final void setSuccess(boolean success) {
		this.success = success;
	}
	public final String getMessage() {
		return message;
	}
	public final void setMessage(String message) {
		this.message = message;
	}
	
	
}
