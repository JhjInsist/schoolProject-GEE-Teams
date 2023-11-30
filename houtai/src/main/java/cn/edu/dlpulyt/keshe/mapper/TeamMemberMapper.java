package cn.edu.dlpulyt.keshe.mapper;

import cn.edu.dlpulyt.keshe.pojo.Team;
import cn.edu.dlpulyt.keshe.pojo.TeamMember;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeamMemberMapper {
    @Select("select * from team_member a join team b on a.team_id = b.id where a.user_id = #{userId}")
    public List<Team> listByUser(String userId);

    @Insert("INSERT INTO team_member (user_id, team_id) VALUES (#{userId},#{teamId})")
    public int create(TeamMember team);

    @Select("select * from team_member where user_id = #{userId} and team_id = #{teamId}")
    public TeamMember checkInTeam(TeamMember teamMember);
}
