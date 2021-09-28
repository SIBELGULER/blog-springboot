package com.example.blog.yorum;

import com.example.blog.blog.BlogDTO;
import com.example.blog.blog.BlogGetirDTO;
import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/yorum")
@RestController
public class YorumController {
    private IYorumService yorumService;

    public YorumController(IYorumService yorumService) {
        this.yorumService = yorumService;
    }

    @Operation(summary = "Yorum Kaydet", description = "Kaydetme işleminde herhangi bir hata meydana gelmezse yorum kaydedilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Yorum kaydetme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/yorum/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Yorum kaydetme işleminde yetkisiz erişim bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/yorum/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Yorum kaydetme işleminin yasaklandığını bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/yorum/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
            content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BlogDTO.class),
                            examples = @ExampleObject(
                                    name = "Yorum kaydetme işleminde sayfanın bulunamadığını bildirir.",
                                    value = "{\"status\": \"404\"," +
                                            "\"message\": \"Not Found.\"," +
                                            "\"path\": \"/api/yorum/kaydet\"," +
                                            "\"timestamp\": \"21.09.2021\"}"
                            )
                    )

            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Yorum kaydetme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/yorum/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    })


    })

    @RequestMapping(value = "/kaydet", method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody YorumDTO yorumDTO) {
        try {
            return Util.islemSonucGetir(yorumService.kaydet(yorumDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Yorum Düzenle", description = "Düzenleme işleminde herhangi bir hata meydana gelmemişse yorum düzenlenir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Yorum düzenle işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/yorum/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Yorum düzenle işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/yorum/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Yorum düzenle işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/yorum/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Yorum düzenle işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/yorum/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Yorum düzenle işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/yorum/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    })
    })

    @RequestMapping(value = "/duzenle", method = RequestMethod.PUT)
    public BaseResponse duzenle(@RequestBody YorumDTO yorumDTO) {
        try {
            return Util.islemSonucGetir(yorumService.duzenle(yorumDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Id'ye Göre Yorum Silme", description = "Id'ye göre yorum silme işleminde herhangi bir hata meydana gelmemişse id'ye göre yorum silinir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre yorum silme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/yorum/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre yorum silme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/yorum/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre yorum silme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/yorum/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre yorum silme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/yorum/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre yorum silme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/yorum/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    })
    })

    @RequestMapping(value = "/sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id) throws Exception {
        try {
            return Util.islemSonucGetir(yorumService.sil(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Tüm Yorumları Getir", description = "Tüm yorumları getirme işleminde herhangi bir hata meydana gelmemişse tüm yorumlar getirilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm yorumları getirme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/yorum/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm yorumları getirme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/yorum/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm yorumları getirme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/yorum/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm yorumları getirme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/yorum/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm yorumları getirme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\",\" +\n" +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/yorum/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    })
    })

    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(yorumService.findAll());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Tüm Yorumları Sil", description = "Tüm yorumları silme işleminde herhangi bir hata meydana gelmemişse tüm yorumlar silinir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm yorumları silme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/yorum/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm yorumları silme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/yorum/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm yorumları silme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/yorum/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm yorumları silme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/yorum/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm yorumları silme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/yorum/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    })
    })

    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE)
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(yorumService.deleteAll());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Id'ye Göre Yorum Getir", description = "Id'ye göre yorum getirme işleminde herhangi bir hata meydana gelmemişse id'ye göre yorum getirilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre yorum getirme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/yorum/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre yorum getirme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/yorum/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre yorum getirme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/yorum/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre yorum getirme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/yorum/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre yorum getirme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/yorum/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    })
    })

    @RequestMapping(value = "/getir/{id}", method = RequestMethod.GET)
    public BaseResponse getir(@PathVariable Long id) {
        try {
            return Util.islemSonucGetir(yorumService.findAllById(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Blog Id'ye Göre Yorum Getir", description = "Blog id'ye göre yorum getirme işleminde herhangi bir hata meydana gelmemişse blog id'ye göre yorum getirilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog id'ye göre yorum getirme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/yorum/blog-id-ye-gore-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog id'ye göre yorum getirme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/yorum/blog-id-ye-gore-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog id'ye göre yorum getirme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/yorum/blog-id-ye-gore-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
            content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BlogDTO.class),
                            examples = @ExampleObject(
                                    name = "Blog id'ye göre yorum getirme işleminde sayfanın bulunamadığını bildirir.",
                                    value = "{\"status\": \"404\"," +
                                            "\"message\": \"Not Found.\"," +
                                            "\"path\": \"/api/yorum/blog-id-ye-gore-getir\"," +
                                            "\"timestamp\": \"21.09.2021\"}"
                            )
                    )

            }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Blog id'ye göre yorum getirme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/yorum/blog-id-ye-gore-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    })
    })

    @RequestMapping(value = "/blog-id-ye-gore-getir", method = RequestMethod.POST)
    public BaseResponse blogIdyeGoreGetir(@RequestBody BlogGetirDTO blogDTO) {
        try {
            return Util.islemSonucGetir(yorumService.findByBlogId(blogDTO.getId()));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
}