package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * ResponsePersonList
 */
public class ResponsePersonList  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("data")
  private ResponsePersonListData data;

  @JsonProperty("links")
  private LinksPaginated links;

  @JsonProperty("meta")
  private MetaPaginated meta;

  public ResponsePersonList data(ResponsePersonListData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  public ResponsePersonListData getData() {
    return data;
  }

  public void setData(ResponsePersonListData data) {
    this.data = data;
  }

  public ResponsePersonList links(LinksPaginated links) {
    this.links = links;
    return this;
  }

  /**
   * Get links
   * @return links
  */

  public LinksPaginated getLinks() {
    return links;
  }

  public void setLinks(LinksPaginated links) {
    this.links = links;
  }

  public ResponsePersonList meta(MetaPaginated meta) {
    this.meta = meta;
    return this;
  }

  /**
   * Get meta
   * @return meta
  */

  public MetaPaginated getMeta() {
    return meta;
  }

  public void setMeta(MetaPaginated meta) {
    this.meta = meta;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponsePersonList responsePersonList = (ResponsePersonList) o;
    return Objects.equals(this.data, responsePersonList.data) &&
        Objects.equals(this.links, responsePersonList.links) &&
        Objects.equals(this.meta, responsePersonList.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, links, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsePersonList {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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

