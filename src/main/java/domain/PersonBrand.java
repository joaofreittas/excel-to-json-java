package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class PersonBrand  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("companies")
  private List<PersonCompany> companies = new ArrayList<>();

  public PersonBrand name(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PersonBrand companies(List<PersonCompany> companies) {
    this.companies = companies;
    return this;
  }

  public PersonBrand addCompaniesItem(PersonCompany companiesItem) {
    this.companies.add(companiesItem);
    return this;
  }

  public List<PersonCompany> getCompanies() {
    return companies;
  }

  public void setCompanies(List<PersonCompany> companies) {
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
    PersonBrand personBrand = (PersonBrand) o;
    return Objects.equals(this.name, personBrand.name) &&
        Objects.equals(this.companies, personBrand.companies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, companies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonBrand {\n");
    
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

