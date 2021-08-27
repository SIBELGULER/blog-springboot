package com.example.blog.kategori;
import com.example.blog.etiket.EtiketDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class KategoriServiceImpl implements IKategoriService {
    private IKategoriRepo kategoriRepo;
    private ModelMapper modelMapper;

    @Autowired
    public KategoriServiceImpl(IKategoriRepo kategoriRepo, ModelMapper modelMapper) {
        this.kategoriRepo = kategoriRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public KategoriDTO kaydet(KategoriDTO kategoriDTO) {
        return modelMapper.map(kategoriRepo.save(modelMapper.map(kategoriDTO, Kategori.class)), KategoriDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public KategoriDTO duzenle(KategoriDTO kategoriDTO) {
        Kategori kategori = kategoriRepo.getOne(kategoriDTO.getId());
        kategori.setAd(kategoriDTO.getAd());
        return modelMapper.map(kategoriRepo.save(kategori), KategoriDTO.class);

        /*Kategori kategori = kategoriRepo.save(modelMapper.map(kategoriDTO, Kategori.class));
        return modelMapper.map(kategori, KategoriDTO.class);*/

    }

    @Override
    public String sil(Long id) throws Exception {
        kategoriRepo.deleteById(id);
        if (kategoriRepo.getOne(id) == null) {

            return "Silme islemi basarili";
        } else {
            return "Silme işlemi başarısız.";
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<KategoriDTO> findAll() {
        return modelMapper.map(kategoriRepo.findAll(), new TypeToken<List<KategoriDTO>>() {
        }.getType());
    }

    @Override
    public KategoriDTO findAllById(Long id) {
        return modelMapper.map(kategoriRepo.getOne(id), KategoriDTO.class);
    }

    @Override
    public String deleteAll() {
        kategoriRepo.deleteAll();
        return "tüm kayıtlar silindi.";
    }
}