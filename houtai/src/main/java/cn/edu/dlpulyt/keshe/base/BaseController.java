package top.dlpujhj.sxx_match_helper.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.dlpujhj.sxx_match_helper.tools.JWTUtils;
import top.dlpujhj.sxx_match_helper.tools.ResultMap;

import java.util.List;

/*
 *
 * @program:sxxMatchHelper
 * @author: jhj
 * @Time: 2023/3/15  0:05
 *
 */
@RestController
@Scope("prototype")
public class BaseController<T extends IdBase,S extends IService<T>> {

    @Autowired
    private S s;

//    @RequestMapping("/list")
//    public ResultMap list(){
//        List<T> list = s.list(new QueryWrapper<T>().eq("deleted",0));
//        ResultMap resultMap = new ResultMap();
//        resultMap.setData(list);
//        return resultMap;
//    }
    @RequestMapping("/list")
    public ResultMap list(T t){
        QueryWrapper<T> queryWrapper = new QueryWrapper<>(t);
        List<T> list = s.list(queryWrapper);
        ResultMap resultMap = new ResultMap();
        resultMap.setData(list);
        return resultMap;
    }

    @RequestMapping("/add")
    public void addOne(@RequestBody T t){

        s.save(t);
    }

    @RequestMapping("/update")
    public void update(@RequestBody T t){
        s.updateById(t);
    }

    @RequestMapping("/delete")
    public void delete(@RequestBody T t){
        t.setDeleted(1);
        s.updateById(t);
    }

    @RequestMapping("listUser")
    public ResultMap listUser(HttpServletRequest request){

        return this.listUser(null,request);
    }


    @RequestMapping("listUserOrderBy")
    public ResultMap listUser(String orderby, HttpServletRequest request){
        Integer userIdByToken = JWTUtils.getUserIdByToken(request.getHeader("token"));

        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userIdByToken).eq("deleted",0);
        if (StringUtils.isNotEmpty(orderby))
            queryWrapper.orderByAsc(orderby);
        List<T> list = s.list(queryWrapper);
        ResultMap resultMap = new ResultMap();
        resultMap.setData(list);
        return resultMap;
    }



}
