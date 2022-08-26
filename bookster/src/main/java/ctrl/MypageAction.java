package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class MypageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo = dao.selectOne_M(vo);
		if(vo != null) {
			request.setAttribute("data", vo);
			forward=new ActionForward();
			forward.setPath("/mypage.jsp");
			forward.setRedirect(false);			
		}
		else {
			throw new Exception("Mypage 오류");
		}
		
		return forward;
	}

}
