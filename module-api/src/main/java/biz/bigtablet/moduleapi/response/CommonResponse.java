package biz.bigtablet.moduleapi.response;

import biz.bigtablet.modulecommon.enums.CodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) /*null인 값은 응답 객체의 필드 조차 보여주지 않음*/
@Builder/*빌더 패턴을 사용하여 객체를 생성할 수 있게 해줌*/
@NoArgsConstructor /*매개변수가 없는 기본 생성자를 자동으로 생성*/
@AllArgsConstructor /*모든 필드를 매개변수로 받는 생성자를 자동으로 생성*/
/*
* 통일화 되어 있는 Response 객체
* 하나의 공통된 규격을 정해놓고 실제 서버와 클라이언트 간의 통신을 하게 된다.*/
public class CommonResponse<T> {

    private String returnCode;
    private String returnMessage;

    private T info;

    /*생성자*/
    public CommonResponse(CodeEnum codeEnum){
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());

    }
    /*info를 넘겨받았다는건 성공으로 간주*/
    public CommonResponse(T info){
        setReturnCode(CodeEnum.SUCCESS.getCode());
        setReturnMessage(CodeEnum.SUCCESS.getMessage());
        setInfo(info);
    }

    public CommonResponse(CodeEnum codeEnum, T info){
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
        setInfo(info);
    }

}
