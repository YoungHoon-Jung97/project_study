/*====================
 * GradeController.java
 * -컨트롤러
 ====================*/

package com.test.mybatis;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GradeController
{
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/gradelist.action",method = RequestMethod.GET)
	public String gradeList(Model model) {
		
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		model.addAttribute("lists",dao.list());
		model.addAttribute("count",dao.count());
		
		return "/WEB-INF/view/GradeList.jsp";
	}
	
	@RequestMapping(value = "/gradeupdateform.action", method = RequestMethod.GET)
	public String gradeSearch(Model model,String sid) 
	{
		String result = null;
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		model.addAttribute("grade",dao.search(sid));
		
		result="/WEB-INF/view/GradeUpdateForm.jsp";
		return result;
	}
	
	@RequestMapping(value = "/gradeupdate.action", method = RequestMethod.POST)
	public String gradeSearch(GradeDTO grade) 
	{
		String result = null;
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		dao.modify(grade);
		
		
		result="redirect:gradelist.action";
		return result;
	}
	
	@RequestMapping(value ="/gradeinsertform.action" , method = RequestMethod.GET)
	public String gradeInsertForm(String sid,Model model) 
	{
		
		model.addAttribute("sid",sid);
		
		return "/WEB-INF/view/GradeInsertForm.jsp";
	}
	
	@RequestMapping(value ="/gradeinsert.action" , method = RequestMethod.POST)
	public String gradeInsert(GradeDTO grade) 
	{
		
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		dao.add(grade);
		
		return "redirect:gradelist.action";
	}
	
	@RequestMapping(value ="/gradedelete.action" , method = RequestMethod.GET)
	public String gradeDelete(String sid) 
	{
		
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		dao.remove(sid);
		
		return "redirect:gradelist.action";
	}
	
}
