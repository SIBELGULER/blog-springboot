package com.example.blog.ortak;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    String hata;
    Object data;
    EnumIslemSonucTipi sonuc;
}
