package data_utils;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

public class CSVReaderUtil {

        public static List<Map<String, String>> readCsvAsMap(String filePath) {

            List<Map<String,String>> records = new ArrayList<>();

            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

                String[] header = reader.readNext(); // first row
                String[] line;

                while ((line = reader.readNext()) != null) {

                    Map<String, String> dataMap = new HashMap<>();

                    for (int i = 0; i < header.length; i++) {
                        dataMap.put(header[i], line[i]);
                    }
                        records.add(dataMap);
                }

            } catch (Exception e) {
                throw new RuntimeException("CSV read failed", e);
            }

            return records;
        }

    public static Object[][] readCsv(String filePath) {

        List<Object[]> records = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            String[] header = reader.readNext(); // first row
            String[] line;

            while ((line = reader.readNext()) != null) {

                Map<String, String> dataMap = new HashMap<>();

                for (int i = 0; i < header.length; i++) {
                    dataMap.put(header[i], line[i]);
                }
                    records.add(new Object[]{dataMap});
            }

        } catch (Exception e) {
            throw new RuntimeException("CSV read failed", e);
        }

        return records.toArray(new Object[0][]);
    }

//        public static void main(String[] args){
//
//            System.out.println(readCsvAsMap(filePath).get(1).get("id"));
////            int row = 1;
////            int numberOfTotalRows = readCsv(filePath).length;
////            Map<Object, Object> dataMap = new HashMap<>();
////            for(int i=0; i<numberOfTotalRows;i++) {
////                dataMap = (Map<Object, Object>) readCsv(filePath)[i][0];
////                System.out.println(dataMap);
////                System.out.println(dataMap.get("id"));
////            }
//
//        }
    }

