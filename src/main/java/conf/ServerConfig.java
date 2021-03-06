package conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * Conf technique de l'application
 *
 * @author antoine.ansel-ext
 */
@Component
@ConfigurationProperties()
public class ServerConfig {


	public static class Server {
		private int port;

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}
	}

	public static class Management {
		private int port;

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}
	}

	private Server server;

	private Management management;

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Management getManagement() {
		return management;
	}

	public void setManagement(Management management) {
		this.management = management;
	}


}
