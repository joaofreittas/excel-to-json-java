package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class LifePensionCosts  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("loadingAntecipated")
  private LifePensionLoading loadingAntecipated;

  @JsonProperty("loadingLate")
  private LifePensionLoading loadingLate;

  public LifePensionCosts loadingAntecipated(LifePensionLoading loadingAntecipated) {
    this.loadingAntecipated = loadingAntecipated;
    return this;
  }


  public LifePensionLoading getLoadingAntecipated() {
    return loadingAntecipated;
  }

  public void setLoadingAntecipated(LifePensionLoading loadingAntecipated) {
    this.loadingAntecipated = loadingAntecipated;
  }

  public LifePensionCosts loadingLate(LifePensionLoading loadingLate) {
    this.loadingLate = loadingLate;
    return this;
  }

  public LifePensionLoading getLoadingLate() {
    return loadingLate;
  }

  public void setLoadingLate(LifePensionLoading loadingLate) {
    this.loadingLate = loadingLate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifePensionCosts lifePensionCosts = (LifePensionCosts) o;
    return Objects.equals(this.loadingAntecipated, lifePensionCosts.loadingAntecipated) &&
        Objects.equals(this.loadingLate, lifePensionCosts.loadingLate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loadingAntecipated, loadingLate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifePensionCosts {\n");
    
    sb.append("    loadingAntecipated: ").append(toIndentedString(loadingAntecipated)).append("\n");
    sb.append("    loadingLate: ").append(toIndentedString(loadingLate)).append("\n");
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

