package com.example.welfareusermanage.app.search.repository;

import java.util.List;

import com.example.welfareusermanage.app.search.entity.searchForm;
import com.example.welfareusermanage.app.search.entity.searchResult;

public interface SearchResultRepository {
	List<searchResult> search(searchForm searchform);
}
