package com.saveScenario.saveScenario.scenario.table.Lists.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.Util.CommonInfoUtil;
import com.saveScenario.saveScenario.scenario.Util.CommonUtil;
import com.saveScenario.saveScenario.scenario.Util.DbUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.PassingDatasDto;

@Service
public class PassingDatasServiceImpl implements PassingDatasService{

	@Override
	public List<PassingDatasDto> select(PassingDatasDto passDto) {
		PreparedStatement ps = null;
		List<PassingDatasDto> dtoList = new ArrayList<PassingDatasDto>();

		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "select * from scenario.PassingDatas";
			String where = "";
			List<String> setValue = new ArrayList<String>();
			if (passDto != null) {
				where = where + CommonUtil.setDataSQL(()->passDto.getId().toString(), "id", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->passDto.getSessionId().toString(), "sessionId", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->passDto.getPlayer().toString(), "player", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->passDto.getPassing().toString(), "participant", setValue, CommonInfoUtil.notUpdate);
			}
			sql = sql + where;
			ps = con.prepareStatement(sql);
			if (setValue.size() > 0) ps.setString(1, setValue.get(0));
			if (setValue.size() > 1) ps.setString(2, setValue.get(1));
			if (setValue.size() > 2) ps.setString(3, setValue.get(1));
			if (setValue.size() > 3) ps.setString(4, setValue.get(1));
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				PassingDatasDto dto = new PassingDatasDto();
				dto.setId((Integer)rs.getInt("id"));
				dto.setSessionId((Integer)rs.getInt("sessionId"));
				dto.setPlayer((Integer)rs.getInt("player"));
				dto.setPassing((Integer)rs.getInt("passing"));
				dtoList.add(dto);
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
	public void insert(PassingDatasDto passDto) {
		PreparedStatement ps = null;

		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "INSERT INTO scenario.PassingDatas(sessionID, player, passing) values(?,?,?)";
			//実行するSQL文とパラメータを指定する
			ps = con.prepareStatement(sql);
			ps.setInt(1, passDto.getSessionId());
			ps.setInt(2, passDto.getPlayer());
			ps.setInt(3, 0);
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
	public void update(PassingDatasDto passDto) {
		PreparedStatement ps = null;

		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "UPDATE scenario.PassingDatas SET passing=? where id=?";
			//実行するSQL文とパラメータを指定する
			ps = con.prepareStatement(sql);
			ps.setInt(1, passDto.getPassing());
			ps.setInt(2, passDto.getId());
			ps.executeUpdate();
			con.commit();
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
