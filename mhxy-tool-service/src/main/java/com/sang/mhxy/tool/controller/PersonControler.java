package com.sang.mhxy.tool.controller;

import com.sang.mhxy.tool.common.exception.ResultException;
import com.sang.mhxy.tool.common.model.Result;
import com.sang.mhxy.tool.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/person")
public class PersonControler {
    @Autowired
    PersonService personService;

    @GetMapping("/upgradeExp")
    public Result upgradeExp(Integer from, Integer to) throws ResultException {
        return Result.ok().addData("exp", personService.getUpgradeExp(from, to));
    }

    @GetMapping("/upgradePractice")
    public Result upgradePractice(Integer from, Integer to) throws ResultException {
        return Result.ok().addAllData(personService.getUpgradePractice(from, to));
    }
}
