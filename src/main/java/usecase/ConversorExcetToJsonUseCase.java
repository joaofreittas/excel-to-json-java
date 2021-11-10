package usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.LifePensionBrand;
import domain.LifePensionCompany;
import domain.LifePensionDefferalPeriod;
import domain.LifePensionProduct;
import domain.LifePensionProductDetails;
import domain.ResponseLifePensionList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class ConversorExcetToJsonUseCase {

  private Logger logger;
  private final String FILE_PATH = "C:/Users/joao.freitas/dev/excel-to-json/src/main/resources/life-pension.xlsx";
  private final String SHEET_NAME = "life-pension";

  public ConversorExcetToJsonUseCase(){
    this.logger = Logger.getLogger(ConversorExcetToJsonUseCase.class.getName());
  }

  public String execute() {
    List<LifePensionProduct> products = readExcelFile();

    return convertPersonsToJson(getResponse(products));
  }

  private List<LifePensionProduct> readExcelFile() {
    logger.info("Reading excel file...");
    try{
      Workbook workbook = getWorkbook();

      Sheet sheet = workbook.getSheet(SHEET_NAME);
      Iterator<Row> rows = sheet.iterator();
      List<LifePensionProduct> products = new ArrayList<LifePensionProduct>();

      int rowNumber = 0;
      while (rows.hasNext()){
        Row currentRow = rows.next();

        if(isFirstLine(rowNumber)) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        LifePensionProduct product = new LifePensionProduct();
        LifePensionProductDetails details = new LifePensionProductDetails();
        LifePensionDefferalPeriod lifePensionDefferalPeriod = new LifePensionDefferalPeriod();

        int cellIndex = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          factoryProductByCell(
                  currentCell,
                  cellIndex,
                  product,
                  details,
                  lifePensionDefferalPeriod
          );

          cellIndex++;
        }
        products.add(product);
      }

      workbook.close();
      return products;

    }catch (Exception error) {
      logger.warning("Error reading file!");
      error.printStackTrace();
      throw new RuntimeException(error);
    }
  }

  private boolean isFirstLine(int rowNumber) {
    return rowNumber == 0;
  }

  private LifePensionProduct factoryProductByCell(
          Cell currentCell,
          Integer cellIndex,
          LifePensionProduct product,
          LifePensionProductDetails details,
          LifePensionDefferalPeriod lifePensionDefferalPeriod
  ) {

    buildProduct(currentCell, cellIndex, product);
    buildProductDetails(currentCell, cellIndex, details);
    buildLifePensionDefferalPeriod(currentCell, cellIndex, lifePensionDefferalPeriod);


    details.setDefferalPeriod(lifePensionDefferalPeriod);
    product.setProductDetails(details);

    return product;
  }

  private void buildLifePensionDefferalPeriod(Cell currentCell, Integer cellIndex, LifePensionDefferalPeriod lifePensionDefferalPeriod) {
    Integer INTEREST_RATE_INDEX = 8;
    Integer UPDATE_INDEX_INDEX = 9;
    Integer OTHER_MINIMUN_PERFORMANCE_GARANTEES_INDEX = 10;
    Integer REVERSAL_FINANCIAL_RESULTS_INDEX = 11;
    Integer PERMISSION_EXTRAORDINARY_CONTRIBUTIONS_INDEX = 14;
    Integer PERMISSION_SCHEDULED_FINANCIAL_PAYMENTS_INDEX = 15;
    Integer GRACE_PERIOD_REDEMPTION_INDEX = 16;
    Integer GRACE_PERIOD_BETWEEN_REDEMPTION_REQUESTS_INDEX = 17;
    Integer REDEMPTION_PAYMENT_TERM_INDEX = 18;
    Integer GRACE_PERIOD_PORTABILITY_INDEX = 19;
    Integer GRACE_PERIOD_BETWEEN_PORTABILITY_REQUESTS_INDEX = 20;
    Integer PORTABILIT_PAYMENT_TERM_INDEX = 21;

    if(cellIndex.equals(INTEREST_RATE_INDEX)) {
      lifePensionDefferalPeriod.setInterestRate(currentCell.getStringCellValue());
    } else if(cellIndex.equals(UPDATE_INDEX_INDEX)) {
      lifePensionDefferalPeriod.setUpdateIndex(extractUpdateIndexEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(OTHER_MINIMUN_PERFORMANCE_GARANTEES_INDEX)) {
      lifePensionDefferalPeriod.setOtherMinimumPerformanceGarantees(currentCell.getStringCellValue());
    } else if(cellIndex.equals(REVERSAL_FINANCIAL_RESULTS_INDEX)) {
      lifePensionDefferalPeriod.setReversalFinancialResults(BigDecimal.valueOf(currentCell.getNumericCellValue()));
    } else if(cellIndex.equals(PERMISSION_EXTRAORDINARY_CONTRIBUTIONS_INDEX)) {
      lifePensionDefferalPeriod.setPermissionExtraordinaryContributions(extractBooleanValue(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(PERMISSION_SCHEDULED_FINANCIAL_PAYMENTS_INDEX)) {
      lifePensionDefferalPeriod.setPermissonScheduledFinancialPayments(extractBooleanValue(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(GRACE_PERIOD_REDEMPTION_INDEX)) {
      lifePensionDefferalPeriod.setGracePeriodRedemption(Integer.valueOf(currentCell.getStringCellValue().split(" ")[0]));
    } else if(cellIndex.equals(GRACE_PERIOD_BETWEEN_REDEMPTION_REQUESTS_INDEX)) {
      lifePensionDefferalPeriod.setGracePeriodBetweenRedemptionRequests(Integer.valueOf(currentCell.getStringCellValue().split(" ")[0]));
    } else if(cellIndex.equals(REDEMPTION_PAYMENT_TERM_INDEX)) {
      lifePensionDefferalPeriod.setRedemptionPaymentTerm((int) currentCell.getNumericCellValue());
    } else if(cellIndex.equals(GRACE_PERIOD_PORTABILITY_INDEX)) {
      lifePensionDefferalPeriod.setGracePeriodPortability((int) currentCell.getNumericCellValue());
    } else if(cellIndex.equals(GRACE_PERIOD_BETWEEN_PORTABILITY_REQUESTS_INDEX)) {
      lifePensionDefferalPeriod.setGracePeriodBetweenPortabilityRequests((int) currentCell.getNumericCellValue());
    } else if(cellIndex.equals(PORTABILIT_PAYMENT_TERM_INDEX)) {
      lifePensionDefferalPeriod.setPortabilityPaymentTerm((int) currentCell.getNumericCellValue());
    }

  }

  private void buildProductDetails(Cell currentCell, Integer cellIndex, LifePensionProductDetails details) {
    Integer TYPE_INDEX = 3;
    Integer SUSEP_PROCESS_INDEX = 6;
    Integer CONTRACT_TERMS_CONDITIONS_INDEX = 7;

    if(cellIndex.equals(TYPE_INDEX)) {
      details.setType(extractTypeEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(SUSEP_PROCESS_INDEX)) {
      details.setSusepProcessNumber(currentCell.getStringCellValue());
    } else if(cellIndex.equals(CONTRACT_TERMS_CONDITIONS_INDEX)) {
      details.setContractTermsConditions(currentCell.getStringCellValue());
    }

  }

  private void buildProduct(Cell currentCell, Integer cellIndex, LifePensionProduct product) {
    Integer NAME_INDEX = 0;
    Integer CODE_INDEX = 1;
    Integer SEGMENT_INDEX = 2;
    Integer MODALITY_INDEX = 4;
    Integer OPTIONAL_COVERAGE_INDEX = 5;

    if(cellIndex.equals(NAME_INDEX)) {
      product.setName(currentCell.getStringCellValue());
    } else if(cellIndex.equals(CODE_INDEX)) {
      product.setCode(String.valueOf((int) currentCell.getNumericCellValue()));
    } else if(cellIndex.equals(SEGMENT_INDEX)) {
      product.setSegment(extractSegmentEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(MODALITY_INDEX)) {
      product.setModality(extractModalityEnum(currentCell.getStringCellValue()));
    }else if(cellIndex.equals(OPTIONAL_COVERAGE_INDEX)) {
      product.setOptionalCoverage(currentCell.getStringCellValue());
    }
  }

  private Boolean extractBooleanValue(String value) {
    return value.equals("SIM");
  }

  private LifePensionProduct.ModalityEnum extractModalityEnum(String modality) {
    if(modality.equals("1. Contribuição variável") || modality.equals("CONTRIBUIÇÃO VARIÁVEL")) return LifePensionProduct.ModalityEnum.CONTRIBUICAO_VARIAVEL;
    if(modality.equals("2. Benefício definido") || modality.equals("BENEFÍCIO DEFINIDO")) return LifePensionProduct.ModalityEnum.BENEFICIO_DEFINIDO;
    return null;
  }

  private LifePensionProduct.SegmentEnum extractSegmentEnum(String segment) {
    if(segment.equals("1. Seguro Pessoas") || segment.equals("SEGURO PESSOAS")) return LifePensionProduct.SegmentEnum.SEGURO_PESSOAS;
    if(segment.equals("2. Previdência") || segment.equals("PREVIDÊNCIA")) return LifePensionProduct.SegmentEnum.PREVIDENCIA;
    return null;
  }

  private LifePensionProductDetails.TypeEnum extractTypeEnum(String type) {
    return LifePensionProductDetails.TypeEnum.fromValue(type);
  }

  private LifePensionDefferalPeriod.UpdateIndexEnum extractUpdateIndexEnum(String updateIndex) {
    return LifePensionDefferalPeriod.UpdateIndexEnum.fromValue(updateIndex);
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

  private String convertPersonsToJson(ResponseLifePensionList response) {
    logger.info("Converting objects to Json...");
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = "";
    try {
      jsonString = mapper.writeValueAsString(response);
    } catch (JsonProcessingException e) {
      logger.warning("Error in transformation to json!");
      e.printStackTrace();
    }

    logger.info("Transformation to json completed!");
    return jsonString;
  }


  private ResponseLifePensionList getResponse(List<LifePensionProduct> products) {
    ResponseLifePensionList response = new ResponseLifePensionList();
    response.setBrand(getBrand(products));
    return response;
  }

  private LifePensionBrand getBrand(List<LifePensionProduct> products) {
    LifePensionCompany company = getCompany(products);

    LifePensionBrand lifePensionBrand = new LifePensionBrand();
    lifePensionBrand.setName("Bradesco Seguros S.A.");
    lifePensionBrand.setCompanies(company);
    return lifePensionBrand;
  }

  private LifePensionCompany getCompany(List<LifePensionProduct> products) {
    LifePensionCompany lifePensionCompany = new LifePensionCompany();
    lifePensionCompany.setName("Bradesco Vida e Previdência");
    lifePensionCompany.setCnpjNumber("51.990.695/0001-37");
    lifePensionCompany.setProducts(products);
    return lifePensionCompany;
  }
}
