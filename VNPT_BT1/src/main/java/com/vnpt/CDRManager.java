package com.vnpt;

import com.vnpt.dao.CDR_DAO;
import com.vnpt.dao.CDR_DAOImpl;
import com.vnpt.model.CDR;
import com.vnpt.utils.ConfigInfo;
import com.vnpt.utils.ReadFileCDR;

import java.util.List;

public class CDRManager {

    public static void main(String[] args) {

        CDR_DAO cdrDao = new CDR_DAOImpl();
        String fileName = ConfigInfo.FILE_NAME;
        int time = ConfigInfo.TIME_AUTO;

        while (true) {
            List<CDR> list = ReadFileCDR.readData(fileName);
            cdrDao.deleteDataAndInsertLog();
            cdrDao.insertDataToDB(list);
            try {
                Thread.sleep(time);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
