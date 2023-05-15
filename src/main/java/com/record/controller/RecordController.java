package com.record.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.inputplayer.model.GameBean;
import com.record.service.RecordService;

@Controller
public class RecordController {

	@Resource
	private RecordService recordService;

	@PostMapping("/add_record")
	public String addRecord(Model model, GameBean gameBean) {
		// 檢查本次分數加總是否為0
		boolean sumIsZero = recordService.sumIsZero(gameBean.getPlayers());
		if (!sumIsZero) {
			return "record_page";
		}
		
		gameBean = recordService.action(gameBean);

		model.addAttribute("gameBean", gameBean);
		return "record_page";
	}
}
