package org.fullstack4.springmvc.filter;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.Common.CommonUtil;
import org.fullstack4.springmvc.Common.CookieUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Log4j2
@WebFilter(urlPatterns = {"/bbs/modify","/bbs/delete","/bbs/regist","/login/logout", "/member/modify", "/member/delete"})
public class BbsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("미로그인 시 게시글 접근 불가");
        HttpServletRequest req =(HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        if(session.getAttribute("user_id") == null) {
            try {
                resp.setContentType("text/html; charset=utf-8");
                PrintWriter w = resp.getWriter();
                w.write("<script>alert('로그인이 필요합니다.');history.go(-1);</script>");
                w.flush();
                w.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }


        chain.doFilter(req,resp);

    }
}
