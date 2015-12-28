package app;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WebSessionUtils {

    public static final String WEBSESSION_KEY = "app.WebSession";

    public static void store(HttpSession httpSession, WebSession webSession ){
        httpSession.setAttribute(WEBSESSION_KEY, webSession);
    }

    public static WebSession get(HttpSession httpSession){
        return (WebSession) httpSession.getAttribute(WEBSESSION_KEY);
    }

    public static void remove(HttpSession httpSession){
        httpSession.removeAttribute(WEBSESSION_KEY);
    }



}
