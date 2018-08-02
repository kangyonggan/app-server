package com.kangyonggan.as.service;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.ap.model.Article;
import com.kangyonggan.as.constants.App;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("article")
    PageInfo<Article> articles(@RequestParam("query") Map<String, Object> query);

    /**
     * 获取文章
     *
     * @param id
     * @return
     */
    @GetMapping("article/{id}")
    Article article(@PathVariable("id") Long id);

    /**
     * 获取下一篇文章
     *
     * @param id
     * @return
     */
    @GetMapping("article/{id}/next")
    Article articleNext(@PathVariable("id") Long id);

    /**
     * 获取上一篇文章
     *
     * @param id
     * @return
     */
    @GetMapping("article/{id}/prev")
    Article articlePrev(@PathVariable("id") Long id);
}
