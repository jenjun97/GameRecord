package com.record.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inputplayer.model.GameBean;

public interface RecordMapper {

	//	新增該局分數
	public void addRecord(GameBean gameBean);

	public List<Integer> getPlayerAllRecord(@Param("gameId") Integer gameId, @Param("playerId") Integer playerId);
}
