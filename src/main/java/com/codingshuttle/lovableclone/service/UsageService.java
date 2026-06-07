package com.codingshuttle.lovableclone.service;

import com.codingshuttle.lovableclone.dto.usage.PlanLimitResponse;
import com.codingshuttle.lovableclone.dto.usage.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsage();

    PlanLimitResponse getPlanLimit();
}
