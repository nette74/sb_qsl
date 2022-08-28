package com.ll.exam.qsl.keyword;

import com.ll.exam.qsl.keyword.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeywordRepository extends JpaRepository<Keyword, String> {
    Optional<Keyword> findByUid(Long id);
}
