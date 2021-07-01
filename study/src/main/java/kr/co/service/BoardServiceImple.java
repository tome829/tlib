package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.BoardDAO;
import kr.co.vo.BoardVO;

@Service
public class BoardServiceImple implements BoardService{
	
	@Inject
	private BoardDAO dao;
	
	//게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
	}
	
	@Override
	public List<BoardVO> list() throws Exception {

		return dao.list();
	}
	
	@Override
	public BoardVO read(int bno) throws Exception{
		return dao.read(bno);
		//bno를 넣은 dao안에 있는 read메소드를 리턴시킴
	}

	@Override
	public void update(BoardVO boardVO) throws Exception{
		dao.update(boardVO);		
	}
	
	@Override
	public void delete(int bno) throws Exception{
		dao.delete(bno);
	}
}
