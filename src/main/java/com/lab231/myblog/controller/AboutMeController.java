package com.lab231.myblog.controller;

import com.lab231.myblog.model.AboutMe;
import com.lab231.myblog.model.PageName;
import com.lab231.myblog.repository.AboutMeRepository;
import com.lab231.myblog.service.PageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AboutMeController {
    @Autowired
    private AboutMeRepository aboutMeRepository;
    @Autowired
    private PageViewService pageViewService;

    @GetMapping("/about")
    public String aboutPage(Model model) {
        List<AboutMe> abouts = aboutMeRepository.findAll();
        if (abouts.isEmpty()) {
            return "/home";
        } else {
            long viewCount = pageViewService.increaseView(PageName.ABOUT.name);
            List<Character> viewCountDigits = pageViewService.getPaddedViewCountDigits(viewCount);
            model.addAttribute("about", abouts.get(0));
            model.addAttribute("viewCountDigits", viewCountDigits);
            return "about";
        }
    }
}
