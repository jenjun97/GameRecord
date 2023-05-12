package com.record.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inputplayer.model.Player;

@Service
public class RecordServiceImpl implements RecordService {

	/**
	 * 檢查分數加總是否為0
	 * 
	 * @param players
	 * @return true 加總為0
	 */
	public boolean sumRecordIsZero(List<Player> players) {

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

}
