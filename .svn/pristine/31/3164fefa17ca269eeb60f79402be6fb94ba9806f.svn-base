package bd.nmam.login.business.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd.nmam.login.business.service.ILoginService;
import bd.nmam.login.config.AppConfigure;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	@Qualifier("LoginServiceImp")
	private ILoginService loginService;
	@RequestMapping("/check")
	public String loginCheck(@RequestBody Map<String, String> paramMap, HttpServletResponse response){
		return loginService.loginCheck(paramMap);
	}
	
	@RequestMapping("/out")
	public String loginOut(HttpServletRequest request){
		return loginService.loginOut(request.getHeader("bd-token"));
	}
	@RequestMapping("getUser")
	public String getUser(HttpServletRequest request){
		return loginService.getUser(request.getHeader("bd-token"));
	}
	
}
