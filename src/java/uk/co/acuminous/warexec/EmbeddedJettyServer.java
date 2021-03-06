/* 
 * See http://stackoverflow.com/questions/2458440/executable-war-file-that-starts-jetty-without-maven
 */

package uk.co.acuminous.warexec;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.*;

import java.net.URL;
import java.security.ProtectionDomain;
import org.mortbay.jetty.webapp.WebAppContext;

class EmbeddedJettyServer {
	
	public static void main(String[] args) throws Exception {
		
		int port = Integer.parseInt(System.getProperty("port", "8080"));
		Server server = new Server(port);
			
		ProtectionDomain domain = EmbeddedJettyServer.class.getProtectionDomain();
		URL location = domain.getCodeSource().getLocation();
		
		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/");
		webapp.setDescriptor(location.toExternalForm() + "/WEB-INF/web.xml");
		webapp.setServer(server);
		webapp.setWar(location.toExternalForm());
		
	    server.setHandler(webapp);
	    server.start();
	    server.join();
	}
}