package edu.ynmd.cms.dao;

import edu.ynmd.cms.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface NewsDao extends JpaRepository<News,String>{
//}
public interface NewsDao extends CrudRepository<News,String> {

    @Query("select n from News n order by n.pbdate desc ")
    Page<News> getNewsForPage(Pageable pageable);

    @Query("select n from News n order by n.pbdate desc ")
    List<News> getAll();
}
