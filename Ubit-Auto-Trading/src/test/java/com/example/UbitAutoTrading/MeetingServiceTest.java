package com.example.UbitAutoTrading;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MeetingServiceTest {
    @Autowired
    private MeetingService meetingService;

    @Test
    void redis_save_테스트(){
        //given
        //when
        String save = meetingService.save();
        //then
        Assertions.assertThat(save).isNotEmpty();
    }
}