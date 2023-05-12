package com.inputplayer.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.inputplayer.model.GameBean;
import com.inputplayer.service.InputPlayerService;

@Controller
public class InputPlayerController {

	@Resource
	private InputPlayerService inputPlayerService;

	/**
	 * 依前端輸入的玩家人數，去建立輸入玩家姓名的欄位數
	 * 
	 * @param model    返回model
	 * @param play_num 前端輸入的玩家人教
	 * @return
	 */
	@PostMapping("/input_player")
	public String inputPlayer(Model model, int playerNum) {

		if (playerNum >= 2) {
			model.addAttribute("playerNum", inputPlayerService.creatNameAry(playerNum));
			return "input_player_name_page";
		} else {
			return "index";
		}
	}

	/**
	 * 取得所有玩家簡稱後寫入DB，建立場次後
	 * 返回記分頁面
	 * 
	 * @param model
	 * @param playerName
	 * @return 遊戲pojo
	 */
	@PostMapping("/creat_name")
	public String creatPlayerName(Model model, String[] playerName) {

		if (playerName == null || playerName.length < 1) {
			return "index";
		}

		LocalDateTime now = LocalDateTime.now();
		Timestamp gameTime = Timestamp.valueOf(now);
		GameBean gameBean = inputPlayerService.savePlayerInfo(playerName, gameTime);
		model.addAttribute("gameBean", gameBean);
		return "record_page";
	}

}
