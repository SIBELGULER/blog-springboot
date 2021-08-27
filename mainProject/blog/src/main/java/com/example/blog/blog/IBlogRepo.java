package com.example.blog.blog;

import com.example.blog.ortak.IBaseEntityRepo;

public interface IBlogRepo extends IBaseEntityRepo<Blog, Long> {
    Blog findByBaslik(String baslik);

}
