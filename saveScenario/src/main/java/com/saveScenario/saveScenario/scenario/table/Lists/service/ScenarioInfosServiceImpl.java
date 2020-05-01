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
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ScenarioInfosDto;

@Service
public class ScenarioInfosServiceImpl implements ScenarioInfosService{

	@Override
	public List<ScenarioInfosDto> select(ScenarioInfosDto scenarioDto) {
		/* リターン用のListを宣言、初期化 */
		List<ScenarioInfosDto> dtoList = new ArrayList<ScenarioInfosDto>();

		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			Statement stm = con.createStatement();
			String sql = "select * from scenario.ScenarioInfos";
			String where = "";
			if (scenarioDto != null) {
				int count = 0;
				if (!CommonUtil.isNullOrZero(scenarioDto.getId())) {
					if(count == 0) {
						where = where + " where";
						count=1;
					} else {
						where = where + " and";
					}
					where = where + " id=" + scenarioDto.getId();
				}
				if (!CommonUtil.isNullOrZero(scenarioDto.getSessionId())) {
					if(count == 0) {
						where = where + " where";
						count=1;
					} else {
						where = where + " and";
					}
					where = where + " sessionId=" + scenarioDto.getSessionId();
				}
				if (!CommonUtil.isNullOrEmpty(scenarioDto.getKind())) {
					if(count == 0) {
						where = where + " where";
						count=1;
					} else {
						where = where + " and";
					}
					where = where + " kind=" + scenarioDto.getKind();
				}
				if (!CommonUtil.isNullOrEmpty(scenarioDto.getContent())) {
					if(count == 0) {
						where = where + " where";
						count=1;
					} else {
						where = where + " and";
					}
					where = where + " content=" + scenarioDto.getContent();
				}
			}
			sql = sql + where;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				ScenarioInfosDto dto = new ScenarioInfosDto();
				dto.setId((Integer)rs.getInt("id"));
				dto.setSessionId((Integer)rs.getInt("sessionId"));
				dto.setKind(rs.getString("kind"));
				dto.setContent(rs.getString("content"));
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

	public void insert(ScenarioInfosDto scenarioDto) {
		PreparedStatement ps = null;
		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "INSERT INTO scenario.ScenarioInfos(sessionId, kind, content) values(?,?,?)";
			//実行するSQL文とパラメータを指定する
			ps = con.prepareStatement(sql);
			ps.setInt(1, scenarioDto.getSessionId());
			ps.setString(2, scenarioDto.getKind());
			ps.setString(3, scenarioDto.getContent());
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

	public void updateContent(ScenarioInfosDto scenarioDto) {
		PreparedStatement ps = null;
		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "UPDATE scenario.ScenarioInfos SET content = ? WHERE sessionId = ? AND kind = ?";
			//実行するSQL文とパラメータを指定する
			ps = con.prepareStatement(sql);
			ps.setInt(1, scenarioDto.getSessionId());
			ps.setString(2, scenarioDto.getKind());
			ps.setString(3, scenarioDto.getContent());
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
