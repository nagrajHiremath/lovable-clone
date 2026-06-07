package com.codingshuttle.lovableclone.service.impl;

import com.codingshuttle.lovableclone.dto.subscription.CheckoutRequest;
import com.codingshuttle.lovableclone.dto.subscription.CheckoutResponse;
import com.codingshuttle.lovableclone.dto.subscription.PortalResponse;
import com.codingshuttle.lovableclone.dto.subscription.SubscriptionResponse;
import com.codingshuttle.lovableclone.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    public SubscriptionResponse getMySubscription() {
        return null;
    }

    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest checkoutRequest) {
        return null;
    }

    public PortalResponse openCustomerPortal() {
        return null;
    }
}
