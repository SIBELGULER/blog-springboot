package com.example.blog.blog;

import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/blog")
@RestController
public class BlogController {
    private final IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }


    @Operation(summary = "Blog Kaydet", description = "Kaydetme işleminde herhangi bir hata meydana gelmezse blog kaydedilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog kaydetme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/blog/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog kaydetme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/blog/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog kaydetme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/blog/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog kaydetme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/blog/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog kaydetme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/blog/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/kaydet", method = RequestMethod.POST, consumes = {"application/json"})
    public BaseResponse kaydet(@RequestBody BlogDTO blogDTO) {
        try {
            return Util.islemSonucGetir(blogService.kaydet(blogDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Blog Düzenle", description = "Düzenleme işleminde herhangi bir hata meydana gelmezse blog düzenlenir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog düzenle işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/blog/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"


                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog düzenle işleminde yetkisiz erişim bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/blog/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog düzenle işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/blog/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog düzenle işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/blog/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}")

                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog düzenle işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/blog/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/duzenle", method = RequestMethod.PUT, consumes = {"application/json"})
    public BaseResponse duzenle(@RequestBody BlogDTO blogDTO) {
        try {
            return Util.islemSonucGetir(blogService.duzenle(blogDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Id'ye Göre Blog Sil", description = "Id'ye göre silme işleminde herhangi bir hata meydana gelmezse id'ye göre blog silinir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre blog silme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/blog/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre blog silme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/blog/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre blog silme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/blog/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre blog silme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/blog/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre blog silme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/blog/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/sil/{id}", method = RequestMethod.DELETE, consumes = {"application/json"})
    public BaseResponse sil(@PathVariable Long id) {
        try {
            return Util.islemSonucGetir(blogService.sil(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Tüm Blogları Getir", description = "Tümünü getir işleminde harhangi bir hata meydana gelmezse tüm bloglar getirilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm blogları getirme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/blog/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm blogları getirme işleminde yetkisiz erişim bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/blog/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm blogları getirme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/blog/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm blogları getirme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/blog/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm blogları getirme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/blog/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(blogService.findAll());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Tüm Blogları Sil", description = "Tümünü sil işleminde herhangi bir hata meydana gelmezse tüm bloglar silinir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm blogları silme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/blog/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm blogları silme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/blog/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm blogları silme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/blog/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm blogları silme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/blog/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm blogları silme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/blog/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE, consumes = {"application/json"})
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(blogService.deleteAll());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Id'ye Göre Blog Getir", description = "Id'ye göre getirme işleminde herhangi bir hata meydana gelmezse tüm bloglar getirilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre blog getirme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/blog/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre blog getirme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/blog/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre blog getirme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/blog/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre blog getirme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/blog/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre blog getirme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/blog/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/getir/{id}", method = RequestMethod.GET, consumes = {"application/json"})
    public BaseResponse getir(@PathVariable Long id) {
        try {
            return Util.islemSonucGetir(blogService.findALLById(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
}