package com.inputplayer.model;

import java.util.List;

import lombok.Data;

/**
 * 遊戲場次、時間、及玩家
 */
@Data
public class Player {
	/**
	 * 玩家id
	 */
	private Integer playerId;
	
	/**
	 * 玩家名稱
	 */
	private String playerName;
	
	/**
	 * 玩家分數
	 */
	private Integer record;
	
	/**
	 * 玩家分數列表
	 */
	private List<Integer> records;
	
	/**
	 * 總分
	 */
	private Integer sumRecord;
}
