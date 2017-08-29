package com.sang.mhxy.tool.controller;

import com.sang.mhxy.tool.common.exception.ResultException;
import com.sang.mhxy.tool.common.model.Result;
import com.sang.mhxy.tool.model.param.FixedDamage;
import com.sang.mhxy.tool.service.FixedDamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/fixedDamage")
public class FixedDamageController {
    @Autowired
    FixedDamageService fixedDamageService;

    @GetMapping("/pt")
    public Result pt(FixedDamage fixedDamage) throws ResultException {
        return Result.ok().addData("damage", fixedDamageService.pt(fixedDamage));
    }

    @GetMapping("/wdd")
    public Result wdd(FixedDamage fixedDamage) throws ResultException {
        return Result.ok().addData("damage", fixedDamageService.wdd(fixedDamage));
    }

    @GetMapping("/ps")
    public Result ps(FixedDamage fixedDamage) throws ResultException {
        return Result.ok().addAllData(fixedDamageService.ps(fixedDamage));
    }

    @GetMapping("/df")
    public Result df(FixedDamage fixedDamage) throws ResultException {
        return Result.ok().addAllData(fixedDamageService.df(fixedDamage));
    }
}
