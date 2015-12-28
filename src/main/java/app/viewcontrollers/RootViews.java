package app.viewcontrollers;

import app.WebSession;
import app.WebSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RootViews {

    private static final Logger logger = LoggerFactory.getLogger(RootViews.class);

    @RequestMapping(value = {"/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping({"/login"})
    public ModelAndView login(
            HttpServletRequest request,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password) {

        logger.info("Login action {} {}", username, password);

        if (username != null && password != null) {
            WebSession webSession = new WebSession();
            WebSessionUtils.store(request.getSession(), webSession);
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("login");
    }

    @RequestMapping({"/logout"})
    public ModelAndView logout(HttpServletRequest request){


        WebSessionUtils.remove(request.getSession());
        return new ModelAndView("redirect:/");


    }

}
