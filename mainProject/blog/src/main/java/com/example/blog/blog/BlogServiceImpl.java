package com.example.blog.blog;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
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
    @Transactional(rollbackFor = Exception.class)
    public BlogDTO kaydet(BlogDTO blogDTO) {
        Blog blog = modelMapper.map(blogDTO, Blog.class);
        blog.setTarih(Calendar.getInstance());
        return modelMapper.map(blogRepo.save(blog), BlogDTO.class);
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
    @Transactional(rollbackFor = Exception.class)
    public String sil(Long id) {
        blogRepo.deleteById(id);
        if (blogRepo.getOne(id) == null) {
            return "Silme işlemi başarılı.";
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
    @Transactional(readOnly = true)
    public Blog findALLById(Long id) {
        return blogRepo.getOne(id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String deleteAll() {
        blogRepo.deleteAll();
        return "Tüm kayıtlar silindi.";
    }

}