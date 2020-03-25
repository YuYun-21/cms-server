package edu.ynmd.cms.action;

import edu.ynmd.cms.model.Carousel;
import edu.ynmd.cms.model.News;
import edu.ynmd.cms.model.Singlepage;
import edu.ynmd.cms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@RequestMapping("/manage")
@CrossOrigin
@RestController
public class AdminAction {
    @Autowired
    private ManageService manageService;


    @PostMapping("saveNews")
    @ResponseBody
    public HashMap saveNews(@RequestBody News news)throws Exception{

        HashMap m=new HashMap();

        try {
            news.setPbdate(System.currentTimeMillis());
            manageService.saveNews(news);
            m.put("msg","ok");

        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","error");
        }
        return m;
    }

    @PostMapping("deleteNews")
    @ResponseBody
    public HashMap deleteNews(@RequestBody News news) throws Exception{
        HashMap m=new HashMap();

        try {
            manageService.deleteNews(news.getNewsid());
            m.put("msg","ok");
        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","error");
        }
        return m;
    }

    //图片上传
    @PostMapping("uploadPic")
    @ResponseBody
    public HashMap uploadPic(@RequestBody MultipartFile uploadfile) throws Exception{
        HashMap m=new HashMap();

        String finename=uploadfile.getOriginalFilename();
        String suffixname=uploadfile.getOriginalFilename().substring(finename.lastIndexOf("."));

        finename=String.valueOf(System.currentTimeMillis())+suffixname;

//        String filepath="d:/springbootupload/";
        String filepath="/usr/server/cms/uploadfiles/";

        File tf=new File(filepath);
        if(!tf.exists()){
            tf.mkdir();
        }

        try {
            uploadfile.transferTo(new File(filepath+finename));
            m.put("msg","ok");
            m.put("filename",finename);
            return m;
        } catch (IOException e) {
            e.printStackTrace();
            m.put("msg","ioerror");
        } catch (IllegalStateException e) {
            e.printStackTrace();
            m.put("msg","illeageerror");
        }

        return m;
    }

    @PostMapping("saveCarousel")
    @ResponseBody
    public HashMap saveCarousel(@RequestBody Carousel carousel) throws Exception{
        HashMap m=new HashMap();

        try {
            manageService.saveCarousel(carousel);
            m.put("msg","ok");
        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","error");
        }

        return m;
    }

    @PostMapping("deleteCarousel")
    @ResponseBody
    public HashMap deleteCarousel(@RequestBody Carousel carousel) throws Exception{
        HashMap m=new HashMap();

        try {
            manageService.deleteCarousel(carousel.getCarouselid());
            m.put("msg","ok");
        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","error");
        }

        return m;
    }

    @PostMapping("saveSinglePage")
    @ResponseBody
    public HashMap saveSinglePage(@RequestBody Singlepage singlepage) throws Exception{
        HashMap m=new HashMap();

        try {
            manageService.saveSinglePage(singlepage);
            m.put("msg","ok");
        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","error");
        }


        return m;
    }


    @PostMapping("deleteSinglePage")
    @ResponseBody
    public HashMap deleteSinglePage(@RequestBody Singlepage singlepage) throws Exception{

        HashMap m=new HashMap();
        try {
            manageService.deleteSinglePage(singlepage.getSinglepageid());
            m.put("msg","ok");
        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","error");
        }
        return m;
    }


}
