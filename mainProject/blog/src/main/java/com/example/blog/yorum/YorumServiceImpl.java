package com.example.blog.yorum;

import com.example.blog.blog.Blog;
import com.example.blog.blog.BlogDTO;
import com.example.blog.kategori.IKategoriRepo;
import com.example.blog.kategori.IKategoriService;
import com.example.blog.kategori.Kategori;
import com.example.blog.kategori.KategoriDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class YorumServiceImpl implements IYorumService {
    private IYorumRepo yorumRepo;
    private ModelMapper modelMapper;

    @Autowired
    public YorumServiceImpl(IYorumRepo yorumRepo, ModelMapper modelMapper) {
        this.yorumRepo = yorumRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public YorumDTO kaydet(YorumDTO yorumDTO) {
        return modelMapper.map(yorumRepo.save(modelMapper.map(yorumDTO, Yorum.class)), YorumDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public YorumDTO duzenle(YorumDTO yorumDTO) {
        Yorum yorum = yorumRepo.getOne(yorumDTO.getId());
        yorum.setAdsoyad(yorumDTO.getAdsoyad());
        yorum.setIcerik(yorumDTO.getIcerik());
        yorum.setTarih(yorumDTO.getTarih());
        yorum.setTarih(yorumDTO.getTarih());
        return modelMapper.map(yorumRepo.save(yorum), YorumDTO.class);
    }

    @Override
    public String sil(Long id) throws Exception {
        yorumRepo.deleteById(id);
        if (yorumRepo.getOne(id) == null) {

            return "Silme islemi basarili";
        } else {
            return "Silme işlemi başarısız.";
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<YorumDTO> findAll() {
        return modelMapper.map(yorumRepo.findAll(), new TypeToken<List<YorumDTO>>() {
        }.getType());
    }

    @Override
    public YorumDTO findAllById(Long id) {
        return modelMapper.map(yorumRepo.getOne(id),YorumDTO.class);
    }


    @Override
    public String deleteAll() {
        yorumRepo.deleteAll();
        return "tüm kayıtlar silindi.";
    }
}