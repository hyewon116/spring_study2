package kr.co.ictedu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
	
	@Autowired
	private EmpDAO dao;
	
	public EmpDTO empDetail(String eno) {
		EmpDTO dto = null; 
		
		dto = dao.empDetail(eno);
		
		return dto;
	}//empDetai

	public List<EmpDTO> empList() {
		System.out.println("여기는 서비스입니다.");
		
		List<EmpDTO> list = null;
		
		list = dao.empList();
		
		return list; 
	}//empList
}//class
