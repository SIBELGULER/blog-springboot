package com.example.blog.yorum;

import com.example.blog.blog.Blog;
import com.example.blog.ortak.BaseEntity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.Calendar;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "yorumSequence",allocationSize = 1)
public class Yorum extends BaseEntity {
    @NotNull
    private String adsoyad;
    @NotNull
    private String icerik;
    @NotNull
    private Calendar tarih;
    @NotNull
    private String mail;

    @ManyToOne
    private Blog blog;


}
