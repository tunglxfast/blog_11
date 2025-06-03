package com.lab231.myblog.repository;

import com.lab231.myblog.model.BlogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogEntryRepository extends JpaRepository<BlogEntry, Long> {
    List<BlogEntry> findTop3ByOrderByPublishedDateDesc();
    List<BlogEntry> findAllByOrderByPublishedDateDesc();


}
