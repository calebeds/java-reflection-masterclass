package dynamicproxing.measuringdynamicproxing.external;

public interface DatabaseReader {
    int countRowsInTable(String table) throws InterruptedException;

    String[] readRow(String query) throws InterruptedException;
}
