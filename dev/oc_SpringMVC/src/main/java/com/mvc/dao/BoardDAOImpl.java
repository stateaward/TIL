package com.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mvc.vo.Board;


//@Component : 이것도 가능하지만, 좀 더 자세히 역할 기술
//@Repository : 컨테이너가 생성하는 객체 중 DB 작업 하는 객체

@Repository
public class BoardDAOImpl implements BoardDAO {
	ArrayList<Board> list;// select 한 결과를 담아놓을 자료구조

	String url="jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC";
	String user = "scott";
	String password = "tiger";
	String driver = "com.mysql.cj.jdbc.Driver";

	public BoardDAOImpl() {// 만들어진 connection pool 찾아오기
		try {
			Class.forName(driver);
			list = new ArrayList<>();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public ArrayList<Board> selectAll() {
		try {
			list.clear();

			Connection con = getConnection();// pool에서 한개 빌려옴
			Statement stat = con.createStatement();
			String q = "select num, name, wdate, title, count from board order by num desc";
			ResultSet rs = stat.executeQuery(q);

			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String wdate = rs.getString(3);
				String title = rs.getString(4);
				String count = rs.getString(5);

				Board b = new Board(num, null, name, wdate, title, null, count);
				list.add(b);
			}
			con.close();// pool에 반납
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;// ->service로 감
	}

	@Override
	public Board selectOne(String num) {
		Board b = null;
		try {

			String q = "select * from board where num = ?";
			Connection con = getConnection();// pool에서 한개 빌려옴
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);// ?에 setting

			ResultSet rs = stat.executeQuery();// 실행
			rs.next();

			String name = rs.getString(3);
			String wdate = rs.getString(4);
			String title = rs.getString(5);
			String content = rs.getString(6);
			String count = rs.getString(7);

			b = new Board(num, null, name, wdate, title, content, count);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public void insert(Board b) {
		try {
			Connection con = getConnection();
			String q = "insert into BOARD(PASS,NAME,WDATE,TITLE,CONTENT,COUNT) values(?,?,sysdate(),?,?,0)";

			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, b.getPass());
			stat.setString(2, b.getName());
			stat.setString(3, b.getTitle());
			stat.setString(4, b.getContent());

			stat.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String num) {
		try {

			String q = "delete from board where num = ?";
			Connection con = getConnection();// pool에서 한개 빌려옴
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);// ?에 setting

			stat.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void countUp(String num) {
		try {

			String q = "update board set count = count + 1 where num = ?";
			Connection con = getConnection();// pool에서 한개 빌려옴
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);// ?에 setting

			stat.executeUpdate();// 실행
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Board> search(String condition, String word) {
		// TODO Auto-generated method stub
		return null;
	}

}
