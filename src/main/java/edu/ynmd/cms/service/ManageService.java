package edu.ynmd.cms.service;

import edu.ynmd.cms.model.Carousel;
import edu.ynmd.cms.model.Media;
import edu.ynmd.cms.model.News;
import edu.ynmd.cms.model.Singlepage;

import java.util.List;

public interface ManageService {
    News saveNews(News news);
    boolean deleteNews(String id);

    News getNews(String id);
    List<News> getNewsList();

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
}
