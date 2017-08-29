package com.sang.mhxy.tool.consts;

import com.sang.mhxy.tool.util.FileUtil;

import java.util.List;

public class PersonConst {
    public static List<String> EXP_LIST;

    public static int[] PRACTICE_EXP_ARRAY = new int[]{
            0, 150, 360, 650, 1040, 1550, 2200, 3010, 4000, 5190, 6600,
            8250, 10160, 12350, 14840, 17650, 20800, 24310, 28200, 32490, 37200,
            42350, 47960, 54050, 60640, 67750
    };
    public static int PRACTICE_LEVEL_MAX = PRACTICE_EXP_ARRAY.length - 1;
    public static int PRACTICE_LEVEL_MIN = 0;

    static {
        initData();
    }

    private static void initData() {
        EXP_LIST = FileUtil.getListFromFile("/data/mhxy/personExp");
    }

}
