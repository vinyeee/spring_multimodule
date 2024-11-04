package biz.bigtablet.moduleapi.exception;

import biz.bigtablet.modulecommon.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*다양한 예외 처리가 필요할 때 해당 객체에 담아서 리턴*/
public class CustomException extends RuntimeException{

    private String returnCode;
    private String returnMessage;

    public CustomException(CodeEnum codeEnum){
        super(codeEnum.getMessage());
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
    }

}
