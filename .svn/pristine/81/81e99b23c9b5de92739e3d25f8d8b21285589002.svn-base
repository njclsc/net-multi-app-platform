package bd.nmam.collection.business.handler.jiangxi;

import bd.nmam.collection.business.task.jiangxi.AlarmHandlerThread;
import bd.nmam.collection.config.BusinessOperateConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class JiangXiAlarmHander extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		BusinessOperateConfig.getThreadPool().execute(new AlarmHandlerThread(ctx, msg));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		cause.printStackTrace();
	}

}
