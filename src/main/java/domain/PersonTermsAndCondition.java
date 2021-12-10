package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * PersonTermsAndCondition
 */
public class PersonTermsAndCondition  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("susepProcessNumber")
  private String susepProcessNumber;

  @JsonProperty("definition")
  private String definition;

  public PersonTermsAndCondition susepProcessNumber(String susepProcessNumber) {
    this.susepProcessNumber = susepProcessNumber;
    return this;
  }

  /**
   * Número do processo Susep.
   * @return susepProcessNumber
  */


  public String getSusepProcessNumber() {
    return susepProcessNumber;
  }

  public void setSusepProcessNumber(String susepProcessNumber) {
    this.susepProcessNumber = susepProcessNumber;
  }

  public PersonTermsAndCondition definition(String definition) {
    this.definition = definition;
    return this;
  }

  /**
   * Campo aberto (possibilidade de incluir URL).
   * @return definition
  */

  public String getDefinition() {
    return definition;
  }

  public void setDefinition(String definition) {
    this.definition = definition;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonTermsAndCondition personTermsAndCondition = (PersonTermsAndCondition) o;
    return Objects.equals(this.susepProcessNumber, personTermsAndCondition.susepProcessNumber) &&
        Objects.equals(this.definition, personTermsAndCondition.definition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(susepProcessNumber, definition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonTermsAndCondition {\n");
    
    sb.append("    susepProcessNumber: ").append(toIndentedString(susepProcessNumber)).append("\n");
    sb.append("    definition: ").append(toIndentedString(definition)).append("\n");
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

