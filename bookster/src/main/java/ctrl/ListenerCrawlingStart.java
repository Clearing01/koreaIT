package ctrl;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import crawling.Novel;
import dao.NovelDAO;
import vo.NovelVO;

/**
 * Application Lifecycle Listener implementation class CrawlingStart
 *
 */
@WebListener
public class ListenerCrawlingStart implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerCrawlingStart() {
        // TODO Auto-generated constructor stub
    }

   /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {  // 톰캣 종료 시 수행
         // TODO Auto-generated method stub
    }

   /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { // 톰캣 시작 시 수행
        // TODO Auto-generated method stub
          ServletContext sc= sce.getServletContext(); // 어플리케이션 스코프에 해당한다.

          NovelVO novel = new NovelVO();
          ArrayList<NovelVO> datas=new ArrayList<NovelVO>();
          NovelDAO nDAO = new NovelDAO();

          if(!nDAO.hasSample(novel)) { // 기존 크롤링한 데이터가 있는지 확인
              Novel.sample(); // 없다면 크롤링 한다
           }
          
          datas= nDAO.selectAll_N(novel); 
              
          System.out.println(datas);
          sc.setAttribute("datas", datas);
          // sc.setAttribute("객체명", 객체);
          
          System.out.println("TestListener: contextInitialized(): 톰캣 시작이 감지됨");
    }
   
}