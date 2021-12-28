package com.tomboja.bootrest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/27/21
 */

@RestController
public class HomeController {
    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    public Map<String, String> getAppStatus() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("app-version", appVersion);
        return map;
    }
}
