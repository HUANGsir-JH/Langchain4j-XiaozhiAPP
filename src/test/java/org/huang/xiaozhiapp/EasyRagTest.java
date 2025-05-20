package org.huang.xiaozhiapp;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EasyRagTest {
    
    @Test
    public void testEasyRag() {
        Document document = FileSystemDocumentLoader.loadDocument("src/main/resources/testRag/人工智能.md");
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
        
        EmbeddingStoreIngestor.ingest(document, embeddingStore);
        System.out.println(embeddingStore);
    }
}
