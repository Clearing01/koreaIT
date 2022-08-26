package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JDBCUtil;
import vo.LlikeVO;

public class LlikeDAO {
   Connection conn;
   PreparedStatement pstmt;
   final String sql_insert="INSERT INTO LLIKE VALUES((SELECT NVL(MAX(LID),0)+1 FROM LLIKE),?,?,?)";
   final String sql_updateLU="UPDATE LLIKE SET LSTATUS=LSTATUS+1 WHERE BID=?";
   final String sql_updateLD="UPDATE LLIKE SET LSTATUS=LSTATUS-1 WHERE BID=?";
   final String sql_updateNLU="UPDATE LLIKE SET NLSTATUS=NLSTATUS+1 WHERE BID=?";
   final String sql_updateNLD="UPDATE LLIKE SET NLSTATUS=NLSTATUS-1 WHERE BID=?";
   final String sql_updateREPU="UPDATE LLIKE SET REPORT=REPORT+1 WHERE BID=?";
   final String sql_updateREPD="UPDATE LLIKE SET REPORT=REPORT-1 WHERE BID=?";
   
   public boolean insert_L(LlikeVO lvo) {
      conn=JDBCUtil.connect();
      try {
         pstmt=conn.prepareStatement(sql_insert);
         pstmt.setString(1, lvo.getMid());
         pstmt.setInt(2, lvo.getOid());
         pstmt.setInt(3, lvo.getBid());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
         return false;
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      return true;
   }
   public boolean update_L(LlikeVO bvo) {
      conn=JDBCUtil.connect();
      try {
         if(bvo.getLstatus()==1) {
            pstmt=conn.prepareStatement(sql_updateLU);
            pstmt.setInt(1, bvo.getBid());
            pstmt.executeUpdate();
         }
         else if(bvo.getLstatus()==-1) {
            pstmt=conn.prepareStatement(sql_updateLD);
            pstmt.setInt(1, bvo.getBid());
            pstmt.executeUpdate();
         }
         else if(bvo.getNlstatus()==1) {
            pstmt=conn.prepareStatement(sql_updateNLU);
            pstmt.setInt(1, bvo.getBid());
            pstmt.executeUpdate();
         }
         else if(bvo.getNlstatus()==-1) {
            pstmt=conn.prepareStatement(sql_updateNLD);
            pstmt.setInt(1, bvo.getBid());
            pstmt.executeUpdate();
         }
         else if(bvo.getReport()==1) {
            pstmt=conn.prepareStatement(sql_updateREPU);
            pstmt.setInt(1, bvo.getBid());
            pstmt.executeUpdate();
         }
         else if(bvo.getReport()==-1) {
            pstmt=conn.prepareStatement(sql_updateREPD);
            pstmt.setInt(1, bvo.getBid());
            pstmt.executeUpdate();
         }
      } catch (SQLException e) {
         e.printStackTrace();
         return false;
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }
      return true;
   }
}