package cn.edu.dlpulyt.keshe.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    private String id;
    private String content;
    private String senderName;
    private String readStatus;
    private String receiverId;
    private String senderId;
}
