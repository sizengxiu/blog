package com.si.blog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @user szx
 * @date 2020/5/10 0:00
 */
@Getter
@Setter
public class Result<T> {
    private boolean success=true;
    private int code=1;
    private T data;
    private String message;
    public Result(){

    }
    public  Result (T data){
        this.data=data;
    }
    public static Result getFailInstance(String message,int code){
        Result result=new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    public static Result getFailInstance(String message){
        return getFailInstance(message,0);
    }
}
