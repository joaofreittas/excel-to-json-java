package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Objects;

public class LifePensionMinimumRequirements  implements Serializable {
  private static final long serialVersionUID = 1L;

  public enum ContractTypeEnum {
    COLETIVO_AVERBADO("COLETIVO_AVERBADO"),
    
    COLETIVO_INSTITUIDO("COLETIVO_INSTITUIDO"),
    
    INDIVIDUAL("INDIVIDUAL");

    private String value;

    ContractTypeEnum(String value) {
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
    public static ContractTypeEnum fromValue(String value) {
      for (ContractTypeEnum b : ContractTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("contractType")
  private ContractTypeEnum contractType;

  @JsonProperty("participantQualified")
  private Boolean participantQualified;

  @JsonProperty("minRequirementsContract")
  private String minRequirementsContract;

  public LifePensionMinimumRequirements contractType(ContractTypeEnum contractType) {
    this.contractType = contractType;
    return this;
  }

  public ContractTypeEnum getContractType() {
    return contractType;
  }

  public void setContractType(ContractTypeEnum contractType) {
    this.contractType = contractType;
  }

  public LifePensionMinimumRequirements participantQualified(Boolean participantQualified) {
    this.participantQualified = participantQualified;
    return this;
  }


  public Boolean getParticipantQualified() {
    return participantQualified;
  }

  public void setParticipantQualified(Boolean participantQualified) {
    this.participantQualified = participantQualified;
  }

  public LifePensionMinimumRequirements minRequirementsContract(String minRequirementsContract) {
    this.minRequirementsContract = minRequirementsContract;
    return this;
  }

  public String getMinRequirementsContract() {
    return minRequirementsContract;
  }

  public void setMinRequirementsContract(String minRequirementsContract) {
    this.minRequirementsContract = minRequirementsContract;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifePensionMinimumRequirements lifePensionMinimumRequirements = (LifePensionMinimumRequirements) o;
    return Objects.equals(this.contractType, lifePensionMinimumRequirements.contractType) &&
        Objects.equals(this.participantQualified, lifePensionMinimumRequirements.participantQualified) &&
        Objects.equals(this.minRequirementsContract, lifePensionMinimumRequirements.minRequirementsContract);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contractType, participantQualified, minRequirementsContract);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifePensionMinimumRequirements {\n");
    
    sb.append("    contractType: ").append(toIndentedString(contractType)).append("\n");
    sb.append("    participantQualified: ").append(toIndentedString(participantQualified)).append("\n");
    sb.append("    minRequirementsContract: ").append(toIndentedString(minRequirementsContract)).append("\n");
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