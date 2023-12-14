package cn.edu.dlpulyt.keshe.controller;

import cn.edu.dlpulyt.keshe.pojo.Message;
import cn.edu.dlpulyt.keshe.pojo.Team;
import cn.edu.dlpulyt.keshe.pojo.TeamMember;
import cn.edu.dlpulyt.keshe.service.TeamService;
import cn.edu.dlpulyt.keshe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // 用于传递数据的controller
@RequestMapping("/keshe/team") // 用于设置请求路径
public class TeamController {
    @Autowired //自动注入
    private TeamService teamService;

    @Autowired
    private UserService userService;

    // 获取队伍列表
    @RequestMapping("list")
    public Map<String,Object> list(){
        Map<String,Object> resMap = new HashMap<>();
        List<Team> list = teamService.list();
        resMap.put("msg",list);
        resMap.put("status","成功");
        return resMap;
    }

    // 根据userID查询该user的小队
    @RequestMapping("myteam")
    public Map<String,Object> list(@SessionAttribute("userId")String userId){
        Map<String,Object> resMap = new HashMap<>();
        List<Team> maps = teamService.listByUserId(userId);
        resMap.put("msg",maps);
        resMap.put("status","成功");
        return resMap;
    }

    // 创建小队：获取到当前user以后，在该user下创建小队，将队长id设置为userid
    @RequestMapping("create")
    public Map<String,Object> createTeam(@RequestBody Team team, HttpSession httpSession){
        String userId = (String) httpSession.getAttribute("userId");
        Map<String,Object> map = new HashMap<>();
        team.setLeaderId(userId);
        if(teamService.create(team)>0){
           map.put("msg","创建成功");
           map.put("status","成功");
        } else {
            map.put("msg","创建失败");
            map.put("status","失败");
        }
        return map;
    }

    // 添加小队，将小队信息输入到数据库里
    @RequestMapping("addTeam")
    public Map<String,Object> addTeam(String teamId,@SessionAttribute("userId") String userId) {
        Map<String,Object> map = new HashMap<>();
        TeamMember teamMember = new TeamMember();
        teamMember.setTeamId(teamId);
        teamMember.setUserId(userId);
        if(teamService.addTeam(teamMember)>0){
            map.put("msg","加入成功");
            map.put("status","成功");
        } else {
            map.put("msg","加入失败");
            map.put("status","失败");
        }
        return map;
    }

    // 添加小队，将小队信息输入到数据库里
    @RequestMapping("exit")
    public Map<String,Object> exitTeam(@RequestBody TeamMember teamMember) {
       Map<String,Object> map = new HashMap<>();
       if(teamService.exitTeam(teamMember)>0){
           map.put("msg","退出成功");
           map.put("status","成功");
       }else {
           map.put("msg","退出失败");
           map.put("status","失败");
       }
       return map;
    }
}