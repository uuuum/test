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
//			vo.setTitle("����5");
//			vo.setContent("���볻��5");
//			vo.setUser_name("�����5");
//			dao.insert(vo);	
//			
//		}
		
		@Test
		public void getTest() throws Exception {
			
			RestVO vo = dao.get(6);
			System.out.println("�Խñ۹�ȣ : " + vo.getRegdate());
			
		}
		
		@Test
		public void getListTest() throws Exception {
			List<RestVO> list = dao.getList();
			Iterator<RestVO> it = list.iterator();
			
			while(it.hasNext()) {
				RestVO vo = it.next();
				System.out.println("���� : " + vo.getTitle());
				System.out.println("���� : " + vo.getContent());
			}
			
		}
		
//		@Test
//		public void updateTest() throws Exception {
//			
//			RestVO vo = new RestVO();	
//			
//			vo.setBoard_no(2);
//			vo.setTitle("�������2");
//			vo.setContent("�������2");
//			vo.setUser_name("����ڼ���2");
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
