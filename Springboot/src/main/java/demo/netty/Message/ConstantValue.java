package demo.netty.Message;

public class ConstantValue<STANDARD_TASK_STATUS_FINISH> {
    public static final int HEADER_FLAG = 0x484B5024; // "HKP$"

    public static final int SUCCESS = 200;
    public static final int FAIL = 201;

    public static final short LOGIN = 0x0001;
    public static final short LOGINPEPLY = 0x0002;
    public static final short CONFIG = 0x0003;
    public static final short CONFIGREPLY= 0x0004;
    public static final short STATE = 0x0005;
    public static final short STATEREPLY = 0x0006;

    public static final short BASEMOVE= 0x0010;
    public static final short BASEMOVEREPLY = 0x0011;
    public static final short CURVEMOVE= 0x0012;
    public static final short CURVEMOVEREPLY = 0x00013;
    public static final short AVOID = 0x0014;
    public static final short AVOIDREPLY = 0x0015;
    public static final short CHARGE = 0x0016;
    public static final short CHARGEREPLY = 0x0017;
    public static final short POWER = 0x0018;
    public static final short POWERREPLY = 0x0019;

    public static final short CANCEL= 0x0020;
    public static final short CANCELREPLY = 0x0021;

    public static final short APPLY = 0x0030;
    public static final short APPLYREPLY = 0x0031;
    public static final short UNLOCK = 0x0032;
    public static final short UNLOCKREPLY = 0x0033;

    public static final short PODTASK = 0x0040;
    public static final short PODTASKREPLY = 0x0041;

    public static final short SORTFLIP = 0x0050;
    public static final short SORTFLIPREPLY = 0x0051;
    public static final short PODDETECT = 0x0052;
    public static final short PODDETECTREPLY = 0x0053;

    public static final short  SORTBELT= 0x0060;
    public static final short SORTBELTREPLY = 0x0061;

    public static final short ROLL = 0x0070;
    public static final short ROLLREPLY = 0x0071;

    public static final short IOACT = 0X0080;
    public static final short IOACTREPLY = 0x0081;

    //agv 实时状态
    public byte STANDARD_TASK_STATUS_FINISH                    = 1;            ///< 任务完成
    public byte STANDARD_TASK_STATUS_RUNNING                   = 2;            ///< 任务执行中
    public byte STANDARD_TASK_STATUS_EXCEPTION                 = 3;            ///< 任务异常
    public byte STANDARD_TASK_STATUS_IDLE                      = 4;            ///< 任务空闲


}
