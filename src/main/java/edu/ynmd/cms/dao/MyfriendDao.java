package edu.ynmd.cms.dao;

import edu.ynmd.cms.model.Myfriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyfriendDao extends JpaRepository<Myfriend,String> {

    @Query("select f from Myfriend f order by f.pbtime desc ")
    List<Myfriend> getlatestMyfrindlist();
}
