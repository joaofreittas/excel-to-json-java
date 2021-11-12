package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Objects;

public class LifePensionProductDetails  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("susepProcessNumber")
  private String susepProcessNumber;

  /**
   * Tipo do produto contratado.
   */
  public enum TypeEnum {
    PGBL("PGBL"),
    
    PRGP("PRGP"),
    
    PAGP("PAGP"),
    
    PRSA("PRSA"),
    
    PRI("PRI"),
    
    PDR("PDR"),
    
    VGBL("VGBL"),
    
    VRGP("VRGP"),
    
    VAGP("VAGP"),
    
    VRSA("VRSA"),
    
    VRI("VRI"),
    
    VDR("VDR");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  @JsonProperty("contractTermsConditions")
  private String contractTermsConditions;

  @JsonProperty("defferalPeriod")
  private LifePensionDefferalPeriod defferalPeriod;

  @JsonProperty("grantPeriodBenefit")
  private LifePensionPeriodGrantBenefit grantPeriodBenefit;

  @JsonProperty("costs")
  private LifePensionCosts costs;

  public LifePensionProductDetails susepProcessNumber(String susepProcessNumber) {
    this.susepProcessNumber = susepProcessNumber;
    return this;
  }

  public String getSusepProcessNumber() {
    return susepProcessNumber;
  }

  public void setSusepProcessNumber(String susepProcessNumber) {
    this.susepProcessNumber = susepProcessNumber;
  }

  public LifePensionProductDetails type(TypeEnum type) {
    this.type = type;
    return this;
  }

  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public LifePensionProductDetails contractTermsConditions(String contractTermsConditions) {
    this.contractTermsConditions = contractTermsConditions;
    return this;
  }

  public String getContractTermsConditions() {
    return contractTermsConditions;
  }

  public void setContractTermsConditions(String contractTermsConditions) {
    this.contractTermsConditions = contractTermsConditions;
  }

  public LifePensionProductDetails defferalPeriod(LifePensionDefferalPeriod defferalPeriod) {
    this.defferalPeriod = defferalPeriod;
    return this;
  }

  public LifePensionDefferalPeriod getDefferalPeriod() {
    return defferalPeriod;
  }

  public void setDefferalPeriod(LifePensionDefferalPeriod defferalPeriod) {
    this.defferalPeriod = defferalPeriod;
  }

  public LifePensionProductDetails grantPeriodBenefit(LifePensionPeriodGrantBenefit grantPeriodBenefit) {
    this.grantPeriodBenefit = grantPeriodBenefit;
    return this;
  }

  public LifePensionPeriodGrantBenefit getGrantPeriodBenefit() {
    return grantPeriodBenefit;
  }

  public void setGrantPeriodBenefit(LifePensionPeriodGrantBenefit grantPeriodBenefit) {
    this.grantPeriodBenefit = grantPeriodBenefit;
  }

  public LifePensionProductDetails costs(LifePensionCosts costs) {
    this.costs = costs;
    return this;
  }


  public LifePensionCosts getCosts() {
    return costs;
  }

  public void setCosts(LifePensionCosts costs) {
    this.costs = costs;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifePensionProductDetails lifePensionProductDetails = (LifePensionProductDetails) o;
    return Objects.equals(this.susepProcessNumber, lifePensionProductDetails.susepProcessNumber) &&
        Objects.equals(this.type, lifePensionProductDetails.type) &&
        Objects.equals(this.contractTermsConditions, lifePensionProductDetails.contractTermsConditions) &&
        Objects.equals(this.defferalPeriod, lifePensionProductDetails.defferalPeriod) &&
        Objects.equals(this.grantPeriodBenefit, lifePensionProductDetails.grantPeriodBenefit) &&
        Objects.equals(this.costs, lifePensionProductDetails.costs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(susepProcessNumber, type, contractTermsConditions, defferalPeriod, grantPeriodBenefit, costs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifePensionProductDetails {\n");
    
    sb.append("    susepProcessNumber: ").append(toIndentedString(susepProcessNumber)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    contractTermsConditions: ").append(toIndentedString(contractTermsConditions)).append("\n");
    sb.append("    defferalPeriod: ").append(toIndentedString(defferalPeriod)).append("\n");
    sb.append("    grantPeriodBenefit: ").append(toIndentedString(grantPeriodBenefit)).append("\n");
    sb.append("    costs: ").append(toIndentedString(costs)).append("\n");
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

