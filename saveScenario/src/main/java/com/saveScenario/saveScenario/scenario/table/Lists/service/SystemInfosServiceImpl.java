package com.saveScenario.saveScenario.scenario.table.Lists.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saveScenario.saveScenario.scenario.Util.CommonUtil;
import com.saveScenario.saveScenario.scenario.Util.DbUtil;
import com.saveScenario.saveScenario.scenario.table.Lists.DbDto.SystemInfosDto;

@Service
public class SystemInfosServiceImpl implements SystemInfosService{

	@Override
	public List<SystemInfosDto> select(SystemInfosDto systemDto) {
		/* リターン用のListを宣言、初期化 */
		List<SystemInfosDto> dtoList = new ArrayList<SystemInfosDto>();

		/* sql文 */
		try {
			Connection con = DbUtil.getConnection();
			/* sql文を実行し、Listに格納 */
			Statement stm = con.createStatement();
			String sql = "select * from scenario.SystemInfos";
			String where = "";
			if (systemDto != null) {
				int count = 0;
				if (!CommonUtil.isNullOrZero(systemDto.getId())) {
					if(count == 0) {
						where = where + " where";
						count=1;
					}
					where = where + " id=" + systemDto.getId();
				}

				if (!CommonUtil.isNullOrEmpty(systemDto.getSystemInfo())) {
					if(count == 0) {
						where = where + " where";
						count=1;
					}
					where = where + " systemInfo=" + systemDto.getSystemInfo();
				}
			}
			sql = sql + where;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				SystemInfosDto dto = new SystemInfosDto();
				dto.setId((Integer)rs.getInt("id"));
				dto.setSystemInfo(rs.getString("systemInfo"));
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
