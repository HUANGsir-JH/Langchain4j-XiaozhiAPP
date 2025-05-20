package org.huang.xiaozhiapp.config;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.pinecone.PineconeEmbeddingStore;
import dev.langchain4j.store.embedding.pinecone.PineconeServerlessIndexConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class EmbeddingStoreConfig {

    @Autowired
    private EmbeddingModel embeddingModel;
    
    @Value("${pinecone.api-key}")
    private String apiKey;
    @Value("${pinecone.index}")
    private String index;
    @Value("${pinecone.namespace}")
    private String nameSpace;
    @Value("${pinecone.cloud}")
    private String cloud;
    @Value("${pinecone.region}")
    private String region;
    
    @Bean(name = "embeddingStore")
    public EmbeddingStore<TextSegment> embeddingStore() {
        return PineconeEmbeddingStore.builder()
                .apiKey(apiKey)
                .index(index)
                .nameSpace(nameSpace)
                .createIndex(PineconeServerlessIndexConfig.builder()
                        .cloud(cloud)
                        .region(region)
                        .dimension(embeddingModel.dimension())
                        .build()
                ).build();
    }
}
