package com.xangars.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xangars.model.Policy;

@Repository("policyDao")
public class PolicyDaoImpl implements PolicyDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addPolicy(Policy policy) {
		sessionFactory.getCurrentSession().saveOrUpdate(policy);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Policy> listPolicys() {
		return (List<Policy>) sessionFactory.getCurrentSession().createCriteria(Policy.class).list();
	}

	@Override
	public Policy getPolicy(int custid) {
		return (Policy) sessionFactory.getCurrentSession().get(Policy.class, custid);
	}

	@Override
	public void deletePolicy(Policy policy) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Policy WHERE custid = "+policy.getCustId()).executeUpdate();
		
	}

}
