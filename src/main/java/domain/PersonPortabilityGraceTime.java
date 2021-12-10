package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Prazo de carência em dias para Portabilidade
 */
public class PersonPortabilityGraceTime  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("amount")
  private BigDecimal amount;

  /**
   * Unidade do prazo (dias ou meses).
   */
  public enum UnitEnum {
    DIAS("DIAS"),
    
    MESES("MESES"),
    
    NAO_SE_APLICA("NAO_SE_APLICA");

    private String value;

    UnitEnum(String value) {
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
    public static UnitEnum fromValue(String value) {
      for (UnitEnum b : UnitEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("unit")
  private UnitEnum unit;

  public PersonPortabilityGraceTime amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Prazo de Carência
   * @return amount
  */

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public PersonPortabilityGraceTime unit(UnitEnum unit) {
    this.unit = unit;
    return this;
  }

  /**
   * Unidade do prazo (dias ou meses).
   * @return unit
  */

  public UnitEnum getUnit() {
    return unit;
  }

  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonPortabilityGraceTime personPortabilityGraceTime = (PersonPortabilityGraceTime) o;
    return Objects.equals(this.amount, personPortabilityGraceTime.amount) &&
        Objects.equals(this.unit, personPortabilityGraceTime.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, unit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonPortabilityGraceTime {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
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

