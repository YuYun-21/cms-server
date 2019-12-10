package edu.ynmd.cms.dao;

import edu.ynmd.cms.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDao extends JpaRepository<News,String>{
}
