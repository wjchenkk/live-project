package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pojo.Reservation;
import util.DBUtil;

public class MaskDAOImpl implements MaskDAO {
	@Override
	public void add(Reservation bean) {
		// TODO Auto-generated method stub
		int x1,x2,x3;
		String sql = "insert into registration values(? ,? ,? ,? ,? ,null,?)";
        	try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            		ps.setString(1, bean.getID());
            		ps.setString(2, bean.getTel());
            		ps.setString(3, bean.getName());
            		x1 = Integer.parseInt(bean.getNumber());
            		x2 = Integer.parseInt(bean.getReserveNum());
            		x3 = Integer.parseInt(bean.getStatus());
            		ps.setInt(4, x1);
            		ps.setInt(5, x2);
            		ps.setInt(6, x3);
            		ps.execute();
            		ResultSet rs = ps.getGeneratedKeys();
            		if (rs.next()) {
                		int id = rs.getInt(1);
                		String y = String.valueOf(id);
                		bean.setWinningNum(y);
            		}
        	} 
        	catch (SQLException e) {
            		e.printStackTrace();
        	}
	}

	@Override
	public void update(int id,String status) {
		// TODO Auto-generated method stub
		int x1;
		String sql = "update registration set status=? where getnumber=?";
        	try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
        		x1 = Integer.parseInt(status);
        		ps.setInt(1, x1);
        		ps.setInt(2, id);
        		ps.executeUpdate();
        	} catch (SQLException e) {
            		e.printStackTrace();
        	}
	}

	@Override
	public Reservation list(int id) {
		// TODO Auto-generated method stub
		Reservation users = new Reservation(null, null, null, null, null);
		String sql = "select * from registration where getnumber=?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
            		ResultSet rs = ps.executeQuery();
            		while (rs.next()) {
            			users.setName(rs.getString("name"));
            			users.setID(rs.getString("id"));
            			users.setTel(rs.getString("tel"));
            			users.setNumber(rs.getString("number"));
            		}
        	} 
		catch (SQLException e) {
            		e.printStackTrace();
        	}
		return users;
	}

	@Override
	public boolean query(String id, int times) {
		// TODO Auto-generated method stub
		String sql = "select * from registration where id=? and times=?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, id);
			ps.setInt(2, times);
            		ResultSet rs = ps.executeQuery();
            		while (rs.next()) {
            			return true;
            		}
       	 	}	 
		catch (SQLException e) {
           		e.printStackTrace();
        	}
		return false;
	}

	@Override
	public boolean queryTel(String tel, int times) {
		// TODO Auto-generated method stub
		String sql = "select * from registration where tel=? and times=?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, tel);
			ps.setInt(2, times);
            		ResultSet rs = ps.executeQuery();
            		while (rs.next()) {
            			return true;
            		}
        	}	 
		catch (SQLException e) {
            		e.printStackTrace();
        	}
		return false;
	}
	
}
