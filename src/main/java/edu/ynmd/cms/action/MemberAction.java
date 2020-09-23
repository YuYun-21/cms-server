package edu.ynmd.cms.action;

import edu.ynmd.cms.model.Users;
import edu.ynmd.cms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@PreAuthorize("hasAuthority('member')") //配置角色，拥有该角色的用户方可访问
@RequestMapping("/member")
public class MemberAction {

    @Autowired
    private ManageService manageService;


    //判断用户是否是注册用户

    @GetMapping("isRegistUser")
    @ResponseBody
    public HashMap isRegistUser() throws Exception{

        HashMap m=new HashMap();

        String userid=manageService.getCurrentUserId();
        Users us=manageService.getUser(userid);
        if(us!=null){
            m.put("msg",true);
        }
        else{
            m.put("msg",false);
        }



        return m;
    }


    @GetMapping("getMyUserInfo")
    @ResponseBody
    public HashMap getMyUserInfo() throws Exception{
        HashMap m=new HashMap();

        String userid=manageService.getCurrentUserId();
        Users u=manageService.getUser(userid);
        if(u!=null){
            m.put("msg","ok");
            m.put("obj",u);

        }
        else{
            m.put("msg","error");
        }


        return m;
    }

}