package cn.com.systec.core;

import cn.com.systec.utility.CommonFunctions;
import cn.com.systec.utility.ResponseStatus;
import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public final class Response {
	
	// 状态码
    private Integer status;
    // 状态消息
    private String message;
    // 返回数据
    private Object data;
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Response() {
        this.status = ResponseStatus.SUCCESS;
        this.message = ResponseStatus.MSG_SUCCESS;
        this.data = null;
    }
    
    public Response(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    
    public Response success() {
        this.status = ResponseStatus.SUCCESS;
        this.message = ResponseStatus.MSG_SUCCESS;
        
        return this;
    }
    
    public Response success(Object data) {
        this.status = ResponseStatus.SUCCESS;
        this.message = ResponseStatus.MSG_SUCCESS;
        this.data = data;
        
        return this;
    }
    
    public Response failure(Integer errorCode) {
        this.status = errorCode;
        this.message = ResponseStatus.getErrorMessage(errorCode);
        this.data = CommonFunctions.nullPointer();
        
        return this;
    }
    
    public Response failure(Integer errorCode, String extraMessage) {
        this.status = errorCode;
        this.message = ResponseStatus.getErrorMessage(errorCode) + ":" + extraMessage;
        this.data = CommonFunctions.nullPointer();
        
        return this;
    }

//    public Response failure( String extraMessage) {
//        this.status = errorCode;
//        this.message =  extraMessage;
//        this.data = CommonFunctions.nullPointer();
//
//        return this;
//    }
}
