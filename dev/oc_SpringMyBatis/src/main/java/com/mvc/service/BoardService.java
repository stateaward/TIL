package com.mvc.service;

import java.util.ArrayList;
import com.mvc.vo.Board;

//인터페이스는 서비스를 이용하는 클라이언트(BoardApp)에게 제공하는 역할. 이걸 보고 '~해주세요' 하는 식으로 되도록
//web에서는 controller를 위한 인터페이스
public interface BoardService {
	
	public ArrayList<Board> selectAll();	//모든 글 정보
	public Board selectOne(String num);		//헤딩 번호의 글 한 개
	public void insert(Board b);		//새글 등록
	public void delete(String num);		//글 삭제
	public ArrayList<Board> search(String condition, String word);	//검색결과 
	
}
