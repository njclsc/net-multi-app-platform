package bd.nmam.collection.business.handler.jiangxi;

import bd.nmam.collection.business.task.jiangxi.CommandSendTask;
import bd.nmam.collection.config.BusinessOperateConfig;
import bd.nmam.collection.config.CommunicationConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ReciveCommandHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		if(!CommunicationConfig.getTcpReciveCmdAddr().equals(ctx.channel().localAddress().toString().substring(1))){
			ctx.fireChannelRegistered();
		}
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		if(CommunicationConfig.getTcpReciveCmdAddr().equals(ctx.channel().localAddress().toString().substring(1))){
			BusinessOperateConfig.getThreadPool().execute(new CommandSendTask(ctx, msg));
		}else{
			ctx.fireChannelRead(msg);
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		CommunicationConfig.getTcpService().getChannelFutures_clients()
			.get(ctx.channel().localAddress().toString().substring(1))
			.put(ctx.channel().remoteAddress().toString().substring(1), ctx.channel());
	}

}
