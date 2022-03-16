package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.vo.ReplyVO;

public class InsertReplyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward=null;

		BoardDAO dao=new BoardDAO();
		ReplyVO vo=new ReplyVO();
		
		vo.setBid(Integer.parseInt(req.getParameter("bid")));
		vo.setMid(req.getParameter("mid"));
		vo.setMsg(req.getParameter("msg"));
		
		if(dao.insertReply(vo)) {
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
		}
		return forward;
	}

}