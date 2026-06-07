package com.codingshuttle.lovableclone.service;

import com.codingshuttle.lovableclone.dto.subscription.CheckoutRequest;
import com.codingshuttle.lovableclone.dto.subscription.CheckoutResponse;
import com.codingshuttle.lovableclone.dto.subscription.PortalResponse;
import com.codingshuttle.lovableclone.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getMySubscription();

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest checkoutRequest);

    PortalResponse openCustomerPortal();
}
