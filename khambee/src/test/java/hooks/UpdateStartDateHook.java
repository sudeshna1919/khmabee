package hooks;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UpdateStartDateHook {

    @Before
    public void updateStartDate(Scenario scenario) {
        String featureFilePath = "src/test/resources/features/course.feature";
        File featureFile = new File(featureFilePath);

        if (featureFile.exists()) {
            try {
                String content = new String(Files.readAllBytes(featureFile.toPath()));
                LocalDate tomorrow = LocalDate.now().plusDays(1);
                String newStartDate = tomorrow.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                LocalDate oldDate = LocalDate.parse("07/26/2024", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                String newDate = oldDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

                // Replace the placeholder with the new start date
                content = content.replaceAll("\\d{2}/\\d{2}/\\d{4}", newStartDate);

                // Write the updated content back to the feature file
                Files.write(featureFile.toPath(), content.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);

                System.out.println("Start date updated to " + newStartDate);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
