package com.saveScenario.saveScenario.scenario.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbUtil {
	private static final String DB_HOST = "localhost";
	private static final String DB_NAME = "scenario";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "Sigure!0323";
	private static final String DBMS = "mysql"; // 使用するDB
	private static final String DB_DRIVER = "com." + DBMS + ".cj.jdbc.Driver"; // ドライバー
	private static final String DB_PORT = "3306";
	private static final String DB_URL = "jdbc:" + DBMS + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"; // DBのURL

	// インスタンス化の禁止
	private DbUtil() {
	}

	// Connectionを単一のインスタンスとする
	// 複数のアプリケーションから取得される場合はコネクションプールを利用するなどする。
	private static Connection con;

	// コネクションを取得
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DB_DRIVER);
		con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		return con;
	}

	// ステートメントを切断
	public static void closeStatement(PreparedStatement stmt) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
	}

	// コネクションを切断
	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}
}