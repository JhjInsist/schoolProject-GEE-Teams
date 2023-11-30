package cn.edu.dlpulyt.keshe.service.impl;

import ch.qos.logback.classic.spi.EventArgUtil;
import cn.edu.dlpulyt.keshe.mapper.UserMapper;
import cn.edu.dlpulyt.keshe.model.RedisModel;
import cn.edu.dlpulyt.keshe.pojo.User;
import cn.edu.dlpulyt.keshe.service.RedisService;
import cn.edu.dlpulyt.keshe.service.UserService;
import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;
    
    @Resource
    private RedisService redisService;
    
    @Override
    public User login(String username, String password) {
        User login = userMapper.getUserByUserNameAndPassword(username, password);
        if(login != null){
            RedisModel redisModel = new RedisModel(login.getPhoneNum(),login);    
            // set user info to redis
            redisService.setString(username,JSON.toJSONString(redisModel));
            return login;
        }
        return null;
    }

    @Override
    public boolean checkRegister(User user) {
        User register = userMapper.getUserByUsername(user.getUsername());
        if(register != null){
            return false;
        }else{
            return true;
        }
    }


    @Override
    public int register(User user) {
        return userMapper.createUser(user);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
