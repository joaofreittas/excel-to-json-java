package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Objects;

/**
 * PersonMinimumRequirements
 */
public class PersonMinimumRequirements  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Gets or Sets contractingType
   */
  public enum ContractingTypeEnum {
    COLETIVO("COLETIVO"),
    
    INDIVIDUAL("INDIVIDUAL");

    private String value;

    ContractingTypeEnum(String value) {
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
    public static ContractingTypeEnum fromValue(String value) {
      for (ContractingTypeEnum b : ContractingTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("contractingType")
  private ContractingTypeEnum contractingType;

  @JsonProperty("contractingMinRequirement")
  private String contractingMinRequirement;

  public PersonMinimumRequirements contractingType(ContractingTypeEnum contractingType) {
    this.contractingType = contractingType;
    return this;
  }

  public ContractingTypeEnum getContractingType() {
    return contractingType;
  }

  public void setContractingType(ContractingTypeEnum contractingType) {
    this.contractingType = contractingType;
  }

  public PersonMinimumRequirements contractingMinRequirement(String contractingMinRequirement) {
    this.contractingMinRequirement = contractingMinRequirement;
    return this;
  }


  public String getContractingMinRequirement() {
    return contractingMinRequirement;
  }

  public void setContractingMinRequirement(String contractingMinRequirement) {
    this.contractingMinRequirement = contractingMinRequirement;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonMinimumRequirements personMinimumRequirements = (PersonMinimumRequirements) o;
    return Objects.equals(this.contractingType, personMinimumRequirements.contractingType) &&
        Objects.equals(this.contractingMinRequirement, personMinimumRequirements.contractingMinRequirement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contractingType, contractingMinRequirement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonMinimumRequirements {\n");
    
    sb.append("    contractingType: ").append(toIndentedString(contractingType)).append("\n");
    sb.append("    contractingMinRequirement: ").append(toIndentedString(contractingMinRequirement)).append("\n");
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

