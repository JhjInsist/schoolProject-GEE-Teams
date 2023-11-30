package cn.edu.dlpulyt.keshe.service;

import cn.edu.dlpulyt.keshe.pojo.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {

    public int create(Message message);

    public List<Message> listByUserId(String userId, String readStatus);

    int updateStatus(String id, String readStatus, String receiverId);
}
