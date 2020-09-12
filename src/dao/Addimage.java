package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Image;
import daoutil.DAOUtil;

public class Addimage {

	static Addimage addimage = null;

	public static Addimage getInstance() {
		if (addimage == null) {
			addimage = new Addimage();
		}
		return addimage;
	}

	public static String addimage(String img_src,String img_name) throws ClassNotFoundException, SQLException {

		Connection con = DAOUtil.getDBConnection();
		String result = image(img_src,img_name,con);
		return result;

	}

	public static String image(String img_src,String img_name,Connection con) {
		


		String result = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
			

			String sql = "INSERT INTO image (img_src,img_name)" +
			        "VALUES (?,?)";


			try {
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1,img_src);
				preparedStatement.setString(2, img_name);
				rs=preparedStatement.executeUpdate(); 

				if (rs>=1) {
					System.out.println("insert Successfull");
					result = "insert Successfull";
				} 

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (preparedStatement!= null) {
					preparedStatement.close();
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

		return result;
	}
}
