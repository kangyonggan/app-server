package com.kangyonggan.as.service;

import com.kangyonggan.as.constants.App;
import com.kangyonggan.common.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@FeignClient(App.ARTICLE_PLATFORM)
public interface ArticleService {

    /**
     * 文章列表查询
     *
     * @param query
     * @return
     */
    @GetMapping("/")
    Response list(@RequestParam Map<String, Object> query);

}
