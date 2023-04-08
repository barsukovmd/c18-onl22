package by.tms.onlinestore.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

@WebFilter(urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding param")})
public class CharacterEncodingFilter implements Filter {
    //
//    private String code;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        code = filterConfig.getInitParameter("encoding");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        String codeRequest = servletRequest.getCharacterEncoding();
//        if (code != null && !code.equalsIgnoreCase(codeRequest)) {
//            servletRequest.setCharacterEncoding(code);
//            servletResponse.setContentType("text/html");
//            servletResponse.setCharacterEncoding(code);
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//        code = null;
//    }
//}
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!encoding.equals(request.getCharacterEncoding())) {
            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
            response.setContentType("text/html");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        encoding = null;
    }
}