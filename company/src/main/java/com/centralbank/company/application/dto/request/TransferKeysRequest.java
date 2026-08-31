package com.centralbank.company.application.dto.request;

import com.centralbank.company.shared.enums.KeyType;

public class TransferKeysRequest {
    private Long userId;
    private KeyType type;
    private String value;
    
    public TransferKeysRequest(Long userId, KeyType type, String value) {
        this.userId = userId;
        this.type = type;
        this.value = value;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public KeyType getType() {
        return type;
    }

    public void setType(KeyType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    
    
}
