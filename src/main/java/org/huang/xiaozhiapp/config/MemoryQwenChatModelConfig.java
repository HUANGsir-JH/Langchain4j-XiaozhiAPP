package org.huang.xiaozhiapp.config;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import jakarta.annotation.Resource;
import org.huang.xiaozhiapp.store.AIChatMemoryStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryQwenChatModelConfig {
    
    @Bean(name="QwenMemory")
    public ChatMemory qwenChatMemory() {
        return MessageWindowChatMemory.withMaxMessages(16);
    }
    
    @Resource
    private AIChatMemoryStore memoryStore;
    
    @Bean(name="QwenMemoryProvider")
    public ChatMemoryProvider qwenChatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory
                .builder()
                .maxMessages(16)
                .id(memoryId)
                .chatMemoryStore(memoryStore)
                .build();
    }
}
