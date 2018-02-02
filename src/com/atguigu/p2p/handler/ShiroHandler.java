package com.atguigu.p2p.handler;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shiro")
public class ShiroHandler {
	static Logger logger = Logger.getLogger(ShiroHandler.class);
	@RequestMapping("/login")
	public String login(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			//@RequestParam("remeberMe") String remeberMe,
			HttpSession session
			){
		logger.debug("进入验证方法");
		 //获取当前的subject,调用SecurityUtils.getSubject()
        Subject currentUser = SecurityUtils.getSubject();
        
        // 测试当前用户是否被认证即是否已经登录
        if (!currentUser.isAuthenticated()) {
        	
        	//把用户名和密码封装为UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            
            //remenberme
            /*if(remeberMe != null && "yes".equals(remeberMe)){
            	 System.out.println(remeberMe);
            	 token.setRememberMe(true);
            }*/
           
            try {
            	
            	//执行登陆
                currentUser.login(token);
            }
            
            // ... catch more exceptions here (maybe custom ones specific to your application?
            //所有的认证异常的父类
            catch (AuthenticationException ae) {
            	
            	System.out.println("登录失败："+ae.getMessage());
				logger.error("登录失败："+ae.getMessage());
            	return "login";
            }
        }
        
        //若成功通过 Shiro 的验证. 则应该可以从 Shiro 的上下文中得到登录的信息. 
        Object user = SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
		session.setAttribute("user", user);
		return "redirect:/customer/toList";

	}
	
}
