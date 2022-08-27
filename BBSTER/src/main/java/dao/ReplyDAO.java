package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.ReplyVO;

public class ReplyDAO {
	Connection conn;
	PreparedStatement pstmt;
	final String sql_selectOne_R="SELECT * FROM REPLY LEFT OUTER JOIN MEMBER ON REPLY.MID=MEMBER.NICKNAME WHERE RID=?";
	final String sql_selectAll_R="SELECT * FROM REPLY LEFT OUTER JOIN MEMBER ON REPLY.MID=MEMBER.NICKNAME ORDER BY RID DESC";
	// SQL �뿉�꽌 蹂�寃쏀뻽�뜕 SELECTALL�쓣 洹몃�濡� 蹂듭궗�븯�뿬 湲곗〈�뿉 寃��깋�븯�뒗 SELECTALL�뿉 異붽��븯���떎.
	
	final String sql_insert_R="INSERT INTO REPLY VALUES((SELECT NVL(MAX(RID),3000)+1 FROM REPLY),?,to_char(sysdate,'yyyy.mm.dd hh24:mi'),?,?,?)";
		// INSERT INTO BOARD VALUES((�꽌釉뚯옘由�),?,?,?)
	final String sql_update_R="UPDATE REPLY SET CONTENT=? WHERE RID=?";
	final String sql_delete_R="DELETE FROM REPLY WHERE RID=?";
	
	public ReplyVO selectOne_R(ReplyVO rvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOne_R);
			pstmt.setInt(1, rvo.getBid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				ReplyVO data=new ReplyVO();
				data.setRid(rs.getInt("RID"));
				data.setRcontent(rs.getString("RCONTENT"));
				data.setRdate(rs.getString("RDATE"));
				
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
	public ArrayList<ReplyVO> selectAll_R(ReplyVO rvo){
		ArrayList<ReplyVO> datas=new ArrayList<ReplyVO>();
		conn=JDBCUtil.connect();
		System.out.println("�떆�옉");
		try {
			pstmt=conn.prepareStatement(sql_selectAll_R);
			ResultSet rs=pstmt.executeQuery();
			System.out.println("以묎컙");

			while(rs.next()) {
				ReplyVO data=new ReplyVO();
				data.setRid(rs.getInt("RID"));
				data.setRcontent(rs.getString("RCONTENT"));
				data.setRdate(rs.getString("RDATE"));
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
	public boolean insert_R(ReplyVO rvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert_R);
			pstmt.setString(1, rvo.getRcontent());
			pstmt.setString(2, rvo.getMid());
			pstmt.setInt(3, rvo.getLid());
			pstmt.setInt(4, rvo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean update_R(ReplyVO rvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_update_R);
			pstmt.setString(1, rvo.getRcontent());
			pstmt.setInt(2, rvo.getRid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean delete_R(ReplyVO rvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete_R);
			pstmt.setInt(1,rvo.getRid());
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
