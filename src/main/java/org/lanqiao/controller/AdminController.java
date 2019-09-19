package org.lanqiao.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.entity.Admin;
import org.lanqiao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	
	@RequestMapping("/login")
	public String login() {
		return "role/login";//-->/WEB-INF/view/role/login.jsp
	}
	@RequestMapping("/exitAction")
	public String exitLogin(HttpServletRequest request) {
		request.getSession().invalidate();
		String path = request.getServletContext().getContextPath();
		return "redirect:"+path+"/view/login.jsp";
	}
	@RequestMapping("/imageValidateAction")
	public void imageValidate(HttpSession session , HttpServletResponse response) throws IOException {
		BufferedImage image = new BufferedImage(60, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g =image.getGraphics();
		g.setColor(Color.orange);
		g.fillRect(0, 0, 60, 30);
		g.setFont(new Font("黑体", Font.BOLD, 20));
		Random r = new Random();
		String str = "ABCDEFGHJKLMNPQRSTUVWXZYabcdefghjkmnpqrstuvwxyz23456789";
		g.setColor(Color.black);
		for(int j = 0 ;j < 100 ; j++) {
			int x = r.nextInt(60);
			int y = r.nextInt(30);
			g.drawLine(x,y,x+r.nextInt(2), y+r.nextInt(2));
		}
		StringBuffer sbuffer = new StringBuffer();
		for(int i = 0;i < 4; i++) {
			char c = str.charAt(r.nextInt(str.length()));
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawString(c+"", 12*i+10, 20);
			sbuffer.append(c);
		}
		session.setAttribute("valiCode", sbuffer.toString());
		ImageIO.write(image, "png", response.getOutputStream());
	}
	@RequestMapping("/loginAction")
	public String login(Admin admin,HttpSession session,HttpServletRequest request) {
		String vcode = (String) session.getAttribute("valiCode");
		String path = request.getServletContext().getContextPath();
		//if(vcode.equalsIgnoreCase(admin.getValicode())) {
			Admin admin2 = adminService.checkUsernameAndPwd(new Admin(admin.getAcname() , Hashing.md5().hashString(admin.getApwd(),Charsets.UTF_8).toString()));
			if(admin2 != null) {
				session.setAttribute("admin", admin2);//登录成功，把amdin放入session中，以供所有页面使用
				return "redirect:"+path+"/view/index.jsp";//登录成功进入主界面
			}else {//登录失败
				session.setAttribute("errorMsg", "用户名或密码错误，请重新登录");//设置一个错误信息
			}
		//}else {
		//	request.getSession().setAttribute("errorMsg", "验证码错误，请重新输入");//设置一个错误信息
		//}
		return "redirect:"+path+"/view/login.jsp";//跳转回登录页面
	}
	@RequestMapping("/updateAdminInfo")
	@ResponseBody
	public String updateAdminInfo(Admin admin,HttpSession session) {
		session.setAttribute("admin", admin);
		boolean b = adminService.updateAdminInfo(admin);
		if(b)
			return "ok";
		else
			return "fail";
	}
	
	public String updatePwd(@RequestParam("newpwd")String newpwd,@RequestParam("oldpwd")String oldpwd,HttpServletRequest request) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		String path = request.getServletContext().getContextPath();//获取http://localhost:8080/telecom_cost
		if(oldpwd.equals(admin.getApwd())) {
			admin.setApwd(newpwd);
			boolean b = adminService.updateApwd(admin);
			if(b) {
				//重定向路径前带"/"只代表 http://localhost:8080/view/login.jsp,不带应用程序名
				return "redirect:"+path+"/view/login.jsp";
			}else {
				request.setAttribute("errorPwdMsg","对不起，密码修改失败");
				//request.getRequestDispatcher(path+"/view/user/user_modi_pwd.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("errorPwdMsg","对不起，旧密码错误");
		}
		//这里的path要前边带个"/"就表示绝对路径 表示的意思  http://localhost:8080/telecom_cost/view/user/......
		return "user/user_modi_pwd";
	}
}
