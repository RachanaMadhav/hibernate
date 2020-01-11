package mvchbn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao dao;
	
	@RequestMapping(value="/addcust",method=RequestMethod.GET)
	public String ShowAddCustomerForm(){
		return "AddCustomer";
	}
	@RequestMapping(value="/addcust",method=RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("customer") Customer cust){//table name
		ModelAndView mav=new ModelAndView();
		dao.addCustomer(cust);
		mav.setViewName("redirect:viewcustomers");
		return mav;
	}
	@RequestMapping(value="/viewcustomers")
	public ModelAndView getCustomers(){
		ModelAndView mav=new ModelAndView();
		List<Customer> list=dao.getCustomers();
		mav.addObject("customers",list);
		mav.setViewName("ViewCustomers");
		return mav;
	}
	@RequestMapping(value="/updatecustomer",method=RequestMethod.GET)
	public String ShowUpdateCustomerForm(){
		return "updatecustomer";
	}
	@RequestMapping(value="/updatecustomer",method=RequestMethod.POST)
	public ModelAndView updateCustomer(@ModelAttribute("customer") Customer cust){
		ModelAndView mav=new ModelAndView();
		dao.updateCustomer(cust);
		mav.setViewName("redirect:viewcustomers");
		return mav;
	}
	@RequestMapping(value="/deletecustomer",method=RequestMethod.GET)
	public String ShowDeleteCustomerForm(){
		return "deletecustomer";//jsp filename
	}
	@RequestMapping(value="/deletecustomer",method=RequestMethod.POST)
	public ModelAndView deleteCustomer(@ModelAttribute("customer") Customer cust){
		ModelAndView mav=new ModelAndView();
		dao.deleteCustomer(cust);
		mav.setViewName("redirect:viewcustomers");
		return mav;
	}
}