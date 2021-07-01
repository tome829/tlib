package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	//게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVO);
	}
	
	//게시물 목록 조회
	@Override
	public List<BoardVO> list() throws Exception {
	
		return sqlSession.selectList("boardMapper.list");

	}
	/*
	 * 
	 * return sqlSession.selectList("boardMapper.list");
	 * 
	 * 1) boardMapper에서 id가 list인 것을 가져와서 반환해라 라는 것을 의미
	 * 
	 * 
	 * 2) 이것은 boardMapper.xml에서 mapper의 namespace가
	 * boardMapper이고 그중에 id가 list인것을 가져와서 반환해라
	 * 
	 */
	
	//게시물 조회
	@Override
	public BoardVO read(int bno) throws Exception{
		
		return sqlSession.selectOne("boardMapper.read", bno);
	}
	
	@Override
	public void update(BoardVO boardVO) throws Exception{
		
		sqlSession.update("boardMapper.update", boardVO);
		
	}//boardMapper안의 update라는 id를 가진 메소드에 boardVO를 넣을것이다.
	
	@Override
	public void delete(int bno) throws Exception{
		
		sqlSession.delete("boardMapper.delete", bno);
	
	}//boardMapper안의 delete라는 id를 가진 메소드에 bno를 넣을것이다.
}
