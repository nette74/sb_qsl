package com.ll.exam.qsl.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.exam.qsl.keyword.entity.Keyword;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "siteUser", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @Builder.Default
    @JsonIgnore
    private Set<SiteUserKeyword> siteUserKeywords = new HashSet<>();

    public SiteUser(Long id) {
        this.id = id;
    }

    public void addKeyword(String content) {
        siteUserKeywords.add(SiteUserKeyword.builder().keyword(new Keyword(content)).siteUser(this).build());
    }

    public List<String> getKeywordContents() {
        return siteUserKeywords.stream().map(SiteUserKeyword::getKeyword).map(Keyword::getContent).collect(Collectors.toList());
    }

    public void removeKeyword(String content) {
        siteUserKeywords.remove(SiteUserKeyword.builder().keyword(new Keyword(content)).siteUser(this).build());
    }
}
