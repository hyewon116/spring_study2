package kr.co.ictedu.board.free;

import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ( value = "/board/free")
public class FreeBoardController {

		private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);
		
		@Autowired
		private FreeBoardService service;
		
		@RequestMapping ( value="/update", method = RequestMethod.POST)
		public void update( FreeBoardDTO dto, PrintWriter out ) {
			//dbms에 게시글을  update : FreeBoardService.update(dto) -> FreeBoardDAO.update(dto) 
			// -> freeboard-mapper.xml(namespace:FreeBoardMapper.update)
			int successCount = 0;
			successCount = service.update(dto);
			out.print(successCount);
			out.close();
		}//update
		
		@RequestMapping ( value = "/update_form", method = RequestMethod.GET)
		public String updateForm( String board_no, Model model ) { //해당 게시글 번호 받아옴 (특정 게시글을 수정하는 거니까)
			FreeBoardDTO dto = null;
			dto = service.detail(board_no);
			model.addAttribute("detail_dto", dto);
			
			return "/board/free/update_form"; //jsp file name 
		}//updateForm
		
		@RequestMapping ( value = "/delete", method = RequestMethod.GET) //get = 주소를 직접 지정하는 방식
		public void delete( FreeBoardDTO dto, PrintWriter out ) { //no & pwd = 값이 두 개이므로 DTO로 받아옴. (mapper가 값을 두개 못 받음)
			//dbms에서 게시글 하나를 delete : FreeBoardService.delete(board_no) -> FreeBoardDAO.delete(board_no) 
			// -> freeboard-mapper.xml(namespace:FreeBoardMapper.delete) 
			int successCount = 0;
			successCount = service.delete( dto );
			out.print(successCount);
			out.close();
		}
				
		@RequestMapping ( value = "/detail", method = RequestMethod.GET) //get = 주소를 직접 지정하는 방식
		public String detail( String board_no, Model model ) {
			//dbms에서 게시글 하나를 select : FreeBoardService.detail(board_no) -> FreeBoardDAO.detail(board_no) 
			// -> freeboard-mapper.xml(namespace:FreeBoardMapper.detail) 
			FreeBoardDTO dto = service.detail(board_no); //글 한 개 정보를 dto에 담을 거임. 
			
			logger.info(dto.toString()); // 콘솔창에 확인용 (중요한거 x)
			model.addAttribute("detail_dto", dto); //dto를 model에 담을 거임.
			return "/board/free/detail";//jsp file name
		}
		
		@RequestMapping ( value = "/write", method = RequestMethod.POST ) //-> /board/free는 상위 request mapping에 이미 있음!!
		public void write( FreeBoardDTO dto, PrintWriter out ) {
			//dbms에 게시글을  insert : FreeBoardService.write(dto) -> FreeBoardDAO.write(dto) 
			// -> freeboard-mapper.xml(namespace:FreeBoardMapper.write)
			int successCount = 0;
			successCount = service.write(dto);
			out.print(successCount);
			out.close();
		}//write
		
		@RequestMapping ( value = "/write_form", method = RequestMethod.GET)
		public String writeForm() {
			return "/board/free/write_form";//jsp 파일 이름
		}//writeForm
		
		@RequestMapping (value = "/list", method = RequestMethod.GET)
		public String list(Model model) {
			//dbms에서 게시판 전체를 select : FreeBoardService.list() -> FreeBoardDAO.list() 
			// -> freeboard-mapper.xml(namespace:FreeBoardMapper.list) 
			List<FreeBoardDTO> list = null;
			list = service.list();
			
			model.addAttribute("list",list);
			return "/board/free/list"; //list.jsp (view name) 호출
		}//list
}
