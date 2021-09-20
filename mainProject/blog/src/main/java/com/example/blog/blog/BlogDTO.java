package com.example.blog.blog;

import com.example.blog.etiket.EtiketDTO;
import com.example.blog.kategori.KategoriDTO;
import com.example.blog.ortak.BaseDTO;
import com.example.blog.resim.ResimDTO;
import com.example.blog.yorum.YorumDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Calendar;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogDTO extends BaseDTO {
    private String baslik;
    private String icerik;
    private Calendar tarih;

    private List<YorumDTO> yorumlar;
    private List<KategoriDTO> kategoriler;
    private List<EtiketDTO> etiketler;
    private List<ResimDTO> resimler;
}
