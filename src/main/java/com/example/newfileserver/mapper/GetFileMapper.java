package com.example.newfileserver.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author 吴俊文
 * @Description
 * @Date create in:2017/11/22 16:27
 * @e-mail wujunwen@snxun.com
 */
@Mapper
public interface GetFileMapper {

@Select("select code, wgybh, xm, xb, to_char(update_date,'yyyy-mm-dd hh24:mi:ss') UPDATE_DATE, ssjdmc, sssqmc, sswgmc, zhzb, sbqk ,sjhm from v_sys_wgy_wgyxx t")
    List<HashMap<String,Object>> getsqllist();


}
