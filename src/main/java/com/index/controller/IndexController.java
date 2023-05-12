package com.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	/**
	 * 導頁到首頁
	 * @return
	 */
	@GetMapping({ "/", "/index" })
	public String indexPath() {
		return "index";
	}
}
