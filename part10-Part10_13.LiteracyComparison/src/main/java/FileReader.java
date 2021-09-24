import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private List<DataSet> dataSetList;


    public FileReader(){
        this.dataSetList = new ArrayList<>();
    }

    public List<DataSet> readFile(String file){
        List<DataSet> dataSetList = new ArrayList<>();
        try (Scanner fileReader = new Scanner(Paths.get(file))) {
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                String [] parts = line.split(",");
                String country = sanitizeInput(parts[3]);
                int year = Integer.valueOf(sanitizeInput(parts[4]));
                String gender = sanitizeGender(parts[2]);
                double literacyPercentage = Double.valueOf(sanitizeInput(parts[5]));
                dataSetList.add(new DataSet(country, year, gender, literacyPercentage));
            }

            //Solution reading using streams through Files.lines
//            Files.lines(Paths.get(file))
//                    .map(d -> d.split(","))
//                    .map(d -> new DataSet(d[3].trim(), Integer.parseInt(d[4].trim()),
//                            d[2].replace("(%)","").trim(), Double.parseDouble(d[5].trim())))
//                    .forEach(dataSet -> dataSetList.add(dataSet));

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return dataSetList;
    }

    private String sanitizeInput(String input){
        return input.trim();
    }

    private String sanitizeGender(String input){
        input = input.trim();
        String [] parts = input.split(" ");
        return parts[0];
    }


}
