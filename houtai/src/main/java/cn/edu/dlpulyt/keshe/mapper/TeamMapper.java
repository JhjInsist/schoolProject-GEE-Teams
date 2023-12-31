package cn.edu.dlpulyt.keshe.mapper;

import cn.edu.dlpulyt.keshe.pojo.Team;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeamMapper {
    @Insert("INSERT INTO team (leader_id, team_name,Institution_province,Institution_name,leader_gender,leader_phonenum,team_request,leader_name) VALUES (#{leaderId},#{teamName},#{institutionProvince},#{institutionName},#{leaderGender},#{leaderPhonenum},#{teamRequest},#{leaderName})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    public int create(Team team);

    @Select("select id,leader_id,leader_name,team_name,institution_province,institution_name,leader_gender,leader_phonenum,team_request from team")
    public List<Team> list();

    @Select("select * from team where id = #{id}")
    public Team getById(String id);
    @Delete("delete from team where id = #{id}")
    public void delete(String id);
}
