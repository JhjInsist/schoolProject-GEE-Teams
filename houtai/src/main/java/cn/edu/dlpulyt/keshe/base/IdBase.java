package cn.edu.dlpulyt.keshe.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;

import java.io.Serializable;

/*
 *
 * @program:sxxMatchHelper
 * @author: jhj
 * @Time: 2023/3/15  0:17
 *
 */
public class IdBase implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int delete) {
        this.deleted = delete;
    }

    private int deleted = 0;
}
