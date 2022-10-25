package com.example.UbitAutoTrading;

import com.example.UbitAutoTrading.redisTest.AdminUserRedisService;
import com.example.UbitAutoTrading.redisTest.RefreshToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = "spring.cloud.config.enabled=false")
class AdminUserRedisServiceTest {

    @Autowired
    private AdminUserRedisService adminUserRedisService;

    @DisplayName("token redis 저장 success")
    @Test
    void tokenSave(){
        //given
        RefreshToken token = RefreshToken.builder()
                .userId("test")
                .refreshToken("test_token")
                .expiredTime(60)    //테스트용 1분
                .build();
        //when
        RefreshToken refreshToken = adminUserRedisService.save(token);
        //then
        RefreshToken findToken = adminUserRedisService.findById(token.getUserId());
        System.out.println(refreshToken.getRefreshToken());
        System.out.println(findToken.getRefreshToken());
        assertEquals(refreshToken.getRefreshToken(), findToken.getRefreshToken());
    }
}