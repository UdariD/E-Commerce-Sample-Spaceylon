package qa.leco.eapp.util;

import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvRoutines;
import qa.leco.eapp.data.BaseData;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DataProviderUtils {
    private DataProviderUtils() {}

    private static Object[][] toArray(ArrayList<ArrayList<? extends BaseData>> data) {
        int noOfRows = data.size();
        Object[][] dataArray = new Object[noOfRows][1];

        for (int i = 0; i < noOfRows; i++) {
            dataArray[i][0] = data.get(i).get(0);
        }

        return dataArray;
    }

    public static Object[][] processCsv(Class<? extends BaseData> clazz, String file, String id) {
        CsvParserSettings settings = new CsvParserSettings();

        settings.getFormat().setLineSeparator("\n");

        CsvRoutines routines = new CsvRoutines(settings);

        try (Reader reader =
                     new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            ArrayList<ArrayList<? extends BaseData>> testData = new ArrayList<>();

            routines.iterate(clazz, reader)
                    .forEach(
                            e -> {
                                if (e.getTestCaseId().equals(id)) {
                                    testData.add(
                                            new ArrayList<>() {
                                                {
                                                    add(e);
                                                }
                                            });
                                }
                            });

            return toArray(testData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Object[0][0];
    }
}
