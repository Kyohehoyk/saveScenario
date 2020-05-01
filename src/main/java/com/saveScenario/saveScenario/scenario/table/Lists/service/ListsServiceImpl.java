package com.saveScenario.saveScenario.scenario.table.Lists.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.Util.CommonUtil;
import com.saveScenario.saveScenario.scenario.Util.DbUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ListsDto;

@Service
public class ListsServiceImpl implements ListsService{

	@Override
	public List<ListsDto> Select(ListsDto dto) {
		PreparedStatement ps = null;
		List<ListsDto> dtoList = new ArrayList<ListsDto>();

		try {
			Connection con = DbUtil.getConnection();

			String sql = "select * from scenario.Lists";
			String where = "";
			List<String> setValue = new ArrayList<String>();
			if (dto != null) {
				where = where + CommonUtil.setDataSQL(()->dto.getId().toString(), "id", setValue);
				where = where + CommonUtil.setDataSQL(()->dto.getTitle(), "title", setValue);
				where = where + CommonUtil.setDataSQL(()->dto.getCreater(), "creater", setValue);
				where = where + CommonUtil.setDataSQL(()->dto.getParticipant(), "participant", setValue);
				where = where + CommonUtil.setDataSQL(()->dto.getEstimatedTime(), "estimatedTime", setValue);
				where = where + CommonUtil.setDataSQL(()->dto.getRegister().toString(), "register", setValue);
				where = where + CommonUtil.setDataSQL(()->dto.getSystemInfo().toString(), "systemInfo", setValue);
			}
			sql = sql + where;
			ps = con.prepareStatement(sql);
			if (setValue.size() > 0) ps.setString(1, setValue.get(0));
			if (setValue.size() > 1) ps.setString(2, setValue.get(1));
			if (setValue.size() > 2) ps.setString(3, setValue.get(2));
			if (setValue.size() > 3) ps.setString(4, setValue.get(3));
			if (setValue.size() > 4) ps.setString(5, setValue.get(4));
			if (setValue.size() > 5) ps.setString(6, setValue.get(5));
			if (setValue.size() > 6) ps.setString(6, setValue.get(6));

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ListsDto Lists = new ListsDto();
				Lists.setId((Integer)rs.getInt("id"));
				Lists.setTitle(rs.getString("title"));
				Lists.setCreater(rs.getString("creater"));
				Lists.setParticipant(rs.getString("participant"));
				Lists.setEstimatedTime(rs.getString("estimatedTime"));
				Lists.setUpdateTime(Timestamp.valueOf(rs.getString("updateTime")));
				Lists.setRegister((Integer)rs.getInt("register"));
				Lists.setSystemInfo((Integer)rs.getInt("systemInfo"));
				dtoList.add(Lists);
			}
			DbUtil.closeConnection(con);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			/* statementをクローズ */
		}
		return dtoList;
	}
	@Override
	public void insert(ListsDto form) {
		PreparedStatement ps = null;
		try {
			Connection con = DbUtil.getConnection();
			String sql = "INSERT INTO scenario.Lists(title, creater, participant, estimatedTime, updateTime, register, systemInfo) values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, form.getTitle());
			ps.setString(2, form.getCreater());
			ps.setString(3, form.getParticipant());
			ps.setString(4, form.getEstimatedTime());
			ps.setInt(6, form.getRegister());
			ps.setInt(7, form.getSystemInfo());
			Timestamp updateDateTime = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(5, updateDateTime);
			ps.executeUpdate();
			DbUtil.closeConnection(con);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			/* statementをクローズ */
		}
	}

}
