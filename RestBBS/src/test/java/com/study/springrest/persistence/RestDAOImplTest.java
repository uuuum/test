package com.study.springrest.persistence;

import java.util.List;
import java.util.Iterator;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.RestVO;
import com.study.springrest.persistent.RestDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class RestDAOImplTest {

		@Inject
		private RestDAO dao;
		
		@Test
		public void test() {
			System.out.println("Test DAO = " + dao);
		}
		
//		@Test
//		public void getNowTest() {
//			System.out.println("Test DAO now = " + dao.getNow());
//		}
		
//		@Test
//		public void insertTest() throws Exception {
//			
//			RestVO vo = new RestVO();
//			vo.setTitle("제목5");
//			vo.setContent("내용내용5");
//			vo.setUser_name("사용자5");
//			dao.insert(vo);	
//			
//		}
		
		@Test
		public void getTest() throws Exception {
			
			RestVO vo = dao.get(6);
			System.out.println("게시글번호 : " + vo.getRegdate());
			
		}
		
		@Test
		public void getListTest() throws Exception {
			List<RestVO> list = dao.getList();
			Iterator<RestVO> it = list.iterator();
			
			while(it.hasNext()) {
				RestVO vo = it.next();
				System.out.println("제목 : " + vo.getTitle());
				System.out.println("내용 : " + vo.getContent());
			}
			
		}
		
//		@Test
//		public void updateTest() throws Exception {
//			
//			RestVO vo = new RestVO();	
//			
//			vo.setBoard_no(2);
//			vo.setTitle("제목수정2");
//			vo.setContent("내용수정2");
//			vo.setUser_name("사용자수정2");
//			
//			dao.update(vo);
//			
//		}
//		
		@Test
		public void deleteTest() throws Exception {
			dao.delete(11);
		}
}
