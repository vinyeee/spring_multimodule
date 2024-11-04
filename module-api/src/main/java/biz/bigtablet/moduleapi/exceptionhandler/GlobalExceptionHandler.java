package biz.bigtablet.moduleapi.exceptionhandler;

import biz.bigtablet.moduleapi.exception.CustomException;
import biz.bigtablet.moduleapi.response.CommonResponse;
import biz.bigtablet.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice /*애플리케이션의 모든 컨트롤러에서 발생하는 예외를 처리 각 컨트롤러마다 예외 처리 로직을 반복해서 작성할 필요 없이, 하나의 클래스에서 일괄적으로 처리*/
public class GlobalExceptionHandler {

    /*exception handler 가 어떤 exception-class 만을 핸들링 할 것인지 정의해주면 됨*/
    @ExceptionHandler(CustomException.class)
    public CommonResponse handlerCustomException(CustomException e){

        return CommonResponse.builder()
                .returnCode(e.getReturnCode())
                .returnMessage(e.getReturnMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse handlerException(Exception e){

        return CommonResponse.builder()
                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode())
                .returnMessage(CodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }
}
