package com.example.blog.blog;

import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/blog")
@RestController
public class BlogController {
    private IBlogService blogService;
    public BlogController(IBlogService blogService) {
        this.blogService=blogService;
    }

    @RequestMapping(value = "/kaydet",method = RequestMethod.POST)
    public BlogDTO kaydet(@RequestBody BlogDTO blogDTO) throws Exception {
        return blogService.kaydet(blogDTO);
    }

    @RequestMapping(value = "/duzenle",method = RequestMethod.PUT)
    public BlogDTO duzenle(@RequestBody BlogDTO blogDTO) throws Exception {
        return blogService.duzenle(blogDTO);
    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return blogService.sil(id);
    }
    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(blogService.findAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }
    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE)
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(blogService.deleteAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }

    @RequestMapping(value = "/bul/{id}", method = RequestMethod.GET)
    public BaseResponse bul(@PathVariable Long id){
        try{
            return Util.islemSonucGetir(blogService.findALLById(id));
        }catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
}