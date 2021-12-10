package utils;

import domain.PersonAgeAdjustment;
import domain.PersonBenefitRecalculation;
import domain.PersonCoverageAttributes;
import domain.PersonGracePeriodUnit;
import domain.PersonPmbacRemuneration;
import domain.PersonProducts;
import domain.PersonProductsCoverages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtractValuesUtil {


  public static PersonProducts.InsuranceModalityEnum extractModalityEnum(String modality) {
    Map<String, PersonProducts.InsuranceModalityEnum> map = new HashMap<>();

    map.put("VIDA", PersonProducts.InsuranceModalityEnum.VIDA);
    map.put("ACIDENTES PESSOAIS", PersonProducts.InsuranceModalityEnum.ACIDENTES_PESSOAIS);
    map.put("VIAGEM", PersonProducts.InsuranceModalityEnum.VIAGEM);
    map.put("PRESTAMISTA (EXCETO HABITACIONAL E RURAL)", PersonProducts.InsuranceModalityEnum.PRESTAMISTA);
    map.put("OUTROS", PersonProducts.InsuranceModalityEnum.OUTROS);
    map.put("ACIDENTES PESSOAIS", PersonProducts.InsuranceModalityEnum.ACIDENTES_PESSOAIS);
    map.put("EDUCACIONAL", PersonProducts.InsuranceModalityEnum.EDUCACIONAL);
    map.put("DOTAL (MISTO E PURO)", PersonProducts.InsuranceModalityEnum.DOTAL);

    return map.get(modality);
  }

  public static PersonProductsCoverages.CoverageEnum extractCoverageEnum(String modality) {
    Map<String, PersonProductsCoverages.CoverageEnum> map = new HashMap<>();

    map.put("MORTE", PersonProductsCoverages.CoverageEnum.MORTE);
    map.put("MORTE ACIDENTAL", PersonProductsCoverages.CoverageEnum.MORTE_ACIDENTAL);
    map.put("CANCELAMENTO DE VIAGEM", PersonProductsCoverages.CoverageEnum.CANCELAMENTO_DE_VIAGEM);
    map.put("DESPESAS MEDICAS HOSPITALARES E/OU ODONTOLOGICAS", PersonProductsCoverages.CoverageEnum.DESPESAS_MEDICAS_HOSPITALARES_ODONTOLOGICAS);
    map.put("INVALIDEZ TOTAL POR ACIDENTE", PersonProductsCoverages.CoverageEnum.INVALIDEZ_TOTAL_ACIDENTE);
    map.put("OUTROS", PersonProductsCoverages.CoverageEnum.OUTRAS);
    map.put("REGRESSO SANITARIO", PersonProductsCoverages.CoverageEnum.REGRESSO_ANTECIPADO_SANITARIO);
    map.put("TRASLADO DE CORPO", PersonProductsCoverages.CoverageEnum.TRANSLADO_CORPO);
    map.put("TRASLADO MEDICO", PersonProductsCoverages.CoverageEnum.TRANSLADO_MEDICO);
    map.put("INCAPACIDADE TEMPORARIA", PersonProductsCoverages.CoverageEnum.INCAPACIDADE_TOTAL_OU_TEMPORARIA);
    map.put("DESEMPREGO/PERDA DE RENDA", PersonProductsCoverages.CoverageEnum.DESEMPREGO_PERDA_DE_RENDA);
    map.put("DOENCA GRAVE", PersonProductsCoverages.CoverageEnum.DOENCA_GRAVE);
    map.put("MORTE DO CONJUGE", PersonProductsCoverages.CoverageEnum.MORTE_CONJUGE);
    map.put("RESCISAO TRABALHISTA", PersonProductsCoverages.CoverageEnum.RESCISAO_TRABALHISTA);
    map.put("PERDA INVOLUNTARIA DE EMPREGO", PersonProductsCoverages.CoverageEnum.PERDA_INVOLUNTARIA_EMPREGO);
    map.put("INVALIDEZ FUNCIONAL PERMANENTE POR DOENCA", PersonProductsCoverages.CoverageEnum.INVALIDEZ_FUNCIONAL_PERMANENTE_DOENCA);
    map.put("MORTE DOS FILHOS", PersonProductsCoverages.CoverageEnum.MORTE_FILHOS);
    map.put("DIARIA INCAPACIDADE TOTAL E/OU TEMPORARIA", PersonProductsCoverages.CoverageEnum.DIARIA_INCAPACIDADE_TOTAL_TEMPORARIA);
    map.put("DIARIA POR INTERNACAO HOSPITALAR", PersonProductsCoverages.CoverageEnum.DIARIA_INTERNACAO_HOSPITALAR);
    map.put("DOENCA CONGENITA DE FILHOS (DCF)", PersonProductsCoverages.CoverageEnum.DOENCA_CONGENITA_FILHOS_DCF);
    map.put("INVALIDEZ LABORATIVA PERMANENTE POR DOENCA", PersonProductsCoverages.CoverageEnum.INVALIDEZ_LABORATIVA_DOENCA);
    map.put("RESCISAO TRABALHISTA", PersonProductsCoverages.CoverageEnum.RESCISAO_TRABALHISTA);
    map.put("SERVICO DE AUXILIO FUNERAL", PersonProductsCoverages.CoverageEnum.SERVICO_AUXILIO_FUNERAL);
    map.put("TRANSPLANTE DE ORGAOS", PersonProductsCoverages.CoverageEnum.TRANSPLANTE_ORGAOS);
    map.put("VERBA RESCISORIA", PersonProductsCoverages.CoverageEnum.VERBA_RESCISORIA);
    map.put("", PersonProductsCoverages.CoverageEnum.OUTRAS);

    return map.get(modality);
  }

  public static PersonProducts.CategoryEnum extractSegmentEnum(String segment) {
    Map<String, PersonProducts.CategoryEnum> map = new HashMap<>();

    map.put("TRADICIONAL", PersonProducts.CategoryEnum.TRADICIONAL);
    map.put("MICROSSEGURO", PersonProducts.CategoryEnum.MICROSEGURO);

    return map.get(segment);
  }

  public static List<PersonProducts.AdditionalEnum> extractAdditionalEnum(String stringCellValue) {
    Map<String, PersonProducts.AdditionalEnum> map = new HashMap<>();

    map.put("NAO HA", PersonProducts.AdditionalEnum.NAO_HA);
    map.put("SERVICOS DE ASSISTENCIA COMPLEMENTARES   GRATUITO-SORTEIO (GRATUITO)", PersonProducts.AdditionalEnum.SERVICOS_ASSISTENCIA_COMPLEMENTARES_GRATUITO);
    map.put("SERVICOS DE ASSISTENCIA COMPLEMENTARES   GRATUITO", PersonProducts.AdditionalEnum.SERVICOS_ASSISTENCIA_COMPLEMENTARES_GRATUITO);
    map.put("SERVICOS DE ASSISTENCIA COMPLEMENTARES   GRATUITO", PersonProducts.AdditionalEnum.SERVICOS_ASSISTENCIA_COMPLEMENTARES_GRATUITO);

    return Collections.singletonList(map.get(stringCellValue));

  }

  public static List<PersonProducts.AssistanceTypeEnum> extractAssistanceTypeEnum(String stringCellValue) {
    Map<String, PersonProducts.AssistanceTypeEnum> map = new HashMap<>();

    map.put("FUNERAL", PersonProducts.AssistanceTypeEnum.FUNERAL);
    map.put("VIAGEM", PersonProducts.AssistanceTypeEnum.VIAGEM);
    map.put("PET", PersonProducts.AssistanceTypeEnum.PET);
    map.put("EQUIPAMENTOS MEDICOS", PersonProducts.AssistanceTypeEnum.EQUIPAMENTOS_MEDICOS);
    map.put("CESTA BASICA", PersonProducts.AssistanceTypeEnum.CESTA_BASICA);
    map.put("RESIDENCIAL", PersonProducts.AssistanceTypeEnum.RESIDENCIAL);
    map.put("OUTROS", PersonProducts.AssistanceTypeEnum.OUTROS);
    map.put("RECOLOCACAO PROFISSIONAL", PersonProducts.AssistanceTypeEnum.RECOLOCACAO_PROFISSIONAL);
    map.put("SEGUNDA OPINIAO MEDICA (NACIONAL E/OU INTERNACIONAL)", PersonProducts.AssistanceTypeEnum.SEGUNDA_OPINIAO_MEDICA);
    map.put("EDUCACIONAL", PersonProducts.AssistanceTypeEnum.EDUCACIONAL);
    map.put("DESCONTO EM FARMACIAS/MEDICAMENTOS", PersonProducts.AssistanceTypeEnum.DESCONTO_FARMACIAS_MEDICAMENTOS);
    map.put("CLUBE DE VANTAGENS/BENEFICIOS", PersonProducts.AssistanceTypeEnum.CLUBE_VANTAGENS_BENEFICIOS);
    map.put("NUTRICIONISTA", PersonProducts.AssistanceTypeEnum.NUTRICIONISTA);
    map.put("AUXILIO NATALIDADE", PersonProducts.AssistanceTypeEnum.AUXILIO_NATALIDADE);
    map.put("TELEMEDICINA", PersonProducts.AssistanceTypeEnum.TELEMEDICINA);

    return Collections.singletonList(map.get(stringCellValue));
  }

  public static List<PersonCoverageAttributes.IndemnityPaymentMethodEnum> extractIndemnityPaymentMethod(String stringCellValue) {
    Map<String, PersonCoverageAttributes.IndemnityPaymentMethodEnum> map = new HashMap<>();

    map.put("PAGAMENTO DO CAPITAL SEGURADO EM VALOR MONETARIO", PersonCoverageAttributes.IndemnityPaymentMethodEnum.PAGAMENTO_CAPITAL_SEGURADO_VALOR_MONETARIO);
    map.put("REEMBOLSO DE DESPESAS", PersonCoverageAttributes.IndemnityPaymentMethodEnum.REEMBOLSO_DESPESAS);
    return Collections.singletonList(map.get(stringCellValue));
  }

  public static List<PersonProducts.IndemnityPaymentMethodEnum> extractIndemnityPaymentMethodProduct(String stringCellValue) {
    Map<String, PersonProducts.IndemnityPaymentMethodEnum> map = new HashMap<>();

    map.put("UNICO", PersonProducts.IndemnityPaymentMethodEnum.UNICO);
    return Collections.singletonList(map.get(stringCellValue));
  }

  public static List<PersonCoverageAttributes.IndemnityPaymentFrequencyEnum> extractIndemnityPaymentFrequency(String stringCellValue) {
    Map<String, PersonCoverageAttributes.IndemnityPaymentFrequencyEnum> map = new HashMap<>();

    map.put("INDENIZACAO UNICA", PersonCoverageAttributes.IndemnityPaymentFrequencyEnum.INDENIZACAO_UNICA);
    map.put("DIARIA OU PARCELA", PersonCoverageAttributes.IndemnityPaymentFrequencyEnum.DIARIA_OU_PARCELA);
    return Collections.singletonList(map.get(stringCellValue));
  }

  public static List<PersonProducts.IndemnityPaymentIncomeEnum> extractIndemnityPaymentInconmeProduct(String stringCellValue) {
    Map<String, PersonProducts.IndemnityPaymentIncomeEnum> map = new HashMap<>();
    map.put("CERTA", PersonProducts.IndemnityPaymentIncomeEnum.CERTA);
    map.put("TEMPORARIA", PersonProducts.IndemnityPaymentIncomeEnum.TEMPORARIA);
    return Collections.singletonList(map.get(stringCellValue));
  }

  public static PersonGracePeriodUnit.UnitEnum extractUnit(String stringCellValue) {
    Map<String, PersonGracePeriodUnit.UnitEnum> map = new HashMap<>();
    map.put("DIAS", PersonGracePeriodUnit.UnitEnum.DIAS);
    map.put("MESES", PersonGracePeriodUnit.UnitEnum.MESES);
    map.put("NAO SE APLICA", PersonGracePeriodUnit.UnitEnum.NAO_SE_APLICA);
    return map.get(stringCellValue);

  }

  public static List<PersonCoverageAttributes.ExcludedRisksEnum> extractExcludedRisk(String stringCellValue) {
    Map<String, PersonCoverageAttributes.ExcludedRisksEnum> map = new HashMap<>();
    List<PersonCoverageAttributes.ExcludedRisksEnum> results = new ArrayList<>();
    List<String> enums = Arrays.asList(stringCellValue.split("-"));

    for(String value : enums) {
      if(!value.equals("")) {
        results.add(PersonCoverageAttributes.ExcludedRisksEnum.valueOf(value));
      }
    }
    
    return results;
  }

  public static List<PersonProducts.ValidityEnum> extractValidityEnum(String stringCellValue) {
    Map<String, PersonProducts.ValidityEnum> map = new HashMap<>();

    map.put("TEMPORARIA - PRAZO FIXO", PersonProducts.ValidityEnum.TEMPORARIA_PRAZO_FIXO);

    return Collections.singletonList(map.get(stringCellValue));
  }

  public static PersonPmbacRemuneration.PmbacUpdateIndexEnum extractUpdateIndex(String stringCellValue) {
    Map<String, PersonPmbacRemuneration.PmbacUpdateIndexEnum> map = new HashMap<>();

    map.put("IPCA (IBGE)", PersonPmbacRemuneration.PmbacUpdateIndexEnum.IPCA);

    return map.get(stringCellValue);

  }

  public static PersonBenefitRecalculation.BenefitRecalculationCriteriaEnum extractBenefitRecalculationCriteria(String stringCellValue) {
    Map<String, PersonBenefitRecalculation.BenefitRecalculationCriteriaEnum> map = new HashMap<>();

    map.put("INDICE", PersonBenefitRecalculation.BenefitRecalculationCriteriaEnum.INDICE);

    return map.get(stringCellValue);

  }

  public static PersonBenefitRecalculation.BenefitUpdateIndexEnum extractBenefitUpdateIndex(String stringCellValue) {
    Map<String, PersonBenefitRecalculation.BenefitUpdateIndexEnum> map = new HashMap<>();

    map.put("IPCA (IBGE)", PersonBenefitRecalculation.BenefitUpdateIndexEnum.IPCA);
    map.put("IGP-M (FGV)", PersonBenefitRecalculation.BenefitUpdateIndexEnum.IGP_M);

    return map.get(stringCellValue);
  }

  public static PersonAgeAdjustment.CriterionEnum extractCriterionEnum(String stringCellValue) {
    Map<String, PersonAgeAdjustment.CriterionEnum> map = new HashMap<>();

    map.put("NAO APLICAVEL", PersonAgeAdjustment.CriterionEnum.NAO_APLICAVEL);
    map.put("POR MUDANCA DE FAIXA ETARIA", PersonAgeAdjustment.CriterionEnum.POR_MUDANCA_DE_FAIXA_ETARIA);

    return map.get(stringCellValue);
  }
}
