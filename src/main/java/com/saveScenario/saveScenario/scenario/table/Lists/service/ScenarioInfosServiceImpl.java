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
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ScenarioInfosDto;

@Service
public class ScenarioInfosServiceImpl implements ScenarioInfosService{

	@Override
	public List<ScenarioInfosDto> select(ScenarioInfosDto scenarioDto) {
		/* リターン用のListを宣言、初期化 */
		PreparedStatement ps = null;
		List<ScenarioInfosDto> dtoList = new ArrayList<ScenarioInfosDto>();

		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "select * from scenario.ScenarioInfos";
			String where = "";
			List<String> setValue = new ArrayList<String>();
			if (scenarioDto != null) {
				where = where + CommonUtil.setDataSQL(()->scenarioDto.getId().toString(), "id", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->scenarioDto.getSessionId().toString(), "sessionId", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->scenarioDto.getKind().toString(), "kind", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->scenarioDto.getContent(), "content", setValue, CommonInfoUtil.notUpdate);
			}
			sql = sql + where;

			ps = con.prepareStatement(sql);
			if (setValue.size() > 0) ps.setString(1, setValue.get(0));
			if (setValue.size() > 1) ps.setString(2, setValue.get(1));
			if (setValue.size() > 2) ps.setString(3, setValue.get(2));
			if (setValue.size() > 3) ps.setString(4, setValue.get(3));
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ScenarioInfosDto dto = new ScenarioInfosDto();
				dto.setId(rs.getInt("id"));
				dto.setSessionId(rs.getInt("sessionId"));
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

	public void insert(ScenarioInfosDto dto) {
		PreparedStatement ps = null;
		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "INSERT INTO scenario.ScenarioInfos(sessionId, kind, content) values(?,?,?)";
			//実行するSQL文とパラメータを指定する
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getSessionId());
			ps.setString(2, dto.getKind());
			ps.setString(3, dto.getContent());
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

	public void update(ScenarioInfosDto dto) {
		PreparedStatement ps = null;
		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "UPDATE scenario.ScenarioInfos SET content = ? WHERE sessionId = ? AND kind = ?";
			//実行するSQL文とパラメータを指定する
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getSessionId());
			ps.setString(2, dto.getKind());
			ps.setString(3, dto.getContent());
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
