package com.receipt.vault.jms;

public interface EventGateway {

    void sendEventInfo(String event);
}
