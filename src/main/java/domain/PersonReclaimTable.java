package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Tabela Percentuais de resgate
 */
public class PersonReclaimTable  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("initialMonthRange")
  private Integer initialMonthRange;

  @JsonProperty("finalMonthRange")
  private Integer finalMonthRange;

  @JsonProperty("percentage")
  private BigDecimal percentage;

  public PersonReclaimTable initialMonthRange(Integer initialMonthRange) {
    this.initialMonthRange = initialMonthRange;
    return this;
  }

  /**
   * Mês inicial do range
   * @return initialMonthRange
  */


  public Integer getInitialMonthRange() {
    return initialMonthRange;
  }

  public void setInitialMonthRange(Integer initialMonthRange) {
    this.initialMonthRange = initialMonthRange;
  }

  public PersonReclaimTable finalMonthRange(Integer finalMonthRange) {
    this.finalMonthRange = finalMonthRange;
    return this;
  }

  /**
   * Mês final do range
   * @return finalMonthRange
  */


  public Integer getFinalMonthRange() {
    return finalMonthRange;
  }

  public void setFinalMonthRange(Integer finalMonthRange) {
    this.finalMonthRange = finalMonthRange;
  }

  public PersonReclaimTable percentage(BigDecimal percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Percentual da faixa de resgate
   * @return percentage
  */

  public BigDecimal getPercentage() {
    return percentage;
  }

  public void setPercentage(BigDecimal percentage) {
    this.percentage = percentage;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonReclaimTable personReclaimTable = (PersonReclaimTable) o;
    return Objects.equals(this.initialMonthRange, personReclaimTable.initialMonthRange) &&
        Objects.equals(this.finalMonthRange, personReclaimTable.finalMonthRange) &&
        Objects.equals(this.percentage, personReclaimTable.percentage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(initialMonthRange, finalMonthRange, percentage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonReclaimTable {\n");
    
    sb.append("    initialMonthRange: ").append(toIndentedString(initialMonthRange)).append("\n");
    sb.append("    finalMonthRange: ").append(toIndentedString(finalMonthRange)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
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

