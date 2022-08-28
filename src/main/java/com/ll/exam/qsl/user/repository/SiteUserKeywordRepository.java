package com.ll.exam.qsl.user.repository;

import com.ll.exam.qsl.keyword.entity.Keyword;
import com.ll.exam.qsl.user.entity.SiteUser;
import com.ll.exam.qsl.user.entity.SiteUserKeyword;
import com.ll.exam.qsl.user.entity.SiteUserKeywordId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SiteUserKeywordRepository extends JpaRepository<SiteUserKeyword, SiteUserKeywordId> {
    Optional<SiteUserKeyword> findByUid(Long uid);
}
