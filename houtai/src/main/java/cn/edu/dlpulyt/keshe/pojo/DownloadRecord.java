package cn.edu.dlpulyt.keshe.pojo;

import cn.edu.dlpulyt.keshe.base.IdBase;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
@TableName("download_record")
@ApiModel(value = "DownloadRecord对象", description = "")
public class DownloadRecord extends IdBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String title;

    private String description;

    private String filePath;
    
    private Timestamp downloadTime;


    private String competitionName;

    private String fileType;
}
