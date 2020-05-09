package com.leyou.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

//封装异常信息的类
@Data
public class ExceptionResult {
      private int errorCode;
      private String message;
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private Date timestamp;

      public ExceptionResult(){
      }

      public ExceptionResult(int errorCode,String message){
          this.errorCode = errorCode;
          this.message = message;
          this.timestamp = new Date();
      }
}
