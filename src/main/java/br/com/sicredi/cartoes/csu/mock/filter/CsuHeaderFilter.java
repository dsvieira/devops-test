package br.com.sicredi.cartoes.csu.mock.filter;

import br.com.sicredi.cartoes.csu.mock.util.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CsuHeaderFilter implements Filter {

    @Override
    public void init(FilterConfig var1) throws ServletException {
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if(!((HttpServletRequest) request).getRequestURI().contains("swagger") && !((HttpServletRequest) request).getRequestURI().contains("api-docs")) {
            if (((HttpServletRequest) request).getRequestURI().contains("token")) {
                if (req.getParameter("client_id") == null ||
                        req.getParameter("client_secret") == null ||
                        req.getParameter("grant_type") == null) {

                    ResponseUtil.error(res);
                    return;
                }
            } else if (req.getHeader(HttpHeaders.AUTHORIZATION) == null ||
                    req.getHeader("operador") == null) {
                ResponseUtil.error(res);
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy(){}
}
