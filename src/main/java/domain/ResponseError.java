package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ResponseError
 */
public class ResponseError  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("errors")
  private List<ResponseErrorErrors> errors = new ArrayList<>();

  @JsonProperty("meta")
  private MetaPaginated meta;

  public ResponseError errors(List<ResponseErrorErrors> errors) {
    this.errors = errors;
    return this;
  }

  public ResponseError addErrorsItem(ResponseErrorErrors errorsItem) {
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Get errors
   * @return errors
  */
  public List<ResponseErrorErrors> getErrors() {
    return errors;
  }

  public void setErrors(List<ResponseErrorErrors> errors) {
    this.errors = errors;
  }

  public ResponseError meta(MetaPaginated meta) {
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
    ResponseError responseError = (ResponseError) o;
    return Objects.equals(this.errors, responseError.errors) &&
        Objects.equals(this.meta, responseError.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseError {\n");
    
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

