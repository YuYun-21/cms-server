package edu.ynmd.cms.dao;

import edu.ynmd.cms.model.Singlepage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpDao extends JpaRepository<Singlepage,String>{
}
