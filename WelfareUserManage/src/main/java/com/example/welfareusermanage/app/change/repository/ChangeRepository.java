package com.example.welfareusermanage.app.change.repository;

import com.example.welfareusermanage.app.change.entity.ChangeForm;
import com.example.welfareusermanage.app.change.entity.UpdateData;

public interface ChangeRepository {
	ChangeForm find(String userId);
	String update(UpdateData form);
}
