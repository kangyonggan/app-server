package com.kangyonggan.as.controller;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.ap.constants.ApplyStatus;
import com.kangyonggan.ap.model.Article;
import com.kangyonggan.app.util.MarkdownUtil;
import com.kangyonggan.as.service.ArticleService;
import com.kangyonggan.common.Query;
import com.kangyonggan.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangyonggan
 * @since 6/7/18
 */
@RestController
@RequestMapping("article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章列表
     *
     * @return
     */
    @GetMapping
    public Response articles() {
        Response response = Response.getSuccessResponse();
        Query query = getQuery();
        query.put("applyStatus", ApplyStatus.COMPLETE.getCode());
        PageInfo<Article> pageInfo = articleService.articles(query);

        response.put("pageInfo", pageInfo);
        return response;
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(value = "{id:[\\d]+}")
    public Response detail(@PathVariable("id") Long id) {
        Response response = Response.getSuccessResponse();
        Article article = articleService.article(id);
        if (article != null) {
            article.setContent(MarkdownUtil.markdownToHtml(article.getContent()));
            Article prevArticle = articleService.articlePrev(id);
            response.put("prevArticle", prevArticle);
            Article nextArticle = articleService.articleNext(id);
            response.put("nextArticle", nextArticle);
        }

        response.put("article", article);
        return response;
    }

}
