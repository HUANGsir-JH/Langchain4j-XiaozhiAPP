package org.huang.xiaozhiapp.config;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import jakarta.annotation.Resource;
import org.huang.xiaozhiapp.store.AIChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class XiaoZhiAgentConfig {
    
    @Resource
    private AIChatMemoryStore memoryStore;
    @Autowired
    private EmbeddingModel embeddingModel;
    @Autowired
    private EmbeddingStore<TextSegment> embeddingStore;
    
    @Bean(name="chatMemoryProviderXiaozhi")
    public ChatMemoryProvider xiaozhiChatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory
                .builder()
                .maxMessages(50)
                .id(memoryId)
                .chatMemoryStore(memoryStore)
                .build();
    }
    
    @Bean(name="contentRetrieverXiaozhi")
    public ContentRetriever contentRetriever() {
        Document document1 = FileSystemDocumentLoader.loadDocument("src/main/resources/rags/医院信息" +
                ".md");
        Document document2 = FileSystemDocumentLoader.loadDocument("src/main/resources/rags/口腔科" +
                ".md");
        Document document3 = FileSystemDocumentLoader.loadDocument("src/main/resources/rags/神经内科" +
                ".md");
        List<Document> documentList = Arrays.asList(document1, document2, document3);
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
        EmbeddingStoreIngestor.ingest(documentList, embeddingStore);
        return EmbeddingStoreContentRetriever.from(embeddingStore);
    }
    
    @Bean(name="embeddingStoreXiaozhiPinecone")
    public ContentRetriever contentRetrieverPinecone(){
        return EmbeddingStoreContentRetriever.builder()
                .embeddingModel(embeddingModel)
                .embeddingStore(embeddingStore)
                .maxResults(3)
                .minScore(0.8)
                .build();
    }
}
