package com.saveScenario.saveScenario.scenario.table.Lists.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.Util.DbUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{
	@Override
	public String selectNickname(UsersDto usersDto) {
		// リターン用Stringのを宣言、初期化
		String nickname = null;
		PreparedStatement ps = null;
		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "select * from scenario.Users where id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, usersDto.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				nickname = rs.getString("nickname");
				break;
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
		return nickname;
	}

	@Override
	public String selectLoginId(UsersDto usersDto) {
		// リターン用Stringのを宣言、初期化
		String nickname = null;
		PreparedStatement ps = null;
		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "select * from scenario.Users where loginId = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, usersDto.getLoginId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				nickname = rs.getString("nickname");
				break;
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
		return nickname;
	}

	@Override
	public UsersDto select(UsersDto usersDto) {
		UsersDto rtnDto = new UsersDto();
		PreparedStatement ps = null;
		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "select * from scenario.Users where loginId = ? and password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, usersDto.getLoginId());
			ps.setString(2, usersDto.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				rtnDto.setNickname(rs.getString("nickname"));
				rtnDto.setId(rs.getInt("id"));
				break;
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
		return rtnDto;
	}

	@Override
	public void insert(UsersDto usersDto) {
		PreparedStatement ps = null;
		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "INSERT INTO scenario.Users(loginId, nickname, password) values(?,?,?)";
			//実行するSQL文とパラメータを指定する
			ps = con.prepareStatement(sql);
			ps.setString(1, usersDto.getLoginId());
			ps.setString(2, usersDto.getNickname());
			ps.setString(3, usersDto.getPassword());
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
