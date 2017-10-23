package cn.com.systec.base;

import cn.com.systec.utility.CommonConstants;
import cn.com.systec.utility.CommonFunctions;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class BaseController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

    private static final int BUFFER_SIZE = 1024;

    /**
     * 读取请求BODY数据
     *
     * @param request
     * @return
     */
    public String readRequstBody(HttpServletRequest request) {
        try {
            BufferedReader bufferedReader = request.getReader();
            StringBuilder stringBuilder = new StringBuilder();

            char[] charBuffer = new char[BUFFER_SIZE];
            int bytesRead = 0;

            while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
                stringBuilder.append(charBuffer, 0, bytesRead);
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            logger.error("Get request body error: ", e);
            return null;
        }
    }

    /**
     * 发送响应BODY数据（字符串格式）
     *
     * @param response
     */
    public void writeResponseBody(HttpServletResponse response, String body) {
        this.writeResponseBody(response, body.getBytes());
    }

    /**
     * 发送响应BODY数据（字符串格式）
     *
     * @param response
     */
    public void writeResponseBody(HttpServletResponse response, byte[] body) {
        try {
            response.getOutputStream().write(body);
            response.getOutputStream().flush();
        } catch (IOException e) {
            logger.error("Send reponse body error: " + e.getMessage());
        }
    }

    /**
     * 获取HTTP请求的Cookie值
     *
     * @param request
     * @param cookieName
     * @param defaultValue
     * @return
     */
    public String getCookieValue(HttpServletRequest request, String cookieName, String defaultValue) {
        return CommonFunctions.getCookieValue(request.getCookies(), cookieName, defaultValue);
    }

    /**
     * 获取客户端设备类型
     *
     * @param request
     * @return
     */
    public int getClientDeviceType(HttpServletRequest request) {
        HttpSession session = request.getSession();

        Integer endPointType = (Integer) session.getAttribute(CommonConstants.SessionConstants.ENDPOINT_TYPE);
        if (endPointType == null) {
            endPointType = CommonFunctions.getEndPointType(
                    request.getHeader("USER-AGENT").toLowerCase());

            session.setAttribute(CommonConstants.SessionConstants.ENDPOINT_TYPE, endPointType);
        }

        return endPointType;
    }

    /**
     * 根据客户端的设备类型，跳转到对应的页面
     *
     * @param request
     * @param modelMap
     * @param page
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ModelAndView dispatchModelAndView(HttpServletRequest request, Map modelMap, String page) {
        return new ModelAndView(page).addAllObjects(modelMap);

//        if (getClientDeviceType(request) == CommonConstants.EndPointType.EPTYPE_PC) {
//            return new ModelAndView("web/" + page).addAllObjects(modelMap);
//        } else {
//            return new ModelAndView("wap/" + page).addAllObjects(modelMap);
//        }
    }
}
