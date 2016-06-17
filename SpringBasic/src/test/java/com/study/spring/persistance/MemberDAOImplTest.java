package com.study.spring.persistance;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOImplTest {

		@Inject
		private MemberDAO dao;
		
		@Test
		public void test() {
			System.out.println("Test DAO = " + dao);
		}
		
		@Test
		public void getNowTest() {
			System.out.println("Test DAO now = " + dao.getNow());
		}
}
