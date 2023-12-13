package cn.edu.dlpulyt.keshe.controller;

import cn.edu.dlpulyt.keshe.pojo.User;
import cn.edu.dlpulyt.keshe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//完成登陆注册功能
@RestController // 用于传递数据的controller
@RequestMapping("/keshe/user")// 用于设置请求路径
public class UserController{
    @Autowired
    private UserService userService;

    //登录：校验数据库中是否有手机号和密码，有的话登陆成功，返回手机号密码，并且将userid存到session里
    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody User user, HttpSession hs){
        String username = user.getUsername();
        String password = user.getPassword();
        Map<String,Object> resMap = new HashMap<>();
        User login = userService.login(username, password);
        if(login != null){
            resMap.put("msg",login);
            hs.setAttribute("userId",login.getId());
            resMap.put("status","成功");
        }
        else{
            resMap.put("status","失败");
        }
            return resMap;
    }

    //注册：检验输入的手机号是否存在，存在的话就注册失败，否则注册成功
    @RequestMapping("/register")
    public Map<String,Object> register(@RequestBody User user){

        Map<String,Object> resMap = new HashMap<String,Object>();
        boolean checkRegister = userService.checkRegister(user);
        if(!checkRegister){
            resMap.put("msg","手机号已存在");
            resMap.put("status","失败");
            return resMap;
        }
        // 开始注册
        if(userService.register(user)>0){
            resMap.put("msg","注册成功");
            resMap.put("status","成功");
        }else{
            resMap.put("msg","未知错误");
            resMap.put("status","失败");
        }

        return resMap;
    }

    @RequestMapping("list")
    public List<User> list(){
        return userService.list();
    }
}
