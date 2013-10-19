package com.hoo.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoo.biz.AccountBiz;
import com.hoo.mapper.Account;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Inject
	private AccountBiz<Account> accountBiz;
	
	@RequestMapping("/add")
	public String add(Account account) {
		System.out.println(account);
		accountBiz.addAccount(account);
		return "redirect:/account/list.do";
	}
	
	@RequestMapping("/get")
	public String get(Integer id, Model model){
		System.out.println("#ID:"+id);
		model.addAttribute(accountBiz.getAccount(id));
		return "/show.jsp";
	}
	
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", accountBiz.getList());
        return "/list.jsp";

    }

    

    @ExceptionHandler(Exception.class)
    public String exception(Exception e, HttpServletRequest request) {
        request.setAttribute("exception", e);
        return "/error.jsp";

    }
}
