package com.xangars.service;

import java.util.List;

import com.xangars.model.Policy;

public interface PolicyService {

	public void addPolicy(Policy policy);

	public List<Policy> listPolicys();
	
	public Policy getPolicy(int custid);
	
	public void deletePolicy(Policy policy);
}
