package com.saveScenario.saveScenario.scenario.table.Lists.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.Util.CommonUtil;
import com.saveScenario.saveScenario.scenario.Util.DbUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.PassingDatasDto;

@Service
public class PassingDatasServiceImpl implements PassingDatasService{

	@Override
	public List<PassingDatasDto> select(PassingDatasDto passDto) {
		/* リターン用のListを宣言、初期化 */
		List<PassingDatasDto> dtoList = new ArrayList<PassingDatasDto>();

		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			Statement stm = con.createStatement();
			String sql = "select * from scenario.PassingDatas";
			String where = "";
			if (passDto != null) {
				if (!CommonUtil.isNullOrZero(passDto.getSessionId())) {
					where = where + " sessionId=" + passDto.getSessionId();
				}
				if (!CommonUtil.isNullOrZero(passDto.getPlayer())) {
					if (where.length()!=0) {
						where = where + " and";
					}
					where = where + " player=" + passDto.getPlayer();
				}
			}
			sql = sql +" where" + where;
			ResultSet rs = stm.executeQuery(sql);
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
