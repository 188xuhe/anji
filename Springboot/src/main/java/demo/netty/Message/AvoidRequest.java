package demo.netty.Message;

import demo.netty.serial.Serializer;

public class AvoidRequest extends Serializer {
    private short agvid;
    private short task_id;
    private byte sub_task_id;

    //避障开关， 0:关闭， 1:开启
    private byte bar_switch;

    //避障方案， 0:业务避障， 1:人车混行避障
    private byte avoid_sche;

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

    public byte getBar_switch() {
        return bar_switch;
    }

    public void setBar_switch(byte bar_switch) {
        this.bar_switch = bar_switch;
    }

    public byte getAvoid_sche() {
        return avoid_sche;
    }

    public void setAvoid_sche(byte avoid_sche) {
        this.avoid_sche = avoid_sche;
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
        writeByte(bar_switch);
        writeByte(avoid_sche);
        writeShort(res);
    }
}
