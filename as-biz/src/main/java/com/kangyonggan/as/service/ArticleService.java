package com.kangyonggan.as.service;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.ap.model.Article;
import com.kangyonggan.as.constants.App;
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
     * 获取文章列表
     *
     * @param query
     * @return
     */
    @GetMapping("list")
    PageInfo<Article> list(@RequestParam Map<String, Object> query);

    /**
     * 获取文章
     *
     * @param id
     * @return
     */
    @GetMapping("/")
    Article get(@RequestParam("id") Long id);

    /**
     * 获取下一篇文章
     *
     * @param id
     * @return
     */
    @GetMapping("next")
    Article next(@RequestParam("id") Long id);

    /**
     * 获取上一篇文章
     *
     * @param id
     * @return
     */
    @GetMapping("prev")
    Article prev(@RequestParam("id") Long id);
}
