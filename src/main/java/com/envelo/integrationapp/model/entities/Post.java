package com.envelo.integrationapp.model.entities;

import com.envelo.integrationapp.model.abstracts.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Post extends Content {
    private byte[] file;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<PostComment> postComments = new ArrayList<>();
}
