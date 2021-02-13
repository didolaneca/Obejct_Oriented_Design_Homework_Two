import java.util.Arrays;

public class Database {
    private String[] colNames;
    private int numRows;
    private String[][] data;

    public String[] getColNames() {
        return colNames;
    }

    public void setColNames(String[] colNames) {
        this.colNames = colNames;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public Database(String contents) {
/* TODO
This constructor should take the contents of a CSV file and initialize the member variables of the Database class.
*/
        String[] fileContent = contents.split("\\n");
        this.colNames = fileContent[0].split(",");
        this.numRows = fileContent.length - 1;
        this.data = new String[fileContent.length - 1][this.colNames.length];
        for (int i = 0; i < fileContent.length - 1; i++) {
            this.data[i] = fileContent[i + 1].split(",") ;
        }
    }

    public String getValue(String columnName,int row){
/* TODO
This method should return the data contained on row "row" and the column matching  @columname */
        return this.data[row][findColByName(columnName)];
    }

    private int findColByName(String colName) {
        int result = 0;
        for (int i = 0; i < colNames.length; i++) {
            if( colNames[i].equals(colName)){
                result = i;
            }
        }
        return result;
    }

}


