package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
public class LifePensionDefferalPeriodMinimumPremiumAmount  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("minimumPremiumAmountValue")
  private BigDecimal minimumPremiumAmountValue;

  @JsonProperty("minimumPremiumAmountDescription")
  private String minimumPremiumAmountDescription;

  public LifePensionDefferalPeriodMinimumPremiumAmount minimumPremiumAmountValue(BigDecimal minimumPremiumAmountValue) {
    this.minimumPremiumAmountValue = minimumPremiumAmountValue;
    return this;
  }

  public BigDecimal getMinimumPremiumAmountValue() {
    return minimumPremiumAmountValue;
  }

  public void setMinimumPremiumAmountValue(BigDecimal minimumPremiumAmountValue) {
    this.minimumPremiumAmountValue = minimumPremiumAmountValue;
  }

  public LifePensionDefferalPeriodMinimumPremiumAmount minimumPremiumAmountDescription(String minimumPremiumAmountDescription) {
    this.minimumPremiumAmountDescription = minimumPremiumAmountDescription;
    return this;
  }

  public String getMinimumPremiumAmountDescription() {
    return minimumPremiumAmountDescription;
  }

  public void setMinimumPremiumAmountDescription(String minimumPremiumAmountDescription) {
    this.minimumPremiumAmountDescription = minimumPremiumAmountDescription;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifePensionDefferalPeriodMinimumPremiumAmount lifePensionDefferalPeriodMinimumPremiumAmount = (LifePensionDefferalPeriodMinimumPremiumAmount) o;
    return Objects.equals(this.minimumPremiumAmountValue, lifePensionDefferalPeriodMinimumPremiumAmount.minimumPremiumAmountValue) &&
        Objects.equals(this.minimumPremiumAmountDescription, lifePensionDefferalPeriodMinimumPremiumAmount.minimumPremiumAmountDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minimumPremiumAmountValue, minimumPremiumAmountDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifePensionDefferalPeriodMinimumPremiumAmount {\n");
    
    sb.append("    minimumPremiumAmountValue: ").append(toIndentedString(minimumPremiumAmountValue)).append("\n");
    sb.append("    minimumPremiumAmountDescription: ").append(toIndentedString(minimumPremiumAmountDescription)).append("\n");
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

