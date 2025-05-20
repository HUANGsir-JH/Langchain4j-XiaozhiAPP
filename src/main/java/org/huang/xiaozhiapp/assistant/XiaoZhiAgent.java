package org.huang.xiaozhiapp.assistant;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;


@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
//        chatModel = "qwenChatModel", // 指定使用的模型
        streamingChatModel = "qwenStreamingChatModel", // 指定使用的流式模型
        chatMemoryProvider = "chatMemoryProviderXiaozhi", // 指定使用的内存提供者
        tools = "appointmentTool",// 指定使用的工具
        contentRetriever = "embeddingStoreXiaozhiPinecone" // 指定使用的检索器rag
)
public interface XiaoZhiAgent {
    @SystemMessage(fromResource = "xiaozhiPromptTemplate.txt")
    Flux<String> chat(@MemoryId Object memoryId, @UserMessage String userMessage);
}
