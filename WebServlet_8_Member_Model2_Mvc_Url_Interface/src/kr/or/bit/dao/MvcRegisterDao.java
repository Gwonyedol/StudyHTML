package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.MvcRegister;

public class MvcRegisterDao {
	static DataSource ds;
	//1. 생성자에서 ds 객체 초기화
	//2. static 초기자 : static{ static 멤버 초기화 }
	Connection conn = null; //DB연결
	PreparedStatement pstmt = null; //DB에 SQL문 실행
	ResultSet rs = null; //DB쿼리 결과 받고 DB해제
	
	static {
		InitialContext ctx;
		try {
			 ctx = new InitialContext();
			 Context envctx= (Context)ctx.lookup("java:comp/env"); //기본설정
			 ds =(DataSource)envctx.lookup("/jdbc/oracle");//context.xml 에서 name="jdbc/oracle"
		}catch (Exception e) {
			System.out.println("look up Fail : " + e.getMessage());
		}
		 //Context context = new InitialContext(); //이름기반 검색
		 //ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); ///jdbc/oracle pool 검색
		/*
		 * DataSource를 이용하려면 다음의 절차를 따릅니다.
		 * 
		 * JNDI Server에서 lookup( ) 메소드를 통해 DataSource 객체를 획득한다. DataSource 객체의
		 * getConnection( ) 메소드를 통해서 Connection Pool에서 Free 상태의 Connection 객체를 획득한다.
		 * Connection 객체를 통한 DBMS 작업을 수행한다. 모든 작업이 끝나면 DataSource 객체를 통해서 Connection
		 * Pool에 Connection을 반납한다.
		 */
		
	}
	
	//CRUD 함수
	public int writeOk(MvcRegister dto) {
		int row = 0;
		
		try {
			  conn = ds.getConnection();
			  String sql="insert into mvcregister(id,pwd,email) values(?,?,?)";
			  pstmt = conn.prepareStatement(sql);
			  
			  pstmt.setInt(1, dto.getId());
			  pstmt.setString(2, dto.getPwd());
			  pstmt.setString(3, dto.getEmail());
			  
			  row = pstmt.executeUpdate();
			  
		}catch (Exception e) {
			System.out.println("write ok Exception : " + e.getMessage());
			row = -1;
		}finally {
			if(pstmt != null)try{pstmt.close();}catch (Exception e){}
			if(conn != null) try{conn.close();}catch (Exception e){}  //반환
			
		}
		System.out.println(row);
		return row;
	}
	
	//단일 select 함수
	
	//다중 select 함수
	
	//update 함수
	
	//delete 함수
	
	
	
}








