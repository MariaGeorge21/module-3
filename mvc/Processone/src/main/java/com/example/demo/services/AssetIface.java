package com.example.demo.services;

import java.util.Optional;

import com.example.demo.model.FTTIssueBase;

public interface AssetIface {
	public Optional<FTTIssueBase> findById(String id);

}
