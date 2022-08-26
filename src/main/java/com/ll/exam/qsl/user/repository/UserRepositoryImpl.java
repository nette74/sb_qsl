package com.ll.exam.qsl.user.repository;

import com.ll.exam.qsl.keyword.entity.QKeyword;
import com.ll.exam.qsl.user.entity.QSiteUser;
import com.ll.exam.qsl.user.entity.SiteUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.ll.exam.qsl.keyword.entity.QKeyword.keyword1;
import static com.ll.exam.qsl.user.entity.QSiteUser.siteUser;

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
    public List<SiteUser> findQslAllByKeywords_keyword(String keyword) {
        List<SiteUser> fetch = jpaQueryFactory.select(siteUser)
                .from(siteUser)
                .leftJoin(siteUser.keywords, keyword1)
                .where(
                        keyword1.keyword.eq(keyword)
                )
                .fetch();
        return fetch;
    }
}
