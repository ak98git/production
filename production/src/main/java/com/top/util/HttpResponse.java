/**
 * Copyright(c) Runsdata Technology Co.,Ltd.
 * All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Runsdata
 * Technology Co.,Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Runsdata Technology Co.,Ltd.
 * For more information about Runsdata, welcome to http://www.runsdata.com
 * <p>
 * project: product_service
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/4/29 1.0          vae          Creation File
 */

package com.top.util;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/4/29 23:33
 */
public class HttpResponse<T> {

    private Integer resultCode;
    private String message;
    private T data;
    private Object accessory;

    public HttpResponse(Integer resultCode){
        this.resultCode = resultCode;
    }
    public HttpResponse(){
        this(0);
    }
    public HttpResponse(String errorMessage){
        setErrorMessage(errorMessage);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpResponse<T> setErrorMessage(String message){
        return setErrorMessage(1, message);
    }
    public HttpResponse<T> setErrorMessage(Integer errorCode,String message){
        this.resultCode = errorCode;
        this.message = message;
        return this;
    }
    public HttpResponse<T> setData(T data){
        this.data = data;
        return this;
    }
    public HttpResponse<T> setResultCode(Integer resultCode){
        this.resultCode = resultCode;
        return this;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Object getAccessory() {
        return accessory;
    }

    public void setAccessory(Object accessory) {
        this.accessory = accessory;
    }

}

