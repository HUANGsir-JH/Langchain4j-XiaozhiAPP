package org.huang.xiaozhiapp.controller;

import jakarta.annotation.Resource;
import org.huang.xiaozhiapp.assistant.XiaoZhiAgent;
import org.huang.xiaozhiapp.bean.ChatForm;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/xiaozhi")
public class XiaozhiController {
    
    @Resource
    private XiaoZhiAgent xiaoZhiAgent;
    
    @PostMapping(value = "/chat", produces = "text/stream;charset=UTF-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm){
        return xiaoZhiAgent.chat(
                chatForm.getMemoryId(),
                chatForm.getUserMessage()
        );
    }
    
}
