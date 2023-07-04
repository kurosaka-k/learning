package com.example.springoracle.app.sample.repository;

import java.util.List;

import com.example.springoracle.table.entity.CareLevelMst;

public interface CareLevelMstRepository{
	List<CareLevelMst> find();
	
}
