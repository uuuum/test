package com.study.spring.persistance;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.spring.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.study.spring.mapper.memberMapper";
	
	@Override
	public String getNow() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getNow");
	}

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insert", vo);
	}
	
}
