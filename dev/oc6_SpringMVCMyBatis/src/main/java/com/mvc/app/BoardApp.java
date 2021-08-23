package com.mvc.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mvc.service.BoardService;
import com.mvc.vo.Board;

//Client Program(서비스를 이용하고 싶은 객체)
public class BoardApp {
	
	public static void main(String[] args) {
		//BoardService를 이용해서 작업 부탁
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConfig.xml");

		
		BoardService service = context.getBean("bservice", BoardService.class);	//찾는 이름 "BoardServiceImpl" 클래스명과 동일하지만 앞에 소문자로!


		//1. selectAll()
		List<Board> list = service.selectAll();
		for (Board b : list) {
			System.out.println(b.getNum() + " -- " + b.getName() + " -- " + b.getTitle() + " -- " + b.getCount());
		}
		
		//2. selectOne()
		Board b = service.selectOne("28");
		System.out.println(b.getNum() + " -- " + b.getName() + " -- " + b.getTitle() + " -- " + b.getCount());
		
		//3. insert()
		service.insert(new Board(null, "1234", "iphone12", null, "HoGu", "Hi", null));
		
		//4. delete()
		
	}

}
