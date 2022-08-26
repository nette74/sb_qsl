package com.ll.exam.qsl;

import com.ll.exam.qsl.keyword.KeyWordRepository;
import com.ll.exam.qsl.user.entity.SiteUser;
import com.ll.exam.qsl.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    KeyWordRepository keyWordRepository;

    @Test
    @DisplayName("회원 생성")
    @Transactional
    void t1() {
        SiteUser u1 = SiteUser.builder()
                .username("user3")
                .password("{noop}1234")
                .email("user3@test.com")
                .build();

        SiteUser u2 = SiteUser.builder()
                .username("user4")
                .password("{noop}1234")
                .email("user4@test.com")
                .build();

        // SiteUser u2 = new SiteUser(null, "user2", "{noop}1234", "user2@test.com");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }

    @Test
    @DisplayName("1번 회원을 Qsl로 가져오기")
    void t2() {
        SiteUser u1 = userRepository.getQslUser(1L);

        assertThat(u1.getId()).isEqualTo(1L);
        assertThat(u1.getUsername()).isEqualTo("user1");
        assertThat(u1.getEmail()).isEqualTo("user1@test.com");
        assertThat(u1.getPassword()).isEqualTo("{noop}1234");
    }

    @Test
    @DisplayName("2번 회원을 Qsl로 가져오기")
    void t3() {
        SiteUser u2 = userRepository.getQslUser(2L);

        assertThat(u2.getId()).isEqualTo(2L);
        assertThat(u2.getUsername()).isEqualTo("user2");
        assertThat(u2.getEmail()).isEqualTo("user2@test.com");
        assertThat(u2.getPassword()).isEqualTo("{noop}1234");
    }

    @Test
    @DisplayName("1번 회원이 2번 회원을 팔로우")
    @Transactional
    @Rollback(false)
    void t4() {
        SiteUser u1 = userRepository.getQslUser(1L);
        SiteUser u2 = userRepository.getQslUser(2L);

        u1.getFollowers().add(u2);
        u2.getFollowees().add(u1);
    }

    @Test
    @DisplayName("1번 회원이 2번 회원을 팔로우 후 언팔")
    @Transactional
    @Rollback(false)
    void t5() {
        SiteUser u1 = userRepository.getQslUser(1L);
    }

    @Test
    @DisplayName("키워드 등록")
    @Transactional
    @Rollback(false)
    void t6() {
        SiteUser u1 = userRepository.getQslUser(1L);

        u1.addKeyword("사랑");
        u1.addKeyword("믿음");
        u1.addKeyword("소망");
    }

    @Test
    @DisplayName("사랑 이라는 키워드에 해당하는 회원들 검색")
    @Transactional
    @Rollback(false)
    void t7() {
        List<SiteUser> siteUsers = userRepository.findAllByKeywords_keyword("사랑");

        System.out.println(siteUsers);
    }

    @Test
    @DisplayName("사랑 이라는 키워드에 해당하는 회원들 검색, Qsl")
    @Transactional
    @Rollback(false)
    void t8() {
        List<SiteUser> siteUsers = userRepository.findQslAllByKeywords_keyword("사랑");

        System.out.println(siteUsers);
    }
}
