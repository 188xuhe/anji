package demo.netty.Message;

import demo.netty.serial.Serializer;

public class CurveMoveRequest extends Serializer {
    private short agvid;
    private  short task_id;
    private byte sub_task_id;
    //最大为3
    private byte curve_num;
    //最终目标点
    private byte[] target_param = new byte[16];
    //对应于curve_num个目标参数
    private byte[] curve_target_param = new byte[48];

    public short getTask_id(){
        return task_id;
    }

    public void setTask_id(short task_id) {
        this.task_id = task_id;
    }

    public byte getSub_task_id() {
        return sub_task_id;
    }

    public void setSub_task_id(byte sub_task_id) {
        this.sub_task_id = sub_task_id;
    }

    public byte getCurve_num() {
        return curve_num;
    }

    public void setCurve_num(byte curve_num) {
        this.curve_num = curve_num;
    }

    public byte[] getTarget_param() {
        return target_param;
    }

    public void setTarget_param(byte[] target_param) {
        this.target_param = target_param;
    }

    public byte[] getCurve_target_param() {
        return curve_target_param;
    }

    public void setCurve_target_param(byte[] curve_target_param) {
        this.curve_target_param = curve_target_param;
    }
    public void setAgvid(short agvid) {
        this.agvid = agvid;
    }

    public short getAgvid() {
        return agvid;
    }


    @Override
    protected void read() {

    }

    @Override
    protected void write() {
        writeShort(task_id);
        writeByte(sub_task_id);
        writeByte(curve_num);
        writeBytes(target_param);
        writeBytes(curve_target_param);
    }
}
