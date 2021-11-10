package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LifePensionPeriodGrantBenefit  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Modalidades de renda disponíveis para contratação. A considerar os seguintes domínios
   */
  public enum IncomeModalityEnum {
    PAGAMENTO_UNICO("PAGAMENTO_UNICO"),
    
    RENDA_PRAZO_CERTO("RENDA_PRAZO_CERTO"),
    
    RENDA_TEMPORARIA("RENDA_TEMPORARIA"),
    
    RENDA_TEMPORARIA_REVERSIVEL("RENDA_TEMPORARIA_REVERSIVEL"),
    
    RENDA_TEMPORARIA_MINMO_GARANTIDO("RENDA_TEMPORARIA_MINMO_GARANTIDO"),
    
    RENDA_TEMPORARIA_REVERSIVEL_MININO_GARANTIDO("RENDA_TEMPORARIA_REVERSIVEL_MININO_GARANTIDO"),
    
    RENDA_VITALICIA("RENDA_VITALICIA"),
    
    RENDA_VITALICIA_REVERSIVEL_BENEFICIARIO_INDICADO("RENDA_VITALICIA_REVERSIVEL_BENEFICIARIO_INDICADO"),
    
    RENDA_VITALICIA_CONJUGE_CONTINUIDADE_MENORES("RENDA_VITALICIA_CONJUGE_CONTINUIDADE_MENORES"),
    
    RENDA_VITALICIA_MINIMO_GARANTIDO("RENDA_VITALICIA_MINIMO_GARANTIDO"),
    
    RENDA_VITALICIA_PRAZO_MINIMO_GRANTIDO("RENDA_VITALICIA_PRAZO_MINIMO_GRANTIDO");

    private String value;

    IncomeModalityEnum(String value) {
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
    public static IncomeModalityEnum fromValue(String value) {
      for (IncomeModalityEnum b : IncomeModalityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("incomeModality")
  private List<IncomeModalityEnum> incomeModality = new ArrayList<>();

  /**
   * Tábua biométrica é o instrumento que mede a duração da vida humana (também conhecida como tábua de mortalidade) ou a probabilidade de entrada em invalidez e é um parâmetro utilizado para tarifar os planos de previdência complementar aberta.
   */
  public enum BiometricTableEnum {
    AT_2000_MALE_FEMALE("AT_2000_MALE_FEMALE"),
    
    AT_2000_FEMALE("AT_2000_FEMALE"),
    
    AT_2000_MALE_SUAVIZADA_10("AT_2000_MALE_SUAVIZADA_10"),
    
    AT_2000_FEMALE_SUAVIZADA_10("AT_2000_FEMALE_SUAVIZADA_10"),
    
    AT_2000_MALE_SUAVIZADA_15("AT_2000_MALE_SUAVIZADA_15"),
    
    AT_2000_FEMALE_SUAVIZADA_15("AT_2000_FEMALE_SUAVIZADA_15"),
    
    AT_83_MALE("AT_83_MALE"),
    
    AT_83_FEMALE("AT_83_FEMALE"),
    
    BR_EMSSB_MALE("BR_EMSSB_MALE"),
    
    BR_EMSSB_FEMALE("BR_EMSSB_FEMALE");

    private String value;

    BiometricTableEnum(String value) {
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
    public static BiometricTableEnum fromValue(String value) {
      for (BiometricTableEnum b : BiometricTableEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("biometricTable")
  private List<BiometricTableEnum> biometricTable = new ArrayList<>();

  @JsonProperty("interestRate")
  private BigDecimal interestRate;

  /**
   * É o índice contratado para atualização monetária dos valores relativos ao plano, na forma estabelecida por este regulamento.
   */
  public enum UpdateIndexEnum {
    IPCA("IPCA"),
    
    IGP_M("IGP-M"),
    
    INPC("INPC");

    private String value;

    UpdateIndexEnum(String value) {
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
    public static UpdateIndexEnum fromValue(String value) {
      for (UpdateIndexEnum b : UpdateIndexEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("updateIndex")
  private UpdateIndexEnum updateIndex;

  @JsonProperty("reversalResultsFinancial")
  private BigDecimal reversalResultsFinancial;

  @JsonProperty("investimentFunds")
  private LifePensionInvestmentFunds investimentFunds;

  public LifePensionPeriodGrantBenefit incomeModality(List<IncomeModalityEnum> incomeModality) {
    this.incomeModality = incomeModality;
    return this;
  }

  public LifePensionPeriodGrantBenefit addIncomeModalityItem(IncomeModalityEnum incomeModalityItem) {
    this.incomeModality.add(incomeModalityItem);
    return this;
  }

  public List<IncomeModalityEnum> getIncomeModality() {
    return incomeModality;
  }

  public void setIncomeModality(List<IncomeModalityEnum> incomeModality) {
    this.incomeModality = incomeModality;
  }

  public LifePensionPeriodGrantBenefit biometricTable(List<BiometricTableEnum> biometricTable) {
    this.biometricTable = biometricTable;
    return this;
  }

  public LifePensionPeriodGrantBenefit addBiometricTableItem(BiometricTableEnum biometricTableItem) {
    this.biometricTable.add(biometricTableItem);
    return this;
  }

  public List<BiometricTableEnum> getBiometricTable() {
    return biometricTable;
  }

  public void setBiometricTable(List<BiometricTableEnum> biometricTable) {
    this.biometricTable = biometricTable;
  }

  public LifePensionPeriodGrantBenefit interestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
    return this;
  }

  public BigDecimal getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
  }

  public LifePensionPeriodGrantBenefit updateIndex(UpdateIndexEnum updateIndex) {
    this.updateIndex = updateIndex;
    return this;
  }
  public UpdateIndexEnum getUpdateIndex() {
    return updateIndex;
  }

  public void setUpdateIndex(UpdateIndexEnum updateIndex) {
    this.updateIndex = updateIndex;
  }

  public LifePensionPeriodGrantBenefit reversalResultsFinancial(BigDecimal reversalResultsFinancial) {
    this.reversalResultsFinancial = reversalResultsFinancial;
    return this;
  }

  public BigDecimal getReversalResultsFinancial() {
    return reversalResultsFinancial;
  }

  public void setReversalResultsFinancial(BigDecimal reversalResultsFinancial) {
    this.reversalResultsFinancial = reversalResultsFinancial;
  }

  public LifePensionPeriodGrantBenefit investimentFunds(LifePensionInvestmentFunds investimentFunds) {
    this.investimentFunds = investimentFunds;
    return this;
  }

  public LifePensionInvestmentFunds getInvestimentFunds() {
    return investimentFunds;
  }

  public void setInvestimentFunds(LifePensionInvestmentFunds investimentFunds) {
    this.investimentFunds = investimentFunds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifePensionPeriodGrantBenefit lifePensionPeriodGrantBenefit = (LifePensionPeriodGrantBenefit) o;
    return Objects.equals(this.incomeModality, lifePensionPeriodGrantBenefit.incomeModality) &&
        Objects.equals(this.biometricTable, lifePensionPeriodGrantBenefit.biometricTable) &&
        Objects.equals(this.interestRate, lifePensionPeriodGrantBenefit.interestRate) &&
        Objects.equals(this.updateIndex, lifePensionPeriodGrantBenefit.updateIndex) &&
        Objects.equals(this.reversalResultsFinancial, lifePensionPeriodGrantBenefit.reversalResultsFinancial) &&
        Objects.equals(this.investimentFunds, lifePensionPeriodGrantBenefit.investimentFunds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(incomeModality, biometricTable, interestRate, updateIndex, reversalResultsFinancial, investimentFunds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifePensionPeriodGrantBenefit {\n");
    
    sb.append("    incomeModality: ").append(toIndentedString(incomeModality)).append("\n");
    sb.append("    biometricTable: ").append(toIndentedString(biometricTable)).append("\n");
    sb.append("    interestRate: ").append(toIndentedString(interestRate)).append("\n");
    sb.append("    updateIndex: ").append(toIndentedString(updateIndex)).append("\n");
    sb.append("    reversalResultsFinancial: ").append(toIndentedString(reversalResultsFinancial)).append("\n");
    sb.append("    investimentFunds: ").append(toIndentedString(investimentFunds)).append("\n");
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

