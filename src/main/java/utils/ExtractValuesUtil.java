package utils;

import domain.LifePensionDefferalPeriod;
import domain.LifePensionInvestmentFunds;
import domain.LifePensionMinimumRequirements;
import domain.LifePensionPeriodGrantBenefit;
import domain.LifePensionProduct;
import domain.LifePensionProductDetails;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtractValuesUtil {

  public static LifePensionMinimumRequirements.ContractTypeEnum extractContractTypeEnum(String stringCellValue) {
    Map<String, LifePensionMinimumRequirements.ContractTypeEnum> map = new HashMap<>();

    map.put("AVERBADO", LifePensionMinimumRequirements.ContractTypeEnum.COLETIVO_AVERBADO);
    map.put("INSTITUÍDO", LifePensionMinimumRequirements.ContractTypeEnum.COLETIVO_INSTITUIDO);
    map.put("INDIVIDUAL", LifePensionMinimumRequirements.ContractTypeEnum.INDIVIDUAL);

    return map.get(stringCellValue);
  }

  public static List<LifePensionDefferalPeriod.PremiumPaymentMethodEnum> extractPremiumPaymentMethod(String paymentMethod) {
    String[] fields = paymentMethod.split(" / ");
    String paymentMethod1 = fields[0];
    String paymentMethod2 = fields[1];

    Map<String, LifePensionDefferalPeriod.PremiumPaymentMethodEnum> map = new HashMap<>();

    map.put("CARTÃO DE CRÉDITO", LifePensionDefferalPeriod.PremiumPaymentMethodEnum.CARTAO_CREDITO);
    map.put("DÉBITO EM CONTA", LifePensionDefferalPeriod.PremiumPaymentMethodEnum.DEBITO_CONTA);
    map.put("DÉBITO EM CONTA POUPANÇA", LifePensionDefferalPeriod.PremiumPaymentMethodEnum.DEBITO_CONTA_POUPANCA);
    map.put("BOLETO BANCÁRIO", LifePensionDefferalPeriod.PremiumPaymentMethodEnum.BOLETO_BANCARIO);
    map.put("PIX", LifePensionDefferalPeriod.PremiumPaymentMethodEnum.PIX);
    map.put("REGRA PARCEIRO", LifePensionDefferalPeriod.PremiumPaymentMethodEnum.REGRA_PARCEIRO);
    map.put("CONSIGUINAÇÃO FOLHA DE PAGAMENTO", LifePensionDefferalPeriod.PremiumPaymentMethodEnum.CONSIGUINACAO_FOLHA_PAGAMENTO);
    map.put("PONTOS PROGRAMA BENEFÍCIO", LifePensionDefferalPeriod.PremiumPaymentMethodEnum.PONTOS_PROGRAMA_BENEFICIO);
    map.put("OUTROS", LifePensionDefferalPeriod.PremiumPaymentMethodEnum.OUTROS);

    return Arrays.asList(map.get(paymentMethod1), map.get(paymentMethod2));

  }

  public static LifePensionPeriodGrantBenefit.IncomeModalityEnum extractIncomeModality(String incomeModality) {
    HashMap<String, LifePensionPeriodGrantBenefit.IncomeModalityEnum> map = new HashMap<>();

    map.put("PAGAMENTO ÚNICO", LifePensionPeriodGrantBenefit.IncomeModalityEnum.PAGAMENTO_UNICO);
    map.put("RENDA PRAZO CERTO", LifePensionPeriodGrantBenefit.IncomeModalityEnum.RENDA_PRAZO_CERTO);
    map.put("RENDA TEMPORÁRIA", LifePensionPeriodGrantBenefit.IncomeModalityEnum.RENDA_TEMPORARIA);
    map.put("RNEDA TEMPORÁRIA REVERSÍVEL", LifePensionPeriodGrantBenefit.IncomeModalityEnum.RENDA_TEMPORARIA_REVERSIVEL);
    map.put("RENDA TEMPORÁRIA MÍNIMO GARANTIDO", LifePensionPeriodGrantBenefit.IncomeModalityEnum.RENDA_TEMPORARIA_MINMO_GARANTIDO);
    map.put("RENDA TEMPORÁRIA REVERSÍVEL GARANTIDO", LifePensionPeriodGrantBenefit.IncomeModalityEnum.RENDA_TEMPORARIA_REVERSIVEL_MININO_GARANTIDO);
    map.put("RENDA VITALÍCIA", LifePensionPeriodGrantBenefit.IncomeModalityEnum.RENDA_VITALICIA);
    map.put("RENDA VITALÍCIA REVERSÍVEL BENEFICIÁRIO INDICADO", LifePensionPeriodGrantBenefit.IncomeModalityEnum.RENDA_VITALICIA_REVERSIVEL_BENEFICIARIO_INDICADO);
    map.put("RENDA VITALÍCIA CÔNJUGE CONTINUIDADE MENORES", LifePensionPeriodGrantBenefit.IncomeModalityEnum.RENDA_VITALICIA_CONJUGE_CONTINUIDADE_MENORES);
    map.put("RENDA VITALÍCIA MÍNIMO GARANTIDO", LifePensionPeriodGrantBenefit.IncomeModalityEnum.RENDA_VITALICIA_MINIMO_GARANTIDO);
    map.put("RENDA VITALÍCIA PRAZO MÍNIMO GARANTIDO", LifePensionPeriodGrantBenefit.IncomeModalityEnum.RENDA_VITALICIA_PRAZO_MINIMO_GRANTIDO);

    return map.get(incomeModality);
  }

  public static List<LifePensionPeriodGrantBenefit.BiometricTableEnum> exctractBiometricTable(String biometricTable) {
    return biometricTable.startsWith("AT") ?
            Arrays.asList(LifePensionPeriodGrantBenefit.BiometricTableEnum.AT_2000_FEMALE_SUAVIZADA_10, LifePensionPeriodGrantBenefit.BiometricTableEnum.AT_2000_MALE_SUAVIZADA_10) :
            Arrays.asList(LifePensionPeriodGrantBenefit.BiometricTableEnum.BR_EMSSB_FEMALE, LifePensionPeriodGrantBenefit.BiometricTableEnum.BR_EMSSB_MALE);
  }

  public static LifePensionProduct.TargetAudienceEnum extractTargetAudienceEnum(String stringCellValue) {
    Map<String, LifePensionProduct.TargetAudienceEnum> map = new HashMap<>();

    map.put("PESSOA JURÍDICA", LifePensionProduct.TargetAudienceEnum.JURIDICA);
    map.put("PESSOA NATURAL", LifePensionProduct.TargetAudienceEnum.NATURAL);

    return map.get(stringCellValue);
  }

  public static LifePensionProduct.ModalityEnum extractModalityEnum(String modality) {
    Map<String, LifePensionProduct.ModalityEnum> map = new HashMap<>();

    map.put("1. Contribuição variável", LifePensionProduct.ModalityEnum.CONTRIBUICAO_VARIAVEL);
    map.put("2. Benefício definido", LifePensionProduct.ModalityEnum.BENEFICIO_DEFINIDO);
    map.put("CONTRIBUIÇÃO VARIÁVEL", LifePensionProduct.ModalityEnum.CONTRIBUICAO_VARIAVEL);
    map.put("BENEFÍCIO DEFINIDO", LifePensionProduct.ModalityEnum.BENEFICIO_DEFINIDO);

    return map.get(modality);
  }

  public static LifePensionProduct.SegmentEnum extractSegmentEnum(String segment) {
    Map<String, LifePensionProduct.SegmentEnum> map = new HashMap<>();

    map.put("1. Seguro Pessoas", LifePensionProduct.SegmentEnum.SEGURO_PESSOAS);
    map.put("2. Previdência", LifePensionProduct.SegmentEnum.PREVIDENCIA);
    map.put("SEGURO PESSOAS", LifePensionProduct.SegmentEnum.SEGURO_PESSOAS);
    map.put("PREVIDÊNCIA", LifePensionProduct.SegmentEnum.PREVIDENCIA);

    return map.get(segment);
  }

  public static LifePensionInvestmentFunds extractInvestmentFunds(String stringCellValue) {
    LifePensionInvestmentFunds investmentFunds = new LifePensionInvestmentFunds();
    String[] fields = stringCellValue.split("\n");

    investmentFunds.setCnpjNumber(fields[0]);
    investmentFunds.setCompanyName(fields[1]);
    investmentFunds.setMaximumAdministrationFee(BigDecimal.valueOf(Double.parseDouble(fields[2].replace(',', '.'))));
    investmentFunds.setMaximumPerformanceFee(fields[3].equals("Não se aplica") ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(fields[3].replace(',', '.'))));

    return investmentFunds;
  }

  public static Boolean extractBooleanValue(String value) {
    return value.equals("SIM");
  }

  public static LifePensionProductDetails.TypeEnum extractTypeEnum(String type) {
    return LifePensionProductDetails.TypeEnum.fromValue(type);
  }

  public static LifePensionDefferalPeriod.UpdateIndexEnum extractUpdateIndexEnum(String updateIndex) {
    return LifePensionDefferalPeriod.UpdateIndexEnum.fromValue(updateIndex);
  }

  public static LifePensionPeriodGrantBenefit.UpdateIndexEnum extractUpdateIndexGrantBenefitEnum(String updateIndex) {
    return LifePensionPeriodGrantBenefit.UpdateIndexEnum.fromValue(updateIndex);
  }

}
