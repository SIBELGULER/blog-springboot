package com.example.blog.yorum;

import com.example.blog.blog.BlogDTO;
import com.example.blog.etiket.EtiketDTO;

import java.util.List;

public interface IYorumService {
    YorumDTO kaydet(YorumDTO yorumDTO) throws Exception;
    YorumDTO duzenle( YorumDTO yorumDTO) throws Exception;
    String sil(Long id) throws Exception;

    List<YorumDTO> findAll();
    YorumDTO findAllById(Long id);
    String deleteAll();
}
