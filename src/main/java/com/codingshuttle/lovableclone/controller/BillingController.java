package com.codingshuttle.lovableclone.controller;

import com.codingshuttle.lovableclone.dto.plan.PlanResponse;
import com.codingshuttle.lovableclone.dto.subscription.CheckoutRequest;
import com.codingshuttle.lovableclone.dto.subscription.CheckoutResponse;
import com.codingshuttle.lovableclone.dto.subscription.PortalResponse;
import com.codingshuttle.lovableclone.dto.subscription.SubscriptionResponse;
import com.codingshuttle.lovableclone.service.PlanService;
import com.codingshuttle.lovableclone.service.SubscriptionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/billing")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BillingController {
    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/plan")
    public ResponseEntity<List<PlanResponse>> getPlans(){
        return ResponseEntity.ok(planService.getPlans());
    }
    @GetMapping("subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription(){
        return ResponseEntity.ok(subscriptionService.getMySubscription());
    }
    @PostMapping("checkout")
    public ResponseEntity<CheckoutResponse> createCheckOutResponse(CheckoutRequest checkoutRequest){
        return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(checkoutRequest));
    }
    @PostMapping("stripePortal")
    public ResponseEntity<PortalResponse> openCustomerPortal(){
        return ResponseEntity.ok(subscriptionService.openCustomerPortal());
    }
}
