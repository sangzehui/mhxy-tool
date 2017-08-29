package com.sang.mhxy.tool.service;

import com.sang.mhxy.tool.common.exception.ResultException;
import com.sang.mhxy.tool.consts.PetConst;
import org.springframework.stereotype.Service;

@Service
public class PetService {
    public int getUpgradeExp(Integer from, Integer to) throws ResultException {
        if (from == null || to == null)
            throw new ResultException("最小等级和最大等级不能为空");
        if (from < PetConst.LEVEL_MIN)
            throw new ResultException("低于最小等级");
        if (to > PetConst.LEVEL_MAX)
            throw new ResultException("超过最大等级");
        if (from > to)
            throw new ResultException("目标等级不能大于初始等级");
        return PetConst.EXP_ARRAY[to] - PetConst.EXP_ARRAY[from];
    }

}
