package org.huang.xiaozhiapp;

import jakarta.annotation.Resource;
import org.huang.xiaozhiapp.assistant.MemoryQwenChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class PromptTest {
    
    @Resource
    private MemoryQwenChatAssistant memoryQwenChatAssistant;
    
    @Test
    public void testChat() {
        String memoryId = UUID.randomUUID().toString();
        String response = memoryQwenChatAssistant.chat(memoryId, "今天是什么好日子？");
        System.out.println(response);
    }
}
