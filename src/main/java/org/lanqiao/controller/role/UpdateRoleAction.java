package org.lanqiao.controller.role;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.lanqiao.entity.Priv;
import org.lanqiao.entity.Role;
import org.lanqiao.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class UpdateRoleAction
 */
@WebServlet("/role/updateRoleAction.do")
@MultipartConfig
public class UpdateRoleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		String rname = request.getParameter("rname");
		String rid = request.getParameter("rid");
		
		Part imgFile = request.getPart("imgfile");
		String by001 ="/upload/"+imgFile.getSubmittedFileName();
			
		//把从前端用户选择的所有权限的id数组封装一个权限的list集合中，该集合只存了pid的值
		String[] privs = request.getParameterValues("priv");
		List<Priv> lp = new ArrayList<>();
		for(String  priv : privs) {
			Priv p = new Priv();
			p.setPid(Integer.parseInt(priv));
			lp.add(p);
		}
		Role role = new Role();
		role.setId(Integer.parseInt(rid));
		role.setRname(rname);
		role.setBy001(by001);
		role.setLp(lp);
		
		boolean b = new RoleServiceImpl().updateRole(role);
		if(b) {
			InputStream is = imgFile.getInputStream();
			FileOutputStream fos = new FileOutputStream(request.getServletContext().getRealPath("/upload/")+imgFile.getSubmittedFileName());
			int c = 0;
			while((c=is.read())!=-1) {
				fos.write(c);
			}
			is.close();
			fos.close();
			request.setAttribute("msg", "添加成功");
		}else {
			request.setAttribute("msg", "添加失败");
		}
		request.getRequestDispatcher("/role/roleListAction.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
