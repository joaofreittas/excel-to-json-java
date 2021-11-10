package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LifePensionInvestmentFunds  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("cnpjNumber")
  private String cnpjNumber;

  @JsonProperty("companyName")
  private String companyName;

  @JsonProperty("maximumAdministrationFee")
  private BigDecimal maximumAdministrationFee;

  /**
   * Tipo de Taxa de Performance
   */
  public enum TypePerformanceFeeEnum {
    DIRETAMENTE("DIRETAMENTE"),
    
    INDIRETAMENTE("INDIRETAMENTE"),
    
    NAO_APLICA("NAO_APLICA");

    private String value;

    TypePerformanceFeeEnum(String value) {
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
    public static TypePerformanceFeeEnum fromValue(String value) {
      for (TypePerformanceFeeEnum b : TypePerformanceFeeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("typePerformanceFee")
  private List<TypePerformanceFeeEnum> typePerformanceFee = new ArrayList<>();

  @JsonProperty("maximumPerformanceFee")
  private BigDecimal maximumPerformanceFee;

  @JsonProperty("eligibilityRule")
  private Boolean eligibilityRule;

  @JsonProperty("minimumContributionAmount")
  private BigDecimal minimumContributionAmount;

  @JsonProperty("minimumMathematicalProvisionAmount")
  private BigDecimal minimumMathematicalProvisionAmount;

  public LifePensionInvestmentFunds cnpjNumber(String cnpjNumber) {
    this.cnpjNumber = cnpjNumber;
    return this;
  }

  public String getCnpjNumber() {
    return cnpjNumber;
  }

  public void setCnpjNumber(String cnpjNumber) {
    this.cnpjNumber = cnpjNumber;
  }

  public LifePensionInvestmentFunds companyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public LifePensionInvestmentFunds maximumAdministrationFee(BigDecimal maximumAdministrationFee) {
    this.maximumAdministrationFee = maximumAdministrationFee;
    return this;
  }

  public BigDecimal getMaximumAdministrationFee() {
    return maximumAdministrationFee;
  }

  public void setMaximumAdministrationFee(BigDecimal maximumAdministrationFee) {
    this.maximumAdministrationFee = maximumAdministrationFee;
  }

  public LifePensionInvestmentFunds typePerformanceFee(List<TypePerformanceFeeEnum> typePerformanceFee) {
    this.typePerformanceFee = typePerformanceFee;
    return this;
  }

  public LifePensionInvestmentFunds addTypePerformanceFeeItem(TypePerformanceFeeEnum typePerformanceFeeItem) {
    this.typePerformanceFee.add(typePerformanceFeeItem);
    return this;
  }

  public List<TypePerformanceFeeEnum> getTypePerformanceFee() {
    return typePerformanceFee;
  }

  public void setTypePerformanceFee(List<TypePerformanceFeeEnum> typePerformanceFee) {
    this.typePerformanceFee = typePerformanceFee;
  }

  public LifePensionInvestmentFunds maximumPerformanceFee(BigDecimal maximumPerformanceFee) {
    this.maximumPerformanceFee = maximumPerformanceFee;
    return this;
  }

  public BigDecimal getMaximumPerformanceFee() {
    return maximumPerformanceFee;
  }

  public void setMaximumPerformanceFee(BigDecimal maximumPerformanceFee) {
    this.maximumPerformanceFee = maximumPerformanceFee;
  }

  public LifePensionInvestmentFunds eligibilityRule(Boolean eligibilityRule) {
    this.eligibilityRule = eligibilityRule;
    return this;
  }

  public Boolean getEligibilityRule() {
    return eligibilityRule;
  }

  public void setEligibilityRule(Boolean eligibilityRule) {
    this.eligibilityRule = eligibilityRule;
  }

  public LifePensionInvestmentFunds minimumContributionAmount(BigDecimal minimumContributionAmount) {
    this.minimumContributionAmount = minimumContributionAmount;
    return this;
  }

  public BigDecimal getMinimumContributionAmount() {
    return minimumContributionAmount;
  }

  public void setMinimumContributionAmount(BigDecimal minimumContributionAmount) {
    this.minimumContributionAmount = minimumContributionAmount;
  }

  public LifePensionInvestmentFunds minimumMathematicalProvisionAmount(BigDecimal minimumMathematicalProvisionAmount) {
    this.minimumMathematicalProvisionAmount = minimumMathematicalProvisionAmount;
    return this;
  }

  public BigDecimal getMinimumMathematicalProvisionAmount() {
    return minimumMathematicalProvisionAmount;
  }

  public void setMinimumMathematicalProvisionAmount(BigDecimal minimumMathematicalProvisionAmount) {
    this.minimumMathematicalProvisionAmount = minimumMathematicalProvisionAmount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifePensionInvestmentFunds lifePensionInvestmentFunds = (LifePensionInvestmentFunds) o;
    return Objects.equals(this.cnpjNumber, lifePensionInvestmentFunds.cnpjNumber) &&
        Objects.equals(this.companyName, lifePensionInvestmentFunds.companyName) &&
        Objects.equals(this.maximumAdministrationFee, lifePensionInvestmentFunds.maximumAdministrationFee) &&
        Objects.equals(this.typePerformanceFee, lifePensionInvestmentFunds.typePerformanceFee) &&
        Objects.equals(this.maximumPerformanceFee, lifePensionInvestmentFunds.maximumPerformanceFee) &&
        Objects.equals(this.eligibilityRule, lifePensionInvestmentFunds.eligibilityRule) &&
        Objects.equals(this.minimumContributionAmount, lifePensionInvestmentFunds.minimumContributionAmount) &&
        Objects.equals(this.minimumMathematicalProvisionAmount, lifePensionInvestmentFunds.minimumMathematicalProvisionAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cnpjNumber, companyName, maximumAdministrationFee, typePerformanceFee, maximumPerformanceFee, eligibilityRule, minimumContributionAmount, minimumMathematicalProvisionAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifePensionInvestmentFunds {\n");
    
    sb.append("    cnpjNumber: ").append(toIndentedString(cnpjNumber)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    maximumAdministrationFee: ").append(toIndentedString(maximumAdministrationFee)).append("\n");
    sb.append("    typePerformanceFee: ").append(toIndentedString(typePerformanceFee)).append("\n");
    sb.append("    maximumPerformanceFee: ").append(toIndentedString(maximumPerformanceFee)).append("\n");
    sb.append("    eligibilityRule: ").append(toIndentedString(eligibilityRule)).append("\n");
    sb.append("    minimumContributionAmount: ").append(toIndentedString(minimumContributionAmount)).append("\n");
    sb.append("    minimumMathematicalProvisionAmount: ").append(toIndentedString(minimumMathematicalProvisionAmount)).append("\n");
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

