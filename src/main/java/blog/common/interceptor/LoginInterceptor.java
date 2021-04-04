package blog.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 挽风
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws IOException {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer userLevel = (Integer) request.getSession().getAttribute("userLevel");
        if(null != userId){
            if(userLevel == 0){
                return true;
            }else {
                response.sendRedirect("/home/index");
                return false;
            }
        }else {
            response.sendRedirect("/home/login");
            return false;
        }
    }
}
