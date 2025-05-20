package org.huang.xiaozhiapp;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.huang.xiaozhiapp.assistant.MemoryQwenChatAssistant;
import org.huang.xiaozhiapp.assistant.QwenChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class AiServiceTest {
    
    @Autowired
    private QwenChatModel qwenModel;
    
    @Test
    public void testChat() {
        QwenChatAssistant assistant = AiServices.create(QwenChatAssistant.class, qwenModel);
        String response = assistant.chat("介绍一下你自己");
        System.out.println(response);
    }
    
    @Autowired // Autowired the QwenChatAssistant bean
    private QwenChatAssistant qwenChatAssistant;
    
    @Test
    public void testChatWithAutowired() {
        String response = qwenChatAssistant.chat("介绍一下你自己");
        System.out.println(response);
    }
    
    @Autowired
    private MemoryQwenChatAssistant memoryQwenChatAssistant;
    
    @Test
    public void testChatWithMemory() {
        System.out.println(memoryQwenChatAssistant.chat(1, "Hello, my name is Klaus"));
        // Hi Klaus! How can I assist you today?
        
        System.out.println(memoryQwenChatAssistant.chat(2, "Hello, my name is Francine"));
        // Hello Francine! How can I assist you today?
        
        System.out.println(memoryQwenChatAssistant.chat(1, "What is my name?"));
        // Your name is Klaus.
        
        System.out.println(memoryQwenChatAssistant.chat(2, "What is my name?"));
        // Your name is Francine.
    }
    
    @Test
    public void testChatWithMemory1() {
        UUID uuid = UUID.randomUUID();
        String response = memoryQwenChatAssistant.chat(uuid,"我是wyi");
        System.out.println(response);
        
        String response2 = memoryQwenChatAssistant.chat(uuid,"我是谁？");
        System.out.println(response2);
    }

}
