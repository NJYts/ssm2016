package com.atguigu.p2p.web;

import com.atguigu.p2p.service.ICustomerService;
import com.atguigu.p2p.util.DateFormatHelper;
import com.atguigu.p2p.util.JsonHelper;
import com.atguigu.p2p.util.Page;
import com.atguigu.p2p.vo.CustomerModel;
import com.atguigu.p2p.vo.CustomerQueryModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value="/customer")
public class CustomerController 
{
	static Logger logger = Logger.getLogger(CustomerController.class);
	@Autowired
	private ICustomerService customerService;
	
	//==========增
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd()
	{
		return "add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@ModelAttribute("cm") CustomerModel cm)
	{
		cm.setRegisterTime(DateFormatHelper.long2str(System.currentTimeMillis()));
		customerService.create(cm);
		return "success";
	}
	//==========删
	@RequestMapping(value="toDelete/{customerUuid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("customerUuid") int customerUuid)
	{
		CustomerModel cm = customerService.getByUuid(customerUuid);
		model.addAttribute("cm", cm);
		return "delete";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String post(@RequestParam("uuid") int customerUuid)
	{
		customerService.delete(customerUuid);
		return "success";
	}
	//==========改
	@RequestMapping(value="toUpdate/{customerUuid}",method=RequestMethod.GET)
	public String toUpdate(Model mvcModel,@PathVariable("customerUuid") int customerUuid)
	{
		CustomerModel cm = customerService.getByUuid(customerUuid);
		mvcModel.addAttribute("cm", cm);
		return "update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String post(@ModelAttribute("cm") CustomerModel cm)
	{
		customerService.update(cm);
		return "success";
	}
	@ModelAttribute
	//==========查method ={RequestMethod.POST,RequestMethod.GET})
	@RequestMapping(value="toList",method =RequestMethod.GET)
	public String toList(@ModelAttribute("wm") CustomerWebModel wm,Model model,HttpServletRequest request)	
	{
		CustomerQueryModel cqm = null;
		
		if(null == wm.getQueryJsonStr() || wm.getQueryJsonStr().trim().length() == 0)
		{
			cqm = new CustomerQueryModel();
		}else{
			cqm = (CustomerQueryModel)JsonHelper.str2Object(wm.getQueryJsonStr(),CustomerQueryModel.class);
		}
		
		cqm.getPage().setNowPage(wm.getNowPage());
		if(wm.getPageShow() > 0)
		{
			cqm.getPage().setPageShow(wm.getPageShow());
		}
		Page resultPage = customerService.getByConditionPage(cqm);
		
		model.addAttribute("wm",wm);
		model.addAttribute("page",resultPage);
		
		return "list";
	}
	
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery()
	{
		return "query";
	}
}
