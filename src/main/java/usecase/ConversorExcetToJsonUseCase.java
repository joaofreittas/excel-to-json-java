package usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class ConversorExcetToJsonUseCase {

  private Logger logger;
  private final String FILE_PATH = "C:/Users/joao.freitas/dev/excel-to-json/src/main/resources/data.xlsx";
  private final String SHEET_NAME = "Persons";

  public ConversorExcetToJsonUseCase(){
    this.logger = Logger.getLogger(ConversorExcetToJsonUseCase.class.getName());
  }

  public String execute() {
    List<Person> persons = readExcelFile();
    return convertPersonsToJson(persons);
  }

  private List<Person> readExcelFile() {
    logger.info("Reading excel file...");
    try{
      Workbook workbook = getWorkbook();

      Sheet sheet = workbook.getSheet(SHEET_NAME);
      Iterator<Row> rows = sheet.iterator();
      List<Person> persons = new ArrayList<Person>();

      int rowNumber = 0;
      while (rows.hasNext()){
        Row currentRow = rows.next();

        if(isFirstLine(rowNumber)) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();
        Person person = new Person();

        int cellIndex = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          factoryPersonByCell(currentCell, cellIndex, person);

          cellIndex++;
        }
        persons.add(person);
      }

      workbook.close();
      return persons;

    }catch (Exception error) {
      logger.warning("Error reading file!");
      error.printStackTrace();
      throw new RuntimeException(error);
    }
  }

  private boolean isFirstLine(int rowNumber) {
    return rowNumber == 0;
  }

  private Person factoryPersonByCell(Cell currentCell, Integer cellIndex, Person person) {
    Integer ID_INDEX = 0;
    Integer NAME_INDEX = 1;
    Integer AGE_INDEX = 2;

    if(cellIndex.equals(ID_INDEX)) {
      person.setId((long) currentCell.getNumericCellValue());

    } else if(cellIndex.equals(NAME_INDEX)) {
      person.setName(currentCell.getStringCellValue());

    } else if(cellIndex.equals(AGE_INDEX)) {
      person.setAge((int) currentCell.getNumericCellValue());
    }

    return person;
  }

  private Workbook getWorkbook() throws IOException {
    logger.info("Reading workbook...");
    Workbook workbook;
    try (FileInputStream excelFile = new FileInputStream(new File(FILE_PATH))) {
      workbook = new XSSFWorkbook(excelFile);
    }

    logger.info("Workbook is correct!");
    return workbook;
  }

  private String convertPersonsToJson(List<Person> customers) {
    logger.info("Converting objects to Json...");
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = "";
    try {
      jsonString = mapper.writeValueAsString(customers);
    } catch (JsonProcessingException e) {
      logger.warning("Error in transformation to json!");
      e.printStackTrace();
    }

    logger.info("Transformation to json completed!");
    return jsonString;
  }
}
