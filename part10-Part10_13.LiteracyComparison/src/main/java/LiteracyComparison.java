import java.util.List;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<DataSet> dataSetList = fileReader.readFile("literacy.csv");
        dataSetList.stream().sorted((d1, d2) -> {
            return d1.getLiteracyPercentage().compareTo(d2.getLiteracyPercentage());
        }).forEach(dataSet -> System.out.println(dataSet));


    }
}
