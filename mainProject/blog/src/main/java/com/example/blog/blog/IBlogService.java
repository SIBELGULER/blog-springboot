package com.example.blog.blog;

import java.util.List;

public interface IBlogService {

    BlogDTO kaydet(BlogDTO blogDTO);

    BlogDTO duzenle(BlogDTO blogDTO);

    String sil(Long id);

    List<BlogDTO> findAll();

    Blog findALLById(Long id);

    String deleteAll();
}
