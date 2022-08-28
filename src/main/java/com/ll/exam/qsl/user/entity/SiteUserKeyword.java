package com.ll.exam.qsl.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.exam.qsl.keyword.entity.Keyword;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(SiteUserKeywordId.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SiteUserKeyword {
    @Column(columnDefinition="serial")
    private Long uid;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Include
    private Keyword keyword;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Include
    @JsonIgnore
    private SiteUser siteUser;
}
