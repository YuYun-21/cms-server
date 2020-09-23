package edu.ynmd.cms.action;

import edu.ynmd.cms.model.*;
import edu.ynmd.cms.service.ManageService;
import edu.ynmd.cms.tools.BaseImgTools;
import edu.ynmd.cms.tools.JwtUtil;
import edu.ynmd.cms.vo.PageParmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
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

    @PostMapping("getNewsListByPage")
    @ResponseBody
    public HashMap getNewsListByPage(@RequestBody PageParmVo pageParmVo) throws Exception{

        HashMap m=new HashMap();

        Page<News> newspage= null;
        try {
            newspage = manageService.getNewsList(pageParmVo.getPage(),pageParmVo.getPagesize());
            m.put("msg","ok");
            m.put("obj",newspage);
        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","error");
        }
        return m;
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

    @PostMapping("getMediaListById")
    @ResponseBody
    public  Media getMediaListById(@RequestBody Media media) throws Exception{
        return manageService.getMedia(media.getMediaid());
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

    @GetMapping("createDemoData")
    @ResponseBody
    public HashMap createDemoData() throws Exception{

        HashMap m=new HashMap();

        try {
            for(int i=0;i<100;i++){
                News n=new News();
                n.setTitle("测试数据标题"+1);
                n.setAuthor("测试作者"+i);
                n.setPbdate(System.currentTimeMillis());
                n.setContent("测试内容"+i);
                manageService.saveNews(n);
            }
            m.put("msg","ok");
        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","error");
        }
        return m;
    }

    @PostMapping("saveUser")
    @ResponseBody
    public HashMap saveUser(@RequestBody Users users) throws Exception{
        HashMap m=new HashMap();

        try {
            users.setRoleid("member");

            manageService.saveUser(users);
            m.put("msg","ok");
        } catch (Exception e) {
            e.printStackTrace();

            m.put("msg","error");
        }


        return m;
    }

    @PostMapping("saveMyFrinds")
    @ResponseBody
    public HashMap saveMyFrinds(@RequestBody Myfriend myfriend) throws Exception{
        HashMap m=new HashMap();
        myfriend.setPbtime(new Timestamp(System.currentTimeMillis()).getTime());


        try {
            manageService.saveMyfriend(myfriend);
            m.put("msg","ok");
        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","error");
        }


        return m;
    }

    @PostMapping("deteMyFriends")
    @ResponseBody
    public HashMap deleteMyFriends(@RequestBody Myfriend myfriend) throws Exception{

        HashMap m=new HashMap();

        try {
            manageService.deleteMyFriends(myfriend.getMyfriendid());
            m.put("msg","ok");
        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","error");
        }

        return m;
    }


    @PostMapping("getSingleMyFriends")
    @ResponseBody
    public HashMap getSingleMyFriends(@RequestBody Myfriend myfriend) throws Exception{

        HashMap m=new HashMap();

        Myfriend temp=  manageService.getMyfrindById(myfriend.getMyfriendid());
        if(temp!=null){
            m.put("msg","ok");
            m.put("obj",temp);

            //朋友圈图片地址
//            String imagepath="E:\\upload\\";
            String imagepath="/usr/server/cms/uploadfiles/myfriend/";

            String[] picbase=temp.getPic().split(",");
            BaseImgTools.saveImgByStr(imagepath+temp.getMyfriendid()+".jpg",picbase[1]);

        }
        else {
            m.put("msg","empty");
        }


        return m;
    }


    @GetMapping("getLatestMyFriends")
    @ResponseBody
    public HashMap getLatestMyFriends() throws Exception{
        HashMap m=new HashMap();
        List<Myfriend> fl=manageService.getLatestMyFrinds();

        if(fl.size()>0){
            m.put("msg","ok");
            m.put("list",fl);
        }
        else{
            m.put("msg","empty");
        }
        return m;

    }

}
