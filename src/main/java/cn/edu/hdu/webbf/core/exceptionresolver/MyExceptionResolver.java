package cn.edu.hdu.webbf.core.exceptionresolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年5月24日
 * @see
 * @since webbf V1.0.0
 */
public class MyExceptionResolver implements HandlerExceptionResolver
{

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
        Object handler, Exception ex)
    {

        ex.printStackTrace();

        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));
        return mv;
    }

}