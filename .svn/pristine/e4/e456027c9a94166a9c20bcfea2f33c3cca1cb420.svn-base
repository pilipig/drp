package com.gmm.drp.controller;

import com.gmm.drp.utils.FileUtils;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @ClassName PhotoController
 * @Description 图片上传
 * @Author baohaipeng
 * @Date 2019-04-16
 * @Version 1.0
 */
@RestController
public class PhotoController {
    @RequestMapping(value="photoupload.do",method= {RequestMethod.POST})
    public R uploadImg(@RequestParam("file")MultipartFile mfile, HttpServletRequest request){
        // File dir = FileUtils.createDir(request.getServletContext().getRealPath("/"),"photos");
        //文件先放在  E:\IMG\photos
        R r  =new R();

        File dir = FileUtils.createDir("E:\\IMG","photos");

        File file = new File(dir,FileUtils.createFileName(mfile.getOriginalFilename()));
        try {
            mfile.transferTo(file);
            System.out.println("-----------------------------------------------------");
            String gimg =dir.getPath()+File.separator+file.getName();
            r.setMsg(dir.getPath()+File.separator+file.getName());
            System.out.println(ResultUtil.setOK(dir.getName()+File.separator+file.getName()));
            return ResultUtil.setOK(dir.getName()+File.separator+file.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.setERROR("ERROR");
        }
    }
}
