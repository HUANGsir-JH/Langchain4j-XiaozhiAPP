package org.huang.xiaozhiapp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "chat_messages")
public class ChatMessages {
    
    @Id
    private ObjectId messageId;// 映射到MongoDB的_id字段
    
    private String memoryId;// 映射到MongoDB的memoryId字段
    
    private String content;// 存储当前聊天记录的json
    
    public ChatMessages(String s) {
        this.content = s;
    }
}
