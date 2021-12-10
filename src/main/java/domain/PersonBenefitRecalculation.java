package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Objects;

public class PersonBenefitRecalculation  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Gets or Sets benefitRecalculationCriteria
   */
  public enum BenefitRecalculationCriteriaEnum {
    INDICE("INDICE"),
    
    VINCULADO_SALDO_DEVEDOR("VINCULADO_SALDO_DEVEDOR"),
    
    VARIAVEL_ACORDO_CRITERIO_ESPECIFICO("VARIAVEL_ACORDO_CRITERIO_ESPECIFICO");

    private String value;

    BenefitRecalculationCriteriaEnum(String value) {
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
    public static BenefitRecalculationCriteriaEnum fromValue(String value) {
      for (BenefitRecalculationCriteriaEnum b : BenefitRecalculationCriteriaEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("benefitRecalculationCriteria")
  private BenefitRecalculationCriteriaEnum benefitRecalculationCriteria;

  /**
   * Índice utilizado na atualização do prêmio/contribuição e do capital segurado/ benefício,  caso critério de atualização por meio de índice
   */
  public enum BenefitUpdateIndexEnum {
    IPCA("IPCA"),
    
    IGP_M("IGP-M"),
    
    INPC("INPC");

    private String value;

    BenefitUpdateIndexEnum(String value) {
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
    public static BenefitUpdateIndexEnum fromValue(String value) {
      for (BenefitUpdateIndexEnum b : BenefitUpdateIndexEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("benefitUpdateIndex")
  private BenefitUpdateIndexEnum benefitUpdateIndex;

  public PersonBenefitRecalculation benefitRecalculationCriteria(BenefitRecalculationCriteriaEnum benefitRecalculationCriteria) {
    this.benefitRecalculationCriteria = benefitRecalculationCriteria;
    return this;
  }

  public BenefitRecalculationCriteriaEnum getBenefitRecalculationCriteria() {
    return benefitRecalculationCriteria;
  }

  public void setBenefitRecalculationCriteria(BenefitRecalculationCriteriaEnum benefitRecalculationCriteria) {
    this.benefitRecalculationCriteria = benefitRecalculationCriteria;
  }

  public PersonBenefitRecalculation benefitUpdateIndex(BenefitUpdateIndexEnum benefitUpdateIndex) {
    this.benefitUpdateIndex = benefitUpdateIndex;
    return this;
  }

  public BenefitUpdateIndexEnum getBenefitUpdateIndex() {
    return benefitUpdateIndex;
  }

  public void setBenefitUpdateIndex(BenefitUpdateIndexEnum benefitUpdateIndex) {
    this.benefitUpdateIndex = benefitUpdateIndex;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonBenefitRecalculation personBenefitRecalculation = (PersonBenefitRecalculation) o;
    return Objects.equals(this.benefitRecalculationCriteria, personBenefitRecalculation.benefitRecalculationCriteria) &&
        Objects.equals(this.benefitUpdateIndex, personBenefitRecalculation.benefitUpdateIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(benefitRecalculationCriteria, benefitUpdateIndex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonBenefitRecalculation {\n");
    
    sb.append("    benefitRecalculationCriteria: ").append(toIndentedString(benefitRecalculationCriteria)).append("\n");
    sb.append("    benefitUpdateIndex: ").append(toIndentedString(benefitUpdateIndex)).append("\n");
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