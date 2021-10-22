package bd.nmam.collection.config.channelinitializer;

import bd.nmam.collection.business.coder.jiangxi.JSONDecoder;
import bd.nmam.collection.business.handler.jiangxi.JiangXiAlarmHander;
import bd.nmam.collection.business.handler.jiangxi.JiangXiCameraDataOperateHandler;
import bd.nmam.collection.business.handler.jiangxi.JiangXiDataHander;
import bd.nmam.collection.business.handler.jiangxi.JiangXiHeartHander;
import bd.nmam.collection.business.handler.jiangxi.JinagXiAxleTemperHumDataHandler;
import bd.nmam.collection.business.handler.jiangxi.ReciveCommandHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class JXTCPBusinessInitializer extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// TODO Auto-generated method stub
		ch.pipeline().addLast(new JSONDecoder())
			.addLast(new ReciveCommandHandler())
			.addLast(new JiangXiCameraDataOperateHandler())
			.addLast(new JiangXiHeartHander())
			.addLast(new JiangXiDataHander())
			.addLast(new JiangXiAlarmHander())
			.addLast(new JinagXiAxleTemperHumDataHandler());
	}

}
