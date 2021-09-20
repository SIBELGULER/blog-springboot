package com.example.blog.resim;

import com.example.blog.blog.Blog;
import com.example.blog.ortak.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "resimSequence", allocationSize = 1)
public class Resim extends BaseEntity {
    @NotNull
    private String ad;
    @NotNull
    private String link;
    @ManyToOne
    private Blog blog;
}
