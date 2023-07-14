package com.example.welfareusermanage.table.repository.interfaces;

import java.util.List;

import com.example.welfareusermanage.app.change.entity.ToolsChecked;
import com.example.welfareusermanage.table.entity.WelfareToolMst;

public interface WelfareToolMstRepository {
	List<WelfareToolMst> find();
	List<ToolsChecked> check();
}
