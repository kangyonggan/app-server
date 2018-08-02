package com.kangyonggan.as.service;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.as.constants.App;
import com.kangyonggan.pp.model.Phrasal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author kangyonggan
 * @since 8/2/18
 */
@FeignClient(App.PHRASAL_PLATFORM)
public interface PhrasalService {

    /**
     * 获取成语列表
     *
     * @param query
     * @return
     */
    @GetMapping("phrasal")
    PageInfo<Phrasal> list(@RequestParam("query") Map<String, Object> query);

    /**
     * 获取成语
     *
     * @param id
     * @return
     */
    @GetMapping("phrasal/{id}")
    Phrasal get(@PathVariable("id") Long id);

    /**
     * 成语接龙
     *
     * @param name
     * @return
     */
    @GetMapping("phrasal/below")
    List<Phrasal> below(@RequestParam("name") String name);
}
