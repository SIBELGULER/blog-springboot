package com.example.blog.yorum;

import com.example.blog.blog.Blog;
import com.example.blog.blog.BlogDTO;
import com.example.blog.blog.IBlogService;
import com.example.blog.kategori.IKategoriRepo;
import com.example.blog.kategori.IKategoriService;
import com.example.blog.kategori.Kategori;
import com.example.blog.kategori.KategoriDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;


@Service(value = "yorum")
public class YorumServiceImpl implements IYorumService {
    private IYorumRepo yorumRepo;
    private ModelMapper modelMapper;
    IBlogService blogService;


    @Autowired
    public YorumServiceImpl(IYorumRepo yorumRepo, ModelMapper modelMapper,IBlogService blogService) {
        this.yorumRepo = yorumRepo;
        this.modelMapper = modelMapper;
        this.blogService = blogService;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public YorumDTO kaydet(YorumDTO yorumDTO) {
        Yorum yorum = modelMapper.map(yorumDTO, Yorum.class);
        yorum.setTarih(Calendar.getInstance());
        yorum.setCreationDate(Calendar.getInstance());
        yorum.setBlog(blogService.findALLById(yorumDTO.getBlogId()));
        return modelMapper.map(yorumRepo.save(yorum), YorumDTO.class);    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public YorumDTO duzenle(YorumDTO yorumDTO) {
        Yorum yorum = yorumRepo.getOne(yorumDTO.getId());
        yorum.setAd(yorumDTO.getAd());
        yorum.setSoyad(yorumDTO.getSoyad());
        yorum.setIcerik(yorumDTO.getIcerik());
        yorum.setTarih(yorumDTO.getTarih());
        yorum.setTarih(yorumDTO.getTarih());
        return modelMapper.map(yorumRepo.save(yorum), YorumDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(readOnly = true)
    public YorumDTO findAllById(Long id) {
        return modelMapper.map(yorumRepo.getOne(id),YorumDTO.class);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteAll() {
        yorumRepo.deleteAll();
        return "Tüm kayıtlar silindi.";
    }
    @Override
    public List<YorumDTO> findByBlogId(Long id) {
        return modelMapper.map(yorumRepo.findByBlog_IdAndIsActiveTrue(id), new TypeToken<List<YorumDTO>>() {
        }.getType());
    }
}