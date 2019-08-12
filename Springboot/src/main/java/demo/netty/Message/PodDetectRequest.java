package demo.netty.Message;

import demo.netty.serial.Serializer;

public class PodDetectRequest extends Serializer {
    private short agvid;
    private short task_id;
    private byte sub_task_id;
    private byte ctrl_type;
    private short res;


    public short getTask_id() {
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

    public byte getCtrl_type() {
        return ctrl_type;
    }

    public void setCtrl_type(byte ctrl_type) {
        this.ctrl_type = ctrl_type;
    }

    public short getRes() {
        return res;
    }

    public void setRes(short res) {
        this.res = res;
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
        writeByte(ctrl_type);
        writeShort(agvid);
        writeShort(res);
    }
}
