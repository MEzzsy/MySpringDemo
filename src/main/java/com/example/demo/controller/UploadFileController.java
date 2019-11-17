package com.example.demo.controller;

import com.example.demo.bean.Message;
import com.example.demo.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by mezzsy on 2019-08-16
 * Describe:
 */
@RestController
@RequestMapping("/upload")
public class UploadFileController {
    private static final boolean DEBUG = true;//是否是测试环境，打包上传到服务器需要改为false
    private static final String IMG_PATH = "/usr/local/tomcat8/webapps/image/";
    private static final String IMG_PATH_DEBUG = "/Users/mezzsy/Downloads/";
    private static final String IMG_URL_HOST = "http://111.230.96.19:8081/image/";

    @RequestMapping
    public String index() {
        return "upload";
    }

    @RequestMapping(value = "/img", method = RequestMethod.POST)
    public Message postUser(MultipartFile file) {
        String fileName = System.currentTimeMillis() + ".png";
        File dest;
        if (DEBUG) {
            dest = new File(IMG_PATH_DEBUG + fileName);
        } else {
            dest = new File(IMG_PATH + fileName);
        }

        Message message = new Message();
        try {
            file.transferTo(dest);

            if (DEBUG) {
                message.setContent("上传成功，文件地址 = " + IMG_PATH_DEBUG + fileName);
            } else {
                message.setContent("上传成功，文件url = " + IMG_URL_HOST + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
            message.setContent("上传失败");
        }
        return message;
    }
}
