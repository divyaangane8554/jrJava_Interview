package com.xangars.dao;

import java.util.List;

import com.xangars.model.Policy;

public interface PolicyDao {

	public void addPolicy(Policy policy);

	public List<Policy> listPolicys();
	
	public Policy getPolicy(int custid);
	
	public void deletePolicy(Policy policy);
}
