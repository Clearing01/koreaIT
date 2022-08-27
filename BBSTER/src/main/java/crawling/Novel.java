package crawling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dao.NovelDAO;
import vo.NovelVO;

public class Novel {
//	public static void main(String [] args) {
	public static void sample() {
      int N = 1;
      int n = 1; // �씠誘몄� �뙆�씪 踰덊샇
      while(N<6) {
         String seriesUrl = "https://series.naver.com/novel/top100List.series?rankingTypeCode=DAILY&categoryCode=ALL&page="+N; // �겕濡ㅻ쭅�븯�젮�뒗 �럹�씠吏��쓽 url
         Document doc = null; // Document 媛앹껜 �깮�꽦
         URL url = null;   // URL 媛앹껜�깮�꽦
         InputStream in = null; // InputStream 媛앹껜 �깮�꽦
         OutputStream out = null; // OutputStream 媛앹껜 �깮�꽦

         try {
            doc = Jsoup.connect(seriesUrl).get(); // Jsoup �겢�옒�뒪濡� url �뿰寃고븯�뿬 �젙蹂대�� doc�뿉 �떞�쓬

         } catch (IOException e) {
            e.printStackTrace();
         }

         String product = ".comic_cont > h3 > a"; // �긽�꽭�럹�씠吏�濡� 媛�湲� �쐞�븳 二쇱냼媛� �엳�뒗 a�깭洹�
         Elements eles1 = doc.select(product); // a�깭洹� �젙蹂대쭔 eles1�뿉 �떞�쓬

         Iterator<Element> itr1 = eles1.iterator(); // �긽�꽭�럹�씠吏� 二쇱냼媛� �엳�뒗 a�깭洹� �젙蹂대�� �슂�냼 蹂꾨줈 遺꾨━

         while(itr1.hasNext()) {

            String product2 = itr1.next().attr("href"); // �옣瑜대�� �젙�젣�븯湲� �쐞�빐 �냽�꽦媛� href(�긽�꽭�젙蹂� �럹�씠吏�) 異붿텧

            String str = "https://series.naver.com/novel/detail.series?"+product2.substring(21,product2.length());
            //         System.out.println(str);

            String seriesUrl2 = str; // 媛쒕퀎 �냼�꽕�쓽 �긽�꽭�젙蹂� �럹�씠吏�
            Document doc2 = null;

            try {
               doc2 = Jsoup.connect(seriesUrl2).get(); // �긽�꽭�젙蹂� �럹�씠吏��뿉 �뿰寃고븯�뿬 �젙蹂대�� �떞�쓬

            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }

            String title = ".end_head > h2"; // �긽�꽭�럹�씠吏��뿉�꽌�쓽 �젣紐� �젙蹂�
            Elements eles2 = doc2.select(title); // �젣紐� �젙蹂대쭔 eles2�뿉 �떞�쓬

            String content = "._synopsis";
            Elements eles3 = doc2.select(content);

            String img = ".pic_area > img";
            Elements eles4 = doc2.select(img);

            String writer = ".info_lst > ul > li > a";
            Elements eles5 = doc2.select(writer);

            String genre = ".info_lst > ul > li > span > a";
            Elements eles6 = doc2.select(genre);


            Iterator<Element> itr2 = eles2.iterator(); // �젣紐� �젙蹂대�� �슂�냼蹂꾨줈 遺꾨━
            Iterator<Element> itr3 = eles3.iterator(); // �궡�슜 �젙蹂대�� �슂�냼蹂꾨줈 遺꾨━
            Iterator<Element> itr4 = eles4.iterator(); // �씠誘몄� �젙蹂대�� �슂�냼蹂꾨줈 遺꾨━
            Iterator<Element> itr5 = eles5.iterator(); // �옉媛� �젙蹂대�� �슂�냼蹂꾨줈 遺꾨━
            Iterator<Element> itr6 = eles6.iterator(); // �옣瑜� �젙蹂대�� �슂�냼蹂꾨줈 遺꾨━

            
            while(itr6.hasNext()) {
               String title2 = itr2.next().text();
               String content2 = itr3.next().text();
               String img2 = itr4.next().attr("src");
               String writer2 = itr5.next().text();
               String genre2 = itr6.next().text();

               try {
                  url = new URL(img2); // url 媛앹껜�뿉 �씠誘몄� 二쇱냼瑜� �떞�쓬
                  in = url.openStream(); // in 媛앹껜�뿉 url �젙蹂� �떞�쓬(諛쏄퀬�떢�� �뜲�씠�꽣 �뿰寃�), �뿴由� 1
                  out = new FileOutputStream("C:\\oraclexe\\poster\\"+n+".png"); // out 媛앹껜�뿉 ���옣寃쎈줈(���옣�쓣 �썝�븯�뒗 �쐞移�) �엯�젰
                  n++;
                  while(true) {
                     int data = in.read(); // in 媛앹껜濡� �빐�떦 �씠誘몄�瑜� �씫�뼱�뱾�엫

                     if(data==-1) { // �뜑�씠�긽 �씫�쓣寃껋씠 �뾾�쑝硫� 硫덉땄
                        break;
                     } 
                     out.write(data); // �씫�뼱�뱾�씤 �뜲�씠�꽣瑜� 寃쎈줈�뿉 �옉�꽦
                  }

                  System.out.println(title2);
                  System.out.println(content2);
                  System.out.println(img2);
                  System.out.println(writer2);
                  System.out.println(genre2);
                  System.out.println();
                  
                  NovelVO vo = new NovelVO();
                  NovelDAO nDAO = new NovelDAO();
                  
                  vo.setNtitle(title2);
                  vo.setNcontent(content2);
                  vo.setNimg(img2);
                  vo.setNwriter(writer2);
                  vo.setNgenre(genre2);
                  nDAO.insert_N(vo);
                  
               }catch (Exception e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               } finally {
                  try {
                     in.close();
                     out.close();
                  } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }            
               }               
            }
         }
         N++;
      }
   }
}