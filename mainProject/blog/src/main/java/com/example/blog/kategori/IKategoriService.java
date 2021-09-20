package com.example.blog.kategori;

import java.util.List;

public interface IKategoriService {
    KategoriDTO kaydet(KategoriDTO kategoriDTO);
    KategoriDTO duzenle(KategoriDTO kategoriDTO);
    String sil(Long id);

    List<KategoriDTO> findAll();
    KategoriDTO findAllById(Long id);
    String deleteAll();
}