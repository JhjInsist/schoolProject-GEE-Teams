package cn.edu.dlpulyt.keshe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private String leaderId;

    private String id;

    private String teamName;

    private    String institutionProvince;

    private   String institutionName;

    private    String leaderGender;

    private   String leaderPhonenum;

    private  String teamRequest;

    private  String leaderName;
}
