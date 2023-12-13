package cn.edu.dlpulyt.keshe.controller;


import cn.edu.dlpulyt.keshe.base.BaseController;
import cn.edu.dlpulyt.keshe.pojo.Resource;
import cn.edu.dlpulyt.keshe.service.ResourceService;
import cn.edu.dlpulyt.keshe.tool.QiNiuUtils;
import cn.edu.dlpulyt.keshe.tool.Renum;
import cn.edu.dlpulyt.keshe.tool.ResultMap;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qiniu.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dlpujhj
 * @since 2023-03-14
 */
@RestController
@RequestMapping("/keshe/resource")
public class ResourceController extends BaseController<Resource, ResourceService> {
    QiNiuUtils qiNiuUtils = new QiNiuUtils();

    @Autowired
    private ResourceService resourceService;


    @PostMapping("/upload")
    public ResultMap fileupload(MultipartFile file, String title, String discription, String userId){

        ResultMap resultMap = new ResultMap();
        InputStream is = null;
        Response response = null;
        try {
            is = file.getInputStream();
            response = qiNiuUtils.upload(file);
            if(response.statusCode == 200){

                String info = response.getInfo();
                String[] infoSplit =  info.split(":");
                String path = infoSplit[infoSplit.length-1]
                        .replace("\"","")
                        .replace("}","");

                Resource r = new Resource();
                r.setFilePath(path);
                r.setUploaderId(userId);
                if (StringUtils.isNotEmpty(title))
                    r.setTitle(title);
                if (StringUtils.isNotEmpty(discription))
                    r.setDescription(discription);
                resourceService.save(r);
                resultMap.setStatus(Renum.SUCCESS);
                resultMap.setMsg("上传成功");
                resultMap.setData(response);

            }else {
                resultMap.setStatus(Renum.UNKNOWN_ERROR);
                resultMap.setMsg("上传失败");
                resultMap.setData(response);
            }
            return resultMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultMap.setStatus(Renum.SUCCESS);
        resultMap.setMsg("上传成功");
        resultMap.setData(response);
        return resultMap;
    }
}
