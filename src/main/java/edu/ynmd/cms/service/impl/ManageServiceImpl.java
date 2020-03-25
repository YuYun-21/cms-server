package edu.ynmd.cms.service.impl;

import edu.ynmd.cms.dao.CarouselDao;
import edu.ynmd.cms.dao.MediaDao;
import edu.ynmd.cms.dao.NewsDao;
import edu.ynmd.cms.dao.SpDao;
import edu.ynmd.cms.model.Carousel;
import edu.ynmd.cms.model.Media;
import edu.ynmd.cms.model.News;
import edu.ynmd.cms.model.Singlepage;
import edu.ynmd.cms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
