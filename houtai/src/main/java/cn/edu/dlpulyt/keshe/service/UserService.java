package cn.edu.dlpulyt.keshe.service;

import cn.edu.dlpulyt.keshe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User login(String username, String password);
    public boolean checkRegister(User user);

    public int register(User user);

    public List<User> list();
}
