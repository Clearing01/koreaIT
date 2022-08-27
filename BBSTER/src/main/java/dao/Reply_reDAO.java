package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.Reply_reVO;

public class Reply_reDAO {
	Connection conn;
	PreparedStatement pstmt;
	final String sql_selectOne_RR="SELECT * FROM REPLY_RE LEFT OUTER JOIN MEMBER ON REPLY_RE.MID=MEMBER.NICKNAME WHERE RRID=?";
	final String sql_selectAll_RR="SELECT * FROM REPLY_RE LEFT OUTER JOIN MEMBER ON REPLY_RE.MID=MEMBER.NICKNAME ORDER BY RRID DESC";
	// SQL �뿉�꽌 蹂�寃쏀뻽�뜕 SELECTALL�쓣 洹몃�濡� 蹂듭궗�븯�뿬 湲곗〈�뿉 寃��깋�븯�뒗 SELECTALL�뿉 異붽��븯���떎.
	
	final String sql_insert_RR="INSERT INTO REPLY_RE VALUES((SELECT NVL(MAX(RRID),4000)+1 FROM REPLY_RE),?,to_char(sysdate,'yyyy.mm.dd hh24:mi'),?,?,?)";
		// INSERT INTO BOARD VALUES((�꽌釉뚯옘由�),?,?,?)
	final String sql_update_RR="UPDATE REPLY_RE SET CONTENT=? WHERE RRID=?";
	final String sql_delete_RR="DELETE FROM REPLY_RE WHERE RRID=?";
	
	public Reply_reVO selectOne_RR(Reply_reVO rrvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOne_RR);
			pstmt.setInt(1, rrvo.getRrid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				Reply_reVO data=new Reply_reVO();
				data.setRrid(rs.getInt("RRID"));
				data.setRrcontent(rs.getString("RRCONTENT"));
				data.setRrdate(rs.getString("RRDATE"));
				
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
	public ArrayList<Reply_reVO> selectAll_RR(Reply_reVO rrvo){
		ArrayList<Reply_reVO> datas=new ArrayList<Reply_reVO>();
		conn=JDBCUtil.connect();
		System.out.println("�떆�옉");
		try {
			pstmt=conn.prepareStatement(sql_selectAll_RR);
			ResultSet rs=pstmt.executeQuery();
			System.out.println("以묎컙");

			while(rs.next()) {
				Reply_reVO data=new Reply_reVO();
				data.setRrid(rs.getInt("RRID"));
				data.setRrcontent(rs.getString("RRCONTENT"));
				data.setRrdate(rs.getString("RRDATE"));
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
	public boolean insert_RR(Reply_reVO rrvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert_RR);
			pstmt.setString(1, rrvo.getRrcontent());
			pstmt.setString(2, rrvo.getMid());
			pstmt.setInt(3, rrvo.getLid());
			pstmt.setInt(4, rrvo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean update_RR(Reply_reVO rrvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_update_RR);
			pstmt.setString(1, rrvo.getRrcontent());
			pstmt.setInt(2, rrvo.getRrid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean delete_RR(Reply_reVO rrvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete_RR);
			pstmt.setInt(1,rrvo.getRrid());
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
