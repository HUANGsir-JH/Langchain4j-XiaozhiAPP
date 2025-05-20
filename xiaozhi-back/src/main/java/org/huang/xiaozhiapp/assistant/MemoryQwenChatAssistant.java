package org.huang.xiaozhiapp.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel" ,// 指定使用的模型
//        chatMemory = "QwenMemory"
        chatMemoryProvider = "QwenMemoryProvider"
)
public interface MemoryQwenChatAssistant{
//    @SystemMessage("你是我的朋友，使用东北话和我聊天，今天是{{current_date}}")
    @SystemMessage(fromResource = "systemPromptTemplate.txt")
    String chat(@MemoryId Object id, @UserMessage String message);
    // 使用@MemoryId注解来标记内存ID参数，为每个用户提供独立的对话记忆
    // 注解是必须的
}
