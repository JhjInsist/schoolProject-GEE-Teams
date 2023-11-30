package cn.edu.dlpulyt.keshe.service.impl;

import cn.edu.dlpulyt.keshe.mapper.MessageMapper;
import cn.edu.dlpulyt.keshe.pojo.Message;
import cn.edu.dlpulyt.keshe.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int create(Message message) {
        return messageMapper.create(message);
    }

    @Override
    public List<Message> listByUserId(String userId, String readStatus) {
        return messageMapper.listByUserId(userId,readStatus);
    }

    @Override
    public int updateStatus(String id, String readStatus, String receiverId) {
        return messageMapper.updateStatus(Message.builder().id(id).readStatus(readStatus).receiverId(receiverId).build());

    }
}
