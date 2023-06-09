package com.record.service;

import java.util.List;

import com.inputplayer.model.GameBean;
import com.inputplayer.model.Player;

public interface RecordService {
	
	public GameBean action(GameBean gameBean);
	
	/**
	 * 檢查分數加總是否為0
	 * 
	 * @param players
	 * @return true 加總為0
	 */
	public boolean sumIsZero(List<Player> players);

}
