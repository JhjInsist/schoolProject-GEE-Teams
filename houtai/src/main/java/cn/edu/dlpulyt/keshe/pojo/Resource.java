package top.dlpujhj.sxx_match_helper.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import top.dlpujhj.sxx_match_helper.base.IdBase;

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


    private Integer uploaderId;

    private String title;

    private String description;

    private String filePath;

    private String competitionName;

    private String fileType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
