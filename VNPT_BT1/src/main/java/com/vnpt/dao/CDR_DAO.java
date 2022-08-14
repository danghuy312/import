package com.vnpt.dao;

import com.vnpt.model.CDR;

import java.util.List;

public interface CDR_DAO {

    void insertDataToDB(List<CDR> list);

    void deleteDataAndInsertLog();
}
