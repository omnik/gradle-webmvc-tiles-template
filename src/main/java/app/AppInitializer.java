package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    private static final Logger logger = LoggerFactory.getLogger(AppInitializer.class);
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        logger.info("Started");

        {
            XmlWebApplicationContext contextMain = new XmlWebApplicationContext();
            contextMain.setConfigLocation("classpath:spring-context.xml");

            servletContext.addListener(new ContextLoaderListener(contextMain));

            ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(contextMain));
            dispatcher.setLoadOnStartup(1);
            dispatcher.addMapping("/api/*");
        }

        {

            XmlWebApplicationContext contextView = new XmlWebApplicationContext();
            contextView.setConfigLocation("classpath:spring-views.xml");
            ServletRegistration.Dynamic dispatcherView = servletContext.addServlet("DispatcherServletView", new DispatcherServlet(contextView));
            dispatcherView.setLoadOnStartup(2);
            dispatcherView.addMapping("*.html");
        }
    }


}
