package Student.Skill.Assessment.Service;

import Student.Skill.Assessment.Entity.CsvData;
import Student.Skill.Assessment.Repository.CsvDataRepository;
import com.opencsv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
@Service
public class CsvUploadService {
    @Autowired
    private CsvDataRepository csvDataRepository;

    public void importCsvData(MultipartFile file) throws IOException {
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            Iterable<CSVRecord> csvRecords = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader() // Assumes the first row is the header row
                    .parse(reader);

            for (CSVRecord csvRecord : csvRecords) {
                CsvData csvData = new CsvData();
                Map<String, String> data = new HashMap<>();

                // Iterate through CSV header columns dynamically
                for (String headerName : csvRecord.getParser().getHeaderNames()) {
                    String columnValue = csvRecord.get(headerName);
                    data.put(headerName, columnValue);
                }

                csvData.setData(data);
                csvDataRepository.save(csvData);
            }
        }
    }
}
