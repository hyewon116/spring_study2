package kr.co.ictedu.board.free;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardService {

	@Autowired
	private FreeBoardDAO dao;
	
	public int update( FreeBoardDTO dto) {
		int successCount = 0;
		successCount = dao.update(dto);
		return successCount;
	}
	
	public int delete( FreeBoardDTO dto ) {
		int successCount = 0;
		successCount = dao.delete(dto);
		return successCount;
	}
	
	public FreeBoardDTO detail( String board_no ) { //결과값이 글 한개에 대한 정보이므로 String 아니고 dto로 리턴되게.
		FreeBoardDTO dto = null;
		dto = dao.detail(board_no);
		return dto;
	}
	
	public int write( FreeBoardDTO dto ) {
		int successCount = 0;
		successCount = dao.write(dto);
		return successCount;
	}//write
	
	public List<FreeBoardDTO> list() {
		
		List<FreeBoardDTO> list = null; //dao에서 list 타입으로 데이터 가져올 거니 list 선언.
		list = dao.list();
		
		return list;
	}//lis
}
