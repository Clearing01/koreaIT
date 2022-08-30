package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;


public class LoginMAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo = dao.selectOne_M(vo);
					
		if(vo!=null) {
			MemberVO member = new MemberVO();
			member.setMid(vo.getMid());
			member.setMname(vo.getNickname());
			session.setAttribute("member", member);
		}
		else {
			System.out.println("Î°úÍ∑∏: Î°úÍ∑∏?ù∏ ?ã§?å®");
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
