package com.example.blog.etiket;
import com.example.blog.kategori.Kategori;
import com.example.blog.kategori.KategoriDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EtiketServiceImpl implements IEtiketService {
    private IEtiketRepo etiketRepo;
    private ModelMapper modelMapper;

    @Autowired
    public EtiketServiceImpl(IEtiketRepo etiketRepo, ModelMapper modelMapper) {
        this.etiketRepo = etiketRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EtiketDTO kaydet(EtiketDTO etiketDTO) {
        return modelMapper.map(etiketRepo.save(modelMapper.map(etiketDTO, Etiket.class)), EtiketDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EtiketDTO duzenle(EtiketDTO etiketDTO) {
        Etiket etiket = etiketRepo.getOne(etiketDTO.getId());
        etiket.setAdi(etiketDTO.getAdi());
        return modelMapper.map(etiketRepo.save(etiket), EtiketDTO.class);

    }

    @Override
    public String sil(Long id) throws Exception {
        etiketRepo.deleteById(id);
        if (etiketRepo.getOne(id) == null) {

            return "Silme islemi basarili";
        } else {
            return "Silme işlemi başarısız.";
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<EtiketDTO> findAll() {
        return modelMapper.map(etiketRepo.findAll(), new TypeToken<List<EtiketDTO>>() {
        }.getType());
    }

    @Override
    public EtiketDTO findAllById(Long id) {
        return modelMapper.map(etiketRepo.getOne(id),EtiketDTO.class);
    }

    @Override
    public String deleteAll() {
        etiketRepo.deleteAll();
        return "tüm kayıtlar silindi.";
    }
}
