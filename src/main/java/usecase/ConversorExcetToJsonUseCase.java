package usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.PersonAgeAdjustment;
import domain.PersonBenefitRecalculation;
import domain.PersonBrand;
import domain.PersonCompany;
import domain.PersonCoverageAttibutesDetails;
import domain.PersonCoverageAttibutesDetailsUnit;
import domain.PersonCoverageAttributes;
import domain.PersonGracePeriodUnit;
import domain.PersonPmbacRemuneration;
import domain.PersonProducts;
import domain.PersonProductsCoverages;
import domain.PersonTermsAndCondition;
import domain.ResponsePersonListData;
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
  private final String FILE_PATH = "C:/Users/joao.freitas/data/data-person.xlsx";
  private final String SHEET_NAME = "data-person";

  public ConversorExcetToJsonUseCase(){
    this.logger = Logger.getLogger(ConversorExcetToJsonUseCase.class.getName());
  }

  public String execute() {
    List<PersonProducts> products = readExcelFile();
    return convertPersonsToJson(getResponse(products));
  }

  private List<PersonProducts> readExcelFile() {
    logger.info("Reading excel file...");
    try{
      Workbook workbook = getWorkbook();

      Sheet sheet = workbook.getSheet(SHEET_NAME);
      Iterator<Row> rows = sheet.iterator();
      List<PersonProducts> products = new ArrayList<PersonProducts>();

      int rowNumber = 0;
      while (rows.hasNext()){
        Row currentRow = rows.next();

        if(isFirstLine(rowNumber)) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        PersonProducts product = new PersonProducts();
        PersonProductsCoverages personProductsCoverages = new PersonProductsCoverages();
        PersonTermsAndCondition personTermsAndCondition = new PersonTermsAndCondition();
        PersonCoverageAttributes personCoverageAttributes = new PersonCoverageAttributes();
        PersonCoverageAttibutesDetails personCoverageAttibutesDetailsMin = new PersonCoverageAttibutesDetails();
        PersonCoverageAttibutesDetails personCoverageAttibutesDetailsMax = new PersonCoverageAttibutesDetails();
        PersonCoverageAttibutesDetailsUnit personCoverageAttibutesDetailsUnitMin = new PersonCoverageAttibutesDetailsUnit();
        PersonCoverageAttibutesDetailsUnit personCoverageAttibutesDetailsUnitMax = new PersonCoverageAttibutesDetailsUnit();
        PersonGracePeriodUnit personGracePeriodUnit = new PersonGracePeriodUnit();
        PersonPmbacRemuneration pmbacRemuneration = new PersonPmbacRemuneration();
        PersonBenefitRecalculation personBenefitRecalculation = new PersonBenefitRecalculation();
        PersonAgeAdjustment personAgeAdjustment = new PersonAgeAdjustment();

        int cellIndex = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          factoryProductByCell(
                  currentCell,
                  cellIndex,
                  product,
                  personProductsCoverages,
                  personTermsAndCondition,
                  personCoverageAttributes,
                  personCoverageAttibutesDetailsMin,
                  personCoverageAttibutesDetailsMax,
                  personCoverageAttibutesDetailsUnitMin,
                  personCoverageAttibutesDetailsUnitMax,
                  personGracePeriodUnit,
                  pmbacRemuneration,
                  personBenefitRecalculation,
                  personAgeAdjustment
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
          PersonProducts product,
          PersonProductsCoverages personProductsCoverages,
          PersonTermsAndCondition personTermsAndCondition,
          PersonCoverageAttributes personCoverageAttributes,
          PersonCoverageAttibutesDetails personCoverageAttibutesDetailsMin,
          PersonCoverageAttibutesDetails personCoverageAttibutesDetailsMax,
          PersonCoverageAttibutesDetailsUnit personCoverageAttibutesDetailsUnitMin,
          PersonCoverageAttibutesDetailsUnit personCoverageAttibutesDetailsUnitMax,
          PersonGracePeriodUnit personGracePeriodUnit,
          PersonPmbacRemuneration pmbacRemuneration,
          PersonBenefitRecalculation personBenefitRecalculation,
          PersonAgeAdjustment personAgeAdjustment
  ) {

    buildProduct(currentCell, cellIndex, product);
    buildPersonCoverages(currentCell, cellIndex, personProductsCoverages);
    buildPersonTermsAndConditions(currentCell, cellIndex, personTermsAndCondition);
    buildPersonCoverageAttributes(currentCell, cellIndex, personCoverageAttributes);
    buildGracePeriodUnit(currentCell, cellIndex, personGracePeriodUnit);
    buildPersonCoverageAttibutesDetailsUnitMin(currentCell, cellIndex, personCoverageAttibutesDetailsUnitMin);
    buildPersonCoverageAttibutesDetailsUnitMax(currentCell, cellIndex, personCoverageAttibutesDetailsUnitMax);
    buildPersonCoverageAttributesDetailsMin(currentCell, cellIndex, personCoverageAttibutesDetailsMin);
    buildPersonCoverageAttributesDetailsMax(currentCell, cellIndex, personCoverageAttibutesDetailsMax);
    buildPersonPmbacRemuneration(currentCell, cellIndex, pmbacRemuneration);
    buildPersonBenefitRecalculation(currentCell, cellIndex, personBenefitRecalculation);
    buildPersonAgeAdjustment(currentCell, cellIndex, personAgeAdjustment);

    personCoverageAttibutesDetailsMin.setUnit(personCoverageAttibutesDetailsUnitMin);
    personCoverageAttibutesDetailsMax.setUnit(personCoverageAttibutesDetailsUnitMax);
    personCoverageAttributes.setMinValue(personCoverageAttibutesDetailsMin);
    personCoverageAttributes.setMaxValue(personCoverageAttibutesDetailsMax);
    personCoverageAttributes.setGracePeriod(personGracePeriodUnit);
    personProductsCoverages.setCoverageAttributes(personCoverageAttributes);
    product.setCoverages(Collections.singletonList(personProductsCoverages));
    product.setTermsAndConditions(Collections.singletonList(personTermsAndCondition));
    product.setBenefitRecalculation(personBenefitRecalculation);
    product.setPmbacRemuneration(pmbacRemuneration);
  }

  private void buildPersonAgeAdjustment(Cell currentCell, Integer cellIndex, PersonAgeAdjustment personAgeAdjustment) {
    Integer CRITERIO_REENQUADRAMENTO = 41;
    Integer PERIODICIDADE_REENQUADRAMENTO = 42;

    if(cellIndex.equals(CRITERIO_REENQUADRAMENTO)) {
      personAgeAdjustment.setCriterion(ExtractValuesUtil.extractCriterionEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(PERIODICIDADE_REENQUADRAMENTO)) {
      personAgeAdjustment.setFrequency(currentCell.getStringCellValue().equals("") ? 0 : Integer.valueOf(currentCell.getStringCellValue()));
    }

  }

  private void buildPersonBenefitRecalculation(Cell currentCell, Integer cellIndex, PersonBenefitRecalculation personBenefitRecalculation) {
    Integer CRITERIO = 39;
    Integer INDICE_ATUALIZACAO = 40;

    if(cellIndex.equals(CRITERIO)) {
      personBenefitRecalculation.setBenefitRecalculationCriteria(ExtractValuesUtil.extractBenefitRecalculationCriteria(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(INDICE_ATUALIZACAO)) {
      personBenefitRecalculation.setBenefitUpdateIndex(ExtractValuesUtil.extractBenefitUpdateIndex(currentCell.getStringCellValue()));
    }
  }

  private void buildPersonPmbacRemuneration(Cell currentCell, Integer cellIndex, PersonPmbacRemuneration pmbacRemuneration) {
    Integer TAXA_JUROS = 37;
    Integer INDICE_PMBAC = 38;

    if(cellIndex.equals(TAXA_JUROS)) {
      pmbacRemuneration.setInterestRate(currentCell.getStringCellValue().equals("") ? BigDecimal.ZERO : BigDecimal.valueOf(Float.valueOf(currentCell.getStringCellValue())));
    } else if(cellIndex.equals(INDICE_PMBAC)) {
      pmbacRemuneration.setPmbacUpdateIndex(ExtractValuesUtil.extractUpdateIndex(currentCell.getStringCellValue()));
    }
  }

  private void buildGracePeriodUnit(Cell currentCell, Integer cellIndex, PersonGracePeriodUnit personGracePeriodUnit) {
    Integer PERIODO_CARENCIA = 24;
    Integer PERIODO_CARENCIA_UNIDADE = 25;

    if(cellIndex.equals(PERIODO_CARENCIA)) {
      personGracePeriodUnit.setAmount(BigDecimal.valueOf(currentCell.getNumericCellValue()));
    } else if(cellIndex.equals(PERIODO_CARENCIA_UNIDADE)) {
      if(!currentCell.getStringCellValue().equals("")) {
        personGracePeriodUnit.setUnit(ExtractValuesUtil.extractUnit(currentCell.getStringCellValue()));
      }
    }
  }

  private void buildPersonCoverageAttibutesDetailsUnitMax(Cell currentCell, Integer cellIndex, PersonCoverageAttibutesDetailsUnit personCoverageAttibutesDetailsUnit) {
    Integer VALOR_MAXIMO_UNIDADE = 19;
    Integer VALOR_MAXIMO_MOEDA_DESCRICAO = 20;

    if(cellIndex.equals(VALOR_MAXIMO_UNIDADE)) {
      personCoverageAttibutesDetailsUnit.setCode(currentCell.getStringCellValue());
    } else if(cellIndex.equals(VALOR_MAXIMO_MOEDA_DESCRICAO)) {
      personCoverageAttibutesDetailsUnit.setDescription(currentCell.getStringCellValue());
    }

  }

  private void buildPersonCoverageAttibutesDetailsUnitMin(Cell currentCell, Integer cellIndex, PersonCoverageAttibutesDetailsUnit personCoverageAttibutesDetailsUnit) {
    Integer VALOR_MINIMO_UNIDADE = 16;
    Integer VALOR_MINIMO_MOEDA_DESCRICAO = 17;

    if(cellIndex.equals(VALOR_MINIMO_UNIDADE)) {
      personCoverageAttibutesDetailsUnit.setCode(currentCell.getStringCellValue());
    } else if(cellIndex.equals(VALOR_MINIMO_MOEDA_DESCRICAO)) {
      personCoverageAttibutesDetailsUnit.setDescription(currentCell.getStringCellValue());
    }

  }

  private void buildPersonCoverageAttributesDetailsMax(Cell currentCell, Integer cellIndex, PersonCoverageAttibutesDetails personCoverageAttibutesDetails) {
    Integer VALOR_MAXIMO = 18;

    if(cellIndex.equals(VALOR_MAXIMO)) {
      personCoverageAttibutesDetails.setAmount(currentCell.getStringCellValue().equals("")  ? BigDecimal.ZERO : BigDecimal.valueOf(Float.valueOf(currentCell.getStringCellValue())));
    }

  }

  private void buildPersonCoverageAttributesDetailsMin(Cell currentCell, Integer cellIndex, PersonCoverageAttibutesDetails personCoverageAttibutesDetails) {
    Integer VALOR_MINIMO = 15;

    if(cellIndex.equals(VALOR_MINIMO)) {
      personCoverageAttibutesDetails.setAmount(currentCell.getStringCellValue().equals("")  ? BigDecimal.ZERO : BigDecimal.valueOf(Float.valueOf(currentCell.getStringCellValue())));
    }

  }

  private void buildPersonCoverageAttributes(Cell currentCell, Integer cellIndex, PersonCoverageAttributes personCoverageAttributes) {
    Integer INDEMINITY_PAYMENT_METHOD_INDEX = 11;
    Integer INDEMINITY_PAYMENT_FREQUENCY_INDEX = 12;
    Integer PERIODO_INDENIZAVEL = 21;
    Integer NUMERO_MAXIMO_PARCELAS_INDENIZAVEIS = 22;
    Integer MOEDA = 23;
    Integer FREQUENCIA_DIAS = 28;
    Integer FRANQUIA_DIAS_DIFERENCIA = 29;
    Integer FRANQUIA_REAIS = 30;
    Integer FRANQUIA_REAIS_DIFERENCIADA = 31;
    Integer RISCOS_EXCLUIDOS = 32;
    Integer RISCOS_EXCLUIDOS_URL = 33;
    Integer CONTRATACAO_ISOLADA = 34;

    if(cellIndex.equals(INDEMINITY_PAYMENT_FREQUENCY_INDEX)) {
      personCoverageAttributes.setIndemnityPaymentMethod(ExtractValuesUtil.extractIndemnityPaymentMethod(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(INDEMINITY_PAYMENT_FREQUENCY_INDEX)) {
      personCoverageAttributes.setIndemnityPaymentFrequency(ExtractValuesUtil.extractIndemnityPaymentFrequency(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(PERIODO_INDENIZAVEL)) {
      personCoverageAttributes.setIndemnifiablePeriod(Collections.singletonList(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(NUMERO_MAXIMO_PARCELAS_INDENIZAVEIS)) {
      personCoverageAttributes.setMaximumQtyIndemnifiableInstallments(currentCell.getStringCellValue().equals("") ? 0 : Integer.valueOf(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(MOEDA)) {
      if(!currentCell.getStringCellValue().equals("")){
        personCoverageAttributes.setCurrency(PersonCoverageAttributes.CurrencyEnum.fromValue(currentCell.getStringCellValue()));
      }
    } else if(cellIndex.equals(FREQUENCIA_DIAS)) {
      personCoverageAttributes.setDeductibleDays((int)currentCell.getNumericCellValue());
    } else if(cellIndex.equals(FRANQUIA_DIAS_DIFERENCIA)) {
      personCoverageAttributes.setDifferentiatedDeductibleDays(BigDecimal.valueOf(currentCell.getNumericCellValue()));
    } else if(cellIndex.equals(FRANQUIA_REAIS)) {
      personCoverageAttributes.setDeductibleBRL(BigDecimal.valueOf(currentCell.getNumericCellValue()));
    } else if(cellIndex.equals(FRANQUIA_REAIS_DIFERENCIADA)) {
      personCoverageAttributes.setDifferentiatedDeductibleBRL(currentCell.getStringCellValue());
    } else if(cellIndex.equals(RISCOS_EXCLUIDOS)) {
      personCoverageAttributes.setExcludedRisks(ExtractValuesUtil.extractExcludedRisk(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(CONTRATACAO_ISOLADA)) {
      personCoverageAttributes.setAllowApartPurchase(currentCell.getBooleanCellValue());
    } else if(cellIndex.equals(CONTRATACAO_ISOLADA)) {
      personCoverageAttributes.setAllowApartPurchase(currentCell.getBooleanCellValue());
    }
  }

  private void buildPersonTermsAndConditions(Cell currentCell, Integer cellIndex, PersonTermsAndCondition personTermsAndCondition) {
    Integer SUSEP_PROCESS_NUMBER_INDEX = 9;
    Integer DEFINITION_INDEX = 10;

    if(cellIndex.equals(SUSEP_PROCESS_NUMBER_INDEX)) {
      personTermsAndCondition.setSusepProcessNumber(currentCell.getStringCellValue());
    } else if(cellIndex.equals(DEFINITION_INDEX)) {
      personTermsAndCondition.setDefinition(currentCell.getStringCellValue());
    }

  }

  private void buildPersonCoverages(Cell currentCell, Integer cellIndex, PersonProductsCoverages personProductsCoverages) {
    Integer COVERAGE_INDEX = 4;
    Integer OTHER_COVERAGE = 5;


    if(cellIndex.equals(COVERAGE_INDEX)) {
      personProductsCoverages.setCoverage(ExtractValuesUtil.extractCoverageEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(OTHER_COVERAGE)) {
      personProductsCoverages.setCoverageOthers(Collections.singletonList(currentCell.getStringCellValue()));
    }

  }

  private void buildProduct(Cell currentCell, Integer cellIndex, PersonProducts product) {
    Integer NAME_INDEX = 0;
    Integer CODE_INDEX = 1;
    Integer CATEGORY_INDEX = 2;
    Integer MODALITY_INDEX = 3;
    Integer ADDITIONAL_INDEX = 6;
    Integer ASSISTANCE_TYPE_INDEX = 7;
    Integer ASSISTANCE_TYPE_ADD_INDEX = 8;
    Integer MODALIDADE_INDENIZACAO_INDEX = 13;
    Integer TIPO_RENDA = 14;
    Integer CAPITAL_GLOBAL = 35;
    Integer VIGENCIA = 36;


    if(cellIndex.equals(NAME_INDEX)) {
      product.setName(currentCell.getStringCellValue());
    } else if(cellIndex.equals(CODE_INDEX)) {
      product.setCode(String.valueOf((int) currentCell.getNumericCellValue()));
    } else if(cellIndex.equals(CATEGORY_INDEX)) {
      product.setCategory(ExtractValuesUtil.extractSegmentEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(MODALITY_INDEX)) {
      product.setInsuranceModality(ExtractValuesUtil.extractModalityEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(ADDITIONAL_INDEX)) {
      product.setAdditional(ExtractValuesUtil.extractAdditionalEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(ASSISTANCE_TYPE_INDEX)) {
      product.setAssistanceType(ExtractValuesUtil.extractAssistanceTypeEnum(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(ASSISTANCE_TYPE_ADD_INDEX)) {
      product.setAssistanceTypeOthers(Collections.singletonList(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(MODALIDADE_INDENIZACAO_INDEX)) {
      product.setIndemnityPaymentMethod(ExtractValuesUtil.extractIndemnityPaymentMethodProduct(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(TIPO_RENDA)) {
      product.setIndemnityPaymentIncome(ExtractValuesUtil.extractIndemnityPaymentInconmeProduct(currentCell.getStringCellValue()));
    } else if(cellIndex.equals(CAPITAL_GLOBAL)) {
      product.setGlobalCapital(currentCell.getBooleanCellValue());
    } else if(cellIndex.equals(VIGENCIA)) {
      product.setValidity(ExtractValuesUtil.extractValidityEnum(currentCell.getStringCellValue()));
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

  private String convertPersonsToJson(ResponsePersonListData response) {
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


  private ResponsePersonListData getResponse(List<PersonProducts> products) {
    ResponsePersonListData response = new ResponsePersonListData();
    response.setBrand(getBrand(products));
    return response;
  }

  private PersonBrand getBrand(List<PersonProducts> products) {
    PersonCompany company = getCompany(products);

    PersonBrand lifePensionBrand = new PersonBrand();
    lifePensionBrand.setName("BRADESCO SEGUROS S.A.");
    lifePensionBrand.setCompanies(Collections.singletonList(company));
    return lifePensionBrand;
  }

  private PersonCompany getCompany(List<PersonProducts> products) {
    PersonCompany lifePensionCompany = new PersonCompany();
    lifePensionCompany.setName("CIA VIDA E PREVIDENCIA - 686");
    lifePensionCompany.setCnpjNumber("51990695000137");
    lifePensionCompany.setProducts(products);
    return lifePensionCompany;
  }
}
