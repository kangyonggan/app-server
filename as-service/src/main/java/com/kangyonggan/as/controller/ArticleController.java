package com.kangyonggan.as.controller;

import com.kangyonggan.as.service.ArticleService;
import com.kangyonggan.common.Response;
import com.kangyonggan.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@RestController
@RequestMapping("article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    /**
     * 搜索文章
     *
     * @return
     */
    @GetMapping
    public Response searchArticles() {
        return articleService.searchArticles(getRequestParams());
    }


}
