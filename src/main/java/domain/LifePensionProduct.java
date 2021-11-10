package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Objects;
public class LifePensionProduct  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("code")
  private String code;

  /**
   * Segmento do qual se trata o produto contratado.
   */
  public enum SegmentEnum {
    SEGURO_PESSOAS("SEGURO_PESSOAS"),
    
    PREVIDENCIA("PREVIDENCIA");

    private String value;

    SegmentEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SegmentEnum fromValue(String value) {
      for (SegmentEnum b : SegmentEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("segment")
  private SegmentEnum segment;

  /**
   * Modalidade do produto contratado.
   */
  public enum ModalityEnum {
    CONTRIBUICAO_VARIAVEL("CONTRIBUICAO_VARIAVEL"),
    
    BENEFICIO_DEFINIDO("BENEFICIO_DEFINIDO");

    private String value;

    ModalityEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ModalityEnum fromValue(String value) {
      for (ModalityEnum b : ModalityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("modality")
  private ModalityEnum modality;

  @JsonProperty("optionalCoverage")
  private String optionalCoverage;

  @JsonProperty("productDetails")
  private LifePensionProductDetails productDetails;

  @JsonProperty("minimumRequirements")
  private LifePensionMinimumRequirements minimumRequirements;

  /**
   * Público-alvo.
   */
  public enum TargetAudienceEnum {
    NATURAL("PESSOA_NATURAL"),
    
    JURIDICA("PESSOA_JURIDICA");

    private String value;

    TargetAudienceEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TargetAudienceEnum fromValue(String value) {
      for (TargetAudienceEnum b : TargetAudienceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("targetAudience")
  private TargetAudienceEnum targetAudience;

  public LifePensionProduct name(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LifePensionProduct code(String code) {
    this.code = code;
    return this;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public LifePensionProduct segment(SegmentEnum segment) {
    this.segment = segment;
    return this;
  }

  public SegmentEnum getSegment() {
    return segment;
  }

  public void setSegment(SegmentEnum segment) {
    this.segment = segment;
  }

  public LifePensionProduct modality(ModalityEnum modality) {
    this.modality = modality;
    return this;
  }

  public ModalityEnum getModality() {
    return modality;
  }

  public void setModality(ModalityEnum modality) {
    this.modality = modality;
  }

  public LifePensionProduct optionalCoverage(String optionalCoverage) {
    this.optionalCoverage = optionalCoverage;
    return this;
  }

  public String getOptionalCoverage() {
    return optionalCoverage;
  }

  public void setOptionalCoverage(String optionalCoverage) {
    this.optionalCoverage = optionalCoverage;
  }

  public LifePensionProduct productDetails(LifePensionProductDetails productDetails) {
    this.productDetails = productDetails;
    return this;
  }

  public LifePensionProductDetails getProductDetails() {
    return productDetails;
  }

  public void setProductDetails(LifePensionProductDetails productDetails) {
    this.productDetails = productDetails;
  }

  public LifePensionProduct minimumRequirements(LifePensionMinimumRequirements minimumRequirements) {
    this.minimumRequirements = minimumRequirements;
    return this;
  }

  public LifePensionMinimumRequirements getMinimumRequirements() {
    return minimumRequirements;
  }

  public void setMinimumRequirements(LifePensionMinimumRequirements minimumRequirements) {
    this.minimumRequirements = minimumRequirements;
  }

  public LifePensionProduct targetAudience(TargetAudienceEnum targetAudience) {
    this.targetAudience = targetAudience;
    return this;
  }

  public TargetAudienceEnum getTargetAudience() {
    return targetAudience;
  }

  public void setTargetAudience(TargetAudienceEnum targetAudience) {
    this.targetAudience = targetAudience;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifePensionProduct lifePensionProduct = (LifePensionProduct) o;
    return Objects.equals(this.name, lifePensionProduct.name) &&
        Objects.equals(this.code, lifePensionProduct.code) &&
        Objects.equals(this.segment, lifePensionProduct.segment) &&
        Objects.equals(this.modality, lifePensionProduct.modality) &&
        Objects.equals(this.optionalCoverage, lifePensionProduct.optionalCoverage) &&
        Objects.equals(this.productDetails, lifePensionProduct.productDetails) &&
        Objects.equals(this.minimumRequirements, lifePensionProduct.minimumRequirements) &&
        Objects.equals(this.targetAudience, lifePensionProduct.targetAudience);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, code, segment, modality, optionalCoverage, productDetails, minimumRequirements, targetAudience);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifePensionProduct {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    segment: ").append(toIndentedString(segment)).append("\n");
    sb.append("    modality: ").append(toIndentedString(modality)).append("\n");
    sb.append("    optionalCoverage: ").append(toIndentedString(optionalCoverage)).append("\n");
    sb.append("    productDetails: ").append(toIndentedString(productDetails)).append("\n");
    sb.append("    minimumRequirements: ").append(toIndentedString(minimumRequirements)).append("\n");
    sb.append("    targetAudience: ").append(toIndentedString(targetAudience)).append("\n");
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

