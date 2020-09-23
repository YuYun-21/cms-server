package edu.ynmd.cms.service;

import edu.ynmd.cms.model.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ManageService {
    News saveNews(News news);
    boolean deleteNews(String id);

    News getNews(String id);
    List<News> getNewsList();
    Page<News> getNewsList(int start, int pagesize);

    Singlepage saveSinglePage(Singlepage singlepage);
    boolean deleteSinglePage(String id);
    Singlepage getSinglePage(String id);
    List<Singlepage> getSinglePageList();

    Carousel saveCarousel(Carousel carousel);
    boolean deleteCarousel(String id);
    Carousel getCarousel(String id);
    List<Carousel> getCarouselList();

    boolean addMedia(Media media);
    boolean deleteMedia(String id);
    boolean updateMedia(Media media);
    Media getMedia(String id);
    List<Media> getMediaListByType(String type);


    String getCurrentUserId();//从令牌环中获取userid
    String getCurrentRole();//从令牌环中获取角色id

    //用户表
    Users saveUser(Users users);//saveUser可以实现用户表的新增和修改操作
    boolean deleteUser(String id);
    Users getUser(String id);
    Users getUserByUserNameAndPass(String username,String pass);


    //朋友圈
    Myfriend saveMyfriend(Myfriend myfriend);
    boolean deleteMyFriends(String id);
    Myfriend getMyfrindById(String id);
    List<Myfriend> getLatestMyFrinds();
}
