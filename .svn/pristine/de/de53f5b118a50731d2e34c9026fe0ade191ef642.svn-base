package bd.nmam.collection.business.handler.jiangxi;

import bd.nmam.collection.business.task.jiangxi.OperateHeartTask;
import bd.nmam.collection.config.BusinessOperateConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class JiangXiHeartHander extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		BusinessOperateConfig.getThreadPool().execute(new OperateHeartTask(ctx, msg));
	}

}
