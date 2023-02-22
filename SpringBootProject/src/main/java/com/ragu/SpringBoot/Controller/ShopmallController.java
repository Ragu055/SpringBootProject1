package com.ragu.SpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ragu.SpringBoot.Model.Shopmall;
import com.ragu.SpringBoot.Repository.ShopmallRepository;

@Controller
public class ShopmallController {
	
	
	@Autowired
	ShopmallRepository shopmallrep;
	
	@RequestMapping("index")
	public String user() {
		return "index.jsp";
	}

	@RequestMapping("addUser")
	public String addUser(Shopmall shopmall) {
		
		shopmallrep.save(shopmall);
		return "index.jsp";
	}
	
	@RequestMapping("getUser")
	public ModelAndView getUser(@RequestParam int shopno) {
		ModelAndView mav=new ModelAndView("showUser.jsp");
		Shopmall shopmall=shopmallrep.findById(shopno).orElse(new Shopmall());
		mav.addObject(shopmall);
		return mav;
	}

	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(@RequestParam int shopno) {
		ModelAndView mav=new ModelAndView("deleteUser.jsp");
		Shopmall shopmall=shopmallrep.findById(shopno).orElse(new Shopmall());
		((CrudRepository<Shopmall, Integer>) shopmall).deleteById(shopno);
		mav.addObject(shopmall);
		return mav;
	}
	@RequestMapping("updateUser")
	public ModelAndView updateUser(Shopmall shopmall) {
		ModelAndView mav=new ModelAndView("updateUser.jsp");
	     shopmall=shopmallrep.findById(shopmall.getShopno()).orElse(new Shopmall());
	     ((CrudRepository<Shopmall, Integer>) shopmall).deleteById(shopmall.getShopno());
		mav.addObject(shopmall);
		return mav;
	}


}
