package com.example.blog.kategori;

import com.example.blog.blog.BlogDTO;
import com.example.blog.etiket.EtiketDTO;

import java.util.List;

public interface IKategoriService {
    KategoriDTO kaydet(KategoriDTO kategoriDTO) throws Exception;
    KategoriDTO duzenle(KategoriDTO kategoriDTO) throws Exception;
    String sil(Long id) throws Exception;

    List<KategoriDTO> findAll();
    KategoriDTO findAllById(Long id);
    String deleteAll();
}