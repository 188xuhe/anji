package demo.netty.Handler;

import demo.netty.Message.CommonResponse;
import demo.netty.Message.ConstantValue;
import demo.netty.Message.Message;
import io.netty.channel.Channel;

public class ResponseHandler {

    public static void ResSuccess(Channel channel, Message message) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(ConstantValue.SUCCESS);
        commonResponse.setErrCode((byte) 0);
        commonResponse.setLast(new byte[3]);

        Message response = new Message();
        response.setSerial(message.getSerial());
        response.setType((short) (message.getType() + 1));
        response.setData(commonResponse.getBytes());
        response.setLen(response.getLength());

        channel.writeAndFlush(response);
    }

    public static void ResFail(Channel channel, Message message) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(ConstantValue.FAIL);
        commonResponse.setErrCode((byte) 0);
        commonResponse.setLast(new byte[3]);

        Message response = new Message();
        response.setSerial(message.getSerial());
        response.setType((short) (message.getType() + 1));
        response.setData(commonResponse.getBytes());
        response.setLen(response.getLength());

        channel.writeAndFlush(response);
    }




}
