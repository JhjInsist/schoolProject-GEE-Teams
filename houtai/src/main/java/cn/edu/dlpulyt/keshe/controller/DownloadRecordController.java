package cn.edu.dlpulyt.keshe.controller;
import cn.edu.dlpulyt.keshe.base.BaseController;
import cn.edu.dlpulyt.keshe.pojo.DownloadRecord;
import cn.edu.dlpulyt.keshe.service.IDownloadRecordService;
import cn.edu.dlpulyt.keshe.tool.QiNiuUtils;
import cn.edu.dlpulyt.keshe.tool.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dlpujhj
 * @since 2023-03-14
 */
@RestController
@RequestMapping("/keshe/downloadRecord")
public class DownloadRecordController extends BaseController<DownloadRecord, IDownloadRecordService> {

    @Autowired
    private IDownloadRecordService downloadRecordService;

}
