package cn.edu.dlpulyt.keshe.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
    private String name;

    private String username;

    private String id;

    private String phoneNum;

    private   String password;

    private   String school;

    private   String gender;

    private    String province;

    private   String content;
}
