package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class PersonCoverageAttibutesDetails  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("amount")
  private BigDecimal amount;

  @JsonProperty("unit")
  private PersonCoverageAttibutesDetailsUnit unit;

  public PersonCoverageAttibutesDetails amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public PersonCoverageAttibutesDetails unit(PersonCoverageAttibutesDetailsUnit unit) {
    this.unit = unit;
    return this;
  }

  public PersonCoverageAttibutesDetailsUnit getUnit() {
    return unit;
  }

  public void setUnit(PersonCoverageAttibutesDetailsUnit unit) {
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
    PersonCoverageAttibutesDetails personCoverageAttibutesDetails = (PersonCoverageAttibutesDetails) o;
    return Objects.equals(this.amount, personCoverageAttibutesDetails.amount) &&
        Objects.equals(this.unit, personCoverageAttibutesDetails.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, unit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonCoverageAttibutesDetails {\n");
    
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

