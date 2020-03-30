package edu.ynmd.cms.dao;

import edu.ynmd.cms.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersDao extends JpaRepository<Users,String> {
    @Query("select u from Users u where u.username=:username and u.pass=:pass")
    List<Users> getUsersByUsernameAndPass(@Param("username")String username, @Param("pass") String pass);
}
