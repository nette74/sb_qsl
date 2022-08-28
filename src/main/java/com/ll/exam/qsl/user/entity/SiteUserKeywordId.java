package com.ll.exam.qsl.user.entity;

import com.ll.exam.qsl.keyword.entity.Keyword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteUserKeywordId implements Serializable {
    private SiteUser siteUser;
    private Keyword keyword;

    public SiteUserKeywordId(Long siteUserId, String keywordContent) {
        siteUser = new SiteUser(siteUserId);
        keyword = new Keyword(keywordContent);
    }
}
