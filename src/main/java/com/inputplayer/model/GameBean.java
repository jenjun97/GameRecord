package com.inputplayer.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 遊戲場次、時間、及玩家Pojo
 */
@Data
public class GameBean {
	/**
	 * 場次
	 */
	private int gameId;
	
	/**
	 * 場次時間
	 */
	private Timestamp gameTime;
	
	/**
	 * 玩家資訊
	 */
	private List<Player> players = new ArrayList<Player>();
	
	/**
	 * 局數
	 */
	private Integer playNum;
}
