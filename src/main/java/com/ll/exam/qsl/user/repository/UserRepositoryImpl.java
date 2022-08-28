package com.ll.exam.qsl.user.repository;

import com.ll.exam.qsl.user.entity.SiteUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.ll.exam.qsl.keyword.entity.QKeyword.keyword;
import static com.ll.exam.qsl.user.entity.QSiteUser.siteUser;
import static com.ll.exam.qsl.user.entity.QSiteUserKeyword.siteUserKeyword;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public SiteUser getQslUser(Long id) {
        /*
        SELECT *
        FROM site_user
        WHERE id = 1
        */

        return jpaQueryFactory
                .select(siteUser)
                .from(siteUser)
                .where(siteUser.id.eq(id))
                .fetchOne();
    }

    @Override
    public List<SiteUser> findUserByKeyword(String content) {
        List<SiteUser> fetch = jpaQueryFactory.select(siteUser)
                .from(siteUser)
                .leftJoin(siteUser.siteUserKeywords, siteUserKeyword)
                .leftJoin(siteUserKeyword.keyword, keyword)
                .where(keyword.content.eq(content))
                .fetch();
        return fetch;
    }
}

