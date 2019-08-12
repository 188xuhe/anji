package demo.netty.Coder;

import demo.netty.Message.ConstantValue;
import demo.netty.Message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 数据包解码器
 * <pre>
 * 数据包格式
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+——-----——+——---  --——+——----    -——+——-----— --—+
 * |  头标识|  报文长度   |  消息类型  |   消息序号 |  协议版本号 |  加密类型   |  保留字节   |    数据     |
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+——-----——+——---  --——+——---- ----——+——--------——+
 * </pre>
 * 头标识4字节 "HKP$"
 * 长度2字节
 * 消息类型2字节
 * 消息序号4字节
 * 协议版本号1字节
 * 加密类型1字节
 * 保留字节2字节
 *
 */
public class MessageDecoder extends ByteToMessageDecoder {
	
	/**
	 * 数据包基本长度
	 */
	public static int BASE_LENTH = 4 + 2 + 2 + 4 + 1 + 1 + 2;

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
		
		while(true){
			if(buffer.readableBytes() >= BASE_LENTH){
				//防止socket字节流攻击
				if(buffer.readableBytes()>2048){
					buffer.skipBytes(buffer.readableBytes());
				}

				//第一个可读数据包的起始位置
				int beginIndex;
				
				while(true) {
					//包头开始游标点
					beginIndex = buffer.readerIndex();
					//标记初始读游标位置
					buffer.markReaderIndex();
					if (buffer.readInt() == ConstantValue.HEADER_FLAG) {
						break;
					}
					//未读到包头标识略过一个字节
					buffer.resetReaderIndex();
					buffer.readByte();
					
					//不满足
					if(buffer.readableBytes() < BASE_LENTH){
						return ;
					}
				}
				//读取报文消息头
				short length = buffer.readShort();
				if(length < 0 ){
					ctx.channel().close();
				}
				short type = buffer.readShort();
				//System.out.println("type:" + type);
				int serial = buffer.readInt();
				//System.out.println("serial:" + serial);
				byte version = buffer.readByte();
				byte secType = buffer.readByte();
				short remain = buffer.readShort();
				
				//数据包还没到齐
				if(buffer.readableBytes() < length - 16){
					buffer.readerIndex(beginIndex);
					return ;
				}
				
				//读数据部分
				byte[] data = new byte[length-16];
				buffer.readBytes(data);
				/*
				System.out.print("\n");
				String res = "";
				for(byte i : data){
					res = res + Integer.toHexString(i) + " ";
			    }
				System.out.println("data:" + res);
				*/

				Message message = new Message();
				message.setLen(length);
				message.setType(type);
				message.setSerial(serial);
				message.setVersion(version);
				message.setSecType(secType);
				message.setRemain(remain);
				message.setData(data);
				//解析出消息对象，继续往下面的handler传递
				out.add(message);
			}else{
				break;
			}
		}
		
		//数据不完整，等待完整的数据包
		return;
	}
}
