package com.stx.web.servlet;

import com.stx.dao.impl.CommentsDaoImpl;
import com.stx.entity.Comments;
import com.stx.service.impl.CommentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/commentsServlet")
public class CommentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("cast")){
            case "newcomments":
                String pinglun = request.getParameter("pinglun");
                String blogid = request.getParameter("blogid");
                Object user = request.getSession().getAttribute("user");
                HashMap<String, Object> map = new HashMap<>();
                map.put("commentText",pinglun);
                map.put("blogid",blogid);
                map.put("user",user);
                new CommentsServiceImpl().addComments(map);
                response.sendRedirect("/blogServlet?blogId="+blogid+"&cast=showblogtext");
                break;
            case "delete":
                Integer bid = Integer.parseInt(request.getParameter("bid"));
                Integer id = Integer.parseInt(request.getParameter("cid"));
                Comments comments = new Comments();
                comments.setId(id);
                CommentsDaoImpl commentsDao = new CommentsDaoImpl();
                commentsDao.deleteComments(comments);
                response.sendRedirect("/blogServlet?blogId="+bid+"&cast=showblogtext");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
