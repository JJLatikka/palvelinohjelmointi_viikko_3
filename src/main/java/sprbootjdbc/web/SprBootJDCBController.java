package sprbootjdbc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sprbootjdbc.domain.CustomerDAO;

@Controller
public class SprBootJDCBController {
	
	@Autowired
    private CustomerDAO customerDAO;

}
