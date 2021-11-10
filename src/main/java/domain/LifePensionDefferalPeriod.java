package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LifePensionDefferalPeriod  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("interestRate")
  private String interestRate;

  /**
   * Indice garantido que remunera o plano durante a fase de diferimento/ acumulação.
   */
  public enum UpdateIndexEnum {
    IPCA("IPCA"),
    
    IGP_M("IGP-M"),
    
    INPC("INPC");

    private String value;

    UpdateIndexEnum(String value) {
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
    public static UpdateIndexEnum fromValue(String value) {
      for (UpdateIndexEnum b : UpdateIndexEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("updateIndex")
  private UpdateIndexEnum updateIndex;

  @JsonProperty("otherMinimumPerformanceGarantees")
  private String otherMinimumPerformanceGarantees;

  @JsonProperty("reversalFinancialResults")
  private BigDecimal reversalFinancialResults;

  @JsonProperty("minimumPremiumAmount")
  private List<LifePensionDefferalPeriodMinimumPremiumAmount> minimumPremiumAmount = new ArrayList<>();

  /**
   * Meio de pagamento escolhido pelo segurado.
   */
  public enum PremiumPaymentMethodEnum {
    CARTAO_CREDITO("CARTAO_CREDITO"),
    
    DEBITO_CONTA("DEBITO_CONTA"),
    
    DEBITO_CONTA_POUPANCA("DEBITO_CONTA_POUPANCA"),
    
    BOLETO_BANCARIO("BOLETO_BANCARIO"),
    
    PIX("PIX"),
    
    CARTAO_DEBITO("CARTAO_DEBITO"),
    
    REGRA_PARCEIRO("REGRA_PARCEIRO"),
    
    CONSIGUINACAO_FOLHA_PAGAMENTO("CONSIGUINACAO_FOLHA_PAGAMENTO"),
    
    PONTOS_PROGRAMA_BENEFICIO("PONTOS_PROGRAMA_BENEFICIO"),
    
    OUTROS("OUTROS");

    private String value;

    PremiumPaymentMethodEnum(String value) {
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
    public static PremiumPaymentMethodEnum fromValue(String value) {
      for (PremiumPaymentMethodEnum b : PremiumPaymentMethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("premiumPaymentMethod")
  private List<PremiumPaymentMethodEnum> premiumPaymentMethod = null;

  @JsonProperty("permissionExtraordinaryContributions")
  private Boolean permissionExtraordinaryContributions;

  @JsonProperty("permissonScheduledFinancialPayments")
  private Boolean permissonScheduledFinancialPayments;

  @JsonProperty("gracePeriodRedemption")
  private Integer gracePeriodRedemption;

  @JsonProperty("gracePeriodBetweenRedemptionRequests")
  private Integer gracePeriodBetweenRedemptionRequests;

  @JsonProperty("redemptionPaymentTerm")
  private Integer redemptionPaymentTerm;

  @JsonProperty("gracePeriodPortability")
  private Integer gracePeriodPortability;

  @JsonProperty("gracePeriodBetweenPortabilityRequests")
  private Integer gracePeriodBetweenPortabilityRequests;

  @JsonProperty("portabilityPaymentTerm")
  private Integer portabilityPaymentTerm;

  @JsonProperty("investimentFunds")
  private List<LifePensionInvestmentFunds> investimentFunds = new ArrayList<>();

  public LifePensionDefferalPeriod interestRate(String interestRate) {
    this.interestRate = interestRate;
    return this;
  }

  public String getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(String interestRate) {
    this.interestRate = interestRate;
  }

  public LifePensionDefferalPeriod updateIndex(UpdateIndexEnum updateIndex) {
    this.updateIndex = updateIndex;
    return this;
  }

  public UpdateIndexEnum getUpdateIndex() {
    return updateIndex;
  }

  public void setUpdateIndex(UpdateIndexEnum updateIndex) {
    this.updateIndex = updateIndex;
  }

  public LifePensionDefferalPeriod otherMinimumPerformanceGarantees(String otherMinimumPerformanceGarantees) {
    this.otherMinimumPerformanceGarantees = otherMinimumPerformanceGarantees;
    return this;
  }

  public String getOtherMinimumPerformanceGarantees() {
    return otherMinimumPerformanceGarantees;
  }

  public void setOtherMinimumPerformanceGarantees(String otherMinimumPerformanceGarantees) {
    this.otherMinimumPerformanceGarantees = otherMinimumPerformanceGarantees;
  }

  public LifePensionDefferalPeriod reversalFinancialResults(BigDecimal reversalFinancialResults) {
    this.reversalFinancialResults = reversalFinancialResults;
    return this;
  }

  public BigDecimal getReversalFinancialResults() {
    return reversalFinancialResults;
  }

  public void setReversalFinancialResults(BigDecimal reversalFinancialResults) {
    this.reversalFinancialResults = reversalFinancialResults;
  }

  public LifePensionDefferalPeriod minimumPremiumAmount(List<LifePensionDefferalPeriodMinimumPremiumAmount> minimumPremiumAmount) {
    this.minimumPremiumAmount = minimumPremiumAmount;
    return this;
  }

  public LifePensionDefferalPeriod addMinimumPremiumAmountItem(LifePensionDefferalPeriodMinimumPremiumAmount minimumPremiumAmountItem) {
    this.minimumPremiumAmount.add(minimumPremiumAmountItem);
    return this;
  }


  public List<LifePensionDefferalPeriodMinimumPremiumAmount> getMinimumPremiumAmount() {
    return minimumPremiumAmount;
  }

  public void setMinimumPremiumAmount(List<LifePensionDefferalPeriodMinimumPremiumAmount> minimumPremiumAmount) {
    this.minimumPremiumAmount = minimumPremiumAmount;
  }

  public LifePensionDefferalPeriod premiumPaymentMethod(List<PremiumPaymentMethodEnum> premiumPaymentMethod) {
    this.premiumPaymentMethod = premiumPaymentMethod;
    return this;
  }

  public LifePensionDefferalPeriod addPremiumPaymentMethodItem(PremiumPaymentMethodEnum premiumPaymentMethodItem) {
    if (this.premiumPaymentMethod == null) {
      this.premiumPaymentMethod = new ArrayList<>();
    }
    this.premiumPaymentMethod.add(premiumPaymentMethodItem);
    return this;
  }

  public List<PremiumPaymentMethodEnum> getPremiumPaymentMethod() {
    return premiumPaymentMethod;
  }

  public void setPremiumPaymentMethod(List<PremiumPaymentMethodEnum> premiumPaymentMethod) {
    this.premiumPaymentMethod = premiumPaymentMethod;
  }

  public LifePensionDefferalPeriod permissionExtraordinaryContributions(Boolean permissionExtraordinaryContributions) {
    this.permissionExtraordinaryContributions = permissionExtraordinaryContributions;
    return this;
  }

  public Boolean getPermissionExtraordinaryContributions() {
    return permissionExtraordinaryContributions;
  }

  public void setPermissionExtraordinaryContributions(Boolean permissionExtraordinaryContributions) {
    this.permissionExtraordinaryContributions = permissionExtraordinaryContributions;
  }

  public LifePensionDefferalPeriod permissonScheduledFinancialPayments(Boolean permissonScheduledFinancialPayments) {
    this.permissonScheduledFinancialPayments = permissonScheduledFinancialPayments;
    return this;
  }

  public Boolean getPermissonScheduledFinancialPayments() {
    return permissonScheduledFinancialPayments;
  }

  public void setPermissonScheduledFinancialPayments(Boolean permissonScheduledFinancialPayments) {
    this.permissonScheduledFinancialPayments = permissonScheduledFinancialPayments;
  }

  public LifePensionDefferalPeriod gracePeriodRedemption(Integer gracePeriodRedemption) {
    this.gracePeriodRedemption = gracePeriodRedemption;
    return this;
  }

  public Integer getGracePeriodRedemption() {
    return gracePeriodRedemption;
  }

  public void setGracePeriodRedemption(Integer gracePeriodRedemption) {
    this.gracePeriodRedemption = gracePeriodRedemption;
  }

  public LifePensionDefferalPeriod gracePeriodBetweenRedemptionRequests(Integer gracePeriodBetweenRedemptionRequests) {
    this.gracePeriodBetweenRedemptionRequests = gracePeriodBetweenRedemptionRequests;
    return this;
  }

  public Integer getGracePeriodBetweenRedemptionRequests() {
    return gracePeriodBetweenRedemptionRequests;
  }

  public void setGracePeriodBetweenRedemptionRequests(Integer gracePeriodBetweenRedemptionRequests) {
    this.gracePeriodBetweenRedemptionRequests = gracePeriodBetweenRedemptionRequests;
  }

  public LifePensionDefferalPeriod redemptionPaymentTerm(Integer redemptionPaymentTerm) {
    this.redemptionPaymentTerm = redemptionPaymentTerm;
    return this;
  }

  public Integer getRedemptionPaymentTerm() {
    return redemptionPaymentTerm;
  }

  public void setRedemptionPaymentTerm(Integer redemptionPaymentTerm) {
    this.redemptionPaymentTerm = redemptionPaymentTerm;
  }

  public LifePensionDefferalPeriod gracePeriodPortability(Integer gracePeriodPortability) {
    this.gracePeriodPortability = gracePeriodPortability;
    return this;
  }

  public Integer getGracePeriodPortability() {
    return gracePeriodPortability;
  }

  public void setGracePeriodPortability(Integer gracePeriodPortability) {
    this.gracePeriodPortability = gracePeriodPortability;
  }

  public LifePensionDefferalPeriod gracePeriodBetweenPortabilityRequests(Integer gracePeriodBetweenPortabilityRequests) {
    this.gracePeriodBetweenPortabilityRequests = gracePeriodBetweenPortabilityRequests;
    return this;
  }

  public Integer getGracePeriodBetweenPortabilityRequests() {
    return gracePeriodBetweenPortabilityRequests;
  }

  public void setGracePeriodBetweenPortabilityRequests(Integer gracePeriodBetweenPortabilityRequests) {
    this.gracePeriodBetweenPortabilityRequests = gracePeriodBetweenPortabilityRequests;
  }

  public LifePensionDefferalPeriod portabilityPaymentTerm(Integer portabilityPaymentTerm) {
    this.portabilityPaymentTerm = portabilityPaymentTerm;
    return this;
  }

  public Integer getPortabilityPaymentTerm() {
    return portabilityPaymentTerm;
  }

  public void setPortabilityPaymentTerm(Integer portabilityPaymentTerm) {
    this.portabilityPaymentTerm = portabilityPaymentTerm;
  }

  public LifePensionDefferalPeriod investimentFunds(List<LifePensionInvestmentFunds> investimentFunds) {
    this.investimentFunds = investimentFunds;
    return this;
  }

  public LifePensionDefferalPeriod addInvestimentFundsItem(LifePensionInvestmentFunds investimentFundsItem) {
    this.investimentFunds.add(investimentFundsItem);
    return this;
  }

  public List<LifePensionInvestmentFunds> getInvestimentFunds() {
    return investimentFunds;
  }

  public void setInvestimentFunds(List<LifePensionInvestmentFunds> investimentFunds) {
    this.investimentFunds = investimentFunds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LifePensionDefferalPeriod lifePensionDefferalPeriod = (LifePensionDefferalPeriod) o;
    return Objects.equals(this.interestRate, lifePensionDefferalPeriod.interestRate) &&
        Objects.equals(this.updateIndex, lifePensionDefferalPeriod.updateIndex) &&
        Objects.equals(this.otherMinimumPerformanceGarantees, lifePensionDefferalPeriod.otherMinimumPerformanceGarantees) &&
        Objects.equals(this.reversalFinancialResults, lifePensionDefferalPeriod.reversalFinancialResults) &&
        Objects.equals(this.minimumPremiumAmount, lifePensionDefferalPeriod.minimumPremiumAmount) &&
        Objects.equals(this.premiumPaymentMethod, lifePensionDefferalPeriod.premiumPaymentMethod) &&
        Objects.equals(this.permissionExtraordinaryContributions, lifePensionDefferalPeriod.permissionExtraordinaryContributions) &&
        Objects.equals(this.permissonScheduledFinancialPayments, lifePensionDefferalPeriod.permissonScheduledFinancialPayments) &&
        Objects.equals(this.gracePeriodRedemption, lifePensionDefferalPeriod.gracePeriodRedemption) &&
        Objects.equals(this.gracePeriodBetweenRedemptionRequests, lifePensionDefferalPeriod.gracePeriodBetweenRedemptionRequests) &&
        Objects.equals(this.redemptionPaymentTerm, lifePensionDefferalPeriod.redemptionPaymentTerm) &&
        Objects.equals(this.gracePeriodPortability, lifePensionDefferalPeriod.gracePeriodPortability) &&
        Objects.equals(this.gracePeriodBetweenPortabilityRequests, lifePensionDefferalPeriod.gracePeriodBetweenPortabilityRequests) &&
        Objects.equals(this.portabilityPaymentTerm, lifePensionDefferalPeriod.portabilityPaymentTerm) &&
        Objects.equals(this.investimentFunds, lifePensionDefferalPeriod.investimentFunds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(interestRate, updateIndex, otherMinimumPerformanceGarantees, reversalFinancialResults, minimumPremiumAmount, premiumPaymentMethod, permissionExtraordinaryContributions, permissonScheduledFinancialPayments, gracePeriodRedemption, gracePeriodBetweenRedemptionRequests, redemptionPaymentTerm, gracePeriodPortability, gracePeriodBetweenPortabilityRequests, portabilityPaymentTerm, investimentFunds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LifePensionDefferalPeriod {\n");
    
    sb.append("    interestRate: ").append(toIndentedString(interestRate)).append("\n");
    sb.append("    updateIndex: ").append(toIndentedString(updateIndex)).append("\n");
    sb.append("    otherMinimumPerformanceGarantees: ").append(toIndentedString(otherMinimumPerformanceGarantees)).append("\n");
    sb.append("    reversalFinancialResults: ").append(toIndentedString(reversalFinancialResults)).append("\n");
    sb.append("    minimumPremiumAmount: ").append(toIndentedString(minimumPremiumAmount)).append("\n");
    sb.append("    premiumPaymentMethod: ").append(toIndentedString(premiumPaymentMethod)).append("\n");
    sb.append("    permissionExtraordinaryContributions: ").append(toIndentedString(permissionExtraordinaryContributions)).append("\n");
    sb.append("    permissonScheduledFinancialPayments: ").append(toIndentedString(permissonScheduledFinancialPayments)).append("\n");
    sb.append("    gracePeriodRedemption: ").append(toIndentedString(gracePeriodRedemption)).append("\n");
    sb.append("    gracePeriodBetweenRedemptionRequests: ").append(toIndentedString(gracePeriodBetweenRedemptionRequests)).append("\n");
    sb.append("    redemptionPaymentTerm: ").append(toIndentedString(redemptionPaymentTerm)).append("\n");
    sb.append("    gracePeriodPortability: ").append(toIndentedString(gracePeriodPortability)).append("\n");
    sb.append("    gracePeriodBetweenPortabilityRequests: ").append(toIndentedString(gracePeriodBetweenPortabilityRequests)).append("\n");
    sb.append("    portabilityPaymentTerm: ").append(toIndentedString(portabilityPaymentTerm)).append("\n");
    sb.append("    investimentFunds: ").append(toIndentedString(investimentFunds)).append("\n");
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

