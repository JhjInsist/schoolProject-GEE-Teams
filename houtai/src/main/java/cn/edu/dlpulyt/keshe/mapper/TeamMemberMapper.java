package cn.edu.dlpulyt.keshe.mapper;

import cn.edu.dlpulyt.keshe.pojo.Team;
import cn.edu.dlpulyt.keshe.pojo.TeamMember;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeamMemberMapper {
    @Select("select * from team_member a join team b on a.team_id = b.id where a.user_id = #{userId}")
    public List<Team> listByUser(String userId);

    @Insert("INSERT INTO team_member (user_id, team_id) VALUES (#{userId},#{teamId})")
    public int create(TeamMember team);

    @Select("select * from team_member where user_id = #{userId} and id = #{id}")
    public TeamMember checkInTeam(TeamMember teamMember);
    @Delete("delete from team_member where id = #{id}")
    public void exitTeam(TeamMember teamMember);
}
