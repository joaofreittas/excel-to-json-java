package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class LifePensionBrand  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("companies")
  private LifePensionCompany companies;

  public LifePensionBrand name(String name) {
    this.name = name;
    return this;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LifePensionBrand companies(LifePensionCompany companies) {
    this.companies = companies;
    return this;
  }

  public LifePensionCompany getCompanies() {
    return companies;
  }

  public void setCompanies(LifePensionCompany companies) {
    this.companies = companies;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifePensionBrand lifePensionBrand = (LifePensionBrand) o;
    return Objects.equals(this.name, lifePensionBrand.name) &&
        Objects.equals(this.companies, lifePensionBrand.companies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, companies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifePensionBrand {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    companies: ").append(toIndentedString(companies)).append("\n");
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

