package demo.netty.Message;

import demo.netty.serial.Serializer;

public class ChargeRequest extends Serializer {
    private short agvid;
    private short task_id;
    private byte sub_task_id;
    private byte chg_act;
    private byte chg_tm;
    private byte[] res1 = new byte[3];
    private int pos_x;
    private int pos_y;
    private short pos_theta;
    private byte barrier_level;
    private byte res = 0;
    private int max_vel;

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


    public byte getChg_act() {
        return chg_act;
    }

    public void setChg_act(byte chg_act) {
        this.chg_act = chg_act;
    }

    public byte getChg_tm() {
        return chg_tm;
    }

    public void setChg_tm(byte chg_tm) {
        this.chg_tm = chg_tm;
    }

    public byte[] getRes1() {
        return res1;
    }

    public void setRes1(byte[] res1) {
        this.res1 = res1;
    }
    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public short getPos_theta() {
        return pos_theta;
    }

    public void setPos_theta(short pos_theta) {
        this.pos_theta = pos_theta;
    }

    public byte getBarrier_level() {
        return barrier_level;
    }

    public void setBarrier_level(byte barrier_level) {
        this.barrier_level = barrier_level;
    }

    public byte getRes() {
        return res;
    }

    public void setRes(byte res) {
        this.res = res;
    }

    public int getMax_vel() {
        return max_vel;
    }

    public void setMax_vel(int max_vel) {
        this.max_vel = max_vel;
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
        writeByte(chg_act);
        writeByte(chg_tm);
        writeBytes(res1);
        writeInt(pos_x);
        writeInt(pos_y);
        writeShort(pos_theta);
        writeByte(barrier_level);
        writeByte(res);
        writeInt(max_vel);
    }
}
