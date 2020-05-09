package com.leyou.common.advice;

import com.leyou.common.exception.LyExeption;
import com.leyou.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LyExceptionHandler {

    //用来对LyException类型的异常进行统一处理
    @ExceptionHandler(LyExeption.class)
    public ResponseEntity<ExceptionResult> handlerException(LyExeption lyExeption){
        ExceptionResult result = new ExceptionResult(lyExeption.getErrorCode(),lyExeption.getMessage());
        return ResponseEntity.status(lyExeption.getErrorCode()).body(result);
    }
}
