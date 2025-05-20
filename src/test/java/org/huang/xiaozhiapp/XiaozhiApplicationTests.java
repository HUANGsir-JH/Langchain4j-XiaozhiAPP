package org.huang.xiaozhiapp;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class XiaozhiApplicationTests {
    
    @Test
    void contextLoads() {
    }
    
    @Test
    public void testLangchain4j(){
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        
        String answer = model.chat("你好~");
        System.out.println(answer);
    }
    
    
    @Autowired
    private OpenAiChatModel model;
    
    @Test
    public void testLangchain4j2(){
        String answer = model.chat("介绍一下你自己");
        System.out.println(answer);
    }
    
    @Autowired
    private OllamaChatModel ollamaChatModel;
    
    @Test
    public void testOllamaChatModel(){
        String answer = ollamaChatModel.chat("介绍一下你自己");
        System.out.println(answer);
    }
    
    @Autowired
    private QwenChatModel qwenChatModel;
    
    @Test
    public void testQwenChatModel(){
        String answer = qwenChatModel.chat("介绍一下你自己");
        System.out.println(answer);
    }
    
//    @Autowired // 万相文生图暂时不支持依赖注入，只能使用builder
//    private WanxImageModel wanxImageModel;
    
    @Value("${wanx.apiKey}")
    private String wanx_api_key;
    @Test
    public void testWanxImageModel(){
        WanxImageModel wanxImageModel = WanxImageModel.builder()
                .apiKey(wanx_api_key)
                .modelName("wanx2.1-t2i-turbo")
                .build();
        Response<Image> response = wanxImageModel.generate("生成一只可爱的猫咪");
        
        System.out.println(response);
    }
    
}
