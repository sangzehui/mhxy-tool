package com.sang.mhxy.tool.service;

import com.sang.mhxy.tool.common.exception.ResultException;
import com.sang.mhxy.tool.model.param.FixedDamage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class FixedDamageService {
    public int pt(FixedDamage param) throws ResultException {
        int tuiyan = param.getJingmai() == FixedDamage.JING_MAI_TUI_YAN ? 50 : 0;
        int jieling = param.getJingmai() == FixedDamage.JING_MAI_JIE_LING ? (int) (param.getShanghai() * 0.24) : 0;
        int xiuLianCha = param.getFaxiu() - param.getFakang();
        double xs = param.getGeshu() == 6 ? 0.11 : 0.1;

        int r = 0;
        r += param.getJineng() * 3 + 50;
        r += (int) (param.getMinjie() * 0.7);
        r += jieling + param.getLingshi();
        r += param.getZuhe1() / 100.0 * param.getDengji();
        r += param.getZuhe2() / 100.0 * param.getDengji();
        r = (int) (r * ((11 - param.getGeshu()) * xs));
        r = (int) (r * (1 + param.getZhenfa() / 100.0));
        r = (int) (r * (1 + xiuLianCha * 0.02));
        r += xiuLianCha * 5;
        r += param.getFushi() * (1 + xiuLianCha * 0.02);
        r += tuiyan;
        r += param.getLinshifu();

        return r;
    }

    public int wdd(FixedDamage param) {
        int xiuLianCha = param.getFaxiu() - param.getFakang();

        int r = 0;
        r += param.getShanghai() * 0.125;
        r += param.getJineng() * 1.5 + 40;
        if (param.getJingmai() == FixedDamage.JING_MAI_ZHUI_HUN)
            r *= 2;
        r += param.getLingshi();
        r += (int) (param.getMinjie() * 0.7);
        r += param.getZuhe1() / 100.0 * param.getDengji();
        r += param.getZuhe2() / 100.0 * param.getDengji();
        r = (int) (r * ((11 - param.getGeshu()) * 0.1));
        r = (int) (r * (1 + param.getZhenfa() / 100.0));
        r = (int) (r * (1 + xiuLianCha * 0.02));
        r += xiuLianCha * 5;
        r += param.getFushi() * (1 + xiuLianCha * 0.02);
        r += param.getLinshifu();

        return r;
    }

    public Map<? extends String, ?> ps(FixedDamage param) {
        double xs = 100;
        if (param.getJineng() < 75)
            xs = 70;
        else if (param.getJineng() < 100)
            xs = 80;
        else if (param.getJineng() < 125)
            xs = 90;
        int xiuLianCha = param.getFaxiu() - param.getFakang();

        int r = 0;
        r += param.getJineng() * 2;
        r += (int) (param.getZongshang() / 3.0);
        r += param.getZuhe1() / 100.0 * param.getDengji();
        r += param.getZuhe2() / 100.0 * param.getDengji();
        r += param.getLingshi();
        if (param.getJingmai() == FixedDamage.JING_MAI_NIAN_FU)
            r += (int) (0.18 * param.getShanghai());

        int r2 = r;
        r2 *= (1 + param.getZhenfa() / 100.0);
        r2 += param.getFushi();
        r2 *= (1 + xiuLianCha * 0.02);
        r2 += xiuLianCha * 5;
        r2 += param.getLinshifu();
        r2 += param.getShanghai() / 2.0;

        r *= xs / 100.0;
        r *= (1 + param.getZhenfa() / 100.0);
        r += param.getFushi();
        r *= (1 + xiuLianCha * 0.02);
        r += xiuLianCha * 5;
        r += param.getLinshifu();

        Map<String, Object> m = new HashMap<>();
        m.put("damage", r);
        m.put("damage2", r2);
        return m;
    }

    public Map<? extends String,?> df(FixedDamage param) {
        int yexing = param.getJingmai() == FixedDamage.JING_MAI_YE_XING ? 50 : 0;
        int yanluo = param.getJingmai() == FixedDamage.JING_MAI_YAN_LUO ? (int) (param.getShanghai() * 0.15) : 0;
        int xiuLianCha = param.getFaxiu() - param.getFakang();

        int r = 0;
        r += param.getJineng() * 1.5 + 30;
        int r2 = (int) (r * 1.3);

        r += (param.getMinjie() * 0.35);
        r += param.getZuhe1() / 100.0 * param.getDengji();
        r += param.getZuhe2() / 100.0 * param.getDengji();
        r += param.getLingshi() * 0.5;
        r += yanluo;
        r *= (1 + param.getZhenfa() / 100.0);
        r += param.getFushi();
        r *= (1 + xiuLianCha * 0.02);
        r += xiuLianCha * 5;
        r += param.getLinshifu();

        r2 += (param.getMinjie() * 0.35);
        r2 += param.getZuhe1() / 100.0 * param.getDengji();
        r2 += param.getZuhe2() / 100.0 * param.getDengji();
        r2 += param.getLingshi() * 0.5;
        r2 += yanluo;
        r2 *= (1 + param.getZhenfa() / 100.0);
        r2 += param.getFushi();
        r2 *= (1 + xiuLianCha * 0.02);
        r2 += xiuLianCha * 5;
        r2 += param.getLinshifu();
        r2 += yexing;

        Map<String, Object> m = new HashMap<>();
        m.put("damage", r);
        m.put("damage2", r2);
        return m;
    }
}
