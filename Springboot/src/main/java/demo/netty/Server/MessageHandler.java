package demo.netty.Server;

import demo.netty.Handler.LoginHandler;
import demo.netty.Handler.ResponseHandler;
import demo.netty.Message.CommonResponse;
import demo.netty.Message.ConstantValue;
import demo.netty.Message.Message;
import demo.netty.Message.StateReponse;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MessageHandler extends  SimpleChannelInboundHandler<Message> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message message) throws Exception {
        handlerMessage(ctx.channel(), message);
    }

    private void handlerMessage(Channel channel, Message message){
        short agvId;
        int result;
        CommonResponse commonResponse;
        short msgType = message.getType();

        log.info("channel: " + channel.id() + " 消息类型: " + msgType);
        switch (msgType) {
            case ConstantValue.LOGIN:
                LoginHandler.login(channel,message);
                break;
            case ConstantValue.CONFIGREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("Config task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("Config task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            case ConstantValue.STATE:
                //回复小车
                ResponseHandler.ResSuccess(channel,message);

                StateReponse stateReponse = new StateReponse();
                stateReponse.readFromBytes(message.getData());
                //确定当前发送状态的小车
                short agvid = NettyChannelMap.getIdFromChannel(channel);

                //任务完成/空闲信息
                short task_id = stateReponse.getTask_id();
                byte sub_task_id = stateReponse.getSub_task_id();
                byte agv_status = stateReponse.getAgv_status();
                byte barrier_level = stateReponse.getBattery_level();

                //需要填写
                if((agv_status == 1 || agv_status == 4) && task_id != 0 && sub_task_id != 0){
                    log.info("AGV: " + agvid + " task_id: " + task_id + " sub_task_id: " + sub_task_id + " 任务已完成");
                }else{
                    log.info("AGV: " + agvid + " task_id: " + task_id + " sub_task_id: " + sub_task_id + " 任务执行中");
                }

                //位置信息
                int pos_x = stateReponse.getPos_x();
                int pos_y = stateReponse.getPos_y();
                short pos_theta = stateReponse.getPos_theta();
                log.info("AGV: " + agvid + " 当前坐标: (" + pos_x + "," + pos_y + ")" + " 角度：" + pos_theta);

                //实时线速度
                int vel = stateReponse.getVel();
                //旋转速度
                int rot_vel = stateReponse.getRot_vel();
                //线加速度
                int line_acc = stateReponse.getLine_acc();
                //旋转加速度
                int rot_acc = stateReponse.getRot_acc();
                //线减速度
                int line_dece = stateReponse.getLine_dece();
                log.info("AGV: " + agvid + " 实时线速度: " + vel + " 旋转速度: " + rot_vel + " 线加速度" + line_acc + " 旋转加速度" + rot_acc + " 线减速度" + line_dece);

                //获取执行机构状态索引
                byte actuator_idx = stateReponse.getActuator_idx();

                /*
                switch (actuator_idx){
                    case 0:
                        byte temperature = stateReponse.getActuator_status().getTemperature();
                        byte current = stateReponse.getActuator_status().getCurrent();
                        log.info("AGV" + agvid + "温度: " + temperature + "电流: " + current);
                    case 1:
                       byte roll_status = stateReponse.getActuator_status().getRoll_status();
                        log.info("AGV" + agvid + "辊筒状态： " + roll_status);
                    case 2:
                        byte io_in_out_status = stateReponse.getActuator_status().getIo_in_out_status();
                        log.info("AGV" + agvid + "IO电平状态: " + io_in_out_status);
                    case 3:
                        int pos_id_stat = stateReponse.getActuator_status().getPos_id_stat();
                        log.info("AGV" + agvid + "货架探测结果反馈: " + pos_id_stat);
                    case 4:
                        int pod_id = stateReponse.getActuator_status().getPod_id();
                        short pod_dir = stateReponse.getActuator_status().getPod_dir();
                        String pod_str = stateReponse.getActuator_status().getPod_str();
                        log.info("AGV" + agvid + "货架ID: " + pod_id + "货架方向: " + pod_dir + "货架编码：" + pod_str);
                }

                 */
                break;
            case ConstantValue.BASEMOVEREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("BASEMOVE task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("BASEMOVE task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            case ConstantValue.CURVEMOVEREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("CURVEMOVE task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("CURVEMOVE task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            case ConstantValue.AVOIDREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("AVOID task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("AVOID task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            case ConstantValue.POWERREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("POWER task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("POWER task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            case ConstantValue.CANCELREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("CANCEL task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("CANCEL task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            case ConstantValue.APPLY:
                ResponseHandler.ResSuccess(channel,message);
                break;
            case ConstantValue.UNLOCK:
                ResponseHandler.ResSuccess(channel,message);
                break;
            case ConstantValue.PODTASKREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("POD task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("POD task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            case ConstantValue.SORTFLIPREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("SORTFLIP task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("SORTFLIP task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            case ConstantValue.PODDETECTREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("PODDETECT task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("PODDETECT task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            case ConstantValue.SORTBELTREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("SORTBELT task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("SORTBELT task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            case ConstantValue.ROLLREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("ROLL task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("ROLL task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            case ConstantValue.IOACTREPLY:
                commonResponse = new CommonResponse();
                commonResponse.readFromBytes(message.getData());
                agvId = NettyChannelMap.getIdFromChannel(channel);
                result = commonResponse.getResult();
                if(result == 200)
                    log.info("IO task   " + "AGV ID : " + agvId + " Result : " + "Success");
                else
                    log.info("IO task   " + "AGV ID : " + agvId + " Result : " + "Fail");
                break;
            default:
                log.info("Accepted Unknown Message!!!");
                break;
        }

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        NettyChannelMap.removeChannel(channel);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        NettyChannelMap.removeChannel(ctx.channel());
        //关闭
        ctx.channel().close();
    }
}
