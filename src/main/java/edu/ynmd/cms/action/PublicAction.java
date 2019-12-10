package edu.ynmd.cms.action;

import edu.ynmd.cms.model.News;
import edu.ynmd.cms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
