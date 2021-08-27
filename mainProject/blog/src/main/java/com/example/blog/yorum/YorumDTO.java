package com.example.blog.yorum;

import com.example.blog.ortak.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@NoArgsConstructor
@Getter
@Setter
public class YorumDTO extends BaseDTO {
    private String adsoyad;
    private String icerik;
    private Calendar tarih;
    private String mail;
}
