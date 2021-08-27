package com.example.blog.kategori;

import com.example.blog.blog.Blog;
import com.example.blog.ortak.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class KategoriDTO extends BaseDTO {
    private String ad;

    private List<Blog> blogs;
}
