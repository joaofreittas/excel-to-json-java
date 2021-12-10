package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * PersonPmbacRemuneration
 */
public class PersonPmbacRemuneration  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("interestRate")
  private BigDecimal interestRate;

  /**
   * Índice utilizado na atualização da PMBaC.
   */
  public enum PmbacUpdateIndexEnum {
    IPCA("IPCA"),
    
    IGP_M("IGP-M"),
    
    INPC("INPC");

    private String value;

    PmbacUpdateIndexEnum(String value) {
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
    public static PmbacUpdateIndexEnum fromValue(String value) {
      for (PmbacUpdateIndexEnum b : PmbacUpdateIndexEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("pmbacUpdateIndex")
  private PmbacUpdateIndexEnum pmbacUpdateIndex;

  public PersonPmbacRemuneration interestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
    return this;
  }

  /**
   * Taxa de juros para capitalização da PMBaC.
   * @return interestRate
  */

  public BigDecimal getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
  }

  public PersonPmbacRemuneration pmbacUpdateIndex(PmbacUpdateIndexEnum pmbacUpdateIndex) {
    this.pmbacUpdateIndex = pmbacUpdateIndex;
    return this;
  }

  /**
   * Índice utilizado na atualização da PMBaC.
   * @return pmbacUpdateIndex
  */

  public PmbacUpdateIndexEnum getPmbacUpdateIndex() {
    return pmbacUpdateIndex;
  }

  public void setPmbacUpdateIndex(PmbacUpdateIndexEnum pmbacUpdateIndex) {
    this.pmbacUpdateIndex = pmbacUpdateIndex;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonPmbacRemuneration personPmbacRemuneration = (PersonPmbacRemuneration) o;
    return Objects.equals(this.interestRate, personPmbacRemuneration.interestRate) &&
        Objects.equals(this.pmbacUpdateIndex, personPmbacRemuneration.pmbacUpdateIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(interestRate, pmbacUpdateIndex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonPmbacRemuneration {\n");
    
    sb.append("    interestRate: ").append(toIndentedString(interestRate)).append("\n");
    sb.append("    pmbacUpdateIndex: ").append(toIndentedString(pmbacUpdateIndex)).append("\n");
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

