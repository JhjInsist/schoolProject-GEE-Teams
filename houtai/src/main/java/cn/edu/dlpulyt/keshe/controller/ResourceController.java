package top.dlpujhj.sxx_match_helper.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.qiniu.http.Response;
import freemarker.template.utility.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.dlpujhj.sxx_match_helper.base.BaseController;
import top.dlpujhj.sxx_match_helper.pojo.Resource;
import top.dlpujhj.sxx_match_helper.service.IResourceService;
import top.dlpujhj.sxx_match_helper.tools.JWTUtils;
import top.dlpujhj.sxx_match_helper.tools.QiNiuUtils;
import top.dlpujhj.sxx_match_helper.tools.Renum;
import top.dlpujhj.sxx_match_helper.tools.ResultMap;


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
@RequestMapping("/sxx_match_helper/resource")
public class ResourceController extends BaseController<Resource,IResourceService> {
    QiNiuUtils qiNiuUtils = new QiNiuUtils();

    @Autowired
    private IResourceService resourceService;


    @PostMapping("upload")
    public ResultMap fileupload(MultipartFile file, String title ,String discription, HttpServletRequest req){
        ResultMap resultMap = new ResultMap();
        String token = req.getHeader("token");
        System.out.println("token："+ token);
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
                Integer userIdByToken = JWTUtils.getUserIdByToken(token);
                r.setUploaderId(userIdByToken);
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
