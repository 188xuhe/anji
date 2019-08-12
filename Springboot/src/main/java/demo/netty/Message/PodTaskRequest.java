package demo.netty.Message;

import demo.netty.serial.Serializer;

public class PodTaskRequest extends Serializer {

    private short agvid;
    private short task_id;
    private byte sub_task_id;
    private byte ctrl_type;
    private int pos_x;
    private int pos_y;
    private short pos_theta;
    private byte barrier_level;
    private byte res = 0;
    private int max_vel;
    private int pod_id;
    private short pod_dir;
    private short run_pod_dir;
    private byte no_adjust;
    private byte pod_type;
    private short res1;
    private String pod_str;

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

    public void setCtrl_type(byte ctrl_type) {
        this.ctrl_type = ctrl_type;
    }

    public byte getCtrl_type() {
        return ctrl_type;
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

    public int getPod_id() {
        return pod_id;
    }

    public void setPod_id(int pod_id) {
        this.pod_id = pod_id;
    }

    public short getPod_dir() {
        return pod_dir;
    }

    public void setPod_dir(short pod_dir) {
        this.pod_dir = pod_dir;
    }

    public void setRes1(short res1) {
        this.res1 = res1;
    }

    public short getRes1() {
        return res1;
    }

    public byte getNo_adjust() {
        return no_adjust;
    }

    public void setNo_adjust(byte no_adjust) {
        this.no_adjust = no_adjust;
    }

    public byte getPod_type() {
        return pod_type;
    }

    public void setPod_type(byte pod_type) {
        this.pod_type = pod_type;
    }

    public String getPod_str() {
        return pod_str;
    }

    public void setPod_str(String pod_str) {
        this.pod_str = pod_str;
    }

    public short getRun_pod_dir() {
        return run_pod_dir;
    }

    public void setRun_pod_dir(short run_pod_dir) {
        this.run_pod_dir = run_pod_dir;
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
        writeInt(pos_x);
        writeInt(pos_y);
        writeShort(pos_theta);
        writeByte(barrier_level);
        writeByte(res);
        writeInt(max_vel);
        writeInt(pod_id);
        writeShort(pod_dir);
        writeShort(run_pod_dir);
        writeByte(no_adjust);
        writeByte(pod_type);
        writeShort(res1);
        writeString(pod_str,32);
    }
}
