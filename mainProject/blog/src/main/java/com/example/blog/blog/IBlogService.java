package com.example.blog.blog;

import com.example.blog.etiket.EtiketDTO;

import java.util.List;

public interface IBlogService {

    BlogDTO kaydet( BlogDTO blogDTO) throws Exception;
    BlogDTO duzenle( BlogDTO blogDTO) throws Exception;
    String sil(Long id) throws Exception;

    List<BlogDTO> findAll();
    BlogDTO findALLById(Long id);
    String deleteAll();
}
