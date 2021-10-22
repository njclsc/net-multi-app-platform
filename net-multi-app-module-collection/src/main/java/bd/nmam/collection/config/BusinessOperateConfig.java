package bd.nmam.collection.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bd.nmam.collection.business.pojo.jiangxi.DevicePojo;
import bd.nmam.collection.config.channelinitializer.JXHttpBusinessInitializer;
import bd.nmam.collection.config.channelinitializer.JXTCPBusinessInitializer;
import io.netty.channel.ChannelInboundHandlerAdapter;

@Configuration
public class BusinessOperateConfig {
	//-----------------业务线程池------------------------
	@Value("${data.threadPool.corePoolSize}")
	private int corePoolSize;
	@Value("${data.threadPool.maximumPoolSize}")
    private int maximumPoolSize;
	@Value("${data.threadPool.keepAliveTim}")
    private long keepAliveTim;
	private static ThreadPoolExecutor threadPool;
	//-----------------业务数据处理------------------------
	//-----------------tcpServer------------------------
	@Value("#{'${business.tcpServer.allKeys}'.split(',')}")
	private String[] allKey;
	@Value("${business.tcpServer.usedKey}")
	private String usedKey;
	private static String _usedKey;
	//-----------------udp------------------------
	@Value("#{'${business.udp.allKeys}'.split(',')}")
	private String[] UdpAllKey;
	@Value("${business.udp.usedKey}")
	private String UdpUsedKey;
	private static String _UdpUsedKey;
	//-----------------http------------------------
	@Value("#{'${business.http.allKeys}'.split(',')}")
	private String[] httpAllKey;
	@Value("${business.http.usedKey}")
	private String httpUsedKey;
	private static String _httpUsedKey;
	
	@Bean(name = "initializers")
	public HashMap<String, ? extends ChannelInboundHandlerAdapter> initializers(){
		HashMap<String, ChannelInboundHandlerAdapter> initializers = new HashMap<>();
		//-----------------tcpServer------------------------
		{
			initializers.put(allKey[0].trim(), new JXTCPBusinessInitializer());
//			initializers.put(allKey[1].trim(), new T());
		}
		//-----------------udp------------------------
		{
//			initializers.put(UdpAllKey[0].trim(), new UDPChnnelinitializer());
//			initializers.put(UdpAllKey[1].trim(), new UT());
		}
		//-----------------http------------------------
		{
			initializers.put(httpAllKey[0].trim(), new JXHttpBusinessInitializer());
		}
		
		
		
		
		BusinessOperateConfig.set_usedKey(usedKey);
		BusinessOperateConfig.set_UdpUsedKey(UdpUsedKey);
		BusinessOperateConfig.set_httpUsedKey(httpUsedKey);
		return initializers;
	}
	@Bean(name = "threadPool")
	public ThreadPoolExecutor threadPoolConfig(){
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
				corePoolSize, maximumPoolSize, keepAliveTim, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(maximumPoolSize)
			);
		BusinessOperateConfig.setThreadPool(threadPool);
		return threadPool;
	}
	
	public static String get_UdpUsedKey() {
		return _UdpUsedKey;
	}
	public static void set_UdpUsedKey(String _UdpUsedKey) {
		BusinessOperateConfig._UdpUsedKey = _UdpUsedKey;
	}
	public static ThreadPoolExecutor getThreadPool() {
		return threadPool;
	}
	public static void setThreadPool(ThreadPoolExecutor threadPool) {
		BusinessOperateConfig.threadPool = threadPool;
	}
	public static String get_usedKey() {
		return _usedKey;
	}
	public String getUdpUsedKey() {
		return UdpUsedKey;
	}
	public void setUdpUsedKey(String udpUsedKey) {
		UdpUsedKey = udpUsedKey;
	}
	public static void set_usedKey(String _usedKey) {
		BusinessOperateConfig._usedKey = _usedKey;
	}
	public static String get_httpUsedKey() {
		return _httpUsedKey;
	}
	public static void set_httpUsedKey(String _httpUsedKey) {
		BusinessOperateConfig._httpUsedKey = _httpUsedKey;
	}
	
}
