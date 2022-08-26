package com.ll.exam.qsl.base;

import com.ll.exam.qsl.user.entity.SiteUser;
import com.ll.exam.qsl.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestInitDatabase {
    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            SiteUser u1 = SiteUser.builder()
                    .username("user1")
                    .password("{noop}1234")
                    .email("user1@test.com")
                    .build();

            SiteUser u2 = SiteUser.builder()
                    .username("user2")
                    .password("{noop}1234")
                    .email("user2@test.com")
                    .build();

            // 2번 회원이 1번 회원을 팔로우
            u2.getFollowers().add(u1);
            u1.getFollowees().add(u2);

            u2.addKeyword("사랑");
            u2.addKeyword("믿음");
            u2.addKeyword("소망");

            List<SiteUser> siteUsers = userRepository.saveAll(Arrays.asList(u1, u2));
        };
    }
}
