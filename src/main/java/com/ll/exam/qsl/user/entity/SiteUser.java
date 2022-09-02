package com.ll.exam.qsl.user.entity;

import com.ll.exam.qsl.interestKeyword.entity.InterestKeyword;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<InterestKeyword> interestKeywords = new HashSet<>();

    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<SiteUser> followers = new HashSet<>();

    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<SiteUser> followings = new HashSet<>();


    public void addInterestKeywordContent(String keywordContent) {
        interestKeywords.add(new InterestKeyword(this, keywordContent));
    }
    /*
    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "followers")
    private Set<SiteUser> followings = new HashSet<>();

    */
    /*
    public void addFollower(SiteUser follower) {
        followers.add(follower);
    }
    */

    public void follow(SiteUser u2){
        if(u2.id == this.id) {
            //throw new IllegalArgumentException("본인을 팔로우 할 수 없습니다.");
            return;
        }
        if(u2 == null)
            return;
        u2.getFollowers().add(this);
        getFollowings().add(u2);
    }

}