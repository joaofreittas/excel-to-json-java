package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * ResponsePersonListData
 */
public class ResponsePersonListData  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("brand")
  private PersonBrand brand;

  public ResponsePersonListData brand(PersonBrand brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Get brand
   * @return brand
  */

  public PersonBrand getBrand() {
    return brand;
  }

  public void setBrand(PersonBrand brand) {
    this.brand = brand;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponsePersonListData responsePersonListData = (ResponsePersonListData) o;
    return Objects.equals(this.brand, responsePersonListData.brand);
  }

  @Override
  public int hashCode() {
    return Objects.hash(brand);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsePersonListData {\n");
    
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
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

