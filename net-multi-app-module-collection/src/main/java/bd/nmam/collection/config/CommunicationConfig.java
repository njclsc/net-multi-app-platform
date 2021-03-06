package bd.nmam.collection.config;

import java.net.InetSocketAddress;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bd.nmam.collection.business.pojo.CommunicationPojo;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

@Configuration
public class CommunicationConfig {
	//---------------tcpserver---------------
	@Value("${communication.tcp.server.used}")
	private boolean tcpServer;
	@Value("${communication.tcp.server.tcpServerBacklog}")
	private int tcpServerBacklog;
	@Value("${communication.tcp.server.tcpBufMin}")
	private int tcpBufMin;
	@Value("${communication.tcp.server.tcpBufInit}")
	private int tcpBufInit;
	@Value("${communication.tcp.server.tcpBufMax}")
	private int tcpBufMax;
	@Value("#{'${communication.tcp.server.serverAddress}'.split(',')}")
	private String[] serverAddress;
	//tcp指令接受端口
	private static String tcpReciveCmdAddr;
	//---------------udp---------------
	@Value("${communication.udp.used}")
	private boolean udp;
	@Value("${communication.udp.udpBufMin}")
	private int udpBufMin;
	@Value("${communication.udp.udpBufInit}")
	private int udpBufInit;
	@Value("${communication.udp.udpBufMax}")
	private int udpBufMax;
	@Value("#{'${communication.udp.udpAddress}'.split(',')}")
	private String[] udpAddress;
	//---------------http---------------
	@Value("${communication.http.used}")
	private boolean http;
	@Value("${communication.http.httpBufMin}")
	private int httpBufMin;
	@Value("${communication.http.httpBufInit}")
	private int httpBufInit;
	@Value("${communication.http.httpBufMax}")
	private int httpBufMax;
	@Value("#{'${communication.http.httpAddress}'.split(',')}")
	private String[] httpAddress;
	//----------------------------------
	private static CommunicationPojo tcpService;
	@Autowired
	@Qualifier("initializers")
	private HashMap<String, ? extends ChannelInboundHandlerAdapter> initializers;
	
	@Bean(name = "tcpServer")
	public CommunicationPojo loadCommunicationConfigInfoForTcpServer(){
		CommunicationPojo cp = null;
		if(tcpServer){
			cp = new CommunicationPojo();
			cp.setType("tcpServer");
			EventLoopGroup boss = new NioEventLoopGroup();
			EventLoopGroup work = new NioEventLoopGroup();
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(boss, work).channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, tcpServerBacklog)
				.childOption(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(tcpBufMin, tcpBufInit, tcpBufMax))
				.childHandler(initializers.get(BusinessOperateConfig.get_usedKey()));
			for(String s : serverAddress){
				try{
					String[] address = s.split(":");
					String ip = address[0].trim();
					int port = Integer.parseInt(address[1].trim());
					ChannelFuture channelFuture = bootstrap.bind(new InetSocketAddress(ip, port));
					cp.setKey(ip + ":" + port);
					cp.getChannelFutures().put(ip + ":" + port, channelFuture);
					cp.getChannelFutures_clients().put(ip + ":" + port, new HashMap<String, Channel>());
					CommunicationConfig.setTcpReciveCmdAddr(s);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			CommunicationConfig.setTcpService(cp);
			return cp;
		}else{
			CommunicationConfig.setTcpService(cp);
			return cp;
		}
	}
	@Bean(name = "udp")
	public CommunicationPojo loadCommunicationConfigInfoForUDP(){
		CommunicationPojo cp = null;
		if(udp){
			cp = new CommunicationPojo();
			cp.setType("udp");
			EventLoopGroup work = new NioEventLoopGroup();
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(work).channel(NioDatagramChannel.class)
				.option(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(udpBufMin, udpBufInit, udpBufMax))
				.handler(initializers.get(BusinessOperateConfig.get_UdpUsedKey()));
			for(String s : udpAddress){
				try{
					String[] address = s.split(":");
					String ip = address[0].trim();
					int port = Integer.parseInt(address[1].trim());
					ChannelFuture channelFuture = bootstrap.bind(new InetSocketAddress(ip, port));
					cp.setKey(ip + ":" + port);
					cp.getChannelFutures().put(ip + ":" + port, channelFuture);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return cp;
		}else{
			return cp;
		}
	}
	@Bean(name = "http")
	public CommunicationPojo loadCommunicationConfigInfoForHTTP(){
		CommunicationPojo cp = null;
		if(http){
			cp = new CommunicationPojo();
			cp.setType("http");
			EventLoopGroup boss = new NioEventLoopGroup();
			EventLoopGroup work = new NioEventLoopGroup();
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(boss, work).channel(NioServerSocketChannel.class)
				.option(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(httpBufMin, httpBufInit, httpBufMax))
				.childHandler(initializers.get(BusinessOperateConfig.get_httpUsedKey()));
			for(String s : httpAddress){
				try{
					String[] address = s.split(":");
					String ip = address[0].trim();
					int port = Integer.parseInt(address[1].trim());
					ChannelFuture channelFuture = bootstrap.bind(new InetSocketAddress(ip, port));
					cp.setKey(ip + ":" + port);
					cp.getChannelFutures().put(ip + ":" + port, channelFuture);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return cp;
		}else{
			return cp;
		}
	}
	public static String getTcpReciveCmdAddr() {
		return tcpReciveCmdAddr;
	}
	public static void setTcpReciveCmdAddr(String tcpReciveCmdAddr) {
		CommunicationConfig.tcpReciveCmdAddr = tcpReciveCmdAddr;
	}
	public static CommunicationPojo getTcpService() {
		return tcpService;
	}
	public static void setTcpService(CommunicationPojo tcpService) {
		CommunicationConfig.tcpService = tcpService;
	}
}
