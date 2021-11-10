package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class LifePensionLoading  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("minValue")
  private BigDecimal minValue;

  @JsonProperty("maxValue")
  private BigDecimal maxValue;

  public LifePensionLoading minValue(BigDecimal minValue) {
    this.minValue = minValue;
    return this;
  }

  public BigDecimal getMinValue() {
    return minValue;
  }

  public void setMinValue(BigDecimal minValue) {
    this.minValue = minValue;
  }

  public LifePensionLoading maxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
    return this;
  }

  public BigDecimal getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifePensionLoading lifePensionLoading = (LifePensionLoading) o;
    return Objects.equals(this.minValue, lifePensionLoading.minValue) &&
        Objects.equals(this.maxValue, lifePensionLoading.maxValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minValue, maxValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifePensionLoading {\n");
    
    sb.append("    minValue: ").append(toIndentedString(minValue)).append("\n");
    sb.append("    maxValue: ").append(toIndentedString(maxValue)).append("\n");
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

