package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Employee;

@Controller
public class EmployeeController {
 
    @GetMapping(value = "/employee")
    public ModelAndView showEmployeeForm() {
    	//Create a new ModelAndView given (String viewName, String modelName, Object modelObject)
    	
    	ModelAndView model = new ModelAndView("employee", "employee", getEmployee());
    	
        return model;
    }
    
    private Employee getEmployee()
    {
    	
    	ArrayList<String> states = new ArrayList<String>();
    	states.add( "Alabama");
    	states.add( "Alaska");
    	states.add( "Arizona");
    	states.add( "Arkansas");
    	states.add( "California");
    	
    	Employee emp = new Employee();
    	emp.setEmployeeDOB(new Date());
    	emp.setEmployeeSkills(states);
    	return emp;
    	
    }
    
    /**
    @PostMapping(value = "/employeeView")
    public ModelAndView submit(@Valid @ModelAttribute("employee")Employee employee, BindingResult bindingResult) 
    {
    	
       	ModelAndView model = null;
    	
    	// form validation error
        if (bindingResult.hasErrors()) 
        {
        	System.out.println(bindingResult.getAllErrors().toString());
        	model =  new ModelAndView("employee");
        }
        else
        	model = new ModelAndView("employeeView");
        
        return model;
    }
    */
    
    @ModelAttribute
    public void addingCommonObjects(Model commonModel)
    {
    	commonModel.addAttribute("message",  "Message");
    	commonModel.addAttribute("message2",  "Message2");
    	commonModel.addAttribute("employee",  getEmployee());

    }
    
    
    @PostMapping(value = "/employeeView")
    public String submit(@Valid @ModelAttribute("employee")Employee employee, BindingResult bindingResult, ModelMap model) 
    {
    	String gotoPage = "employee";
    	
    	// if no form validation errors
        if (!bindingResult.hasErrors()) 
        	gotoPage = "employeeView";
        
        //This is not needed as the page has access to model object
        //model.addAttribute("name", employee.getName());
        //model.addAttribute("contactNumber", employee.getContactNumber());
        //model.addAttribute("id", employee.getId());
        
    	employee = getEmployee();

        return gotoPage;
    }
    
    
    	//ArrayList<User> listUser = new ArrayList<>();
		// get user list	
		//ModelAndView modelView = new ModelAndView("employeeView");
		//modelView.addObject("listUser", listUser);

    
    
}