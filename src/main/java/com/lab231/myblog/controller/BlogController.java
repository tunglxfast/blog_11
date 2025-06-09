package com.lab231.myblog.controller;

import com.lab231.myblog.model.BlogEntry;
import com.lab231.myblog.model.PageName;
import com.lab231.myblog.service.PageViewService;
import com.lab231.myblog.service.BlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Controller
public class BlogController {
    @Autowired
    private PageViewService pageViewService;
    @Autowired
    private BlogEntryService blogEntryService;

    @GetMapping(value = {"/", "index", "/home"})
    public String home(Model model) {
        List<BlogEntry> top3 = blogEntryService.getTop3BlogEntries();
        long viewCount = pageViewService.increaseView(PageName.BLOG.name);
        List<Character> viewCountDigits = pageViewService.getPaddedViewCountDigits(viewCount);
        model.addAttribute("viewCountDigits", viewCountDigits);
        model.addAttribute("entries", top3);
        return "index";
    }

    @GetMapping("/overview")
    public String overview(Model model) {
        Map<String, List<BlogEntry>> grouped = blogEntryService.getEntriesGroupedByMonthYear();
        long viewCount = pageViewService.increaseView(PageName.OVERVIEW.name);
        List<Character> viewCountDigits = pageViewService.getPaddedViewCountDigits(viewCount);
        model.addAttribute("groupedEntries", grouped);
        model.addAttribute("viewCountDigits", viewCountDigits);
        return "overview";
    }

    @GetMapping("/entry/{id}")
    public String detail(@PathVariable Long id, Model model) {
        BlogEntry blogEntry = blogEntryService.getBlogEntryById(id);
        if (blogEntry != null) {
            long viewCount = pageViewService.increaseView(PageName.DETAIL.name);
            List<Character> viewCountDigits = pageViewService.getPaddedViewCountDigits(viewCount);
            model.addAttribute("viewCountDigits", viewCountDigits);
            model.addAttribute("entry", blogEntry);
            return "detail";
        } else {
            long viewCount = pageViewService.increaseView(PageName.BLOG.name);
            List<Character> viewCountDigits = pageViewService.getPaddedViewCountDigits(viewCount);
            model.addAttribute("viewCountDigits", viewCountDigits);
            model.addAttribute("error", "Blog entry not found");
            return "index";
        }
    }
}
