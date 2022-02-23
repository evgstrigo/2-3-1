package web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


        @Override
        protected Class<?>[] getRootConfigClasses() {
            // TODO Auto-generated method stub
            return new Class[]{AppContext.class};
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            // TODO Auto-generated method stub
            return new Class[]{WebConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            // TODO Auto-generated method stub
            return new String[]{"/"};
        }
}
