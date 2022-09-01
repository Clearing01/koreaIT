package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import vo.BoardVO;
import vo.MemberVO;

public class InsertBAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		HttpSession session=request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		
		vo.setMid(mvo.getMid()); // 현재 접속한 멤버 id
		vo.setBtitle(request.getParameter("btitle")); // 입력받은 게시글 제목
		vo.setBcontent(request.getParameter("bcontent")); // 입력한 게시글 내용
		
		if(dao.insert_B(vo)) { // 게시글 등록
			forward = new ActionForward();
			forward.setPath("community.do");
			forward.setRedirect(true);
		}
		else {
			throw new Exception("insertB 오류");
		}
					
		return forward;
	}
	
}

/*
		if(bDAO.insert(bVO)){
			response.sendRedirect("ctrlB.jsp?action=main");
		}
*/