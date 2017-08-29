package com.sang.mhxy.tool.service;

import com.sang.mhxy.tool.common.exception.ResultException;
import com.sang.mhxy.tool.consts.PersonConst;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonService {
    public String getUpgradeExp(Integer from, Integer to) throws ResultException {
        if (from == null || to == null)
            throw new ResultException("最小等级和最大等级不能为空");
        if (from < 0)
            throw new ResultException("低于最小等级");
        if (to > PersonConst.EXP_LIST.size())
            throw new ResultException("超过最大等级");
        if (from > to)
            throw new ResultException("目标等级不能大于初始等级");
        BigInteger b1 = new BigInteger(PersonConst.EXP_LIST.get(from));
        BigInteger b2 = new BigInteger(PersonConst.EXP_LIST.get(to));
        return b2.subtract(b1).toString();
    }

    public Map<String, Object> getUpgradePractice(Integer from, Integer to) throws ResultException {
        if (from == null || to == null)
            throw new ResultException("最小等级和最大等级不能为空");
        if (from < PersonConst.PRACTICE_LEVEL_MIN)
            throw new ResultException("低于最小等级");
        if (to > PersonConst.PRACTICE_LEVEL_MAX)
            throw new ResultException("超过最大等级");
        if (from > to)
            throw new ResultException("目标等级不能大于初始等级");
        Map<String, Object> result = new HashMap<>();
        int exp = PersonConst.PRACTICE_EXP_ARRAY[to] - PersonConst.PRACTICE_EXP_ARRAY[from];
        result.put("money1", exp / 10 * 30000);
        result.put("money2", exp / 10 * 20000);
        result.put("level", to * 5 + 20);
        result.put("contribution", to * 150);
        result.put("material", exp * 0.5);
        result.put("exp", exp);
        return result;
    }
}
