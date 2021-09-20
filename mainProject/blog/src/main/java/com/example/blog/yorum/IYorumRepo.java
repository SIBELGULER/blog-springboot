package com.example.blog.yorum;


import com.example.blog.ortak.IBaseEntityRepo;

import java.util.List;

public interface IYorumRepo extends IBaseEntityRepo<Yorum, Long> {
    List<Yorum> findByBlog_IdAndIsActiveTrue(Long blogId);

}
