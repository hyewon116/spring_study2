package kr.co.ictedu;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmpDAO {

	@Autowired
	private SqlSession sqlSession; 
	
	public EmpDTO empDetail(String eno) {
		EmpDTO dto = null;
		
		dto = sqlSession.selectOne("EmpMapper.empDetail", eno); //mapper에 있는 detail을 가져올 건데, eno를 넘겨줄 것임
		
		return dto;//service로 넘긴다.
	}//empDetail
	
	public List<EmpDTO> empList() {
			
			List<EmpDTO> list = null;
			
			list = sqlSession.selectList("EmpMapper.empList"); //selectList : select 결과를 list에 담아서 return 해주는 객체
			
			System.out.println("Execute DAO : " + list);
			
			return list; 
			
		}//empList
}//class
