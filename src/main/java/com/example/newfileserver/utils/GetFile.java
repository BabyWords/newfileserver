package com.example.newfileserver.utils;

import com.alibaba.fastjson.JSON;
import com.example.newfileserver.mapper.GetFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author 吴俊文
 * @Description
 * @Date create in:2017/11/22 16:26
 * @e-mail wujunwen@snxun.com
 */
@Component
public class GetFile  implements CommandLineRunner {
    @Autowired
    GetFileMapper getFileMapper;
    public List<HashMap<String,Object>> getsqllist(){
        return getFileMapper.getsqllist();
    }

    public void writefile() {
        List<HashMap<String,Object>> sqllists =getsqllist();
        StringBuffer sqllist = new StringBuffer();
        String data= JSON.toJSONString(sqllists);
        File file = new File("e:/shengxun/sender");
        try {
            WriteFile.writeFile("e:/shengxun/sender/"+UUIDGenerator.getUUID()+".json",data);
            System.out.println("上传成功!"+new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run(String... args) throws Exception {
        final long timeInterval = 10000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    // ------- code for task to run
                    writefile();
                    // ------- ends here
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }


}
