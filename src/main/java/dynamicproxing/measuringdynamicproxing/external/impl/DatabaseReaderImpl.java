package dynamicproxing.measuringdynamicproxing.external.impl;

import dynamicproxing.measuringdynamicproxing.external.DatabaseReader;

public class DatabaseReaderImpl implements DatabaseReader {
    @Override
    public int countRowsInTable (String table) throws InterruptedException {
        System.out.printf("DatabaseReaderImpl - counting rows in table %s%n", table);

        Thread.sleep(1000);
        return 50;
    }

    @Override
    public String[] readRow(String query) throws InterruptedException {
        System.out.printf("DatabaseReaderImpl - Executing SQL query %s%n", query);

        Thread.sleep(1500);
        return new String[]{"column1", "column2","column3"};
    }
}
