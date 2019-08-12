package demo.netty.Coder;
import demo.netty.Message.ConstantValue;
import demo.netty.Message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * <pre>
 * 数据包格式
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+——-----——+——---  --——+——----    -——+——-----— --—+
 * |  头标识	|  报文长度   |  消息类型  |   消息序号 |  协议版本号 |  加密类型   |  保留字节   |    数据     |
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

public class MessageEncoder extends MessageToByteEncoder<Message>{

	@Override
	protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf buffer) throws Exception {

		//包头
		buffer.writeInt(ConstantValue.HEADER_FLAG);
		//长度
		int lenth = message.getData()==null? 16 : message.getData().length + 16;
		buffer.writeShort(lenth);

		buffer.writeShort(message.getType());
		buffer.writeInt(message.getSerial());
		buffer.writeByte(message.getVersion());
		buffer.writeByte(message.getSecType());
		buffer.writeShort(message.getRemain());

		//data
		buffer.writeBytes(message.getData());

	}
}
