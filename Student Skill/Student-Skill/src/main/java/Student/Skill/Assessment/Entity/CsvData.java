package Student.Skill.Assessment.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "Csv_data_import")
public class CsvData {
    @Id
    private ObjectId id;
    private Map<String, String> data;
//    public void addDataColumn(String columnName, String columnValue) {
//        dataColumns.put(columnName, columnValue);
    }

