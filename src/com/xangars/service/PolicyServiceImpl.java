package com.xangars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xangars.dao.PolicyDao;
import com.xangars.model.Policy;

@Service("policyService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyDao policyDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPolicy(Policy policy) {
		policyDao.addPolicy(policy);
	}

	public List<Policy> listPolicys() {
		return policyDao.listPolicys();
	}

	public Policy getPolicy(int custid) {
		return policyDao.getPolicy(custid);
	}

	public void deletePolicy(Policy policy) {
		policyDao.deletePolicy(policy);
	}

}
