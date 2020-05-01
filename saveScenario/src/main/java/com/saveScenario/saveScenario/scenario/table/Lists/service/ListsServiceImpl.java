package com.saveScenario.saveScenario.scenario.table.Lists.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.Util.DbUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.ListsDto;

@Service
public class ListsServiceImpl implements ListsService{

	@Override
	public List<ListsDto> Select() {
		/* リターン用のListを宣言、初期化 */
		List<ListsDto> dtoList = new ArrayList<ListsDto>();

		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			Statement stm = con.createStatement();
			String sql = "select * from scenario.Lists";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				ListsDto dto = new ListsDto();
				dto.setId((Integer)rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setCreater(rs.getString("creater"));
				dto.setParticipant(rs.getString("participant"));
				dto.setEstimatedTime(rs.getString("estimatedTime"));
				dto.setUpdateTime(Timestamp.valueOf(rs.getString("updateTime")));
				dto.setRegister((Integer)rs.getInt("register"));
				dto.setSystemInfo((Integer)rs.getInt("systemInfo"));
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
	public ListsDto Select(String id) {
		/* リターン用のListを宣言、初期化 */
		List<ListsDto> dtoList = new ArrayList<ListsDto>();

		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			Statement stm = con.createStatement();
			String sql = "select * from scenario.Lists where id ="+id;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				ListsDto dto = new ListsDto();
				dto.setId((Integer)rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setCreater(rs.getString("creater"));
				dto.setParticipant(rs.getString("participant"));
				dto.setEstimatedTime(rs.getString("estimatedTime"));
				dto.setUpdateTime(Timestamp.valueOf(rs.getString("updateTime")));
				dto.setRegister((Integer)rs.getInt("register"));
				dto.setSystemInfo((Integer)rs.getInt("systemInfo"));
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
		return dtoList.get(0);
	}

	@Override
	public void insert(ListsDto form) {
		PreparedStatement ps = null;
		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "INSERT INTO scenario.Lists(title, creater, participant, estimatedTime, updateTime, register, systemInfo) values(?,?,?,?,?,?,?)";
			//実行するSQL文とパラメータを指定する
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

	@Override
	public List<ListsDto> Select(ListsDto form) {
		/* リターン用のListを宣言、初期化 */
		List<ListsDto> dtoList = new ArrayList<ListsDto>();

		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			Statement stm = con.createStatement();
			String sql = "select * from scenario.Lists";
			String where = "";
			if (form.getTitle()!=null && form.getTitle().length() != 0) {
				where += " title ='" + form.getTitle()+"'";
			}
			if (form.getSystemInfo()!=null && form.getSystemInfo() != 0) {
				if(where.length() > 0) {
					where = where + " and";
				}
				where += " systemInfo =" + form.getSystemInfo();
			}
			if (form.getRegister()!=null && form.getRegister() != 0) {
				if(where.length() > 0) {
					where = where + " and";
				}
				where += " register =" + form.getRegister();
			}

			sql = sql + " where " + where;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				ListsDto dto = new ListsDto();
				dto.setId((Integer)rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setCreater(rs.getString("creater"));
				dto.setParticipant(rs.getString("participant"));
				dto.setEstimatedTime(rs.getString("estimatedTime"));
				dto.setUpdateTime(Timestamp.valueOf(rs.getString("updateTime")));
				dto.setRegister((Integer)rs.getInt("register"));
				dto.setSystemInfo((Integer)rs.getInt("systemInfo"));
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

}
