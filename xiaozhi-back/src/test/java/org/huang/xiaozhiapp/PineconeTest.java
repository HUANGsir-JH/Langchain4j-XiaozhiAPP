package org.huang.xiaozhiapp;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PineconeTest {
    
    @Autowired
    private EmbeddingStore<TextSegment> embeddingStore;
    @Autowired
    private EmbeddingModel embeddingModel;
    
    @Test
    public void testPinecone() {
        TextSegment text = TextSegment.from("我喜欢你~");
        Embedding embed1 = embeddingModel.embed(text).content();
        System.out.println("embed1: " + embed1);
        embeddingStore.add(embed1, text);
        
        TextSegment segment2 = TextSegment.from("今天天气很好");
        Embedding embedding2 = embeddingModel.embed(segment2).content();
        System.out.println("embed2: " + embedding2);
        embeddingStore.add(embedding2, segment2);
    }
    
    @Test
    public void embeddingSearch() {
        //提问，并将问题转成向量数据
        Embedding queryEmbedding = embeddingModel.embed("神经内科").content();
        //创建搜索请求对象
        EmbeddingSearchRequest searchRequest = EmbeddingSearchRequest.builder()
                .queryEmbedding(queryEmbedding)
                .maxResults(1) //匹配最相似的一条记录
                //.minScore(0.8)
                .build();
        //根据搜索请求 searchRequest 在向量存储中进行相似度搜索
        EmbeddingSearchResult<TextSegment> searchResult = embeddingStore.search(searchRequest);
        //searchResult.matches()：获取搜索结果中的匹配项列表。
        //.get(0)：从匹配项列表中获取第一个匹配项
        EmbeddingMatch<TextSegment> embeddingMatch = searchResult.matches().get(0);
        
        //获取匹配项的相似度得分
        System.out.println(embeddingMatch.score());
        //返回文本结果
        System.out.println(embeddingMatch.embedded().text());
    }
    
    // 上传所需的rag资料
    @Test
    public void uploadRag() {
        Document document1 = FileSystemDocumentLoader.loadDocument("src/main/resources/rags/医院信息" +
                ".md");
        Document document2 = FileSystemDocumentLoader.loadDocument("src/main/resources/rags/口腔科" +
                ".md");
        Document document3 = FileSystemDocumentLoader.loadDocument("src/main/resources/rags/神经内科" +
                ".md");
        
        List<Document> documentList = Arrays.asList(document1, document2, document3);
        
        EmbeddingStoreIngestor.builder()
                .embeddingModel(embeddingModel)
                .embeddingStore(embeddingStore)
                .build()
                .ingest(documentList);
    }
}
