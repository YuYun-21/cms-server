package edu.ynmd.cms.service.impl;

import edu.ynmd.cms.dao.*;
import edu.ynmd.cms.model.*;
import edu.ynmd.cms.service.ManageService;
import edu.ynmd.cms.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private NewsDao newsDao;

    @Autowired
    private SpDao spDao;

    @Autowired
    private CarouselDao carouselDao;

    @Autowired
    private MediaDao mediaDao;

    @Autowired
    private UsersDao usersDao;

    @Override
    public boolean deleteNews(String id) {

        try {
            newsDao.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public News saveNews(News news) {
        try {
            return   newsDao.save(news);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public News getNews(String id) {

        try {
            Optional<News> temp=newsDao.findById(id);
            return temp.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<News> getNewsList() {
        return newsDao.findAll();
    }

    @Override
    public Singlepage saveSinglePage(Singlepage singlepage) {
        try {
            return spDao.save(singlepage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean deleteSinglePage(String id) {
        try {
            spDao.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Singlepage getSinglePage(String id) {
        try {
            Optional<Singlepage> singlepage=spDao.findById(id);
            return singlepage.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Singlepage> getSinglePageList() {
        return spDao.findAll();
    }




    @Override
    public boolean deleteCarousel(String id) {
        try {
            carouselDao.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Carousel saveCarousel(Carousel carousel) {
        try {
            return carouselDao.save(carousel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Carousel getCarousel(String id) {
        try {
            Optional<Carousel> temp=carouselDao.findById(id);
            return temp.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Carousel> getCarouselList() {
        return carouselDao.findAll();
    }

    @Override
    public boolean addMedia(Media media) {
        return false;
    }

    @Override
    public boolean deleteMedia(String id) {
        return false;
    }

    @Override
    public boolean updateMedia(Media media) {
        return false;
    }

    @Override
    public Media getMedia(String id) {

        try {
            Optional<Media> temp=mediaDao.findById(id);
            return  temp.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Media> getMediaListByType(String type) {
        return mediaDao.getMediaByType(type);
    }

    //获取当前登录用的的Id
    @Override
    public String getCurrentUserId() {
        String userid= (String) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        if(Tools.isNullOrSpace(userid)){
            return null;
        }
        else {
            return userid;
        }
    }

    //获取当前登录用户的角色
    @Override
    public String getCurrentRole() {
        String role=null;
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();

        }

        if(Tools.isNullOrSpace(role)){
            return null;
        }
        else{
            return role;
        }
    }

    @Override
    public Users saveUser(Users users) {
        try {
            return usersDao.save(users);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteUser(String id) {
        try {
            usersDao.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Users getUser(String id) {
        Optional<Users> temp=usersDao.findById(id);
        return temp.isPresent()?temp.get():null;
    }

    @Override
    public Users getUserByUserNameAndPass(String username, String pass) {
        List<Users> ul=usersDao.getUsersByUsernameAndPass(username,pass);
        if(ul.size()>0){
            return ul.get(0);
        }
        return null;
    }
}
