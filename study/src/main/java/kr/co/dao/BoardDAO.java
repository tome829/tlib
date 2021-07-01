package kr.co.dao;

import java.util.List;

import kr.co.vo.BoardVO;

public interface BoardDAO {
	
	//게시글 작성
	public void write(BoardVO boardvo) throws Exception ;
	
	//게시물 목록 조회
	public List<BoardVO> list() throws Exception;
	/*
	 * Mapper 에선 내용 작성.
	 * DAO에선 Mapper에서 작성된 것을 객체화 시키고
	 * DAOImpl에선 객체화된 Mapper의 내용을 구현시킴.
	 * 
	 * 그리고 BoardDAO 연결되는 boardService 작성?
	 * 구현부인 BoardServiceImpl작성
	 * 
	 */
	
	//게시물 조회
	public BoardVO read(int bno) throws Exception;
	
	/*
	 * 조회에서 BoardVO를 한 이유는 bno을 넣고 BoardVO에 데이터를 담아
	 * 다른곳에서 출력을 해야 하기 때문이지만
	 * 
	 * 수정에서 BoardVO가 없고 void와 (int bno)가 아닌
	 * (BoardVo boardVO)인 이유는 값을 돌려 받지 않고 boardMapper에
	 * 전달만 하면 되고 BoardVO에 데이터를 담아오기 때문에
	 * BoardVO클래스를 boardVO로 객체화 시켜 데이터를 전달하기 위해
	 */
	//게시물 수정
	public void update(BoardVO boardVO) throws Exception;
	
	//게시물 삭제
	public void delete(int bno) throws Exception;
	
	
	
}//
