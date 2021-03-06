package bd.nmam.collection.business.task.jiangxi;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.collection.business.pojo.jiangxi.DevicePojo;
import bd.nmam.collection.config.BusinessOperateConfig;
import bd.nmam.collection.config.CommunicationConfig;
import bd.nmam.collection.util.jiangxi.JiangXIContainerUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

public class CommandSendTask implements Runnable{
	private Object msg;
	public CommandSendTask(ChannelHandlerContext ctx, Object msg){
		this.msg = msg;
	}
	public void run(){
		String data = (String)msg;
//		System.out.println(data);
		JSONObject jb = JSONObject.parseObject(data);
		DevicePojo dp = JiangXIContainerUtil.getDevices().get(jb.get("gID"));
		CommunicationConfig.getTcpService().getChannelFutures_clients().get(dp.getDev_target_ip() + ":" + dp.getDev_target_port())
			.get(dp.getDev_local_ip() + ":" + dp.getDev_local_port())
			.writeAndFlush(Unpooled.copiedBuffer(data.getBytes()));
//		System.out.println("---------->>>" + jb.toString());
	}
}
