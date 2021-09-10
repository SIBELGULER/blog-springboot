package com.example.blog.resim;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "resim")
public class ResimServiceImpl implements IResimService {

    IResimRepo iResimRepo;
    ModelMapper modelMapper;

    @Autowired
    public ResimServiceImpl(IResimRepo iResimRepo, ModelMapper modelMapper) {
        this.iResimRepo = iResimRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResimDTO kaydet(ResimDTO resimDTO) {
        Resim resim = modelMapper.map(resimDTO, Resim.class);
        return modelMapper.map(iResimRepo.save(resim), ResimDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String sil(Long id) throws Exception {
        iResimRepo.deleteById(id);
        if (iResimRepo.getOne(id) == null) {
            return "silme işlemi başarılı.";
        } else {
            return "silme işlemi başarısız.";
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String tumunuSil() {
        iResimRepo.deleteAll();
        return "tum kayıtlar silindi.";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResimDTO duzenle(ResimDTO resimDTO) {
        Resim resim = iResimRepo.getOne(resimDTO.getId());
        resim.setAd(resimDTO.getAd());

        return modelMapper.map(iResimRepo.save(resim), ResimDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResimDTO> findAll() {
        return modelMapper.map(iResimRepo.findAll(), new TypeToken<List<ResimDTO>>() {
        }.getType());
    }

    @Override
    @Transactional(readOnly = true)
    public ResimDTO findById(Long id) {
        return modelMapper.map(iResimRepo.getOne(id), ResimDTO.class);
    }
}
