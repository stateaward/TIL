package com.mvc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mvc.vo.Board;

//Service를 이용하려는 클라이언트(BoardService.java)를 위한 목적
public interface BoardDAO {
	
	public ArrayList<Board> selectAll();	//모든 글 정보
	public Board selectOne(String num);		//헤딩 번호의 글 한 개
	public void insert(Board b);		//새글 등록
	public void delete(String num);		//글 삭제
	public void countUp(String num);	//조회수 증가 : 고객은 countUp을 하면 안되므로, DAO에만 있음	
	public ArrayList<Board> search(String condition, String word);	//검색기능
	public List<Board> join();
	public void modify(HashMap<String, String> map);
	
}
