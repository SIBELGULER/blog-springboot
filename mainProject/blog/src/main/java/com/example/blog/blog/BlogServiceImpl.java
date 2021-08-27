package com.example.blog.blog;

import com.example.blog.etiket.EtiketDTO;
import com.example.blog.kategori.Kategori;
import com.example.blog.kategori.KategoriDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "blogService")
public class BlogServiceImpl implements IBlogService {

    private IBlogRepo blogRepo;
    private ModelMapper modelMapper;

    @Autowired
    public BlogServiceImpl(IBlogRepo blogRepo, ModelMapper modelMapper) {
        this.blogRepo = blogRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public BlogDTO kaydet(BlogDTO blogDTO) throws Exception {
        try {
            if (blogRepo.findByBaslik(blogDTO.getBaslik()) != null) {
                throw new Exception("Bu ad ile daha önce bir başlık kaydedilmiştir. Başka başlık gir.");
            }
            blogRepo.save(modelMapper.map(blogDTO, Blog.class)); // Parametre ile gelen ders veri tabanına kayıt ediliyor.
            return modelMapper.map(blogRepo.findByBaslik(blogDTO.getBaslik()), BlogDTO.class); // Kayıt edilen dersi veri tabanından çekip DTO ya mapliyoruz.
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BlogDTO duzenle(BlogDTO blogDTO) {
        Blog blog = blogRepo.getOne(blogDTO.getId());
        blog.setBaslik(blogDTO.getBaslik());
        blog.setIcerik(blogDTO.getIcerik());
        blog.setTarih(blogDTO.getTarih());
        return modelMapper.map(blogRepo.save(blog), BlogDTO.class);
    }

    @Override
    public String sil(Long id) throws Exception {
        blogRepo.deleteById(id);
        if (blogRepo.getOne(id) == null) {
            return "Başarılı bir şekilde silinmiştir.";
        } else {
            return "Silme işlemi başarısız.";
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlogDTO> findAll() {
        return modelMapper.map(blogRepo.findAll(), new TypeToken<List<BlogDTO>>() {
        }.getType());
    }

    @Override
    public BlogDTO findALLById(Long id) {
        return modelMapper.map(blogRepo.getOne(id), BlogDTO.class);
    }


    @Override
    public String deleteAll() {
        blogRepo.deleteAll();
        return "tüm kayıtlar silindi.";
    }

}