package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Lista de Dependências de uma Instituição.
 */
public class PersonProducts  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("code")
  private String code;

  /**
   * Indica a categoria do Produto
   */
  public enum CategoryEnum {
    TRADICIONAL("TRADICIONAL"),
    
    MICROSEGURO("MICROSEGURO");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String value) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("category")
  private CategoryEnum category;

  /**
   * Gets or Sets insuranceModality
   */
  public enum InsuranceModalityEnum {
    FUNERAL("FUNERAL"),
    
    PRESTAMISTA("PRESTAMISTA"),
    
    VIAGEM("VIAGEM"),
    
    EDUCACIONAL("EDUCACIONAL"),
    
    DOTAL("DOTAL"),
    
    ACIDENTES_PESSOAIS("ACIDENTES_PESSOAIS"),
    
    VIDA("VIDA"),
    
    PERDA_CERTIFICADO_HABILITACAOO_VOO("PERDA_CERTIFICADO_HABILITACAOO_VOO"),
    
    DOENCAS_GRAVES_DOENCA_TERMINAL("DOENCAS_GRAVES_DOENCA_TERMINAL"),
    
    DESEMPREGO_PERDA_RENDA("DESEMPREGO_PERDA_RENDA"),
    
    EVENTOS_ALEATORIOS("EVENTOS_ALEATORIOS"),

    OUTROS("OUTROS");

    private String value;

    InsuranceModalityEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static InsuranceModalityEnum fromValue(String value) {
      for (InsuranceModalityEnum b : InsuranceModalityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("insuranceModality")
  private InsuranceModalityEnum insuranceModality;

  @JsonProperty("coverages")
  private List<PersonProductsCoverages> coverages = new ArrayList<>();

  /**
   * Gets or Sets assistanceType
   */
  public enum AssistanceTypeEnum {
    ACOMPANHANTE_CASO_HOSPITALIZACAO_PROLONGADA("ACOMPANHANTE_CASO_HOSPITALIZACAO_PROLONGADA"),
    
    ARQUITETO_VIRTUAL("ARQUITETO_VIRTUAL"),
    
    ASSESSORIA_FINANCEIRA("ASSESSORIA_FINANCEIRA"),
    
    AUTOMOVEL("AUTOMOVEL"),
    
    AUXILIO_NATALIDADE("AUXILIO_NATALIDADE"),
    
    AVALIACAO_CLINICA_PREVENTIVA("AVALIACAO_CLINICA_PREVENTIVA"),
    
    BOLSA_PROTEGIDA("BOLSA_PROTEGIDA"),
    
    CESTA_BASICA("CESTA_BASICA"),
    
    CHECKUP_ODONTOLOGICO("CHECKUP_ODONTOLOGICO"),
    
    CLUBE_VANTAGENS_BENEFICIOS("CLUBE_VANTAGENS_BENEFICIOS"),
    
    CONVALESCENCIA("CONVALESCENCIA"),
    
    DECESSO("DECESSO"),
    
    DESCONTO_FARMACIAS_MEDICAMENTOS("DESCONTO_FARMACIAS_MEDICAMENTOS"),
    
    DESPESAS_FARMACEUTICAS_VIAGEM("DESPESAS_FARMACEUTICAS_VIAGEM"),
    
    DIGITAL("DIGITAL"),
    
    EDUCACIONAL("EDUCACIONAL"),
    
    EMPRESARIAL("EMPRESARIAL"),
    
    ENCANADOR("ENCANADOR"),
    
    ENTRETENIMENTO("ENTRETENIMENTO"),
    
    EQUIPAMENTOS_MEDICOS("EQUIPAMENTOS_MEDICOS"),
    
    FIANCAS_DESPESAS_LEGAIS("FIANCAS_DESPESAS_LEGAIS"),
    
    FISIOTERAPIA("FISIOTERAPIA"),
    
    FUNERAL("FUNERAL"),
    
    HELP_LINE("HELP_LINE"),
    
    HOSPEDAGEM_ACOMPANHANTE("HOSPEDAGEM_ACOMPANHANTE"),
    
    INTERRUPCAO_VIAGEM("INTERRUPCAO_VIAGEM"),
    
    INVENTARIO("INVENTARIO"),
    
    MAIS_EM_VIDA("MAIS_EM_VIDA"),
    
    MAMAE_BEBE("MAMAE_BEBE"),
    
    MEDICA_ACIDENTE_DOENCA("MEDICA_ACIDENTE_DOENCA"),
    
    MOTOCICLETA("MOTOCICLETA"),
    
    MULHER("MULHER"),
    
    NUTRICIONISTA("NUTRICIONISTA"),
    
    ODONTOLOGICA("ODONTOLOGICA"),
    
    ORIENTACAO_FITNESS("ORIENTACAO_FITNESS"),
    
    ORIENTACAO_JURIDICA("ORIENTACAO_JURIDICA"),
    
    ORIENTACAO_NUTRICIONAL("ORIENTACAO_NUTRICIONAL"),
    
    PERSONAL_FITNESS("PERSONAL_FITNESS"),
    
    ORIENTACAO_PSICOSSOCIAL_FAMILIAR("ORIENTACAO_PSICOSSOCIAL_FAMILIAR"),
    
    PERDA_ROUBO_CARTAO("PERDA_ROUBO_CARTAO"),
    
    PET("PET"),
    
    PRORROGACAO_ESTADIA("PRORROGACAO_ESTADIA"),
    
    PROTECAO_DADOS("PROTECAO_DADOS"),
    
    RECOLOCACAO_PROFISSIONAL("RECOLOCACAO_PROFISSIONAL"),
    
    REDE_DESCONTO_NUTRICIONAL("REDE_DESCONTO_NUTRICIONAL"),
    
    RESIDENCIAL("RESIDENCIAL"),
    
    RETORNO_MENORES_SEGURADO("RETORNO_MENORES_SEGURADO"),
    
    SAQUE_COACAO("SAQUE_COACAO"),
    
    SAUDE_BEM_ESTAR("SAUDE_BEM_ESTAR"),
    
    SEGUNDA_OPINIAO_MEDICA("SEGUNDA_OPINIAO_MEDICA"),
    
    SENIOR("SENIOR"),
    
    SUSTENTAVEL_DESCARTE_ECOLOGICO("SUSTENTAVEL_DESCARTE_ECOLOGICO"),
    
    TELEMEDICINA("TELEMEDICINA"),
    
    VIAGEM("VIAGEM"),
    
    VITIMA("VITIMA"),
    
    OUTROS("OUTROS");

    private String value;

    AssistanceTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AssistanceTypeEnum fromValue(String value) {
      for (AssistanceTypeEnum b : AssistanceTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("assistanceType")
  private List<AssistanceTypeEnum> assistanceType = null;

  /**
   * Gets or Sets additional
   */
  public enum AdditionalEnum {
    SORTEIO("SORTEIO"),
    
    SERVICOS_ASSISTENCIAS_COMPLEMENTARES_PAGO("SERVICOS_ASSISTENCIAS_COMPLEMENTARES_PAGO"),
    
    SERVICOS_ASSISTENCIA_COMPLEMENTARES_GRATUITO("SERVICOS_ASSISTENCIA_COMPLEMENTARES_GRATUITO"),
    
    OUTROS("OUTROS"),
    
    NAO_HA("NAO_HA");

    private String value;

    AdditionalEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AdditionalEnum fromValue(String value) {
      for (AdditionalEnum b : AdditionalEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("additional")
  private List<AdditionalEnum> additional = new ArrayList<>();

  @JsonProperty("assistanceTypeOthers")
  private List<String> assistanceTypeOthers = null;

  @JsonProperty("termsAndConditions")
  private List<PersonTermsAndCondition> termsAndConditions = new ArrayList<>();

  @JsonProperty("globalCapital")
  private Boolean globalCapital;

  /**
   * Gets or Sets validity
   */
  public enum ValidityEnum {
    VITALICIA("VITALICIA"),
    
    TEMPORARIA_PRAZO_FIXO("TEMPORARIA_PRAZO_FIXO"),
    
    TEMPORARIA_INTERMITENTE("TEMPORARIA_INTERMITENTE");

    private String value;

    ValidityEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ValidityEnum fromValue(String value) {
      for (ValidityEnum b : ValidityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("validity")
  private List<ValidityEnum> validity = new ArrayList<>();

  @JsonProperty("pmbacRemuneration")
  private PersonPmbacRemuneration pmbacRemuneration;

  @JsonProperty("benefitRecalculation")
  private PersonBenefitRecalculation benefitRecalculation;

  @JsonProperty("ageAdjustment")
  private PersonAgeAdjustment ageAdjustment;

  /**
   * Regime Financeiro
   */
  public enum ContractTypeEnum {
    REPARTICAO_SIMPLES("REPARTICAO_SIMPLES"),
    
    REPARTICAO_CAPITAIS("REPARTICAO_CAPITAIS"),
    
    CAPITALIZACAO("CAPITALIZACAO");

    private String value;

    ContractTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ContractTypeEnum fromValue(String value) {
      for (ContractTypeEnum b : ContractTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("contractType")
  private ContractTypeEnum contractType;

  @JsonProperty("reclaim")
  private PersonReclaim reclaim;

  /**
   * Gets or Sets otherGuaranteedValues
   */
  public enum OtherGuaranteedValuesEnum {
    SALDAMENTO("SALDAMENTO"),
    
    BENEFICIO_PROLONGADO("BENEFICIO_PROLONGADO"),
    
    NAO_SE_APLICA("NAO_SE_APLICA");

    private String value;

    OtherGuaranteedValuesEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OtherGuaranteedValuesEnum fromValue(String value) {
      for (OtherGuaranteedValuesEnum b : OtherGuaranteedValuesEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("otherGuaranteedValues")
  private OtherGuaranteedValuesEnum otherGuaranteedValues;

  @JsonProperty("allowPortability")
  private Boolean allowPortability;

  @JsonProperty("portabilityGraceTime")
  private Integer portabilityGraceTime;

  /**
   * Modalidade de pagamento da indenização
   */
  public enum IndemnityPaymentMethodEnum {
    UNICO("UNICO"),
    
    SOB_FORMA_DE_RENDA("SOB_FORMA_DE_RENDA");

    private String value;

    IndemnityPaymentMethodEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IndemnityPaymentMethodEnum fromValue(String value) {
      for (IndemnityPaymentMethodEnum b : IndemnityPaymentMethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("indemnityPaymentMethod")
  private List<IndemnityPaymentMethodEnum> indemnityPaymentMethod = new ArrayList<>();

  /**
   * Gets or Sets indemnityPaymentIncome
   */
  public enum IndemnityPaymentIncomeEnum {
    CERTA("CERTA"),
    
    TEMPORARIA("TEMPORARIA"),
    
    TEMPORARIA_REVERSIVEL("TEMPORARIA_REVERSIVEL"),
    
    TEMPORARIO_MINIMO_GARANTIDO("TEMPORARIO_MINIMO_GARANTIDO"),
    
    TEMPORARIA_REVERSIVEL_MINIMO_GARANTIDO("TEMPORARIA_REVERSIVEL_MINIMO_GARANTIDO"),
    
    VITALICIA("VITALICIA"),
    
    VITALICIA_REVERSIVEL("VITALICIA_REVERSIVEL"),
    
    VITALICIA_MINIMO_GARANTIDO("VITALICIA_MINIMO_GARANTIDO"),
    
    VITALICIA_REVERSIVEL_MINIMO_GARANTIDO("VITALICIA_REVERSIVEL_MINIMO_GARANTIDO");

    private String value;

    IndemnityPaymentIncomeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IndemnityPaymentIncomeEnum fromValue(String value) {
      for (IndemnityPaymentIncomeEnum b : IndemnityPaymentIncomeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("indemnityPaymentIncome")
  private List<IndemnityPaymentIncomeEnum> indemnityPaymentIncome = new ArrayList<>();

  @JsonProperty("premiumPayment")
  private PersonPremiumPayment premiumPayment;

  @JsonProperty("minimunRequirements")
  private PersonMinimumRequirements minimunRequirements;

  /**
   * Gets or Sets targetAudience
   */
  public enum TargetAudienceEnum {
    NATURAL("PESSOA_NATURAL"),
    
    JURIDICA("PESSOA_JURIDICA");

    private String value;

    TargetAudienceEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TargetAudienceEnum fromValue(String value) {
      for (TargetAudienceEnum b : TargetAudienceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("targetAudience")
  private TargetAudienceEnum targetAudience;

  public PersonProducts name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Nome comercial do produto, pelo qual é identificado nos canais de distribuição e atendimento da sociedade.
   * @return name
  */


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PersonProducts code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Código único a ser definido pela sociedade (código interno do produto) a critério da participante.
   * @return code
  */


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public PersonProducts category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * Indica a categoria do Produto
   * @return category
  */


  public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  public PersonProducts insuranceModality(InsuranceModalityEnum insuranceModality) {
    this.insuranceModality = insuranceModality;
    return this;
  }

  /**
   * Get insuranceModality
   * @return insuranceModality
  */

  public InsuranceModalityEnum getInsuranceModality() {
    return insuranceModality;
  }

  public void setInsuranceModality(InsuranceModalityEnum insuranceModality) {
    this.insuranceModality = insuranceModality;
  }

  public PersonProducts coverages(List<PersonProductsCoverages> coverages) {
    this.coverages = coverages;
    return this;
  }

  public PersonProducts addCoveragesItem(PersonProductsCoverages coveragesItem) {
    this.coverages.add(coveragesItem);
    return this;
  }

  /**
   * Get coverages
   * @return coverages
  */
  public List<PersonProductsCoverages> getCoverages() {
    return coverages;
  }

  public void setCoverages(List<PersonProductsCoverages> coverages) {
    this.coverages = coverages;
  }

  public PersonProducts assistanceType(List<AssistanceTypeEnum> assistanceType) {
    this.assistanceType = assistanceType;
    return this;
  }

  public PersonProducts addAssistanceTypeItem(AssistanceTypeEnum assistanceTypeItem) {
    if (this.assistanceType == null) {
      this.assistanceType = new ArrayList<>();
    }
    this.assistanceType.add(assistanceTypeItem);
    return this;
  }

  /**
   * Listagem dos serviços de assistências complementares disponíveis vinculados ao produto. Deve ser padronizada na proposta técnica submetida pela Estrutura Inicial de  Governança para observância comum por todas as sociedades participantes
   * @return assistanceType
  */

  public List<AssistanceTypeEnum> getAssistanceType() {
    return assistanceType;
  }

  public void setAssistanceType(List<AssistanceTypeEnum> assistanceType) {
    this.assistanceType = assistanceType;
  }

  public PersonProducts additional(List<AdditionalEnum> additional) {
    this.additional = additional;
    return this;
  }

  public PersonProducts addAdditionalItem(AdditionalEnum additionalItem) {
    this.additional.add(additionalItem);
    return this;
  }

  /**
   * Get additional
   * @return additional
  */
  public List<AdditionalEnum> getAdditional() {
    return additional;
  }

  public void setAdditional(List<AdditionalEnum> additional) {
    this.additional = additional;
  }

  public PersonProducts assistanceTypeOthers(List<String> assistanceTypeOthers) {
    this.assistanceTypeOthers = assistanceTypeOthers;
    return this;
  }

  public PersonProducts addAssistanceTypeOthersItem(String assistanceTypeOthersItem) {
    if (this.assistanceTypeOthers == null) {
      this.assistanceTypeOthers = new ArrayList<>();
    }
    this.assistanceTypeOthers.add(assistanceTypeOthersItem);
    return this;
  }

  /**
   * Get assistanceTypeOthers
   * @return assistanceTypeOthers
  */

  public List<String> getAssistanceTypeOthers() {
    return assistanceTypeOthers;
  }

  public void setAssistanceTypeOthers(List<String> assistanceTypeOthers) {
    this.assistanceTypeOthers = assistanceTypeOthers;
  }

  public PersonProducts termsAndConditions(List<PersonTermsAndCondition> termsAndConditions) {
    this.termsAndConditions = termsAndConditions;
    return this;
  }

  public PersonProducts addTermsAndConditionsItem(PersonTermsAndCondition termsAndConditionsItem) {
    this.termsAndConditions.add(termsAndConditionsItem);
    return this;
  }

  /**
   * Get termsAndConditions
   * @return termsAndConditions
  */

  public List<PersonTermsAndCondition> getTermsAndConditions() {
    return termsAndConditions;
  }

  public void setTermsAndConditions(List<PersonTermsAndCondition> termsAndConditions) {
    this.termsAndConditions = termsAndConditions;
  }

  public PersonProducts globalCapital(Boolean globalCapital) {
    this.globalCapital = globalCapital;
    return this;
  }

  /**
   * Seguro de pessoas com capital global modalidade de contratação coletiva da cobertura de risco, respeitados os critérios técnico-operacionais, forma e limites fixados pela SUSEP, segundo a qual o valor do capital segurado referente a cada componente sofrerá variações decorrentes de mudanças na composição do grupo segurado
   * @return globalCapital
  */

  public Boolean getGlobalCapital() {
    return globalCapital;
  }

  public void setGlobalCapital(Boolean globalCapital) {
    this.globalCapital = globalCapital;
  }

  public PersonProducts validity(List<ValidityEnum> validity) {
    this.validity = validity;
    return this;
  }

  public PersonProducts addValidityItem(ValidityEnum validityItem) {
    this.validity.add(validityItem);
    return this;
  }

  /**
   * Get validity
   * @return validity
  */
  
  public List<ValidityEnum> getValidity() {
    return validity;
  }

  public void setValidity(List<ValidityEnum> validity) {
    this.validity = validity;
  }

  public PersonProducts pmbacRemuneration(PersonPmbacRemuneration pmbacRemuneration) {
    this.pmbacRemuneration = pmbacRemuneration;
    return this;
  }

  /**
   * Get pmbacRemuneration
   * @return pmbacRemuneration
  */

  public PersonPmbacRemuneration getPmbacRemuneration() {
    return pmbacRemuneration;
  }

  public void setPmbacRemuneration(PersonPmbacRemuneration pmbacRemuneration) {
    this.pmbacRemuneration = pmbacRemuneration;
  }

  public PersonProducts benefitRecalculation(PersonBenefitRecalculation benefitRecalculation) {
    this.benefitRecalculation = benefitRecalculation;
    return this;
  }

  /**
   * Get benefitRecalculation
   * @return benefitRecalculation
  */

  public PersonBenefitRecalculation getBenefitRecalculation() {
    return benefitRecalculation;
  }

  public void setBenefitRecalculation(PersonBenefitRecalculation benefitRecalculation) {
    this.benefitRecalculation = benefitRecalculation;
  }

  public PersonProducts ageAdjustment(PersonAgeAdjustment ageAdjustment) {
    this.ageAdjustment = ageAdjustment;
    return this;
  }

  /**
   * Get ageAdjustment
   * @return ageAdjustment
  */

  public PersonAgeAdjustment getAgeAdjustment() {
    return ageAdjustment;
  }

  public void setAgeAdjustment(PersonAgeAdjustment ageAdjustment) {
    this.ageAdjustment = ageAdjustment;
  }

  public PersonProducts contractType(ContractTypeEnum contractType) {
    this.contractType = contractType;
    return this;
  }

  /**
   * Regime Financeiro
   * @return contractType
  */

  public ContractTypeEnum getContractType() {
    return contractType;
  }

  public void setContractType(ContractTypeEnum contractType) {
    this.contractType = contractType;
  }

  public PersonProducts reclaim(PersonReclaim reclaim) {
    this.reclaim = reclaim;
    return this;
  }

  /**
   * Get reclaim
   * @return reclaim
  */
  public PersonReclaim getReclaim() {
    return reclaim;
  }

  public void setReclaim(PersonReclaim reclaim) {
    this.reclaim = reclaim;
  }

  public PersonProducts otherGuaranteedValues(OtherGuaranteedValuesEnum otherGuaranteedValues) {
    this.otherGuaranteedValues = otherGuaranteedValues;
    return this;
  }

  /**
   * Get otherGuaranteedValues
   * @return otherGuaranteedValues
  */

  public OtherGuaranteedValuesEnum getOtherGuaranteedValues() {
    return otherGuaranteedValues;
  }

  public void setOtherGuaranteedValues(OtherGuaranteedValuesEnum otherGuaranteedValues) {
    this.otherGuaranteedValues = otherGuaranteedValues;
  }

  public PersonProducts allowPortability(Boolean allowPortability) {
    this.allowPortability = allowPortability;
    return this;
  }

  /**
   * Permite Portabilidade
   * @return allowPortability
  */

  public Boolean getAllowPortability() {
    return allowPortability;
  }

  public void setAllowPortability(Boolean allowPortability) {
    this.allowPortability = allowPortability;
  }

  public PersonProducts portabilityGraceTime(Integer portabilityGraceTime) {
    this.portabilityGraceTime = portabilityGraceTime;
    return this;
  }

  /**
   * Prazo de carência em dias para Portabilidade
   * @return portabilityGraceTime
  */

  public Integer getPortabilityGraceTime() {
    return portabilityGraceTime;
  }

  public void setPortabilityGraceTime(Integer portabilityGraceTime) {
    this.portabilityGraceTime = portabilityGraceTime;
  }

  public PersonProducts indemnityPaymentMethod(List<IndemnityPaymentMethodEnum> indemnityPaymentMethod) {
    this.indemnityPaymentMethod = indemnityPaymentMethod;
    return this;
  }

  public PersonProducts addIndemnityPaymentMethodItem(IndemnityPaymentMethodEnum indemnityPaymentMethodItem) {
    this.indemnityPaymentMethod.add(indemnityPaymentMethodItem);
    return this;
  }

  /**
   * Get indemnityPaymentMethod
   * @return indemnityPaymentMethod
  */
  public List<IndemnityPaymentMethodEnum> getIndemnityPaymentMethod() {
    return indemnityPaymentMethod;
  }

  public void setIndemnityPaymentMethod(List<IndemnityPaymentMethodEnum> indemnityPaymentMethod) {
    this.indemnityPaymentMethod = indemnityPaymentMethod;
  }

  public PersonProducts indemnityPaymentIncome(List<IndemnityPaymentIncomeEnum> indemnityPaymentIncome) {
    this.indemnityPaymentIncome = indemnityPaymentIncome;
    return this;
  }

  public PersonProducts addIndemnityPaymentIncomeItem(IndemnityPaymentIncomeEnum indemnityPaymentIncomeItem) {
    this.indemnityPaymentIncome.add(indemnityPaymentIncomeItem);
    return this;
  }

  /**
   * Get indemnityPaymentIncome
   * @return indemnityPaymentIncome
  */

  public List<IndemnityPaymentIncomeEnum> getIndemnityPaymentIncome() {
    return indemnityPaymentIncome;
  }

  public void setIndemnityPaymentIncome(List<IndemnityPaymentIncomeEnum> indemnityPaymentIncome) {
    this.indemnityPaymentIncome = indemnityPaymentIncome;
  }

  public PersonProducts premiumPayment(PersonPremiumPayment premiumPayment) {
    this.premiumPayment = premiumPayment;
    return this;
  }

  /**
   * Get premiumPayment
   * @return premiumPayment
  */

  public PersonPremiumPayment getPremiumPayment() {
    return premiumPayment;
  }

  public void setPremiumPayment(PersonPremiumPayment premiumPayment) {
    this.premiumPayment = premiumPayment;
  }

  public PersonProducts minimunRequirements(PersonMinimumRequirements minimunRequirements) {
    this.minimunRequirements = minimunRequirements;
    return this;
  }

  /**
   * Get minimunRequirements
   * @return minimunRequirements
  */

  public PersonMinimumRequirements getMinimunRequirements() {
    return minimunRequirements;
  }

  public void setMinimunRequirements(PersonMinimumRequirements minimunRequirements) {
    this.minimunRequirements = minimunRequirements;
  }

  public PersonProducts targetAudience(TargetAudienceEnum targetAudience) {
    this.targetAudience = targetAudience;
    return this;
  }

  /**
   * Get targetAudience
   * @return targetAudience
  */

  public TargetAudienceEnum getTargetAudience() {
    return targetAudience;
  }

  public void setTargetAudience(TargetAudienceEnum targetAudience) {
    this.targetAudience = targetAudience;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonProducts personProducts = (PersonProducts) o;
    return Objects.equals(this.name, personProducts.name) &&
        Objects.equals(this.code, personProducts.code) &&
        Objects.equals(this.category, personProducts.category) &&
        Objects.equals(this.insuranceModality, personProducts.insuranceModality) &&
        Objects.equals(this.coverages, personProducts.coverages) &&
        Objects.equals(this.assistanceType, personProducts.assistanceType) &&
        Objects.equals(this.additional, personProducts.additional) &&
        Objects.equals(this.assistanceTypeOthers, personProducts.assistanceTypeOthers) &&
        Objects.equals(this.termsAndConditions, personProducts.termsAndConditions) &&
        Objects.equals(this.globalCapital, personProducts.globalCapital) &&
        Objects.equals(this.validity, personProducts.validity) &&
        Objects.equals(this.pmbacRemuneration, personProducts.pmbacRemuneration) &&
        Objects.equals(this.benefitRecalculation, personProducts.benefitRecalculation) &&
        Objects.equals(this.ageAdjustment, personProducts.ageAdjustment) &&
        Objects.equals(this.contractType, personProducts.contractType) &&
        Objects.equals(this.reclaim, personProducts.reclaim) &&
        Objects.equals(this.otherGuaranteedValues, personProducts.otherGuaranteedValues) &&
        Objects.equals(this.allowPortability, personProducts.allowPortability) &&
        Objects.equals(this.portabilityGraceTime, personProducts.portabilityGraceTime) &&
        Objects.equals(this.indemnityPaymentMethod, personProducts.indemnityPaymentMethod) &&
        Objects.equals(this.indemnityPaymentIncome, personProducts.indemnityPaymentIncome) &&
        Objects.equals(this.premiumPayment, personProducts.premiumPayment) &&
        Objects.equals(this.minimunRequirements, personProducts.minimunRequirements) &&
        Objects.equals(this.targetAudience, personProducts.targetAudience);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, code, category, insuranceModality, coverages, assistanceType, additional, assistanceTypeOthers, termsAndConditions, globalCapital, validity, pmbacRemuneration, benefitRecalculation, ageAdjustment, contractType, reclaim, otherGuaranteedValues, allowPortability, portabilityGraceTime, indemnityPaymentMethod, indemnityPaymentIncome, premiumPayment, minimunRequirements, targetAudience);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonProducts {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    insuranceModality: ").append(toIndentedString(insuranceModality)).append("\n");
    sb.append("    coverages: ").append(toIndentedString(coverages)).append("\n");
    sb.append("    assistanceType: ").append(toIndentedString(assistanceType)).append("\n");
    sb.append("    additional: ").append(toIndentedString(additional)).append("\n");
    sb.append("    assistanceTypeOthers: ").append(toIndentedString(assistanceTypeOthers)).append("\n");
    sb.append("    termsAndConditions: ").append(toIndentedString(termsAndConditions)).append("\n");
    sb.append("    globalCapital: ").append(toIndentedString(globalCapital)).append("\n");
    sb.append("    validity: ").append(toIndentedString(validity)).append("\n");
    sb.append("    pmbacRemuneration: ").append(toIndentedString(pmbacRemuneration)).append("\n");
    sb.append("    benefitRecalculation: ").append(toIndentedString(benefitRecalculation)).append("\n");
    sb.append("    ageAdjustment: ").append(toIndentedString(ageAdjustment)).append("\n");
    sb.append("    contractType: ").append(toIndentedString(contractType)).append("\n");
    sb.append("    reclaim: ").append(toIndentedString(reclaim)).append("\n");
    sb.append("    otherGuaranteedValues: ").append(toIndentedString(otherGuaranteedValues)).append("\n");
    sb.append("    allowPortability: ").append(toIndentedString(allowPortability)).append("\n");
    sb.append("    portabilityGraceTime: ").append(toIndentedString(portabilityGraceTime)).append("\n");
    sb.append("    indemnityPaymentMethod: ").append(toIndentedString(indemnityPaymentMethod)).append("\n");
    sb.append("    indemnityPaymentIncome: ").append(toIndentedString(indemnityPaymentIncome)).append("\n");
    sb.append("    premiumPayment: ").append(toIndentedString(premiumPayment)).append("\n");
    sb.append("    minimunRequirements: ").append(toIndentedString(minimunRequirements)).append("\n");
    sb.append("    targetAudience: ").append(toIndentedString(targetAudience)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

