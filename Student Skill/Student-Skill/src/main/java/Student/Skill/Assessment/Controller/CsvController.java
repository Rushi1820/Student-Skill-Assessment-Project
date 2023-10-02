package Student.Skill.Assessment.Controller;


import Student.Skill.Assessment.Service.CsvUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class CsvController {

    @Autowired
    private CsvUploadService csvService;

    @PostMapping("/api/v1/career/csv/upload")
    public ResponseEntity<String> uploadCsvFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (!file.isEmpty()) {
            csvService.importCsvData(file);
            return ResponseEntity.status(HttpStatus.OK).body("File data uploaded successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select a file to upload.");
        }
    }
}
