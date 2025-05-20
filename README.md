## 项目介绍
本项目基于[该视频](https://www.bilibili.com/video/BV1cpLTz1EVp/?spm_id_from=333.1007.top_right_bar_window_custom_collection.content.click&vd_source=45792527913efdcbf520573d0c16b421)进行。主要内容是langchain4j与springboot的结合，以及开发一个医疗智能体作为实战。

## 项目特色
- 通过对langchain4j的逐步研究，学习如何使用Java语言在spring框架下实现应用程序和AI的结合，如何调用qwen、deepseek、ollama本地模型，如何进行记忆存储（使用mongodb）和多轮对话，如何应用系统提示词，如何使用function call，如何使用rag检索增强，如何应用embedding模型
- 基于上述的功能，构建一个`医疗客服智能体`，其可以
  - 调用工具函数，根据用户提供的信息进行门诊预约（将用户预约信息插入数据库）、预约取消、预约查询
  - 根据RAG知识库（存储在Pinecone云端）回答用户提出的问题

## 如何运行
在application.properties中配置所需模型的api-key（ollama需本地部署，部分使用位于test包下）  
如果没有注册Pinecone云服务，可以在assistant包下的XiaozhiAgent把`contentRetriever = "embeddingStoreXiaozhiPinecone"`修改为`contentRetriever = "contentRetrieverXiaozhi"`
详情见配置类中的bean

## 前端页面
基于vue做的一个简单实现，可是实现流式输出效果、多轮对话、结果markodwn转换等。












