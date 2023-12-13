package cn.edu.dlpulyt.keshe.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import cn.edu.dlpulyt.keshe.base.IdBase;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;


/**
 * <p>
 * 
 * </p>
 *
 * @author dlpujhj
 * @since 2023-03-14
 */
@Getter
@Setter
@ApiModel(value = "Resource对象", description = "")
public class Resource extends IdBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private String uploaderId;

    private String title;

    private String description;

    private String filePath;

    private String competitionName;

    private String fileType;

    private Timestamp createTime;

    private Timestamp updateTime;
}
