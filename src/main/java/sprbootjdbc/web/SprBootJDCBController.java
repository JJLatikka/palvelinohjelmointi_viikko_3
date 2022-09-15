package sprbootjdbc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sprbootjdbc.domain.Customer;
import sprbootjdbc.domain.CustomerDAO;

@Controller
public class SprBootJDCBController {
	
	@Autowired
    private CustomerDAO customerDAO;
	
	@GetMapping("customerlist")
    public String customerList(Model m) {	
        List<Customer> c = customerDAO.findAllCustomers();
        m.addAttribute("customers", c);
        return "customerListTemplate";
    }

    @GetMapping("addcustomer")
    public String addStudent(Model m){
    	m.addAttribute("customer", new Customer());
        return "addCustomerTemplate";
    }     

    @PostMapping("savecustomer")
    public String saveCustomer(Customer c){
        customerDAO.saveCustomer(c);
        return "redirect:customerlist";
    }     

}
