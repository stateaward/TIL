package com.mvc.mapper;

import java.util.ArrayList;
import com.mvc.vo.Board;

//Service를 이용하려는 클라이언트(BoardDAO.java)를 위한 목적
public interface BoardMapper {
	
	public ArrayList<Board> selectAll();	//모든 글 정보
	public Board selectOne(String num);		//헤딩 번호의 글 한 개
	public void insert(Board b);		//새글 등록
	public void delete(String num);		//글 삭제
	public void countUp(String num);	//조회수 증가		
	public ArrayList<Board> search(String condition, String word);	//검색기능
	
}
