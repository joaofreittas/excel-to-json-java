package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Objects;

public class PersonAgeAdjustment  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Critério escolhido para reenquadramento etário
   */
  public enum CriterionEnum {
    APOS_PERIODO_EM_ANOS("APOS_PERIODO_EM_ANOS"),
    
    A_CADA_PERIODO_EM_ANOS("A_CADA_PERIODO_EM_ANOS"),
    
    POR_MUDANCA_DE_FAIXA_ETARIA("POR_MUDANCA_DE_FAIXA_ETARIA"),
    
    NAO_APLICAVEL("NAO_APLICAVEL");

    private String value;

    CriterionEnum(String value) {
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
    public static CriterionEnum fromValue(String value) {
      for (CriterionEnum b : CriterionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("criterion")
  private CriterionEnum criterion;

  @JsonProperty("frequency")
  private Integer frequency;

  public PersonAgeAdjustment criterion(CriterionEnum criterion) {
    this.criterion = criterion;
    return this;
  }

  public CriterionEnum getCriterion() {
    return criterion;
  }

  public void setCriterion(CriterionEnum criterion) {
    this.criterion = criterion;
  }

  public PersonAgeAdjustment frequency(Integer frequency) {
    this.frequency = frequency;
    return this;
  }

  public Integer getFrequency() {
    return frequency;
  }

  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonAgeAdjustment personAgeAdjustment = (PersonAgeAdjustment) o;
    return Objects.equals(this.criterion, personAgeAdjustment.criterion) &&
        Objects.equals(this.frequency, personAgeAdjustment.frequency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(criterion, frequency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonAgeAdjustment {\n");
    
    sb.append("    criterion: ").append(toIndentedString(criterion)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
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