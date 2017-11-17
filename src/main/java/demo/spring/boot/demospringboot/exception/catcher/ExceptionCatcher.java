package demo.spring.boot.demospringboot.exception.catcher;

import org.hibernate.exception.DataException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import demo.spring.boot.demospringboot.framework.BaseResponse;
import demo.spring.boot.demospringboot.framework.ErrorResponse;

/**
 * 全局捕获异常
 *
 * 1、在class上添加注解，@ControllerAdvice; 2、在方法上添加@ExcetionHandler拦截相应的异常信息； 3、如果返回的是View --
 * 方法的返回值是ModelAndView; 4、如果返回的是String或者是Json数据，那么需要在方法上添加@ResponseBody注解
 */
@ControllerAdvice
public class ExceptionCatcher {

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ErrorResponse NullPointException(NullPointerException e) {
        ErrorResponse response = new ErrorResponse();
        response.getError().add(e);
        response.setMsg("空指针异常");
        return response;
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorResponse exception(Exception e) {
        ErrorResponse response = new ErrorResponse();

        response.setMsg("系统有点累");
        response.getError().add(e);
        return response;
    }
}
