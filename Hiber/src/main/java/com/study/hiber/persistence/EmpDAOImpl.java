package com.study.hiber.persistence;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.study.hiber.domain.EmpVO;

@Repository
public class EmpDAOImpl implements EmpDAO {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<EmpVO> getList() {
		
		Session session = sessionFactory.openSession();
		Criteria cri = session.createCriteria(EmpVO.class);
		
		return cri.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
	}

}
