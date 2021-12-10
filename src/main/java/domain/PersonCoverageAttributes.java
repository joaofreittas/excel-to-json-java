package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonCoverageAttributes  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Gets or Sets indemnityPaymentMethod
   */
  public enum IndemnityPaymentMethodEnum {
    PAGAMENTO_CAPITAL_SEGURADO_VALOR_MONETARIO("PAGAMENTO_CAPITAL_SEGURADO_VALOR_MONETARIO"),
    
    REEMBOLSO_DESPESAS("REEMBOLSO_DESPESAS"),
    
    PRESTACAO_SERVICOS("PRESTACAO_SERVICOS");

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
   * Gets or Sets indemnityPaymentFrequency
   */
  public enum IndemnityPaymentFrequencyEnum {
    INDENIZACAO_UNICA("INDENIZACAO_UNICA"),
    
    DIARIA_OU_PARCELA("DIARIA_OU_PARCELA");

    private String value;

    IndemnityPaymentFrequencyEnum(String value) {
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
    public static IndemnityPaymentFrequencyEnum fromValue(String value) {
      for (IndemnityPaymentFrequencyEnum b : IndemnityPaymentFrequencyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("indemnityPaymentFrequency")
  private List<IndemnityPaymentFrequencyEnum> indemnityPaymentFrequency = new ArrayList<>();

  @JsonProperty("minValue")
  private PersonCoverageAttibutesDetails minValue;

  @JsonProperty("maxValue")
  private PersonCoverageAttibutesDetails maxValue;

  @JsonProperty("indemnifiablePeriod")
  private List<String> indemnifiablePeriod = new ArrayList<>();

  @JsonProperty("maximumQtyIndemnifiableInstallments")
  private Integer maximumQtyIndemnifiableInstallments;

  /**
   * Moeda sobre a qual a cobertura se refere. De acordo com ISO-4217.
   */
  public enum CurrencyEnum {
    AFN("AFN"),
    
    ALL("ALL"),
    
    DZD("DZD"),
    
    USD("USD"),
    
    EUR("EUR"),
    
    AOA("AOA"),
    
    XCD("XCD"),
    
    ARS("ARS"),
    
    AMD("AMD"),
    
    AWG("AWG"),
    
    AZN("AZN"),
    
    BSD("BSD"),
    
    BHD("BHD"),
    
    BDT("BDT"),
    
    BBD("BBD"),
    
    BYN("BYN"),
    
    BZD("BZD"),
    
    XOF("XOF"),
    
    BMD("BMD"),
    
    BTN("BTN"),
    
    BOB("BOB"),
    
    BOV("BOV"),
    
    BAM("BAM"),
    
    BWP("BWP"),
    
    BRL("BRL"),
    
    BND("BND"),
    
    BGN("BGN"),
    
    BIF("BIF"),
    
    CVE("CVE"),
    
    KHR("KHR"),
    
    XAF("XAF"),
    
    CAD("CAD"),
    
    KYD("KYD"),
    
    CLF("CLF"),
    
    CLP("CLP"),
    
    CNY("CNY"),
    
    COP("COP"),
    
    COU("COU"),
    
    KMF("KMF"),
    
    CDF("CDF"),
    
    NZD("NZD"),
    
    CRC("CRC"),
    
    HRK("HRK"),
    
    CUC("CUC"),
    
    CUP("CUP"),
    
    CZK("CZK"),
    
    DKK("DKK"),
    
    DJF("DJF"),
    
    DOP("DOP"),
    
    EGP("EGP"),
    
    SVC("SVC"),
    
    ERN("ERN"),
    
    ETB("ETB"),
    
    FKP("FKP"),
    
    FJD("FJD"),
    
    GMD("GMD"),
    
    GEL("GEL"),
    
    GHS("GHS"),
    
    GIP("GIP"),
    
    GTQ("GTQ"),
    
    GBP("GBP"),
    
    GNF("GNF"),
    
    GYD("GYD"),
    
    HTG("HTG"),
    
    HNL("HNL"),
    
    HKD("HKD"),
    
    HUF("HUF"),
    
    ISK("ISK"),
    
    INR("INR"),
    
    IDR("IDR"),
    
    XDR("XDR"),
    
    IRR("IRR"),
    
    IQD("IQD"),
    
    ILS("ILS"),
    
    JMD("JMD"),
    
    JPY("JPY"),
    
    JOD("JOD"),
    
    KZT("KZT"),
    
    KES("KES"),
    
    KPW("KPW"),
    
    KRW("KRW"),
    
    KWD("KWD"),
    
    KGS("KGS"),
    
    AUD("AUD"),
    
    LAK("LAK"),
    
    LBP("LBP"),
    
    LSL("LSL"),
    
    ZAR("ZAR"),
    
    LRD("LRD"),
    
    LYD("LYD"),
    
    CHF("CHF"),
    
    MOP("MOP"),
    
    MGA("MGA"),
    
    MWK("MWK"),
    
    MYR("MYR"),
    
    MVR("MVR"),
    
    MRU("MRU"),
    
    MUR("MUR"),
    
    XUA("XUA"),
    
    MXN("MXN"),
    
    MXV("MXV"),
    
    MDL("MDL"),
    
    MNT("MNT"),
    
    MAD("MAD"),
    
    MZN("MZN"),
    
    MMK("MMK"),
    
    NAD("NAD"),
    
    NPR("NPR"),
    
    NIO("NIO"),
    
    NGN("NGN"),
    
    OMR("OMR"),
    
    NOK("NOK"),
    
    PKR("PKR"),
    
    PAB("PAB"),
    
    PGK("PGK"),
    
    PYG("PYG"),
    
    PEN("PEN"),
    
    PHP("PHP"),
    
    PLN("PLN"),
    
    QAR("QAR"),
    
    MKD("MKD"),
    
    RON("RON"),
    
    RUB("RUB"),
    
    RWF("RWF"),
    
    SHP("SHP"),
    
    WST("WST"),
    
    STN("STN"),
    
    SAR("SAR"),
    
    RSD("RSD"),
    
    SCR("SCR"),
    
    SLL("SLL"),
    
    SGD("SGD"),
    
    XSU("XSU"),
    
    ANG("ANG"),
    
    SBD("SBD"),
    
    SOS("SOS"),
    
    SSP("SSP"),
    
    LKR("LKR"),
    
    SDG("SDG"),
    
    SRD("SRD"),
    
    SZL("SZL"),
    
    SEK("SEK"),
    
    CHE("CHE"),
    
    CHW("CHW"),
    
    SYP("SYP"),
    
    TWD("TWD"),
    
    TJS("TJS"),
    
    TZS("TZS"),
    
    THB("THB"),
    
    TOP("TOP"),
    
    TTD("TTD"),
    
    TND("TND"),
    
    TRY("TRY"),
    
    TMT("TMT"),
    
    UGX("UGX"),
    
    UAH("UAH"),
    
    AED("AED"),
    
    USN("USN"),
    
    UYI("UYI"),
    
    UYU("UYU"),
    
    UZS("UZS"),
    
    VUV("VUV"),
    
    VEF("VEF"),
    
    VND("VND"),
    
    YER("YER"),
    
    XPF("XPF"),
    
    ZMW("ZMW"),
    
    ZWL("ZWL");

    private String value;

    CurrencyEnum(String value) {
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
    public static CurrencyEnum fromValue(String value) {
      for (CurrencyEnum b : CurrencyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("currency")
  private CurrencyEnum currency;

  @JsonProperty("gracePeriod")
  private PersonGracePeriodUnit gracePeriod;

  @JsonProperty("differentiatedGracePeriod")
  private PersonGracePeriodUnit differentiatedGracePeriod;

  @JsonProperty("deductibleDays")
  private Integer deductibleDays;

  @JsonProperty("differentiatedDeductibleDays")
  private BigDecimal differentiatedDeductibleDays;

  @JsonProperty("deductibleBRL")
  private BigDecimal deductibleBRL;

  @JsonProperty("differentiatedDeductibleBRL")
  private String differentiatedDeductibleBRL;

  /**
   * Gets or Sets excludedRisks
   */
  public enum ExcludedRisksEnum {
    ATO_RECONHECIMENTO_PERIGOSO("ATO_RECONHECIMENTO_PERIGOSO"),
    
    ATO_ILICITO_DOLOSO_PRATICADO_SEGURADO("ATO_ILICITO_DOLOSO_PRATICADO_SEGURADO"),
    
    OPERACOES_DE_GUERRA("OPERACOES_DE_GUERRA"),
    
    FURACOES_CICLONES_TERREMOTOS("FURACOES_CICLONES_TERREMOTOS"),
    
    MATERIAL_NUCLEAR("MATERIAL_NUCLEAR"),
    
    DOENCAS_LESOES_PREEXISTENTES("DOENCAS_LESOES_PREEXISTENTES"),
    
    EPIDEMIAS_PANDEMIAS("EPIDEMIAS_PANDEMIAS"),
    
    SUICIDIO("SUICIDIO"),
    
    ATO_ILICITO_DOLOSO_PRATICADO_CONTROLADOR("ATO_ILICITO_DOLOSO_PRATICADO_CONTROLADOR"),
    
    OUTROS("OUTROS");

    private String value;

    ExcludedRisksEnum(String value) {
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
    public static ExcludedRisksEnum fromValue(String value) {
      for (ExcludedRisksEnum b : ExcludedRisksEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("excludedRisks")
  private List<ExcludedRisksEnum> excludedRisks = new ArrayList<>();

  @JsonProperty("excludedRisksURL")
  private String excludedRisksURL;

  @JsonProperty("allowApartPurchase")
  private Boolean allowApartPurchase;

  public PersonCoverageAttributes indemnityPaymentMethod(List<IndemnityPaymentMethodEnum> indemnityPaymentMethod) {
    this.indemnityPaymentMethod = indemnityPaymentMethod;
    return this;
  }

  public PersonCoverageAttributes addIndemnityPaymentMethodItem(IndemnityPaymentMethodEnum indemnityPaymentMethodItem) {
    this.indemnityPaymentMethod.add(indemnityPaymentMethodItem);
    return this;
  }


  public List<IndemnityPaymentMethodEnum> getIndemnityPaymentMethod() {
    return indemnityPaymentMethod;
  }

  public void setIndemnityPaymentMethod(List<IndemnityPaymentMethodEnum> indemnityPaymentMethod) {
    this.indemnityPaymentMethod = indemnityPaymentMethod;
  }

  public PersonCoverageAttributes indemnityPaymentFrequency(List<IndemnityPaymentFrequencyEnum> indemnityPaymentFrequency) {
    this.indemnityPaymentFrequency = indemnityPaymentFrequency;
    return this;
  }

  public PersonCoverageAttributes addIndemnityPaymentFrequencyItem(IndemnityPaymentFrequencyEnum indemnityPaymentFrequencyItem) {
    this.indemnityPaymentFrequency.add(indemnityPaymentFrequencyItem);
    return this;
  }

  public List<IndemnityPaymentFrequencyEnum> getIndemnityPaymentFrequency() {
    return indemnityPaymentFrequency;
  }

  public void setIndemnityPaymentFrequency(List<IndemnityPaymentFrequencyEnum> indemnityPaymentFrequency) {
    this.indemnityPaymentFrequency = indemnityPaymentFrequency;
  }

  public PersonCoverageAttributes minValue(PersonCoverageAttibutesDetails minValue) {
    this.minValue = minValue;
    return this;
  }

  public PersonCoverageAttibutesDetails getMinValue() {
    return minValue;
  }

  public void setMinValue(PersonCoverageAttibutesDetails minValue) {
    this.minValue = minValue;
  }

  public PersonCoverageAttributes maxValue(PersonCoverageAttibutesDetails maxValue) {
    this.maxValue = maxValue;
    return this;
  }

  public PersonCoverageAttibutesDetails getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(PersonCoverageAttibutesDetails maxValue) {
    this.maxValue = maxValue;
  }

  public PersonCoverageAttributes indemnifiablePeriod(List<String> indemnifiablePeriod) {
    this.indemnifiablePeriod = indemnifiablePeriod;
    return this;
  }

  public PersonCoverageAttributes addIndemnifiablePeriodItem(String indemnifiablePeriodItem) {
    this.indemnifiablePeriod.add(indemnifiablePeriodItem);
    return this;
  }

  public List<String> getIndemnifiablePeriod() {
    return indemnifiablePeriod;
  }

  public void setIndemnifiablePeriod(List<String> indemnifiablePeriod) {
    this.indemnifiablePeriod = indemnifiablePeriod;
  }

  public PersonCoverageAttributes maximumQtyIndemnifiableInstallments(Integer maximumQtyIndemnifiableInstallments) {
    this.maximumQtyIndemnifiableInstallments = maximumQtyIndemnifiableInstallments;
    return this;
  }

  public Integer getMaximumQtyIndemnifiableInstallments() {
    return maximumQtyIndemnifiableInstallments;
  }

  public void setMaximumQtyIndemnifiableInstallments(Integer maximumQtyIndemnifiableInstallments) {
    this.maximumQtyIndemnifiableInstallments = maximumQtyIndemnifiableInstallments;
  }

  public PersonCoverageAttributes currency(CurrencyEnum currency) {
    this.currency = currency;
    return this;
  }

  public CurrencyEnum getCurrency() {
    return currency;
  }

  public void setCurrency(CurrencyEnum currency) {
    this.currency = currency;
  }

  public PersonCoverageAttributes gracePeriod(PersonGracePeriodUnit gracePeriod) {
    this.gracePeriod = gracePeriod;
    return this;
  }

  public PersonGracePeriodUnit getGracePeriod() {
    return gracePeriod;
  }

  public void setGracePeriod(PersonGracePeriodUnit gracePeriod) {
    this.gracePeriod = gracePeriod;
  }

  public PersonCoverageAttributes differentiatedGracePeriod(PersonGracePeriodUnit differentiatedGracePeriod) {
    this.differentiatedGracePeriod = differentiatedGracePeriod;
    return this;
  }

  public PersonGracePeriodUnit getDifferentiatedGracePeriod() {
    return differentiatedGracePeriod;
  }

  public void setDifferentiatedGracePeriod(PersonGracePeriodUnit differentiatedGracePeriod) {
    this.differentiatedGracePeriod = differentiatedGracePeriod;
  }

  public PersonCoverageAttributes deductibleDays(Integer deductibleDays) {
    this.deductibleDays = deductibleDays;
    return this;
  }

  public Integer getDeductibleDays() {
    return deductibleDays;
  }

  public void setDeductibleDays(Integer deductibleDays) {
    this.deductibleDays = deductibleDays;
  }

  public PersonCoverageAttributes differentiatedDeductibleDays(BigDecimal differentiatedDeductibleDays) {
    this.differentiatedDeductibleDays = differentiatedDeductibleDays;
    return this;
  }

  public BigDecimal getDifferentiatedDeductibleDays() {
    return differentiatedDeductibleDays;
  }

  public void setDifferentiatedDeductibleDays(BigDecimal differentiatedDeductibleDays) {
    this.differentiatedDeductibleDays = differentiatedDeductibleDays;
  }

  public PersonCoverageAttributes deductibleBRL(BigDecimal deductibleBRL) {
    this.deductibleBRL = deductibleBRL;
    return this;
  }

  public BigDecimal getDeductibleBRL() {
    return deductibleBRL;
  }

  public void setDeductibleBRL(BigDecimal deductibleBRL) {
    this.deductibleBRL = deductibleBRL;
  }

  public PersonCoverageAttributes differentiatedDeductibleBRL(String differentiatedDeductibleBRL) {
    this.differentiatedDeductibleBRL = differentiatedDeductibleBRL;
    return this;
  }

  public String getDifferentiatedDeductibleBRL() {
    return differentiatedDeductibleBRL;
  }

  public void setDifferentiatedDeductibleBRL(String differentiatedDeductibleBRL) {
    this.differentiatedDeductibleBRL = differentiatedDeductibleBRL;
  }

  public PersonCoverageAttributes excludedRisks(List<ExcludedRisksEnum> excludedRisks) {
    this.excludedRisks = excludedRisks;
    return this;
  }

  public PersonCoverageAttributes addExcludedRisksItem(ExcludedRisksEnum excludedRisksItem) {
    this.excludedRisks.add(excludedRisksItem);
    return this;
  }

  public List<ExcludedRisksEnum> getExcludedRisks() {
    return excludedRisks;
  }

  public void setExcludedRisks(List<ExcludedRisksEnum> excludedRisks) {
    this.excludedRisks = excludedRisks;
  }

  public PersonCoverageAttributes excludedRisksURL(String excludedRisksURL) {
    this.excludedRisksURL = excludedRisksURL;
    return this;
  }


  public String getExcludedRisksURL() {
    return excludedRisksURL;
  }

  public void setExcludedRisksURL(String excludedRisksURL) {
    this.excludedRisksURL = excludedRisksURL;
  }

  public PersonCoverageAttributes allowApartPurchase(Boolean allowApartPurchase) {
    this.allowApartPurchase = allowApartPurchase;
    return this;
  }

  public Boolean getAllowApartPurchase() {
    return allowApartPurchase;
  }

  public void setAllowApartPurchase(Boolean allowApartPurchase) {
    this.allowApartPurchase = allowApartPurchase;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonCoverageAttributes personCoverageAttributes = (PersonCoverageAttributes) o;
    return Objects.equals(this.indemnityPaymentMethod, personCoverageAttributes.indemnityPaymentMethod) &&
        Objects.equals(this.indemnityPaymentFrequency, personCoverageAttributes.indemnityPaymentFrequency) &&
        Objects.equals(this.minValue, personCoverageAttributes.minValue) &&
        Objects.equals(this.maxValue, personCoverageAttributes.maxValue) &&
        Objects.equals(this.indemnifiablePeriod, personCoverageAttributes.indemnifiablePeriod) &&
        Objects.equals(this.maximumQtyIndemnifiableInstallments, personCoverageAttributes.maximumQtyIndemnifiableInstallments) &&
        Objects.equals(this.currency, personCoverageAttributes.currency) &&
        Objects.equals(this.gracePeriod, personCoverageAttributes.gracePeriod) &&
        Objects.equals(this.differentiatedGracePeriod, personCoverageAttributes.differentiatedGracePeriod) &&
        Objects.equals(this.deductibleDays, personCoverageAttributes.deductibleDays) &&
        Objects.equals(this.differentiatedDeductibleDays, personCoverageAttributes.differentiatedDeductibleDays) &&
        Objects.equals(this.deductibleBRL, personCoverageAttributes.deductibleBRL) &&
        Objects.equals(this.differentiatedDeductibleBRL, personCoverageAttributes.differentiatedDeductibleBRL) &&
        Objects.equals(this.excludedRisks, personCoverageAttributes.excludedRisks) &&
        Objects.equals(this.excludedRisksURL, personCoverageAttributes.excludedRisksURL) &&
        Objects.equals(this.allowApartPurchase, personCoverageAttributes.allowApartPurchase);
  }

  @Override
  public int hashCode() {
    return Objects.hash(indemnityPaymentMethod, indemnityPaymentFrequency, minValue, maxValue, indemnifiablePeriod, maximumQtyIndemnifiableInstallments, currency, gracePeriod, differentiatedGracePeriod, deductibleDays, differentiatedDeductibleDays, deductibleBRL, differentiatedDeductibleBRL, excludedRisks, excludedRisksURL, allowApartPurchase);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonCoverageAttributes {\n");
    
    sb.append("    indemnityPaymentMethod: ").append(toIndentedString(indemnityPaymentMethod)).append("\n");
    sb.append("    indemnityPaymentFrequency: ").append(toIndentedString(indemnityPaymentFrequency)).append("\n");
    sb.append("    minValue: ").append(toIndentedString(minValue)).append("\n");
    sb.append("    maxValue: ").append(toIndentedString(maxValue)).append("\n");
    sb.append("    indemnifiablePeriod: ").append(toIndentedString(indemnifiablePeriod)).append("\n");
    sb.append("    maximumQtyIndemnifiableInstallments: ").append(toIndentedString(maximumQtyIndemnifiableInstallments)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    gracePeriod: ").append(toIndentedString(gracePeriod)).append("\n");
    sb.append("    differentiatedGracePeriod: ").append(toIndentedString(differentiatedGracePeriod)).append("\n");
    sb.append("    deductibleDays: ").append(toIndentedString(deductibleDays)).append("\n");
    sb.append("    differentiatedDeductibleDays: ").append(toIndentedString(differentiatedDeductibleDays)).append("\n");
    sb.append("    deductibleBRL: ").append(toIndentedString(deductibleBRL)).append("\n");
    sb.append("    differentiatedDeductibleBRL: ").append(toIndentedString(differentiatedDeductibleBRL)).append("\n");
    sb.append("    excludedRisks: ").append(toIndentedString(excludedRisks)).append("\n");
    sb.append("    excludedRisksURL: ").append(toIndentedString(excludedRisksURL)).append("\n");
    sb.append("    allowApartPurchase: ").append(toIndentedString(allowApartPurchase)).append("\n");
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

