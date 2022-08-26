package com.ll.exam.qsl.user.entity;

import com.ll.exam.qsl.base.entity.BaseTimedEntity;
import com.ll.exam.qsl.keyword.entity.Keyword;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class SiteUser extends BaseTimedEntity {

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @Builder.Default
    @ToString.Exclude
    private Set<SiteUser> followers = new HashSet<>();

    @ManyToMany
    @Builder.Default
    @ToString.Exclude
    private Set<SiteUser> followees = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @Builder.Default
    @ToString.Exclude
    @Getter(AccessLevel.PROTECTED)
    private Set<Keyword> keywords = new HashSet<>();

    public void addKeyword(String keywordStr) {
        Keyword keyword = new Keyword(keywordStr);
        this.getKeywords().add(keyword);
    }
}
