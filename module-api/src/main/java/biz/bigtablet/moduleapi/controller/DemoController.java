package biz.bigtablet.moduleapi.controller;

import biz.bigtablet.moduleapi.exception.CustomException;
import biz.bigtablet.moduleapi.service.DemoService;
import biz.bigtablet.modulecommon.enums.CodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러에 있는 모든 메서드들이 @ResponseBody 형식으로 응답 (json)
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/save")
    public String save(){
        return demoService.save();
    }

    @GetMapping("/find")
    public String find(){
        return demoService.find();
    }

    @GetMapping("/exception")
    public String exception(){

        return demoService.exception();
    }

}
