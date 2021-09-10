package com.example.blog.resim;

import com.example.blog.ortak.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResimDTO extends BaseDTO {
    private String ad;
    private String link;
}
