package com.inputplayer.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inputplayer.dao.InputPlayerMapper;
import com.inputplayer.model.GameBean;
import com.inputplayer.model.Player;

@Service
public class InputPlayerServiceImpl implements InputPlayerService {

	@Resource
	private InputPlayerMapper inputPlayerMapper;

	/**
	 * 依輸入的人數建立數字陣列
	 * 
	 * @param playerNum 前端輸入的玩家人數
	 * @return 數字陣列
	 */
	@Override
	public List<Integer> creatNameAry(int playerNum) {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < playerNum; i++) {
			intList.add(i);
		}
		return intList;
	}

	/**
	 * 建立場次、時間、玩家簡稱
	 * 
	 * @param playerName 所有玩家的簡稱
	 * @param gameTime   啟始時間
	 * @return 遊戲資訊
	 */
	@Override
	public GameBean savePlayerInfo(String[] playerNameAry, Timestamp gameTime) {
		GameBean gameBean = new GameBean();
		gameBean.setGameTime(gameTime);
		inputPlayerMapper.saveGameInfo(gameBean);

		for (int i = 0; i < playerNameAry.length; i++) {
			Player playerPojo = new Player();
			playerPojo.setPlayerId(i);
			playerPojo.setPlayerName(playerNameAry[i]);
			gameBean.getPlayers().add(playerPojo);
		}
		inputPlayerMapper.savePlayerInfo(gameBean);

		return gameBean;
	}

}
