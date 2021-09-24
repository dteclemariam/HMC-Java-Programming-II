import java.util.List;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<DataSet> dataSetList = fileReader.readFile("literacy.csv");
        //prints the literacy stats from low to the high ranked on literacy using the Double object method compareTo()
        dataSetList.stream().sorted((d1, d2) -> {
            return Double.valueOf(d1.getLiteracyPercentage()).compareTo(d2.getLiteracyPercentage());
        }).forEach(dataSet -> System.out.println(dataSet));


    }
}
