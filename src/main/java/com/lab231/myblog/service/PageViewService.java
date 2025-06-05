package com.lab231.myblog.service;

import com.lab231.myblog.model.PageView;
import com.lab231.myblog.repository.PageViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageViewService {
    @Autowired
    private PageViewRepository pageViewRepo;

    @Transactional
    public long increaseView(String page) {
        PageView view = pageViewRepo.findByPage(page).orElse(new PageView(page, 0L));
        view.setCount(view.getCount() + 1);
        pageViewRepo.save(view);
        return view.getCount();
    }

    public long getViewCount(String page) {
        PageView view = pageViewRepo.findByPage(page).orElse(null);
        if (view != null) {
            return view.getCount();
        } else {
            return 0L;
        }
    }

    public List<Character> getPaddedViewCountDigits(long viewCount) {
        String viewStr = String.format("%0" + Math.max(6, String.valueOf(viewCount).length()) + "d", viewCount);
        List<Character> digits = new ArrayList<>();
        for (int i = 0; i < viewStr.length(); i++) {
            digits.add(viewStr.charAt(i));
        }
        return digits;
    }
}
