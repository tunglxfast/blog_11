package com.lab231.myblog.service;

import com.lab231.myblog.model.BlogEntry;
import com.lab231.myblog.repository.BlogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.TextStyle;
import java.util.*;

@Service
public class BlogEntryService {
    @Autowired
    private BlogEntryRepository blogEntryRepository;

    public List<BlogEntry> findAllByOrderByPublishedDateDesc() {
        return blogEntryRepository.findAllByOrderByPublishedDateDesc();
    }

    public Map<String, List<BlogEntry>> getEntriesGroupedByMonthYear() {
        List<BlogEntry> entries = findAllByOrderByPublishedDateDesc();
        Map<String, List<BlogEntry>> grouped = new LinkedHashMap<>();
        for (BlogEntry entry : entries) {
            String monthYear = entry.getPublishedDate().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase()
                    + " " + entry.getPublishedDate().getYear();
            grouped.computeIfAbsent(monthYear, k -> new ArrayList<>()).add(entry);
        }
        return grouped;
    }

    public List<BlogEntry> getTop3BlogEntries() {
        return blogEntryRepository.findTop3ByOrderByPublishedDateDesc();
    }

    /**
     * Get a blog entry by its ID
     * @param id the ID of the blog entry
     * @return the blog entry, or null if it does not exist
     */
    public BlogEntry getBlogEntryById(Long id) {
        return blogEntryRepository.findById(id).orElse(null);
    }
} 