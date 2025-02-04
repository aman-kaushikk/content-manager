package com.social.post_service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "post_comments")
@Getter
@Setter
@NoArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Lob
    @Column(nullable = false, name = "comment_value")
    private String commentValue;

    @Column(nullable = false)
    private Integer likeCount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postComment", fetch = FetchType.LAZY)
    private List<CommentReply> replies;

    @ManyToOne
    @JsonBackReference
    private Post post;

    private String userName;
}
