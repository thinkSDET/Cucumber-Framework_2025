package utility;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class DataTableMapper {

    public static List<Map<String, String>> convertToMap(DataTable dataTable) {
        return dataTable.asMaps(String.class, String.class);
    }
}
