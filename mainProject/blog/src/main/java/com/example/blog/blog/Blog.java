package com.example.blog.blog;


import com.example.blog.etiket.Etiket;
import com.example.blog.kategori.Kategori;
import com.example.blog.ortak.BaseEntity;
import com.example.blog.yorum.Yorum;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Calendar;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "blogSequence",allocationSize = 1)
public class Blog extends BaseEntity {
    @NotNull
    private String baslik;
    @NotNull
    private String icerik;
    @NotNull
    private Calendar tarih;

    @OneToMany(mappedBy = "blog")
    private List<Yorum> yorumlar;

    @ManyToMany(mappedBy = "blogs")
    private List<Kategori> kategoriler;

    @ManyToMany(mappedBy = "blogs")
    private List<Etiket> etiketler;

}



