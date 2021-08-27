package com.example.blog.kategori;

import com.example.blog.blog.Blog;
import com.example.blog.ortak.BaseEntity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "kategoriSequence",allocationSize = 1)
public class Kategori extends BaseEntity {
    @NotNull
    private String ad;

    @ManyToMany
    private List<Blog> blogs;

}
