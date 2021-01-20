
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

import com.xangars.bean.ProductBean;
import com.xangars.model.Product;
import com.xangars.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("command") ProductBean productBean, 
			BindingResult result) {
		Product product = prepareModel(productBean);
		productService.addProduct(product);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value="/products", method = RequestMethod.GET)
	public ModelAndView listProducts() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("products",  prepareListofBean(productService.listProductss()));
		return new ModelAndView("productsList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addProduct(@ModelAttribute("command")  ProductBean productBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("products",  prepareListofBean(productService.listProductss()));
		return new ModelAndView("addProduct", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editProduct(@ModelAttribute("command")  ProductBean productBean,
			BindingResult result) {
		productService.deleteProduct(prepareModel(productBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("product", null);
		model.put("products",  prepareListofBean(productService.listProductss()));
		return new ModelAndView("addProduct", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@ModelAttribute("command")  ProductBean productBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("product", prepareProductBean(productService.getProduct(productBean.getPid())));
		model.put("products",  prepareListofBean(productService.listProductss()));
		return new ModelAndView("addProduct", model);
	}
	
	private Product prepareModel(ProductBean productBean){
		Product product = new Product();
		product.setProdDetails(productBean.getPdetails());
		product.setProdLaunchDate(productBean.getPlaunchdate());
		product.setProdName(productBean.getPname());
		product.setProdEndDate(productBean.getPenddate());
		product.setProdId(productBean.getPid());
		productBean.setPid(null);
		return product;
	}
	
	private List<ProductBean> prepareListofBean(List<Product> products){
		List<ProductBean> beans = null;
		if(products != null && !products.isEmpty()){
			beans = new ArrayList<ProductBean>();
			ProductBean bean = null;
			for(Product product : products){
				bean = new ProductBean();
				bean.setPname(product.getProdName());
				bean.setPid(product.getProdId());
				bean.setPdetails(product.getProdDetails());
				bean.setPenddate(product.getProdEndDate());
				bean.setPlaunchdate(product.getProdLaunchDate());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private ProductBean prepareProductBean(Product product){
		ProductBean bean = new ProductBean();
		bean.setPdetails(product.getProdDetails());
		bean.setPlaunchdate(product.getProdLaunchDate());
		bean.setPname(product.getProdName());
		bean.setPenddate(product.getProdEndDate());
		bean.setPid(product.getProdId());
		return bean;
	}
}

