package bd.nmam.collection.business.pojo;

import java.util.HashMap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

public class CommunicationPojo {

	private String type;
	private String key;
	//tcp服务端口
	private HashMap<String, ChannelFuture> channelFutures = new HashMap<String, ChannelFuture>();
	//tcp服务端口连接的客户端
	private HashMap<String, HashMap<String, Channel>> channelFutures_clients = new HashMap<String, HashMap<String, Channel>>();
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public HashMap<String, ChannelFuture> getChannelFutures() {
		return channelFutures;
	}
	public void setChannelFutures(HashMap<String, ChannelFuture> channelFutures) {
		this.channelFutures = channelFutures;
	}
	public HashMap<String, HashMap<String, Channel>> getChannelFutures_clients() {
		return channelFutures_clients;
	}
	public void setChannelFutures_clients(HashMap<String, HashMap<String, Channel>> channelFutures_clients) {
		this.channelFutures_clients = channelFutures_clients;
	}
	
	
	
}
