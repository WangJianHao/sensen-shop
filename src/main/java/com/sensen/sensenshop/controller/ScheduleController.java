package com.sensen.sensenshop.controller;

import cn.hutool.core.date.DatePattern;
import com.sensen.sensenshop.common.api.SenCommonResponse;
import com.sensen.sensenshop.common.utils.DateUtil;
import com.sensen.sensenshop.component.task.CronProcessJob;
import com.sensen.sensenshop.component.task.SendEmailJob;
import com.sensen.sensenshop.component.task.SendMessageJob;
import com.sensen.sensenshop.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description:
 * @author: sensen
 * @date: 2024/8/5 20:40
 */
@Api(tags = "ScheduleController", description = "定时任务调度相关接口")
@RestController
@AllArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private ScheduleService scheduleService;

    @ApiOperation("定时发送邮件")
    @PostMapping("/sendEmail")
    public SenCommonResponse<?> sendEmail(@RequestParam String startTime, @RequestParam String data) {
        Date date = DateUtil.parse(startTime, DatePattern.NORM_DATETIME_FORMAT);
        String jobName = scheduleService.scheduleFixTimeJob(SendEmailJob.class, date, data);
        return SenCommonResponse.success(jobName);
    }

    @ApiOperation("定时发送站内信")
    @PostMapping("/sendMessage")
    public SenCommonResponse<?>  sendMessage(@RequestParam String startTime, @RequestParam String data) {
        Date date = DateUtil.parse(startTime, DatePattern.NORM_DATETIME_FORMAT);
        String jobName = scheduleService.scheduleFixTimeJob(SendMessageJob.class, date, data);
        return SenCommonResponse.success(jobName);
    }

    @ApiOperation("通过CRON表达式调度任务")
    @PostMapping("/scheduleJob")
    public SenCommonResponse<?>  scheduleJob(@RequestParam String cron, @RequestParam String data) {
        String jobName = scheduleService.scheduleJob(CronProcessJob.class, cron, data);
        return SenCommonResponse.success(jobName);
    }

    @ApiOperation("取消定时任务")
    @PostMapping("/cancelScheduleJob")
    public SenCommonResponse<?>  cancelScheduleJob(@RequestParam String jobName) {
        Boolean success = scheduleService.cancelScheduleJob(jobName);
        return SenCommonResponse.success(success);
    }
}
