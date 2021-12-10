package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PersonReclaim
 */
public class PersonReclaim  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("reclaimTable")
  private List<PersonReclaimTable> reclaimTable = new ArrayList<>();

  @JsonProperty("differentiatedPercentage")
  private String differentiatedPercentage;

  @JsonProperty("gracePeriod")
  private PersonGracePeriodUnit gracePeriod;

  public PersonReclaim reclaimTable(List<PersonReclaimTable> reclaimTable) {
    this.reclaimTable = reclaimTable;
    return this;
  }

  public PersonReclaim addReclaimTableItem(PersonReclaimTable reclaimTableItem) {
    this.reclaimTable.add(reclaimTableItem);
    return this;
  }


  public List<PersonReclaimTable> getReclaimTable() {
    return reclaimTable;
  }

  public void setReclaimTable(List<PersonReclaimTable> reclaimTable) {
    this.reclaimTable = reclaimTable;
  }

  public PersonReclaim differentiatedPercentage(String differentiatedPercentage) {
    this.differentiatedPercentage = differentiatedPercentage;
    return this;
  }

  /**
   * Campo aberto (possibilidade de incluir URL).
   * @return differentiatedPercentage
  */


  public String getDifferentiatedPercentage() {
    return differentiatedPercentage;
  }

  public void setDifferentiatedPercentage(String differentiatedPercentage) {
    this.differentiatedPercentage = differentiatedPercentage;
  }

  public PersonReclaim gracePeriod(PersonGracePeriodUnit gracePeriod) {
    this.gracePeriod = gracePeriod;
    return this;
  }

  /**
   * Get gracePeriod
   * @return gracePeriod
  */
  public PersonGracePeriodUnit getGracePeriod() {
    return gracePeriod;
  }

  public void setGracePeriod(PersonGracePeriodUnit gracePeriod) {
    this.gracePeriod = gracePeriod;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonReclaim personReclaim = (PersonReclaim) o;
    return Objects.equals(this.reclaimTable, personReclaim.reclaimTable) &&
        Objects.equals(this.differentiatedPercentage, personReclaim.differentiatedPercentage) &&
        Objects.equals(this.gracePeriod, personReclaim.gracePeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reclaimTable, differentiatedPercentage, gracePeriod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonReclaim {\n");
    
    sb.append("    reclaimTable: ").append(toIndentedString(reclaimTable)).append("\n");
    sb.append("    differentiatedPercentage: ").append(toIndentedString(differentiatedPercentage)).append("\n");
    sb.append("    gracePeriod: ").append(toIndentedString(gracePeriod)).append("\n");
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

