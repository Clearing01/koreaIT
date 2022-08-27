package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.OpinionVO;

public class OpinionDAO {
	Connection conn;
	PreparedStatement pstmt;
	final String sql_selectOne_O="SELECT * FROM OPINION LEFT OUTER JOIN MEMBER ON OPINION.MID=MEMBER.MID WHERE MID=?";
	final String sql_selectAll_O="SELECT * FROM OPINION LEFT OUTER JOIN MEMBER ON OPINION.MID=MEMBER.MID ORDER BY OID DESC";
	
	final String sql_selectAll_OPINION_SEARCH="SELECT * FROM OPINION LEFT OUTER JOIN MEMBER ON OPINION.MID=MEMBER.MID ORDER BY OID DESC WHERE MEMBER.MID=?";
	
	final String sql_insert_O="INSERT INTO OPINION VALUES((SELECT NVL(MAX(OID),2000)+1 FROM OPINION),?,TO_DATE(sysdate,'yyyy-mm-dd hh24:mi'),?,?,?)";
		// INSERT INTO OPINION VALUES((�꽌釉뚯옘由�),?,?,?)
	final String sql_update_O="UPDATE OPINION SET CONTENT=? WHERE OID=?";
	final String sql_delete_O="DELETE FROM OPINION WHERE OID=?";
	
	public OpinionVO selectOne_O(OpinionVO ovo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOne_O);
			pstmt.setInt(1, ovo.getOid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				OpinionVO data=new OpinionVO();
				data.setOid(rs.getInt("OID"));
				data.setOcontent(rs.getString("OCONTENT"));
				data.setMid(rs.getString("MID"));
				data.setOdate(rs.getString("ODATE"));
				
				if(rs.getString("NICKNAME")==null) {
					data.setMid("[�씠由꾩뾾�쓬]");
				}else {
				data.setMid(rs.getString("NICKNAME"));
				}
				return data;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
		return null;
	}
	public ArrayList<OpinionVO> selectAll_O(OpinionVO ovo){
		ArrayList<OpinionVO> datas=new ArrayList<OpinionVO>();
		conn=JDBCUtil.connect();
		System.out.println("�떆�옉");
		try {
			pstmt=conn.prepareStatement(sql_selectAll_O);
			ResultSet rs=pstmt.executeQuery();
			System.out.println("以묎컙");
			while(rs.next()) {
				OpinionVO data=new OpinionVO();
				data.setOid(rs.getInt("OID"));
				data.setOcontent(rs.getString("OCONTENT"));
				data.setOdate(rs.getString("ODATE"));
				if(rs.getString("NICKNAME")==null) {
					data.setMid("[�씠由꾩뾾�쓬]");
				} else {
					// WRITER���떊 MNAME�쓣 �떞�븘�꽌 WRITER瑜� 戮묒쑝硫� MNAME�씠 異쒕젰�맂�떎.
					data.setMid(rs.getString("NICKNAME"));
				}
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("�걹");

		return datas;
	}
	public boolean insert_O(OpinionVO ovo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert_O);
			pstmt.setString(1, ovo.getOcontent());
			pstmt.setString(2, ovo.getMid());
			pstmt.setInt(3, ovo.getLid());
			pstmt.setInt(4, ovo.getOstar());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean update_O(OpinionVO ovo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_update_O);
			pstmt.setString(1, ovo.getOcontent());
			pstmt.setInt(2,ovo.getOid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean delete_O(OpinionVO ovo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete_O);
			pstmt.setInt(1,ovo.getOid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}

}
