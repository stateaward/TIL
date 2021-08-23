package com.mvc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.mapper.BoardMapper;
import com.mvc.vo.Board;


//@Component : 이것도 가능하지만, 좀 더 자세히 역할 기술
//@Repository : 컨테이너가 생성하는 객체 중 DB 작업 하는 객체

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	//타입이 BoardMapper인 객체를 찾아서 주입을 시킴 -> BoardMapperImpl.java를 찾아서 넣음
	@Autowired	
	BoardMapper mapper;		//proxy 객체가 실제로 주입됨

	@Override
	public ArrayList<Board> selectAll() {
		return mapper.selectAll();
		//호출하는 맵퍼의 메소드 이름 == xml mapper안의 쿼리 id
	}

	@Override
	public Board selectOne(String num) {
		return mapper.selectOne(num);
	}

	@Override
	public void insert(Board b) {
		mapper.insert(b);
		
	}

	@Override
	public void delete(String num) {
		mapper.delete(num);
	}

	@Override
	public void countUp(String num) {
		mapper.countUp(num);
	}

	@Override
	public ArrayList<Board> search(String condition, String word) {
		return null;
	}

	@Override
	public List<Board> join() {
		return mapper.join();
	}

	@Override
	public void modify(HashMap<String, String> map) {
		mapper.modify();
	}

}
