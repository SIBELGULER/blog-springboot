package com.example.blog.etiket;

import com.example.blog.blog.Blog;
import com.example.blog.ortak.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class EtiketDTO extends BaseDTO {
    private String adi;

    private List<Blog> blogs;
}
