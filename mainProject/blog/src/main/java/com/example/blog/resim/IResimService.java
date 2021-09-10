package com.example.blog.resim;

import java.util.List;

public interface IResimService {
    ResimDTO kaydet(ResimDTO resimDTO);
    String sil(Long id) throws Exception;
    String tumunuSil();
    ResimDTO duzenle(ResimDTO resimDTO);
    List<ResimDTO> findAll();
    ResimDTO findById(Long id);

}
