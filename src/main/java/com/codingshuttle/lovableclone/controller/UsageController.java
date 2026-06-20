package com.codingshuttle.lovableclone.controller;

import com.codingshuttle.lovableclone.dto.usage.PlanLimitResponse;
import com.codingshuttle.lovableclone.dto.usage.UsageTodayResponse;
import com.codingshuttle.lovableclone.service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")
public class UsageController {
  private final UsageService usageService;

  @GetMapping
  public ResponseEntity<UsageTodayResponse> getTodayUsage() {
    return ResponseEntity.ok(usageService.getTodayUsage());
  }

  @GetMapping("/planLimit")
  public ResponseEntity<PlanLimitResponse> getPlanLimit() {
    return ResponseEntity.ok(usageService.getPlanLimit());
  }
}
