package com.example.blog.etiket;

import java.util.List;

public interface IEtiketService {

    EtiketDTO kaydet(EtiketDTO etiketDTO);

    EtiketDTO duzenle(EtiketDTO etiketDTO);

    String sil(Long id);

    List<EtiketDTO> findAll();

    EtiketDTO findAllById(Long id);

    String deleteAll();
}
