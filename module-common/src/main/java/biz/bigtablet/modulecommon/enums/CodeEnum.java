package biz.bigtablet.modulecommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자를 자동으로 생성
/*상수 집합을 정의할 때 사용 */
public enum CodeEnum {

    /*사전에 클라이언트와 정의해 놓은 리턴 코드, 메세지를 정의 */
    SUCCESS("0000", "SUCCESS"),
    UNKNOWN_ERROR("9999","UNKNOWN_ERROR");

    private String code;
    private String message;

    /*CodeEnum(String code, String message){
        this.code = code;
        this.message = message;

    }*/
}
