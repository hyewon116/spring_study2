package kr.co.ictedu.board.free;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FreeBoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int update( FreeBoardDTO dto ) {
		int successCount = 0;
		successCount = sqlSession.update("FreeBoardMapper.update", dto);
		return successCount;
	}
	
	public int delete( FreeBoardDTO dto ) {
		int successCount = 0;
		//successCount = sqlSession.delete("FreeBoardMapper.delete", board_no, pwd); 
		//sqlSession은 두 개의 아규먼트만 있을 수 있음. board_no와 pwd 두 개 다 받을 수 없음. 아래 처럼 controller에서부터 dto로 받아와야 함.
		successCount = sqlSession.delete("FreeBoardMapper.delete", dto);
		return successCount;
	}//delete
	
	public FreeBoardDTO detail( String board_no ) {
		FreeBoardDTO dto = null;
		dto = sqlSession.selectOne("FreeBoardMapper.detail", board_no); //board_no를 가지고 mapper의 select 작업 수행할 거임.
		
		return dto;
	}//detail
	
	public int write(FreeBoardDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("FreeBoardMapper.write", dto); //freeboard-mapper.xml의 namespace
																		 //dto = 우리가 넘겨받아온 데이터
		return successCount;
	}//write 
	
	//sqlSession.selectOne : select 결과가 오직 하나
	//sqlSession.selectList : select 결과가 여러 개
	public List<FreeBoardDTO> list() {
	
		List<FreeBoardDTO> list = null;
		list = sqlSession.selectList("FreeBoardMapper.list"); //freeboard-mapper.xml의 namespace
		return list;
	}//list

}
