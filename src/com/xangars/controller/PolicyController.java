package com.xangars.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xangars.bean.PolicyBean;
import com.xangars.model.Policy;
import com.xangars.service.PolicyService;

@Controller
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	@RequestMapping(value = "/savep", method = RequestMethod.POST)
	public ModelAndView savePolicy(@ModelAttribute("command") PolicyBean policyBean, 
			BindingResult result) {
		Policy policy = prepareModel(policyBean);
		policyService.addPolicy(policy);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value="/policys", method = RequestMethod.GET)
	public ModelAndView listPolicys() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("policys",  prepareListofBean(policyService.listPolicys()));
		return new ModelAndView("policysList", model);
	}

	@RequestMapping(value = "/addp", method = RequestMethod.GET)
	public ModelAndView addPolicy(@ModelAttribute("command")  PolicyBean policyBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("policys",  prepareListofBean(policyService.listPolicys()));
		return new ModelAndView("addPolicy", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/deletep", method = RequestMethod.GET)
	public ModelAndView editPolicy(@ModelAttribute("command")  PolicyBean policyBean,
			BindingResult result) {
		policyService.deletePolicy(prepareModel(policyBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("policy", null);
		model.put("policys",  prepareListofBean(policyService.listPolicys()));
		return new ModelAndView("addPolicy", model);
	}
	
	@RequestMapping(value = "/editp", method = RequestMethod.GET)
	public ModelAndView deletePolicy(@ModelAttribute("command")  PolicyBean policyBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("policy", preparePolicyBean(policyService.getPolicy(policyBean.getcId())));
		model.put("policys",  prepareListofBean(policyService.listPolicys()));
		return new ModelAndView("addPolicy", model);
	}
	
	private Policy prepareModel(PolicyBean policyBean){
		Policy policy = new Policy();
		policy.setCustName(policyBean.getcName());
		policy.setCustEmail(policyBean.getcEmail());
		policy.setCustMobNumber(policyBean.getcMobNumber());
		policy.setCustId(policyBean.getcId());
		policyBean.setcId(null);
		return policy;
	}
	
	private List<PolicyBean> prepareListofBean(List<Policy> policys){
		List<PolicyBean> beans = null;
		if(policys != null && !policys.isEmpty()){
			beans = new ArrayList<PolicyBean>();
			PolicyBean bean = null;
			for(Policy policy : policys){
				bean = new PolicyBean();
				bean.setcName(policy.getCustName());
				bean.setcId(policy.getCustId());
				bean.setcEmail(policy.getCustEmail());
				bean.setcMobNumber(policy.getCustMobNumber());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private PolicyBean preparePolicyBean(Policy policy){
		PolicyBean bean = new PolicyBean();
		bean.setcName(policy.getCustName());
		bean.setcId(policy.getCustId());
		bean.setcEmail(policy.getCustEmail());
		bean.setcId(policy.getCustId());
		return bean;
	}
}
