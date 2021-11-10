package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class LifePensionCompany  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("cnpjNumber")
  private String cnpjNumber;

  @JsonProperty("products")
  private List<LifePensionProduct> products = new ArrayList<>();

  public LifePensionCompany name(String name) {
    this.name = name;
    return this;
  }



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LifePensionCompany cnpjNumber(String cnpjNumber) {
    this.cnpjNumber = cnpjNumber;
    return this;
  }



  public String getCnpjNumber() {
    return cnpjNumber;
  }

  public void setCnpjNumber(String cnpjNumber) {
    this.cnpjNumber = cnpjNumber;
  }

  public LifePensionCompany products(List<LifePensionProduct> products) {
    this.products = products;
    return this;
  }

  public LifePensionCompany addProductsItem(LifePensionProduct productsItem) {
    this.products.add(productsItem);
    return this;
  }

  public List<LifePensionProduct> getProducts() {
    return products;
  }

  public void setProducts(List<LifePensionProduct> products) {
    this.products = products;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifePensionCompany lifePensionCompany = (LifePensionCompany) o;
    return Objects.equals(this.name, lifePensionCompany.name) &&
        Objects.equals(this.cnpjNumber, lifePensionCompany.cnpjNumber) &&
        Objects.equals(this.products, lifePensionCompany.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, cnpjNumber, products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifePensionCompany {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cnpjNumber: ").append(toIndentedString(cnpjNumber)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
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

