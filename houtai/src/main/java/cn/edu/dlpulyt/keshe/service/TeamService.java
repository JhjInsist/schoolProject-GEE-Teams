package cn.edu.dlpulyt.keshe.service;

import cn.edu.dlpulyt.keshe.pojo.Team;
import cn.edu.dlpulyt.keshe.pojo.TeamMember;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TeamService {

    public int create(Team team);

    public List<Team> list();

    public List<Team> listByUserId(String userId);

    public int addTeam(TeamMember teamMember);
}
