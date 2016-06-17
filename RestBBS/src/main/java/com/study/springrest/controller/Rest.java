package com.study.springrest.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.springrest.domain.ReplyVO;
import com.study.springrest.domain.RestVO;
import com.study.springrest.service.ReplyService;
import com.study.springrest.service.RestService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RestController
@RequestMapping("/rest")
public class Rest {
	
	@Inject
	private RestService service;

	
	@RequestMapping(value = "", method = RequestMethod.GET) 
	public ModelAndView list(Locale locale, Model model) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("list");
		
		List<RestVO> restlist = service.getList();
		view.addObject("list", restlist);
		
		return view;
	}
	// ±Û¹øÈ£
	@RequestMapping(value = "/{board_no}", method = RequestMethod.GET) 
	public ModelAndView detail(@PathVariable("board_no") int board_no, Model model) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("detail");

		RestVO vo = service.get(board_no);
		vo.setView_cnt(vo.getView_cnt() + 1);
		
		service.update(vo);
		view.addObject("vo", vo);
		
		return view;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET) 
	public ModelAndView write(Locale locale, Model model) {

		return new ModelAndView("/write");
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST) 
	public ModelAndView insert(RestVO vo, Model model) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/rest/");

		service.insert(vo);
		return view;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST) 
	public ModelAndView update(RestVO vo, Model model) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/rest/");
		service.update(vo);
		return view;
		
	}
	
	@RequestMapping(value = "/{board_no}", method = RequestMethod.DELETE) 
	public ModelAndView delete(@PathVariable("board_no") int board_no) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/rest/");
		
		service.delete(board_no);
		
		return view;
	}
}
