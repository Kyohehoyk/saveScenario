package com.saveScenario.saveScenario.scenario.table.Lists.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.Util.CommonInfoUtil;
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
				where = where + CommonUtil.setDataSQL(()->dto.getId().toString(), "id", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->dto.getTitle(), "title", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->dto.getCreater(), "creater", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->dto.getParticipant(), "participant", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->dto.getEstimatedTime(), "estimatedTime", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->dto.getRegister().toString(), "register", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->dto.getSystemInfo().toString(), "systemInfo", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->dto.getDisplay().toString(), "display", setValue, CommonInfoUtil.notUpdate);
			}
			sql = sql + where;
			ps = con.prepareStatement(sql);
			if (setValue.size() > 0) ps.setString(1, setValue.get(0));
			if (setValue.size() > 1) ps.setString(2, setValue.get(1));
			if (setValue.size() > 2) ps.setString(3, setValue.get(2));
			if (setValue.size() > 3) ps.setString(4, setValue.get(3));
			if (setValue.size() > 4) ps.setString(5, setValue.get(4));
			if (setValue.size() > 5) ps.setString(6, setValue.get(5));
			if (setValue.size() > 6) ps.setString(7, setValue.get(6));
			if (setValue.size() > 7) ps.setString(8, setValue.get(7));

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
				Lists.setDisplay((Integer)rs.getInt("display"));
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
			String sql = "INSERT INTO scenario.Lists(title, creater, participant, estimatedTime, updateTime, register, systemInfo, display) values(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, form.getTitle());
			ps.setString(2, form.getCreater());
			ps.setString(3, form.getParticipant());
			ps.setString(4, form.getEstimatedTime());
			ps.setInt(6, form.getRegister());
			ps.setInt(7, form.getSystemInfo());
			ps.setInt(8, form.getDisplay());
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

	@Override
	public void update(ListsDto update, ListsDto cond) {
		PreparedStatement ps = null;
		try {
			Connection con = DbUtil.getConnection();
			String sql = "UPDATE scenario.Lists";

			List<String> setValue = new ArrayList<String>();
			List<String> setUpdate = new ArrayList<String>();
			String set = CommonInfoUtil.BLANK;
			set = set + CommonUtil.setDataSQL(()->update.getId().toString(), "id", setUpdate, CommonInfoUtil.isUpdate);
			set = set + CommonUtil.setDataSQL(()->update.getTitle(), "title", setUpdate, CommonInfoUtil.isUpdate);
			set = set + CommonUtil.setDataSQL(()->update.getCreater(), "creater", setUpdate, CommonInfoUtil.isUpdate);
			set = set + CommonUtil.setDataSQL(()->update.getParticipant(), "participant", setUpdate, CommonInfoUtil.isUpdate);
			set = set + CommonUtil.setDataSQL(()->update.getEstimatedTime(), "estimatedTime", setUpdate, CommonInfoUtil.isUpdate);
			set = set + CommonUtil.setDataSQL(()->update.getRegister().toString(), "register", setUpdate, CommonInfoUtil.isUpdate);
			set = set + CommonUtil.setDataSQL(()->update.getSystemInfo().toString(), "systemInfo", setUpdate, CommonInfoUtil.isUpdate);
			set = set + CommonUtil.setDataSQL(()->update.getDisplay().toString(), "display", setUpdate, CommonInfoUtil.isUpdate);

			String where = CommonInfoUtil.BLANK;
			List<String> setWhere = new ArrayList<String>();
			where = where + CommonUtil.setDataSQL(()->cond.getId().toString(), "id", setWhere, CommonInfoUtil.notUpdate);
			where = where + CommonUtil.setDataSQL(()->cond.getTitle(), "title", setWhere, CommonInfoUtil.notUpdate);
			where = where + CommonUtil.setDataSQL(()->cond.getCreater(), "creater", setWhere, CommonInfoUtil.notUpdate);
			where = where + CommonUtil.setDataSQL(()->cond.getParticipant(), "participant", setWhere, CommonInfoUtil.notUpdate);
			where = where + CommonUtil.setDataSQL(()->cond.getEstimatedTime(), "estimatedTime", setWhere, CommonInfoUtil.notUpdate);
			where = where + CommonUtil.setDataSQL(()->cond.getRegister().toString(), "register", setWhere, CommonInfoUtil.notUpdate);
			where = where + CommonUtil.setDataSQL(()->cond.getSystemInfo().toString(), "systemInfo", setWhere, CommonInfoUtil.notUpdate);
			where = where + CommonUtil.setDataSQL(()->cond.getDisplay().toString(), "display", setWhere, CommonInfoUtil.notUpdate);

			setValue.addAll(setUpdate);
			setValue.addAll(setWhere);
			if (set.length() > 0) sql = sql + set;
			if (set.length() > 0) sql = sql + where;

			ps = con.prepareStatement(sql);
			if (setValue.size() > 0) ps.setString(1, setValue.get(0));
			if (setValue.size() > 1) ps.setString(2, setValue.get(1));
			if (setValue.size() > 2) ps.setString(3, setValue.get(2));
			if (setValue.size() > 3) ps.setString(4, setValue.get(3));
			if (setValue.size() > 4) ps.setString(5, setValue.get(4));
			if (setValue.size() > 5) ps.setString(6, setValue.get(5));
			if (setValue.size() > 6) ps.setString(7, setValue.get(6));
			if (setValue.size() > 7) ps.setString(8, setValue.get(7));
			if (setValue.size() > 8) ps.setString(9, setValue.get(8));
			if (setValue.size() > 9) ps.setString(10, setValue.get(9));
			if (setValue.size() > 10) ps.setString(11, setValue.get(10));
			if (setValue.size() > 11) ps.setString(12, setValue.get(11));
			if (setValue.size() > 12) ps.setString(13, setValue.get(12));
			if (setValue.size() > 13) ps.setString(14, setValue.get(13));
			if (setValue.size() > 14) ps.setString(15, setValue.get(14));
			if (setValue.size() > 15) ps.setString(16, setValue.get(15));
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
