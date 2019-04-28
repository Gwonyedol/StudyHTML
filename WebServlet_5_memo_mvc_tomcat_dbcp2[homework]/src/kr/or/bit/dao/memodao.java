package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.memo;
import kr.or.bit.utils.SingletonHelper;

//CRUD 작업
//DB서버 통신 > CURD 에 대한 method 제공
//memo table > select , insert , update , delete 함수 제공
//select > 다중행(select *  from memo) , 단일행 (where id=?)
//기본으로 5개 : + 알파(like , 다른 조건 조회)

//CURD 함수 생성 (paramter , return type) 고민
//parameter 객체(dto 타입) 
//return 객체 , 문자열 리턴

//public int insertmemo(String id, String email , String content){}

//public int insertmemo(memo m) { }  (0)

//단일 select
//public memo selectByMemoId(String id) {  .... where id=?}

//다중 select
//public List selectMemo(   select 한 데이터 >> 객체 담기  )
//List<memo> list = new ArrayList<>();
//return list
public class memodao {
	
	DataSource ds = null;
	
	/*
	 * DataSource 정의
	 * 
	 * 커넥션 풀의 Connection을 관리하기 위한 객체이다. 
	 * JNDI Server를 통해서 이용된다. 
	 * DataSource 객체를 통해 필요한 Connection을 획득, 반납 등의 작업을 한다.
	 * 
	 * 
	 * DataSource를 이용하려면 다음의 절차를 따름
	 * 
	 * 1. JNDI Server에서 lookup( ) 메소드를 통해 DataSource 객체를 획득한다. 
	 * 2. DataSource 객체의 getConnection( ) 메소드를 통해서 Connection Pool에서 Free 상태의 
	 * Connection 객체를 획득한다.
	 * Connection 객체를 통한 DBMS 작업을 수행한다. 
	 * 3.모든 작업이 끝나면 DataSource 객체를 통해서 Connection Pool에 Connection을 반납한다.
	 */
	public memodao() throws NamingException {
		//conn = SingletonHelper.getConnection("oracle");
		 Context context = new InitialContext(); //이름기반 검색
		 ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); 
		/*
		 * 우리가 찾으려는 리소스의 이름은 "jdbc/oracle" 이고 WAS인 톰캣에서 리소스를 관리하는 
		 * 가상의 디렉터리는 "java:comp/env"입니다. 그래서 lookup( ) 메소드의 최종인자 값은 
		 * "java:comp/env/jdbc/oracle"이됩니다.
		 */	}
	
	//Read : 한건 데이터 (반드시 테이블에 primary key 컬럼 대상)
	public memo getMemoListById(String id) {
		//select id,email,content from memo where id=?
		//memo m = new memo();
		//m.setId(rs.getInt(1)); ....
		//return m;
		return null;
	}
	
	//Read : 여러건 데이터(where 조건이 없어요)
	public List<memo> getMemoList() throws SQLException{
		//select id,email,content from memo
		
		//Class.forName("oracle.jdbc.OracleDriver");
		//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","kosta","1004");
		/*
		 * 1.Class.forName() : 드라이버를 로드한다.
		 * 2.DriverManager : 로드된 드라이버를 통해서 Connection을 활성화 해주는 객체
		 * 3.Connection : 데이터베이스와의 연결.
		 * 4.Statement : SQL을 실행하는 객체
		 * 5.ResultSet : SQL문 실행 후 데이터를 받는 객체
		 */
		
		PreparedStatement pstmt = null;
		String sql = "select id,email,content from memo";
		//POOL 연결 객체 얻어오기
		Connection conn = ds.getConnection();
		//
		pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<memo> memolist = new ArrayList<>();
		//[] 
		while(rs.next()) {
			memo m = new memo();
			m.setId(rs.getString("id"));
			m.setEmail(rs.getString("email"));
			m.setContent(rs.getString("content"));
			memolist.add(m);
		}
		
		SingletonHelper.close(rs);
		SingletonHelper.close(pstmt);
		//POINT
		conn.close(); //반환하기
		return memolist;
	}
	
	//parameter (memo m)
	//사실은 
	//public int insertMemo(memo m) {
	public int insertMemo(String id, String email, String content)  {
		//insert into memo(id,email,content) values(?,?,?)
		int resultrow=0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			   
			    String sql="insert into memo(id,email,content) values(?,?,?)";
			    //POOL 연결 객체 얻어오기
				conn = ds.getConnection();
				//
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, id);
			   pstmt.setString(2, email);
			   pstmt.setString(3, content);
			   
			   resultrow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Insert :" + e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
			//POINT //반환하기
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			} 
		}
 
		return resultrow;
	}
	
	public int updateMemo(memo m) {
		//update memo set email=? , content=? where id=?
		return 0;
	}
	
	
	public int deleteMemo(String id) {
		//delete from memo where id=?
		return 0;
	}
	
	
	//추가함수 (비동기 통해서 ID 유무)
	public String isCheckById(String id) {
		String ismemoid= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			
				String sql = "select id from memo where id=?";
				//POOL 연결 객체 얻어오기
				conn = ds.getConnection();
				//
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					//do {
						//String id = rs.getString("id")
						ismemoid = "false";
						
					//}while(rs.next());
				}else {
						ismemoid = "true";
				}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("ismemoid : " + ismemoid);
		return ismemoid;
	}
	
	//필요하다면 추가 구현 
	//Like 검색 함수  > 메일주소 like 검색 함수 
	//id,pwd 검사 함수 .... > id  , pwd 검증 하는 함수 .....
	
}
