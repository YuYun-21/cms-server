package edu.ynmd.cms.service.impl;

import edu.ynmd.cms.dao.NewsDao;
import edu.ynmd.cms.model.News;
import edu.ynmd.cms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public boolean addNews(News news) {
        return false;
    }

    @Override
    public boolean deleteNews(String id) {
        return false;
    }

    @Override
    public boolean updateNews(News news) {
        return false;
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
}
