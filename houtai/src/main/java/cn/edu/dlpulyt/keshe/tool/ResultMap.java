package top.dlpujhj.sxx_match_helper.tools;

import java.util.Map;

/*
 *
 * @program:sxxMatchHelper
 * @author: jhj
 * @Time: 2023/3/15  16:35
 *
 */
public class ResultMap {
    private Renum status = Renum.SUCCESS;

    private String msg = "ok";

    private Object data;

    public ResultMap() {
    }

    public Renum getStatus() {
        return status;
    }

    public void setStatus(Renum status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
