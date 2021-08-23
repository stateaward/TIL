package com.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.BoardDAO;
import com.mvc.vo.Board;

//container에 의해 생성되어서 controller에 주입되어야 함

//@Component : 이것도 가능. 알아서 스캔해서 만들어짐.
//@Service : 생성해야 하는 컴포넌트 중 서비스 객체임을 표시. 좀 더 자세히 기술하는 어노테이션. 

//클라이언트인 BoardApp.java에서 요청이 들어오면 실제로 일을 하는 객체
@Service("bservice")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO dao;		//어노테이션으로 자동 주입시키면 객체 생성할 필요 없음
	
	@Override
	public ArrayList<Board> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Board selectOne(String num) {
		dao.countUp(num); //조회수 증가 후, 게시글 정보 받아오기
		Board b = dao.selectOne(num);
		return b;	//controller에게 리턴됨
	}

	@Override
	public void insert(Board b) {
		dao.insert(b);
	}

	@Override
	public void delete(String num) {
		dao.delete(num);
	}

	@Override
	public ArrayList<Board> search(String condition, String word) {
		return dao.search(condition, word);
	}

	@Override
	public List<Board> join() {
		return dao.join();
	}

	@Override
	public void modify(HashMap<String, String> map) {
		dao.modify(map);
	}
	
}
