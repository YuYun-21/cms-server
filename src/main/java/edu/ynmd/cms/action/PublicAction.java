package edu.ynmd.cms.action;

import edu.ynmd.cms.model.Carousel;
import edu.ynmd.cms.model.Media;
import edu.ynmd.cms.model.News;
import edu.ynmd.cms.model.Singlepage;
import edu.ynmd.cms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
