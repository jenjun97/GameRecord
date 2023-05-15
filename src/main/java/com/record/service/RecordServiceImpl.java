package com.record.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inputplayer.model.GameBean;
import com.inputplayer.model.Player;
import com.record.dao.RecordMapper;

@Service
public class RecordServiceImpl implements RecordService {

	@Resource
	private RecordMapper recordMapper;

	public GameBean action(GameBean gameBean) {
		addRecord(gameBean);
		
		for(Player player:gameBean.getPlayers()) {
			List<Integer> records = getPlayerAllRecord(gameBean.getGameId(), player.getPlayerId());
			player.setRecords(records);
		}

		return gameBean;
	}

	/**
	 * 檢查分數加總是否為0
	 * 
	 * @param players
	 * @return true 加總為0
	 */
	public boolean sumIsZero(List<Player> players) {

		if (players == null) {
			return false;
		}

		int sum = 0;

		try {
			for (Player player : players) {
				sum += player.getRecord();
			}
		} catch (Exception e) {
			return false;
		}

		if (sum != 0) {
			return false;
		} else {
			return true;
		}
	}

	private void addRecord(GameBean gameBean) {
		recordMapper.addRecord(gameBean);
	}

	private List<Integer> getPlayerAllRecord(Integer gameId, Integer playerId) {
		return recordMapper.getPlayerAllRecord(gameId, playerId);
	}

}
