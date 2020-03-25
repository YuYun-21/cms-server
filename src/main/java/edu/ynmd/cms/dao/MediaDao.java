package edu.ynmd.cms.dao;

import edu.ynmd.cms.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MediaDao extends JpaRepository<Media,String> {

    @Query("select m from Media m where m.type=:mtype")
    List<Media> getMediaByType(@Param("mtype") String type);

}
