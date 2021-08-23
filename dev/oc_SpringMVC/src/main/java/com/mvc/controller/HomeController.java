package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */


/*  http://localhost:[port]/mvc/test.bod
 *  http://localhost:[port]/mvc/list.bod   	<- 이런식으로 요청이 들어오면
 *  
 *  1)DispatcherServlet 에게 가고
 *  2)HandlerMapping에게 보내서 어느 컨트롤러가 일할지 결정해달라 함 : 그러나 현 버젼에선 따로 만들지 않음 --> annotation으로 해결 (@RequestMapping)
 *  3)적합한 Controller가 해당 일을 처리
 *  4)Controller가 디스패쳐에게 결과 data와 논리적 view 정보를 줌
 *  	- data : model.addAttribute("city", "seattle" )
 *  	- view : return "home";
 */


//@Controller : 컨트롤러 역할의 객체, 모든 컨트롤러엔 이같은 annotation 필요

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home.bod", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("city", "seattle" );		//key, value : model에 data 저장
		return "home";		//논리적인 view 이름 ->	 최종 뷰 정보 /WEB-INF/views/home.jsp
	}
	
	@RequestMapping(value = "/test.bod", method = RequestMethod.GET)
	public String test(Model model) {
		model.addAttribute("city", "seoul" );
		return "home";
	}
	
}