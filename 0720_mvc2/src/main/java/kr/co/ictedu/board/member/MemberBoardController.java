package kr.co.ictedu.board.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( value = "/board/member" )
public class MemberBoardController {

	private final static Logger logger = LoggerFactory.getLogger(MemberBoardController.class);
	
	@RequestMapping ( value = "/write_form", method = RequestMethod.GET )
	public String writeForm() {
		return "/board/member/write_form";//jsp file name
	}//writeForm
	
	@RequestMapping ( value = "/list", method = RequestMethod.GET )
	public String list() {
		return "/board/member/list"; //jsp file name
	}//list
	
}//class

/*
create table memberboard (
  board_no int primary key auto_increment
, title varchar(150)
, mno int
, contents varchar(1500)
, view_count int
, write_date datetime
); 
*/