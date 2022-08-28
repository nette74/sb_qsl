package com.ll.exam.qsl.user.controller;

import com.ll.exam.qsl.keyword.KeywordRepository;
import com.ll.exam.qsl.keyword.entity.Keyword;
import com.ll.exam.qsl.user.entity.SiteUser;
import com.ll.exam.qsl.user.entity.SiteUserKeyword;
import com.ll.exam.qsl.user.entity.SiteUserKeywordId;
import com.ll.exam.qsl.user.repository.SiteUserKeywordRepository;
import com.ll.exam.qsl.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final KeywordRepository keywordRepository;
    private final SiteUserKeywordRepository siteUserKeywordRepository;

    @RequestMapping("/user/{id}")
    public SiteUser user(@PathVariable Long id) {
        SiteUser siteUser = userRepository.getQslUser(id);
        siteUser.addKeyword("하나");
        siteUser.addKeyword("둘");
        siteUser.addKeyword("넷");
        siteUser.addKeyword("다섯");
        siteUser.addKeyword("다섯");
        siteUser.addKeyword("다섯");
        siteUser.addKeyword("다섯");
        siteUser.addKeyword("다섯");

        siteUser.removeKeyword("다섯");

        userRepository.save(siteUser);

        return siteUser;
    }

    @RequestMapping("/keyword/{uid}")
    public Keyword keyword(@PathVariable Long uid) {
        return keywordRepository.findByUid(uid).get();
    }

    @RequestMapping("/siteUserKeyword/{siteUserId}/{keywordContent}")
    public SiteUserKeyword siteUserKeyword(@PathVariable Long siteUserId, @PathVariable String keywordContent) {
        return siteUserKeywordRepository.findById(new SiteUserKeywordId(siteUserId, keywordContent)).get();
    }
}
