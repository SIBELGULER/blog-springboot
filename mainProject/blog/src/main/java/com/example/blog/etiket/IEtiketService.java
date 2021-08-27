package com.example.blog.etiket;
import java.util.List;

public interface IEtiketService {

    EtiketDTO kaydet(EtiketDTO etiketDTO) throws Exception;
    EtiketDTO duzenle(EtiketDTO etiketDTO) throws Exception;
    String sil(Long id) throws Exception;

    List<EtiketDTO> findAll();
    EtiketDTO findAllById(Long id);
    String deleteAll();
}
