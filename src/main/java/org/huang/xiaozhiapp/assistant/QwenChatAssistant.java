package org.huang.xiaozhiapp.assistant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT,chatModel = "qwenChatModel") // 指定使用的模型
// qwen: qwenChatModel openai: openAiChatModel ollama: ollamaChatModel
// 把这个接口标记为一个AI服务，可以被Spring自动识别和注入
public interface QwenChatAssistant {
    String chat(String message);
}
