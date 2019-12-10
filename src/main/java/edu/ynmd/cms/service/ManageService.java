package edu.ynmd.cms.service;

import edu.ynmd.cms.model.News;

import java.util.List;

public interface ManageService {
    boolean addNews(News news);
    boolean deleteNews(String id);
    boolean updateNews(News news);
    News getNews(String id);
    List<News> getNewsList();
}
