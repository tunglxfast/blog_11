package com.lab231.myblog.controller;

import com.lab231.myblog.model.BlogEntry;
import com.lab231.myblog.repository.BlogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogEntryRepository blogEntryRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<BlogEntry> top3 = blogEntryRepository.findTop3ByOrderByPublishedDateDesc();
        model.addAttribute("entries", top3);
        return "index";
    }

    @GetMapping("/overview")
    public String overview(Model model) {
        model.addAttribute("entries", blogEntryRepository.findAllByOrderByPublishedDateDesc());
        return "overview";
    }

    @GetMapping("/entry/{id}")
    public String detail(@PathVariable Long id, Model model) {
        BlogEntry blogEntry = blogEntryRepository.findById(id).orElse(null);
        if (blogEntry != null) {
            model.addAttribute("entry", blogEntry);
            return "detail";
        } else {
            return "error";
        }
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
