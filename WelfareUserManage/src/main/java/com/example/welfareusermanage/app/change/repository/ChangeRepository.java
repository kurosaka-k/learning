package com.example.welfareusermanage.app.change.repository;

import com.example.welfareusermanage.app.change.entity.ChangeForm;

public interface ChangeRepository {
	ChangeForm find(String userId);
}
