package com.study.springrest.persistent;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.springrest.domain.RestVO;

@Repository
public class RestDAOImpl implements RestDAO{

	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.study.springrest.mappers.restMapper";
	
	@Override
	public RestVO get(int board_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".get", board_no);
	}

	@Override
	public List<RestVO> getList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getList");
	}

	@Override
	public void insert(RestVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertRest", vo);
	}

	@Override
	public void update(RestVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int board_no) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", board_no);
	}

	@Override
	public void increaseReply(int board_no) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".increaseReply", board_no);
	}
	
	
}
