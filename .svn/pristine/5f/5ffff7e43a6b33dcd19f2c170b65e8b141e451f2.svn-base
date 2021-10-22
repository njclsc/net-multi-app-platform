package bd.nmam.bridge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BridgeConfig {

	private static String targetIp;
	private static int targetPort;
	private static int CONNECT_TIME_OUT;
	private static int CONNECT_REQUEST_TIME_OUT;
	private static int SOCKET_TIME_OUT;
	
	@Bean
	public Object loadConfig(@Value("${bridge.targetIp}")String targetIp, 
				@Value("${bridge.targetPort}") int targetPort,
				@Value("${bridge.connectTimeOut}") int CONNECT_TIME_OUT,
				@Value("${bridge.connectionRequestTimeOut}") int CONNECT_REQUEST_TIME_OUT,
				@Value("${bridge.socketTimeOut}") int SOCKET_TIME_OUT){
		BridgeConfig.setTargetIp(targetIp);
		BridgeConfig.setTargetPort(targetPort);
		BridgeConfig.setCONNECT_TIME_OUT(CONNECT_TIME_OUT);
		BridgeConfig.setCONNECT_REQUEST_TIME_OUT(CONNECT_REQUEST_TIME_OUT);
		BridgeConfig.setSOCKET_TIME_OUT(SOCKET_TIME_OUT);
		return null;
	}

	public static String getTargetIp() {
		return targetIp;
	}

	public static void setTargetIp(String targetIp) {
		BridgeConfig.targetIp = targetIp;
	}

	public static int getTargetPort() {
		return targetPort;
	}

	public static int getCONNECT_TIME_OUT() {
		return CONNECT_TIME_OUT;
	}

	public static void setCONNECT_TIME_OUT(int cONNECT_TIME_OUT) {
		CONNECT_TIME_OUT = cONNECT_TIME_OUT;
	}

	public static int getCONNECT_REQUEST_TIME_OUT() {
		return CONNECT_REQUEST_TIME_OUT;
	}

	public static void setCONNECT_REQUEST_TIME_OUT(int cONNECT_REQUEST_TIME_OUT) {
		CONNECT_REQUEST_TIME_OUT = cONNECT_REQUEST_TIME_OUT;
	}

	public static int getSOCKET_TIME_OUT() {
		return SOCKET_TIME_OUT;
	}

	public static void setSOCKET_TIME_OUT(int sOCKET_TIME_OUT) {
		SOCKET_TIME_OUT = sOCKET_TIME_OUT;
	}

	public static void setTargetPort(int targetPort) {
		BridgeConfig.targetPort = targetPort;
	}
	
	
}
