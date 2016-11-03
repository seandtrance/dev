package com.klb.runnable;


import java.util.Map;

import javax.ws.rs.Path;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.codahale.metrics.health.HealthCheck;
import com.klb.configuration.ConfigurationApp;
import com.klb.configuration.SpringConfiguration;
import com.klb.configuration.SpringContextLoaderListener;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;


import java.util.EnumSet;


public class MainAppRunner extends Application<ConfigurationApp> {
	
		public static void main(String[] args) throws Exception {
	        new MainAppRunner().run(args);
	    }

	    @Override
	    public void initialize(Bootstrap<ConfigurationApp> bootstrap) {
	    	bootstrap.addBundle(new AssetsBundle("/webapp", "/", "index.html"));
	    }
	    
	    @Override
		public String getName() {
			return "hello-world";
		}

	    @Override
	    public void run(ConfigurationApp conf, Environment env) throws Exception {
	    	
	    	
	    	 //init Spring context
	        //before we init the app context, we have to create a parent context with all the config objects others rely on to get initialized
	        AnnotationConfigWebApplicationContext parent = new AnnotationConfigWebApplicationContext();
	        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

	        parent.refresh();
	        parent.getBeanFactory().registerSingleton("configuration", conf);
	        parent.registerShutdownHook();
	        parent.start();

	        //the real main app context has a link to the parent context
	        ctx.setParent(parent);
	        ctx.register(SpringConfiguration.class);
	        ctx.refresh();
	        ctx.registerShutdownHook();
	        ctx.start();

	        //now that Spring is started, let's get all the beans that matter into DropWizard

	        //health checks
	        Map<String, HealthCheck> healthChecks = ctx.getBeansOfType(HealthCheck.class);
	        for(Map.Entry<String,HealthCheck> entry : healthChecks.entrySet()) {
	            env.healthChecks().register("template", entry.getValue());
	}

	      //resources
	        Map<String, Object> resources = ctx.getBeansWithAnnotation(Path.class);
	        for(Map.Entry<String,Object> entry : resources.entrySet()) {
	            env.jersey().register(entry.getValue());
	}
	        
	        env.jersey().setUrlPattern("/api/*");

	        //last, but not least,let's link Spring to the embedded Jetty in Dropwizard
	        env.servlets().addServletListeners(new SpringContextLoaderListener(ctx));
	    //    configureCors(env);
	    
	    }
	    
	    private void configureCors(Environment environment) {
	        Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
	        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
	        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
	        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
	        filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
	        filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
	        filter.setInitParameter("allowCredentials", "true");
	}
}
