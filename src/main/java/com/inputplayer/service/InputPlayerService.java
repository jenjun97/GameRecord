package com.inputplayer.service;

import java.sql.Timestamp;
import java.util.List;

import com.inputplayer.model.GameBean;

public interface InputPlayerService {
	/**
	 * 依輸入的人數建立數字陣列
	 * 
	 * @param playerNum 前端輸入的玩家人數
	 * @return 數字陣列
	 */
	public List<Integer> creatNameAry(int playerNum);

	/**
	 * 建立場次及時間
	 * 
	 * @param playerName 所有玩家的簡稱
	 * @param gameTime   啟始時間
	 * @return 遊戲資訊
	 */
	public GameBean savePlayerInfo(String[] playerName, Timestamp gameTime);

}
