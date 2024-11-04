package biz.bigtablet.moduleapi.service;


import biz.bigtablet.moduleapi.exception.CustomException;
import biz.bigtablet.modulecommon.domain.Member;
import biz.bigtablet.modulecommon.enums.CodeEnum;
import biz.bigtablet.modulecommon.repository.MemberRepository;
import biz.bigtablet.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
/*
* 단순히 commonDemoService 를 Bean 으로 등록하고 의존성을 주입한다고 해서 module api 쪽에서 쓸 수 있는게 아님
* 어플리케이션을 실행시키는 패키지를 기준으로 Bean 스캔 component 스캔이 일어남
* module api 하위 모듈인 common 도 똑같은 패스로 스캔이 이루어지지만 biz.bigtablet 까지는 동일 moduleapi 라는 패키지가 없기에 빈등록 x
* ModuleApiApplication 을 biz.bigtablet 아래에 두면 common 쪽에서도 bean 스캔이 가능해짐
* 즉 biz.bigtablet 아래에 ModuleApiApplication 있으면 그 아래는 자동으로 스캔  */
public class DemoService {

    private final CommonDemoService commonDemoService;
    private final MemberRepository memberRepository;

    public String save(){
        memberRepository.save(Member.builder()
                        .name(Thread.currentThread().getName())
                .build());
        return "save";
    }

    public String find(){

        int size = memberRepository.findAll().size();
        System.out.println("DB size : " + size);
        return "find";
    }

    public String exception() {
        if(true){
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }
        return "exception";
    }
}
