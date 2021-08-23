package com.ssafy.guestbook.model.dao;

import java.sql.SQLException;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.util.SqlMapConfig;

@Repository
public class GuestBookDaoImpl implements GuestBookDao {
	
	@Override
	public void writeArticle(GuestBookDto guestBookDto) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.insert("com.ssafy.guestbook.model.dao.GuestBookDao.writeArticle", guestBookDto);
		}
	}

	@Override
	public List<GuestBookDto> listArticle(Map<String, Object> map) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectList("com.ssafy.guestbook.model.dao.GuestBookDao.listArticle", map);
		}
	}

	
	
	@Override
	public int getTotalCount(Map<String, String> map) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne("com.ssafy.guestbook.model.dao.GuestBookDao.getTotalCount", map);
		}
	}

	@Override
	public GuestBookDto getArticle(int articleno) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne("com.ssafy.guestbook.model.dao.GuestBookDao.getArticle", articleno);
		}
	}

	@Override
	public void modifyArticle(GuestBookDto guestBookDto) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.update("com.ssafy.guestbook.model.dao.GuestBookDao.modifyArticle", guestBookDto);
		}
	}

	@Override
	public void deleteArticle(int articleno) throws SQLException {
		try(SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.delete("com.ssafy.guestbook.model.dao.GuestBookDao.deleteArticle", articleno);
			sqlSession.commit();
		}
	}

}
