package TP3EJERCICIO2;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {
    public static List<Map<String, String>> where(Map<String, String> options)
            throws IOException {
        List<String[]> csvData = new ArrayList<String[]>();
        CSVReader reader = new CSVReader(new FileReader("src/main/resources/data.csv"));
        String[] row = null;

        while ((row = reader.readNext()) != null) {
            csvData.add(row);
        }

        reader.close();
        csvData.remove(0);
//REFACTORIZACION TP3
        if (options.containsKey("company_name")) {
            csvData = filtrar(csvData, 1, options.get("company_name"));
        }

        if (options.containsKey("city")) {
            csvData = filtrar(csvData, 4, options.get("city"));
        }

        if (options.containsKey("state")) {
            csvData = filtrar(csvData, 5, options.get("state"));
        }

        if (options.containsKey("round")) {
            csvData = filtrar(csvData, 9, options.get("round"));
        }

        List<Map<String, String>> output = new ArrayList<Map<String, String>>();

        for (int i = 0; i < csvData.size(); i++) {
            Map<String, String> mapped = new HashMap<String, String>();
            mapped.put("permalink", csvData.get(i)[0]);
            mapped.put("company_name", csvData.get(i)[1]);
            mapped.put("number_employees", csvData.get(i)[2]);
            mapped.put("category", csvData.get(i)[3]);
            mapped.put("city", csvData.get(i)[4]);
            mapped.put("state", csvData.get(i)[5]);
            mapped.put("funded_date", csvData.get(i)[6]);
            mapped.put("raised_amount", csvData.get(i)[7]);
            mapped.put("raised_currency", csvData.get(i)[8]);
            mapped.put("round", csvData.get(i)[9]);
            output.add(mapped);
        }
        return output;
    }
    private static List<String[]> filtrar(List<String[]> data, int index, String valor) {
        List<String[]> results = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i)[index].equals(valor)) {
                results.add(data.get(i));
            }
        }

        return results;
    }
}