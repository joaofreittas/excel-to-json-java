package usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.LifePensionBrand;
import domain.LifePensionCompany;
import domain.LifePensionCosts;
import domain.LifePensionDefferalPeriod;
import domain.LifePensionDefferalPeriodMinimumPremiumAmount;
import domain.LifePensionLoading;
import domain.LifePensionMinimumRequirements;
import domain.LifePensionPeriodGrantBenefit;
import domain.LifePensionProduct;
import domain.LifePensionProductDetails;
import domain.ResponseLifePensionList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.ExtractValuesUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
        LifePensionPeriodGrantBenefit lifePensionPeriodGrantBenefit = new LifePensionPeriodGrantBenefit();
        LifePensionCosts costs = new LifePensionCosts();
        LifePensionMinimumRequirements lifePensionMinimumRequirements = new LifePensionMinimumRequirements();

        int cellIndex = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          factoryProductByCell(
                  currentCell,
                  cellIndex,
                  product,
                  details,
                  lifePensionDefferalPeriod,
                  lifePensionPeriodGrantBenefit,
                  costs,
                  lifePensionMinimumRequirements
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

  private void factoryProductByCell(
          Cell currentCell,
          Integer cellIndex,
          LifePensionProduct product,
          LifePensionProductDetails details,
          LifePensionDefferalPeriod lifePensionDefferalPeriod,
          LifePensionPeriodGrantBenefit lifePensionPeriodGrantBenefit,
          LifePensionCosts costs,
          LifePensionMinimumRequirements lifePensionMinimumRequirements
  ) {

    buildProduct(currentCell, cellIndex, product);
    buildProductDetails(currentCell, cellIndex, details);
    buildLifePensionDefferalPeriod(currentCell, cellIndex, lifePensionDefferalPeriod);
    buildGrantPeriodBenefit(currentCell, cellIndex, lifePensionPeriodGrantBenefit);
    buildLifePensionCosts(currentCell, cellIndex, costs);
    buildMinimunRequirements(currentCell, cellIndex, lifePensionMinimumRequirements);

    details.setDefferalPeriod(lifePensionDefferalPeriod);
    details.setGrantPeriodBenefit(lifePensionPeriodGrantBenefit);
    details.setCosts(costs);
    product.setProductDetails(details);
    product.setMinimumRequirements(lifePensionMinimumRequirements);

  }

  private void buildMinimunRequirements(Cell currentCell, Integer cellIndex, LifePensionMinimumRequirements lifePensionMinimumRequirements) {
    Integer CONTRACT_TYPE_INDEX = 31;
    Integer PARTICIPANT_QUALIFIED_INDEX = 32;
    Integer MIN_REQUIREMENTS_CONTRACT_INDEX = 33;

    if(cellIndex.equals(CONTRACT_TYPE_INDEX)) {
      lifePensionMinimumRequirements.setContractType(ExtractValuesUtil.extractContractTypeEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(PARTICIPANT_QUALIFIED_INDEX)) {
      lifePensionMinimumRequirements.setParticipantQualified(ExtractValuesUtil.extractBooleanValue(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(MIN_REQUIREMENTS_CONTRACT_INDEX)) {
      lifePensionMinimumRequirements.setMinRequirementsContract(currentCell.getStringCellValue());
    }
  }

  private void buildLifePensionCosts(Cell currentCell, Integer cellIndex, LifePensionCosts costs) {
    Integer LOADING_ANTECIPATED_INDEX = 29;
    Integer LOADING_LATE_INDEX = 30;

    if(cellIndex.equals(LOADING_ANTECIPATED_INDEX)) {
      LifePensionLoading lifePensionLoading = new LifePensionLoading();
      lifePensionLoading.setMinValue(BigDecimal.valueOf(currentCell.getNumericCellValue()));
      lifePensionLoading.setMaxValue(BigDecimal.valueOf(currentCell.getNumericCellValue()));
      costs.setLoadingAntecipated(lifePensionLoading);
    } else if(cellIndex.equals(LOADING_LATE_INDEX)) {
      LifePensionLoading lifePensionLoading = new LifePensionLoading();
      lifePensionLoading.setMinValue(BigDecimal.valueOf(currentCell.getNumericCellValue()));
      lifePensionLoading.setMaxValue(BigDecimal.valueOf(currentCell.getNumericCellValue()));
      costs.setLoadingLate(lifePensionLoading);
    }

  }

  private void buildGrantPeriodBenefit(Cell currentCell, Integer cellIndex, LifePensionPeriodGrantBenefit grantBenefit) {
    Integer INCOME_MODALITY_INDEX = 23;
    Integer BIOMETRIC_TABLE_INDEX = 24;
    Integer INTEREST_RATE_INDEX = 25;
    Integer UPDATE_INDEX_INDEX = 26;
    Integer REVERSAL_RESULTS_INDEX = 27;
    Integer INVESTMENT_FUNDS_INDEX = 28;

    if(cellIndex.equals(INCOME_MODALITY_INDEX)) {
      grantBenefit.setIncomeModality(Collections.singletonList(ExtractValuesUtil.extractIncomeModality(currentCell.getStringCellValue())));
    } else if(cellIndex.equals(BIOMETRIC_TABLE_INDEX)) {
      grantBenefit.setBiometricTable(ExtractValuesUtil.exctractBiometricTable(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(INTEREST_RATE_INDEX)) {
      grantBenefit.setInterestRate(BigDecimal.valueOf(currentCell.getNumericCellValue()));
    } else if(cellIndex.equals(UPDATE_INDEX_INDEX)) {
      grantBenefit.setUpdateIndex(ExtractValuesUtil.extractUpdateIndexGrantBenefitEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(REVERSAL_RESULTS_INDEX)) {
      grantBenefit.setReversalResultsFinancial(BigDecimal.valueOf(currentCell.getNumericCellValue()));
    } else if(cellIndex.equals(INVESTMENT_FUNDS_INDEX)) {
      grantBenefit.setInvestimentFunds(ExtractValuesUtil.extractInvestmentFunds(currentCell.getStringCellValue()));
    }
  }

  private void buildLifePensionDefferalPeriod(Cell currentCell, Integer cellIndex, LifePensionDefferalPeriod lifePensionDefferalPeriod) {
    Integer INTEREST_RATE_INDEX = 8;
    Integer UPDATE_INDEX_INDEX = 9;
    Integer OTHER_MINIMUN_PERFORMANCE_GARANTEES_INDEX = 10;
    Integer REVERSAL_FINANCIAL_RESULTS_INDEX = 11;
    Integer MINIMUM_PREMIUM_AMOUNT_INDEX = 12;
    Integer PREMIUM_PAYMENT_METHOD_INDEX = 13;
    Integer PERMISSION_EXTRAORDINARY_CONTRIBUTIONS_INDEX = 14;
    Integer PERMISSION_SCHEDULED_FINANCIAL_PAYMENTS_INDEX = 15;
    Integer GRACE_PERIOD_REDEMPTION_INDEX = 16;
    Integer GRACE_PERIOD_BETWEEN_REDEMPTION_REQUESTS_INDEX = 17;
    Integer REDEMPTION_PAYMENT_TERM_INDEX = 18;
    Integer GRACE_PERIOD_PORTABILITY_INDEX = 19;
    Integer GRACE_PERIOD_BETWEEN_PORTABILITY_REQUESTS_INDEX = 20;
    Integer PORTABILITY_PAYMENT_TERM_INDEX = 21;
    Integer INVESTMENT_FUNDS_INDEX = 22;

    if(cellIndex.equals(INTEREST_RATE_INDEX)) {
      String value = currentCell.getStringCellValue();
      lifePensionDefferalPeriod.setInterestRate(value.isBlank() ? BigDecimal.ZERO:BigDecimal.valueOf(Integer.parseInt(value)));
    } else if(cellIndex.equals(UPDATE_INDEX_INDEX)) {
      lifePensionDefferalPeriod.setUpdateIndex(ExtractValuesUtil.extractUpdateIndexEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(OTHER_MINIMUN_PERFORMANCE_GARANTEES_INDEX)) {
      lifePensionDefferalPeriod.setOtherMinimumPerformanceGarantees(currentCell.getStringCellValue());
    } else if(cellIndex.equals(REVERSAL_FINANCIAL_RESULTS_INDEX)) {
      lifePensionDefferalPeriod.setReversalFinancialResults(BigDecimal.valueOf(currentCell.getNumericCellValue()));
    } else if(cellIndex.equals(MINIMUM_PREMIUM_AMOUNT_INDEX)) {
      LifePensionDefferalPeriodMinimumPremiumAmount lifePensionDefferalPeriodMinimumPremiumAmount = new LifePensionDefferalPeriodMinimumPremiumAmount();
      lifePensionDefferalPeriodMinimumPremiumAmount.setMinimumPremiumAmountValue(BigDecimal.valueOf(currentCell.getNumericCellValue()));
      lifePensionDefferalPeriod.setMinimumPremiumAmount(Collections.singletonList(lifePensionDefferalPeriodMinimumPremiumAmount));
    } else if(cellIndex.equals(PREMIUM_PAYMENT_METHOD_INDEX)) {
      lifePensionDefferalPeriod.setPremiumPaymentMethod(ExtractValuesUtil.extractPremiumPaymentMethod(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(PERMISSION_EXTRAORDINARY_CONTRIBUTIONS_INDEX)) {
      lifePensionDefferalPeriod.setPermissionExtraordinaryContributions(ExtractValuesUtil.extractBooleanValue(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(PERMISSION_SCHEDULED_FINANCIAL_PAYMENTS_INDEX)) {
      lifePensionDefferalPeriod.setPermissonScheduledFinancialPayments(ExtractValuesUtil.extractBooleanValue(currentCell.getStringCellValue()));
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
    } else if(cellIndex.equals(PORTABILITY_PAYMENT_TERM_INDEX)) {
      lifePensionDefferalPeriod.setPortabilityPaymentTerm((int) currentCell.getNumericCellValue());
    } else if(cellIndex.equals(INVESTMENT_FUNDS_INDEX)) {
      lifePensionDefferalPeriod.setInvestimentFunds(Collections.singletonList(ExtractValuesUtil.extractInvestmentFunds(currentCell.getStringCellValue())));
    }

  }

  private void buildProductDetails(Cell currentCell, Integer cellIndex, LifePensionProductDetails details) {
    Integer TYPE_INDEX = 3;
    Integer SUSEP_PROCESS_INDEX = 6;
    Integer CONTRACT_TERMS_CONDITIONS_INDEX = 7;

    if(cellIndex.equals(TYPE_INDEX)) {
      details.setType(ExtractValuesUtil.extractTypeEnum(currentCell.getStringCellValue()));
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
    Integer TARGET_AUDIENCE_INDEX = 34;

    if(cellIndex.equals(NAME_INDEX)) {
      product.setName(currentCell.getStringCellValue());
    } else if(cellIndex.equals(CODE_INDEX)) {
      product.setCode(String.valueOf((int) currentCell.getNumericCellValue()));
    } else if(cellIndex.equals(SEGMENT_INDEX)) {
      product.setSegment(ExtractValuesUtil.extractSegmentEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(MODALITY_INDEX)) {
      product.setModality(ExtractValuesUtil.extractModalityEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(OPTIONAL_COVERAGE_INDEX)) {
      product.setOptionalCoverage(currentCell.getStringCellValue());
    } else if(cellIndex.equals(TARGET_AUDIENCE_INDEX)) {
      product.setTargetAudience(ExtractValuesUtil.extractTargetAudienceEnum(currentCell.getStringCellValue()));
    }
  }

  private Workbook getWorkbook() throws IOException {
    logger.info("Reading workbook...");
    Workbook workbook;
    try (FileInputStream excelFile = new FileInputStream(FILE_PATH)) {
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
    lifePensionCompany.setCnpjNumber("51990695000137");
    lifePensionCompany.setProducts(products);
    return lifePensionCompany;
  }
}
