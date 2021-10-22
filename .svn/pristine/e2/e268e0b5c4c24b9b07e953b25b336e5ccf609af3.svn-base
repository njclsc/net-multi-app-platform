package bd.nmam.collection.business.coder.jiangxi;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import bd.nmam.collection.config.Configuer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class JSONDecoder extends ByteToMessageDecoder{
	StringBuffer buffer = new StringBuffer();
	int bufferTime = 0;
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		// TODO Auto-generated method stub
		int len = in.readableBytes();
		byte[] bits = new byte[len];
		in.readBytes(bits);
		if((bits[0] & 0xFF) == 0x7B && (bits[len - 1] & 0xFF) == 0x7D){
			for(byte b : bits){
				buffer.append((char)b);
			}
			out.add(buffer.toString());
			buffer.delete(0, buffer.length());
			bufferTime = 0;
		}else{
			bufferTime += 1;
			for(byte b : bits){
				buffer.append((char)b);
			}
			if((bits[len - 1] & 0xFF) == 0x7D && buffer.toString().substring(0, 1).equals("{")){
				out.add(buffer.toString());
				buffer.delete(0, buffer.length());
				bufferTime = 0;
			}else if(bufferTime == 2){
				buffer.delete(0, buffer.length());
				bufferTime = 0;
			}
			
		}
	}

}

