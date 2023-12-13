package cn.edu.dlpulyt.keshe.mapper;

import cn.edu.dlpulyt.keshe.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MessageMapper {

    @Select("select * from message where receiver_id = #{userId} and read_status = #{readStatus}")
    public List<Message> listByUserId(String userId,String readStatus);

    @Insert("insert into message (sender_id,receiver_id, content,read_status,sender_name) values(#{senderId},#{receiverId},#{content},0,#{senderName})")
    public int create(Message message);

    @Update("update message  SET read_status = #{readStatus} where id = #{id}")
    public int updateStatus(Message message);
}
