package kr.co.controller;



import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.BoardService;
import kr.co.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	//게시판 글 작성 화면
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() {
		logger.info("writeView");
	}
	
	//게시판 글 작성
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception {
		logger.info("write");
		
		service.write(boardVO);
		
		return "redirect:/";
	}
	
	//게시판 목록 조회
	//오라클 > DAO > Service > Controller 로 가져온 DATA를 jsp에 뿌리려는 작업
	//model은 데이터를 담을 그릇이고 addAttribute("list", service.list())는
	//service.list()에 담긴 데이터를 list라는 이름으로 담을것이라는 뜻.
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		logger.info("list");
		
		model.addAttribute("list",service.list());
		
		
		return "board/list";
		
	}
	
	//게시물 조회
	//현재 게시판 목록에 bno값들을 있으니 그것을 불러와야함.
	//bno값들은 BoardVO에 들어있으니 Service를 실행할때 BoardVO에 있는 bno를 넣어
	//read라는 이름으로 값을 저장한다.
	@RequestMapping(value="/readView", method=RequestMethod.GET)
	public String read(BoardVO boardVO, Model model)throws Exception{
		logger.info("read");
		
		model.addAttribute("read", service.read(boardVO.getBno()));
		
		return "board/readView";
		
	}
	
	//게시판 수정뷰
	@RequestMapping(value="/updateView", method=RequestMethod.GET)
	public String updateView(BoardVO boardVO, Model model)throws Exception{
		logger.info("updateView");
		
		model.addAttribute("update", service.read(boardVO.getBno()));
		
		return "board/updateView";
	}
	
	//게시판 수정
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception{
		logger.info("update");
		
		service.update(boardVO);
		
		return "redirect:/board/list";
	}
	
	//게시판 삭제
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(BoardVO boardVO) throws Exception{
		logger.info("delete");
		
		service.delete(boardVO.getBno());
		
		return "redirect:/board/list";
	}
}
