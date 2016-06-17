package com.study.springrest.persistence;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.ReplyVO;
import com.study.springrest.persistent.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDAOImplTest {
	
	@Inject
	private ReplyDAO dao;
	
	@Test
	public void test() {
		System.out.println("Test DAO = " + dao);
	}
	
//	@Test
//	public void getNowTest() {
//		System.out.println("Test DAO now = " + dao.getNow());
//	}
	
	@Test
	public void insertTest() throws Exception {
		
		ReplyVO vo = new ReplyVO();
		vo.setContent("댓글1");
		vo.setUser_name("사용자1");
		vo.setBoard_no(7);
		dao.insert(vo);	
		
	}
	
//	@Test
//	public void getTest() throws Exception {
//		
//		ReplyVO vo = dao.get(0);
//		System.out.println("댓글번호 : " + vo.getReply_no());
//		
//	}
	
	@Test
	public void getListTest() throws Exception {
		List<ReplyVO> list = dao.getList(6);
		Iterator<ReplyVO> it = list.iterator();
		
		while(it.hasNext()) {
			ReplyVO vo = it.next();
			System.out.println("내용 : " + vo.getContent());
		}
		
	}
	
	@Test
	public void updateTest() throws Exception {
		
		ReplyVO vo = new ReplyVO();	
		vo.setReply_no(5);
		vo.setContent("내용수정2");
		vo.setUser_name("사용자수정2");
		
		dao.update(vo);
		
	}
//	
//	@Test
//	public void deleteTest() throws Exception {
//		dao.delete(1);
//	}
}
