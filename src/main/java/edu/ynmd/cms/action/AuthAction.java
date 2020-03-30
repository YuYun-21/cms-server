package edu.ynmd.cms.action;

import edu.ynmd.cms.tools.JwtUtil;
import edu.ynmd.cms.tools.Tools;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;

//令牌环更新
@CrossOrigin
@RestController
@PreAuthorize("hasAuthority('admin')")
@RequestMapping("/auth")
public class AuthAction {
    //更新令牌环信息
    @GetMapping("refreshToken")
    @ResponseBody
    public HashMap<String,String> refreshToken( HttpServletRequest request){


        String role=null;
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();

        }
        // UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        String userid= (String)SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        if(Tools.isNullOrSpace(role)){
            return new HashMap<String,String>(){{
                put("token","error");
            }};
        }
        else{

            String jwt="";

            jwt= JwtUtil.generateToken(role,userid,60*60*1000);//一小时
            HashMap<String,String> m=new HashMap<>();
            m.put("token",jwt);
            return m;


        }

    }

    //获取当前登录用户的角色
    @GetMapping("getRole")
    @ResponseBody
    public HashMap<String,String> getRoleByToken(){

        String role="";
        String userid="";
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();

        }
        if(Tools.isNullOrSpace(role)){
            return new HashMap<String,String>(){{
                put("role","error");
            }};
        }
        else{

            HashMap<String,String> m=new HashMap<>();
            m.put("role",role);
            return m;
        }
    }
}