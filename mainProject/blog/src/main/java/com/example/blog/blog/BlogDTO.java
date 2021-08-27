package com.example.blog.blog;

import com.example.blog.etiket.Etiket;
import com.example.blog.kategori.Kategori;
import com.example.blog.ortak.BaseDTO;
import com.example.blog.yorum.Yorum;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Calendar;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class BlogDTO extends BaseDTO {
    private String baslik;
    private String icerik;
    private Calendar tarih;

    private List<Yorum> yorumlar;
    private List<Kategori> kategoriler;
    private List<Etiket> etiketler;
}
