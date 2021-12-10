package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PersonPremiumPayment
 */
public class PersonPremiumPayment  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Meio(s) de pagamento do Prêmio disponíveis
   */
  public enum PaymentMethodEnum {
    CARTAO_CREDITO("CARTAO_CREDITO"),
    
    DEBITO_CONTA("DEBITO_CONTA"),
    
    DEBITO_CONTA_POUPANCA("DEBITO_CONTA_POUPANCA"),
    
    BOLETO_BANCARIO("BOLETO_BANCARIO"),
    
    PIX("PIX"),
    
    CARTAO_DEBITO("CARTAO_DEBITO"),
    
    REGRA_PARCEIRO("REGRA_PARCEIRO"),
    
    CONSIGNACAO_FOLHA_PAGAMENTO("CONSIGNACAO_FOLHA_PAGAMENTO"),
    
    PONTOS_PROGRAMAS_BENEFICIO("PONTOS_PROGRAMAS_BENEFICIO");

    private String value;

    PaymentMethodEnum(String value) {
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
    public static PaymentMethodEnum fromValue(String value) {
      for (PaymentMethodEnum b : PaymentMethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("paymentMethod")
  private List<PaymentMethodEnum> paymentMethod = new ArrayList<>();

  /**
   * Periodicidade de pagamento do prêmio
   */
  public enum FrequencyEnum {
    DIARIA("DIARIA"),
    
    MENSAL("MENSAL"),
    
    UNICA("UNICA"),
    
    ANUAL("ANUAL"),
    
    TRIMESTRAL("TRIMESTRAL"),
    
    SEMESTRAL("SEMESTRAL"),
    
    FRACIONADO("FRACIONADO"),
    
    OUTRA("OUTRA");

    private String value;

    FrequencyEnum(String value) {
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
    public static FrequencyEnum fromValue(String value) {
      for (FrequencyEnum b : FrequencyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("frequency")
  private List<FrequencyEnum> frequency = new ArrayList<>();

  @JsonProperty("premiumTax")
  private String premiumTax;

  public PersonPremiumPayment paymentMethod(List<PaymentMethodEnum> paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  public PersonPremiumPayment addPaymentMethodItem(PaymentMethodEnum paymentMethodItem) {
    this.paymentMethod.add(paymentMethodItem);
    return this;
  }

  /**
   * Get paymentMethod
   * @return paymentMethod
  */

  public List<PaymentMethodEnum> getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(List<PaymentMethodEnum> paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public PersonPremiumPayment frequency(List<FrequencyEnum> frequency) {
    this.frequency = frequency;
    return this;
  }

  public PersonPremiumPayment addFrequencyItem(FrequencyEnum frequencyItem) {
    this.frequency.add(frequencyItem);
    return this;
  }

  /**
   * Get frequency
   * @return frequency
  */
  public List<FrequencyEnum> getFrequency() {
    return frequency;
  }

  public void setFrequency(List<FrequencyEnum> frequency) {
    this.frequency = frequency;
  }

  public PersonPremiumPayment premiumTax(String premiumTax) {
    this.premiumTax = premiumTax;
    return this;
  }

  /**
   * Distribuição de frequência relativa aos valores referentes às taxas cobradas.
   * @return premiumTax
  */

  public String getPremiumTax() {
    return premiumTax;
  }

  public void setPremiumTax(String premiumTax) {
    this.premiumTax = premiumTax;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonPremiumPayment personPremiumPayment = (PersonPremiumPayment) o;
    return Objects.equals(this.paymentMethod, personPremiumPayment.paymentMethod) &&
        Objects.equals(this.frequency, personPremiumPayment.frequency) &&
        Objects.equals(this.premiumTax, personPremiumPayment.premiumTax);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentMethod, frequency, premiumTax);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonPremiumPayment {\n");
    
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    premiumTax: ").append(toIndentedString(premiumTax)).append("\n");
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

