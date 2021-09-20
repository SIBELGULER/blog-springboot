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
    public BaseResponse kaydet(@RequestBody BlogDTO blogDTO){
        try {
            return Util.islemSonucGetir(blogService.kaydet(blogDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/duzenle",method = RequestMethod.PUT)
    public BaseResponse duzenle(@RequestBody BlogDTO blogDTO){
        try {
            return Util.islemSonucGetir(blogService.duzenle(blogDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id){
        try {
            return Util.islemSonucGetir(blogService.sil(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(blogService.findAll());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE)
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(blogService.deleteAll());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/getir/{id}", method = RequestMethod.GET)
    public BaseResponse getir(@PathVariable Long id){
        try{
            return Util.islemSonucGetir(blogService.findALLById(id));
        }catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
}