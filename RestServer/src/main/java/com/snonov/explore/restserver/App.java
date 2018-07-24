package com.snonov.explore.restserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		Server server = new Server(8080);

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        servletContextHandler.setContextPath("/");
        server.setHandler(servletContextHandler);

        ServletHolder servletHolder = servletContextHandler.addServlet(ServletContainer.class, "/api/*");
        servletHolder.setInitOrder(0);
        servletHolder.setInitParameter("jersey.config.server.provider.packages","com.snonov.explore.restserver.restproduce"
        );

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
        	LOGGER.error("Error occurred while starting Jetty", ex);
            System.exit(1);
        }

        finally {
            server.destroy();
        }
	}

}
