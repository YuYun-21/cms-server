package edu.ynmd.cms.action;

import edu.ynmd.cms.model.*;
import edu.ynmd.cms.service.ManageService;
import edu.ynmd.cms.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/public")
@CrossOrigin
@RestController
public class PublicAction {

    @Autowired
    private ManageService manageService;

    @GetMapping("getNewsList")
    @ResponseBody
    public List<News> getNewsList() throws Exception {

        return manageService.getNewsList();
    }

    @PostMapping("getSingleNewsById")
    @ResponseBody
    public  News getSingleNewsById(@RequestBody News news) throws Exception{
        return manageService.getNews(news.getNewsid());
    }

    @GetMapping("getSinglePageList")
    @ResponseBody
    public List<Singlepage> getSinglePageList() throws Exception{

        return manageService.getSinglePageList();
    }

    @PostMapping("getSinglePageById")
    @ResponseBody
    public Singlepage getSinglePageById(@RequestBody Singlepage singlepage) throws Exception{
        return manageService.getSinglePage(singlepage.getSinglepageid());
    }

    @GetMapping("getCarouselList")
    @ResponseBody
    public List<Carousel> getCarouselList() throws Exception{
        return manageService.getCarouselList();
    }

    @PostMapping("getMediaListByType")
    @ResponseBody
    public List<Media> getMediaListByType(@RequestBody Media media) throws Exception{
        return manageService.getMediaListByType(media.getType());
    }

    @GetMapping("getCarouselListMap")
    @ResponseBody
    public HashMap getgetCarouselListMap() throws Exception{

        HashMap m=new HashMap();
        List<Carousel> cl=manageService.getCarouselList();
        m.put("msg","ok");
        m.put("list",cl);

        return m;
    }

    @PostMapping("getSingleCarousel")
    @ResponseBody
    public HashMap getSingleCarousel(@RequestBody Carousel carousel) throws Exception{

        HashMap m=new HashMap();

        Carousel temp=manageService.getCarousel(carousel.getCarouselid());
        if(temp!=null){
            m.put("msg","ok");
            m.put("obj",temp);

        }
        else {
            m.put("msg","error");
        }

        return m;
    }

    @PostMapping("/login")
    @ResponseBody
    public HashMap<String,String> login(
            @RequestBody Account account) throws IOException {
        Users u=manageService.getUserByUserNameAndPass(account.username,account.password);
//        if(account.username.equals("admin")&&account.password.equals("123456")){
        if(u!=null){
            //String jwt= JwtUtil.generateToken("admin","123456789abc");
            String jwt= JwtUtil.generateToken(u.getRoleid(),u.getUsersid());


            return new HashMap<String,String>(){{
                put("msg","ok");
                put("token",jwt);
                put("role",u.getRoleid());
                //put("role","admin");
            }};
        }
        else {
            //return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            return new HashMap<String,String>(){{
                put("msg","error");
                put("token","error");
            }};
        }
    }

    public static class Account{
        public String username;
        public String password;
    }
}
