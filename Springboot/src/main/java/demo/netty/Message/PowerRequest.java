package demo.netty.Message;

import demo.netty.serial.Serializer;

public class PowerRequest extends Serializer {
    private short agvid;
    private short task_id;
    private byte sub_task_id;
    private byte ctrl_type;
    private byte close_tm;
    private byte[] res = new byte[3];
    private int low_power_tm;
    private int discon_wakeup_time;

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

    public byte getClose_tm() {
        return close_tm;
    }

    public void setClose_tm(byte close_tm) {
        this.close_tm = close_tm;
    }

    public int getLow_power_tm() {
        return low_power_tm;
    }

    public void setLow_power_tm(int low_power_tm) {
        this.low_power_tm = low_power_tm;
    }

    public int getDiscon_wakeup_time() {
        return discon_wakeup_time;
    }

    public void setDiscon_wakeup_time(int discon_wakeup_time) {
        this.discon_wakeup_time = discon_wakeup_time;
    }

    public byte[] getRes() {
        return res;
    }

    public void setRes(byte[] res) {
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
        writeByte(close_tm);
        writeBytes(res);
        writeInt(low_power_tm);
        writeInt(discon_wakeup_time);
    }
}
