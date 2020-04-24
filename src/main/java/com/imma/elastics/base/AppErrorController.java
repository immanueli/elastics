package com.imma.elastics.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * web异常信息配置类
 */
@Controller
public class AppErrorController implements ErrorController {
    public static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }


    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    /**
     * web页面错误异常
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        int status = httpServletResponse.getStatus();
        switch (status) {
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "index";
    }

    /**
     * 处理其他异常信息 json/xml
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ApiResponse errorApi(WebRequest request,HttpServletRequest httpServletRequest){
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(request, false);
        int status = getStatus(httpServletRequest);
        return ApiResponse.ofMessage(status, String.valueOf(errorAttributes.getOrDefault("message","error")));
    }

    private int getStatus(HttpServletRequest request){
        Integer status = Integer.parseInt(request.getAttribute("javax.servlet.error.status_code").toString());
        if (status != null){
            return status;
        }
        return 500;
    }

}
