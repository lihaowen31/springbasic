package com.wx.entity.dto;

import lombok.Data;

@Data
public class Result<T> {
    private int code;//状态码，表示请求结果，200表示成功
    private String msg;//本次请求结果的详情
    private T data;//本次请求返回的结果集
}
