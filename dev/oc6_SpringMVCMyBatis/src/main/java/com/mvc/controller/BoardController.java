package com.mvc.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.service.BoardService;
import com.mvc.vo.Board;

/* 
 * 확인해야 할 것
 * 1. 어노테이션 되어 있는지 @Controller
 * 2. 주입 제대로 되는지 @Autowired
 * 
 */


@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	 
	//HandlerMapping :  요청을 처리할 컨트롤러 결정하는 객체 -> @RequestMapping로 대신함
	@RequestMapping(value = "/list.bod", method = RequestMethod.GET)
	public String home(Model model) {	
		//request에 setAttribute 한 것 과 동일한 개념. 단,리턴을 따로 안해줘도 모델 안에 담기는 형태
		//MVC web에선 RequestDispatcher로 보냈는데, 여기선 static 변수처럼 할당만 하면 끝나는 형태!
		
		List<Board> list = service.selectAll();
		
		//모델은 Map형태의 Data Type (key, value)
		model.addAttribute("list", list);		//key, value : model에 data 저장
	  //model.addAttribute("city", "la");		//하나의 모델 안에 여러 정보를 담을 수 있고, 객체기만 하면 됨
		return "list";
	}

	
	@GetMapping(value = "/read.bod")
	public String read(Model model, HttpServletRequest req, HttpSession ses, HttpServletRequest res) {	//필요한거 모두 쓸 수 있음. 
		
		Board b = service.selectOne(req.getParameter("num"));
		
		model.addAttribute("b", b);		//key, value : model에 data 저장
		return "read";
	}
	
	@GetMapping(value = "/insertForm.bod")	//입력화면으로 넘기기
	public String insertForm() {
		return "insertForm";
	}
	
	@PostMapping(value = "/insertProcess.bod") //DB에 입력하기
	public String insertProcess(Board b) {	  //vo : 사용자가 입력한 값 4개를 받아옴.
											  //	 insertForm.jsp의 폼 이름과 vo의 필드명이 일치해야함
											  //insertProcess(@ModelAttribute Board b) : 클라이언트가 입력한 값을 객체(vo)로 받아오기 위한 annotation / 생략가능
		
		service.insert(b);
		return "redirect:/list.bod";	//view 이름으로 안보고 redirect(다른페이지 넘기기) 시켜줌
	}
	
	/*	이것도 가능하지만 번거로움
	@PostMapping(value = "/insertProcess.bod") //DB에 입력하기
	public String insertProcess(HttpServletRequest req) {
		Board b = new Board(null, 
				            req.getParameter("pass"), 
				            req.getParameter("name"), 
				            null, 
				            req.getParameter("title"), 
				            req.getParameter("content"), 
				            null
				            );
		
		service.insert(b);
		return "redirect:/list.bod";
	}
	 */
	
	@GetMapping(value = "/delete.bod")
	public String delete(Model model, HttpServletRequest req) {
		
		service.delete(req.getParameter("num"));
		
		return "redirect:/list.bod";
	}
	
	//get 방식 -> 로그인 화면
	@GetMapping(value = "/login.bod")
	public String login() {				
		return "loginForm";	//view name
	}
	
	//post 방식 -> 로그인 처리(id, pass 받아오고 DB체크. 세션 저장)
	@PostMapping(value = "/login.bod")
	public String loginPost(HttpSession session, HttpServletRequest req) {
		
		session.setAttribute("id", req.getParameter("id"));
		return "redirect:/list.bod";	//view name
	
	}
	
	@GetMapping(value = "/logout.bod")
	public String logout(HttpSession session) {		
		session.setAttribute("id", null);
		
		return "redirect:/list.bod";	//view name
	}
	
	@RequestMapping(value = "/join.bod", method = RequestMethod.GET)
	public String join(Model model) {	
		List<Board> list = service.join();
		
		model.addAttribute("list", list);
		return "join";
	}
	
	@GetMapping(value = "/modify.bod")
	public String modify(Model model, HttpServletRequest req) {	
		Board b = service.selectOne(req.getParameter("num"));
		
		model.addAttribute("b", b);
		return "modifyForm";
	}

	@PostMapping(value = "/modify.bod")
	public String modifyProcess(Model model, HttpServletRequest req) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("num", req.getParameter("num"));
		map.put("title", req.getParameter("title"));
		map.put("content", req.getParameter("content"));
		
//		System.out.println(map.get("num"));
//		System.out.println(map.get("title"));
//		System.out.println(map.get("content"));
		
		service.modify(map);
		
		return "redirect:/list.bod";
	}
	
}