package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import bean.Image;
import daoutil.DAOUtil;

public class GetImage {

	static GetImage getimage = null;

	public static GetImage getInstance() {
		if (getimage == null) {
			getimage = new GetImage();
		}
		return getimage;
	}

	public static List<Image> getimage() throws ClassNotFoundException, SQLException {

		Connection con = DAOUtil.getDBConnection();
		List<Image> result = image(con);
		return result;

	}

	public static List<Image> image(Connection con) {
		Image tempUserObj = null;
		List<Image> userList = null;

		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			

			String sql = "SELECT * FROM image order by img_id desc";
		
			stmt = con.prepareStatement(sql);
		
			rs = stmt.executeQuery();
			
			userList = new ArrayList<>();
			while (rs.next()) {
				int img_id = rs.getInt("img_id");
				String img_src = rs.getString("img_src");
				String img_name = rs.getString("img_name");
				tempUserObj = new Image(img_id,img_src,img_name);
				userList.add(tempUserObj);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
			}
			try {
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return userList;
	}
}
