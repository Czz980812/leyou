package com.leyou.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LyExeption extends RuntimeException {

    private int errorCode;   //错误状态码
    private String message;   //异常消息
}
