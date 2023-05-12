package com.inputplayer.dao;

import com.inputplayer.model.GameBean;

public interface InputPlayerMapper {
	/**
	 * 新增場次及時間
	 * 
	 * @param playerPojo
	 */
	public void saveGameInfo(GameBean gameBean);

	/**
	 * 新增玩家代號及名稱
	 * 
	 * @param playerPojo
	 */
	public void savePlayerInfo(GameBean gameBean);
}
