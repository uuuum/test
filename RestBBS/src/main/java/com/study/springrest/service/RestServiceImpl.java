package com.study.springrest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.study.springrest.domain.RestVO;
import com.study.springrest.persistent.RestDAO;
// @Service : @Repository 와 @Controller를 연결해주는 역할
//            데이터를 가져와서 가공
@Service
public class RestServiceImpl implements RestService {
	
	@Inject
	private RestDAO dao;
	
	@Override
	public RestVO get(int board_no) {
		// TODO Auto-generated method stub
		return dao.get(board_no);
	}
	
	@Override
	public List<RestVO> getList() {
		// TODO Auto-generated method stub
		return dao.getList();
	}

	@Override
	public void insert(RestVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public void update(RestVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(int board_no) {
		// TODO Auto-generated method stub
		dao.delete(board_no);
	}

}
