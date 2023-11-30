package cn.edu.dlpulyt.keshe.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamMember{
    private String id;
    private String teamId;
    private String userId;

}
