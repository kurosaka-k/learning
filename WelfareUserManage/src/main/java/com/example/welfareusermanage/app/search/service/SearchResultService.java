package com.example.welfareusermanage.app.search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.welfareusermanage.app.search.entity.searchForm;
import com.example.welfareusermanage.app.search.entity.searchResult;
import com.example.welfareusermanage.app.search.repository.SearchResultRepository;

@Service
public class SearchResultService {
	private SearchResultRepository srRepository;
	
	public SearchResultService(SearchResultRepository srRepository) {
		this.srRepository = srRepository;
	}
	
	public SearchResultRepository getsrRepository() {
		return srRepository;
	}
	
	public List<searchResult> search(searchForm form){
		return getsrRepository().search(form);
	}
}
