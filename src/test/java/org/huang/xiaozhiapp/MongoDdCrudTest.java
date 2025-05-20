package org.huang.xiaozhiapp;

import org.huang.xiaozhiapp.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
public class MongoDdCrudTest {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Test
    public void testInsertMsg(){
        mongoTemplate.insert(new ChatMessages("Hello, my name is Xiaozhi"));
    }
    
    @Test
    public void testFindMsg(){
        ChatMessages chatMessages = mongoTemplate.findById("682940e016734f20378c3564", ChatMessages.class);
        System.out.println(chatMessages);
    }
    
    @Test
    public void testDeleteMsg(){
        mongoTemplate.remove(mongoTemplate.findById("682940e016734f20378c3564", ChatMessages.class));
    }
    
    @Test
    public void testUpdateMsg(){
        ChatMessages chatMessages = mongoTemplate.findById("682942933aa520469c3cdf8f", ChatMessages.class);
        chatMessages.setContent("Hello, my name is Xiaozhi, I am a software engineer");
        mongoTemplate.save(chatMessages);
    }
}
