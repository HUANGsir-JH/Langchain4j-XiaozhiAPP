package org.huang.xiaozhiapp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatForm {
    
    private Object memoryId;
    private String userMessage;
}
