package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

public class ResponseLifePensionList  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("requestTime")
  private OffsetDateTime requestTime;

  @JsonProperty("data")
  private Object data;

  @JsonProperty("brand")
  private LifePensionBrand brand;

  @JsonProperty("linksPaginated")
  private LinksPaginated linksPaginated;

  @JsonProperty("metaPaginated")
  private MetaPaginated metaPaginated;

  public ResponseLifePensionList requestTime(OffsetDateTime requestTime) {
    this.requestTime = requestTime;
    return this;
  }
  public OffsetDateTime getRequestTime() {
    return requestTime;
  }

  public void setRequestTime(OffsetDateTime requestTime) {
    this.requestTime = requestTime;
  }

  public ResponseLifePensionList data(Object data) {
    this.data = data;
    return this;
  }


  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public ResponseLifePensionList brand(LifePensionBrand brand) {
    this.brand = brand;
    return this;
  }

  public LifePensionBrand getBrand() {
    return brand;
  }

  public void setBrand(LifePensionBrand brand) {
    this.brand = brand;
  }

  public ResponseLifePensionList linksPaginated(LinksPaginated linksPaginated) {
    this.linksPaginated = linksPaginated;
    return this;
  }

  public LinksPaginated getLinksPaginated() {
    return linksPaginated;
  }

  public void setLinksPaginated(LinksPaginated linksPaginated) {
    this.linksPaginated = linksPaginated;
  }

  public ResponseLifePensionList metaPaginated(MetaPaginated metaPaginated) {
    this.metaPaginated = metaPaginated;
    return this;
  }

  public MetaPaginated getMetaPaginated() {
    return metaPaginated;
  }

  public void setMetaPaginated(MetaPaginated metaPaginated) {
    this.metaPaginated = metaPaginated;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseLifePensionList responseLifePensionList = (ResponseLifePensionList) o;
    return Objects.equals(this.requestTime, responseLifePensionList.requestTime) &&
        Objects.equals(this.data, responseLifePensionList.data) &&
        Objects.equals(this.brand, responseLifePensionList.brand) &&
        Objects.equals(this.linksPaginated, responseLifePensionList.linksPaginated) &&
        Objects.equals(this.metaPaginated, responseLifePensionList.metaPaginated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestTime, data, brand, linksPaginated, metaPaginated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseLifePensionList {\n");
    
    sb.append("    requestTime: ").append(toIndentedString(requestTime)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    linksPaginated: ").append(toIndentedString(linksPaginated)).append("\n");
    sb.append("    metaPaginated: ").append(toIndentedString(metaPaginated)).append("\n");
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

