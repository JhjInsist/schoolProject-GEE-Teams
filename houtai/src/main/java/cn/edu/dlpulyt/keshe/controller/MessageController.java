package cn.edu.dlpulyt.keshe.controller;


import cn.edu.dlpulyt.keshe.pojo.Message;
import cn.edu.dlpulyt.keshe.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/keshe/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/myMessage")
    public List<Message> myMessage(@SessionAttribute("userId" )String userId,@RequestParam("readStatus")String readStatus){
       return messageService.listByUserId(userId,readStatus);
    }
    @RequestMapping("/read")
    public Map<String,Object> myMessage(@SessionAttribute("userId" )String userId, @RequestParam("id")String messageId, @RequestParam("readStatus")String readStatus){

        Map<String,Object> map = new HashMap<>();
        if(messageService.updateStatus(messageId, readStatus,userId)>0){
            map.put("msg","成功");
            map.put("status","成功");
        } else {
            map.put("msg","失败");
            map.put("status","失败");
        }
        return map;
    }



}
