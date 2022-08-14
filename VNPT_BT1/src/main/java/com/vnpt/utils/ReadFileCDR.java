package com.vnpt.utils;


import com.vnpt.model.CDR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCDR {

    public static List<CDR> readData(String fileName) {
        List<CDR> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String word[] = line.split(",");
                String phoneNumber = word[0];
                String code = word[1];
                String dateTime = word[2];
                list.add(new CDR(phoneNumber, code, dateTime));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
