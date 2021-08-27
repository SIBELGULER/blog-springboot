package com.example.blog.etiket;

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
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "etiketSequence",allocationSize = 1)
public class Etiket extends BaseEntity {

    @NotNull
    private String adi;

    @ManyToMany
    private List<Blog> blogs;

}
