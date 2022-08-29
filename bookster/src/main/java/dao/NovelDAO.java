package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.NovelVO;

public class NovelDAO {
   Connection conn;
   PreparedStatement pstmt;
   final String sql_selectAll_N="SELECT * FROM (SELECT * FROM NOVEL WHERE NTITLE LIKE '%'||?||'%' AND NGENRE LIKE '%'||?||'%' AND NWRITER LIKE '%'||?||'%' ORDER BY NID DESC) WHERE ROWNUM < = ?";
   final String sql_selectAll_AVG="SELECT AVG(OSTAR) AS AVG FROM OPINION LEFT OUTER JOIN NOVEL ON OPINION.OID=NOVEL.OID WHERE OPINION.NID=?";
   
   final String sql_selectOne_N="SELECT * FROM NOVEL WHERE NID=?";
   
   final String sql_insert_N="INSERT INTO NOVEL VALUES((SELECT NVL(MAX(NID),0)+1 FROM NOVEL),?,?,?,?,?,?)";
   final String sql_sample = "SELECT COUNT(*) AS CNT FROM NOVEL";
   
   
   public boolean insert_N(NovelVO nvo) {
         conn = JDBCUtil.connect(); 
         try {
 //      	pstmt = conn.prepareStatement(sql_selectAll_AVG);
 //       	pstmt.setInt(1, vo.getNid());
 //       	ResultSet rs2 = pstmt.executeQuery();
        	 
            pstmt = conn.prepareStatement(sql_insert_N);
            pstmt.setString(1, nvo.getNtitle());
            pstmt.setString(2, nvo.getNcontent());
            pstmt.setString(3, nvo.getNimg());
            pstmt.setString(4, nvo.getNgenre()); 
            pstmt.setString(5, nvo.getNwriter()); 
            pstmt.setDouble(6, 0);
            //rs2.getDouble("AVG")

            pstmt.executeUpdate();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
         } finally {
            JDBCUtil.disconnect(pstmt, conn); 
         }
         return true;

      }
   
   public NovelVO selectOne_N(NovelVO nvo) {
	   conn=JDBCUtil.connect();
      try {
         pstmt=conn.prepareStatement(sql_selectOne_N);
         pstmt.setInt(1, nvo.getNid());
         ResultSet rs=pstmt.executeQuery();
         if(rs.next()) {
            NovelVO data=new NovelVO();
            data.setNid(rs.getInt("NID"));
            data.setNtitle(rs.getString("NTITLE"));
            data.setNcontent(rs.getString("NCONTENT"));
            data.setNimg(rs.getString("NIMG"));
            data.setNgenre(rs.getString("NGENRE"));
            data.setNwriter(rs.getString("NWRITER"));
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
   
   public ArrayList<NovelVO> selectAll_N(NovelVO nvo){
      ArrayList<NovelVO> datas=new ArrayList<NovelVO>();
      conn=JDBCUtil.connect();
      try {
            pstmt=conn.prepareStatement(sql_selectAll_N);
            if(nvo.getSearchContent()==null) { // 검색 내용이 없는 경우
				System.out.println("로그 : 검색");
				pstmt.setString(1, "");
				pstmt.setString(2, "");
				pstmt.setString(3, "");
			}
			else if(nvo.getSearchCondition().equals("NTITLE")) {
				pstmt.setString(1, nvo.getSearchContent());
				pstmt.setString(2, "");
				pstmt.setString(3, "");
			}
			else if(nvo.getSearchCondition().equals("NGENRE")) {
				pstmt.setString(1, "");
				pstmt.setString(2, nvo.getSearchContent());
				pstmt.setString(3, "");
			}
			else if(nvo.getSearchCondition().equals("NWRITER")) {
				pstmt.setString(1, "");
				pstmt.setString(2, "");
				pstmt.setString(3, nvo.getSearchContent());
			}
            pstmt.setInt(4,nvo.getNcnt());
            ResultSet rs=pstmt.executeQuery();
//            System.out.println("로그 : ");
         while(rs.next()) {
            NovelVO data=new NovelVO();
            data.setNid(rs.getInt("NID"));
            data.setNtitle(rs.getString("NTITLE"));
            data.setNcontent(rs.getString("NCONTENT"));
            data.setNimg(rs.getString("NIMG"));
            data.setNgenre(rs.getString("NGENRE"));
            data.setNwriter(rs.getString("NWRITER"));
//            System.out.println("로그 :" + data);
            datas.add(data);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         JDBCUtil.disconnect(pstmt, conn);
      }      
      return datas;
   }

   public boolean hasSample(NovelVO vo) {
         conn = JDBCUtil.connect();
         try {
            pstmt = conn.prepareStatement(sql_sample);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int cnt = rs.getInt("CNT");
            if (cnt >= 5) {
               return true;
            }
            return false;
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
         } finally {
            JDBCUtil.disconnect(pstmt, conn);
         }
      }

   
}