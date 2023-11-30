package cn.edu.dlpulyt.keshe.model;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisModel implements Serializable{

    private String key;

    private Object value;
    
}
