package com.aiden.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Whitelist {
    int id;
    int userId;
    String appName;
    String appPackage;
    ZonedDateTime createdAt;
}
