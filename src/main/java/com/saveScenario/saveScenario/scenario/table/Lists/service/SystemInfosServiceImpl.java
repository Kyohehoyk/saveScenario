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
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.SystemInfosDto;

@Service
public class SystemInfosServiceImpl implements SystemInfosService{

	@Override
	public List<SystemInfosDto> select(SystemInfosDto dto) {
		/* リターン用のListを宣言、初期化 */
		PreparedStatement ps = null;
		List<SystemInfosDto> dtoList = new ArrayList<SystemInfosDto>();

		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			String sql = "select * from scenario.SystemInfos";
			String where = "";
			List<String> setValue = new ArrayList<String>();
			if (dto != null) {
				where = where + CommonUtil.setDataSQL(()->dto.getId().toString(), "id", setValue, CommonInfoUtil.notUpdate);
				where = where + CommonUtil.setDataSQL(()->dto.getSystemInfo().toString(), "systemInfo", setValue, CommonInfoUtil.notUpdate);
			}
			sql = sql + where;

			ps = con.prepareStatement(sql);
			if (setValue.size() > 0) ps.setString(1, setValue.get(0));
			if (setValue.size() > 1) ps.setString(2, setValue.get(1));
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				SystemInfosDto systemInfosDto = new SystemInfosDto();
				systemInfosDto.setId((Integer)rs.getInt("id"));
				systemInfosDto.setSystemInfo(rs.getString("systemInfo"));
				dtoList.add(systemInfosDto);
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
