package com.example.welfareusermanage.app.detailData.repository;

import com.example.welfareusermanage.app.detailData.entity.DetailDataForm;

public interface DetailDataFormRepository {
	DetailDataForm find(String userId);
}
