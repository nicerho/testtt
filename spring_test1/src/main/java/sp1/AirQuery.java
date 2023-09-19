package sp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AirQuery {
	private String sql = "";
	private PreparedStatement ps = null;
	private Connection con = null;

	public int totalSum(String tableName) throws Exception{
		sql = "select count(*) as ctn from " + tableName;
		con = dbconfig.info();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		int sum = rs.getInt(0);
		con.close();
		st.close();
		rs.close();
		return sum;
	}

	public int result(String a, String b, String c, String d, String e, String f, String g, String h) {
		int msg = 0;
		try {
			sql = "insert into air_reserve values('0',?,?,?,?,?,?,?,?,now())";
			con = dbconfig.info();
			ps = con.prepareStatement(sql);
			ps.setString(1, a);
			ps.setString(2, b);
			ps.setString(3, c);
			ps.setString(4, d);
			ps.setString(5, e);
			ps.setString(6, f);
			ps.setString(7, g);
			ps.setString(8, h);
			msg = ps.executeUpdate();
			System.out.println(sql);
			ps.close();
			con.close();

		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return msg;
	}

	public ArrayList<ArrayList<String>> result2() {
		ArrayList<String> list = null;
		ArrayList<ArrayList<String>> list2 = new ArrayList<>();
		try {
			sql = "select * from air_reserve order by ano desc";
			con = dbconfig.info();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list = new ArrayList<>();
				list.add(rs.getString("amoney"));
				list.add(rs.getString("acorp"));
				list.add(rs.getString("aplane_number"));
				list2.add(list);
			}

			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	}

	public void result3(String pid, String pname, String ppnumber, String pnumber, String corp, String pplane_number,
			String preserve, String pmoney) throws SQLException {

		try {
			String count = "select count(preserve) as cnt from air_person where ppnumber=? and preserve >= ?";
			/*
			 * ps.setString(1,ppnumber) ps.setString(2,preserve) ResultSet rs =
			 * ps.executeQuery() rs.next(); if(rs.getString("cnt").equals("1")){ 이후 insert }
			 * else{ error }
			 */

			sql = "insert into air_person values('0',?,?,?,?,?,?,?,?,now())";

			con = dbconfig.info();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, pid);
			ps.setString(2, pname);
			ps.setString(3, ppnumber);
			ps.setString(4, pnumber);
			ps.setString(5, corp);
			ps.setString(6, pplane_number);
			ps.setString(7, preserve);
			ps.setString(8, pmoney);
			ps.executeUpdate();
			ps.close();
			con.commit();
			con.close();
		} catch (Exception ee) {
			con.rollback();
			ee.printStackTrace();
		}
	}

	public ArrayList<ArrayList<String>> result4() throws Exception {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		con = dbconfig.info();
		try {
			sql = "select * from air_person order by pno limit 0,2";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			dto_air da = new dto_air();
			while (rs.next()) {
				da.setPid(rs.getString("pid"));
				da.setPname(rs.getString("pname"));
				da.setPpnumber(rs.getString("ppnumber"));
				da.setPnumber(rs.getString("pnumber"));
				da.setPcorp(rs.getString("pcorp"));
				da.setPplane_number(rs.getString("pplane_number"));
				da.setPreserve(rs.getString("preserve"));
				da.setPmoney(rs.getString("pmoney"));
				list.add(da.listdata());
			}
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {

		}
		return list;
	}
}
