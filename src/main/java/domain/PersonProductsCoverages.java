package domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PersonProductsCoverages
 */
public class PersonProductsCoverages  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Gets or Sets coverage
   */
  public enum CoverageEnum {
    ADIANTAMENTO_DOENCA_ESTAGIO_TERMINAL("ADIANTAMENTO_DOENCA_ESTAGIO_TERMINAL"),
    
    AUXILIO_CESTA_BASICA("AUXILIO_CESTA_BASICA"),
    
    AUXILIO_FINANCEIRO_IMEDIATO("AUXILIO_FINANCEIRO_IMEDIATO"),
    
    CANCELAMENTO_DE_VIAGEM("CANCELAMENTO_DE_VIAGEM"),
    
    CIRURGIA("CIRURGIA"),
    
    COBERTURA_PARA_HERNIA("COBERTURA_PARA_HERNIA"),
    
    COBERTURA_PARA_LER_DORT("COBERTURA_PARA_LER_DORT"),
    
    CUIDADOS_PROLONGADOS_ACIDENTE("CUIDADOS_PROLONGADOS_ACIDENTE"),
    
    DESEMPREGO_PERDA_DE_RENDA("DESEMPREGO_PERDA_DE_RENDA"),
    
    DESPESAS_EXTRA_INVALIDEZ_PERMANENTE_TOTAL_PARCIAL_ACIDENTE_DEI("DESPESAS_EXTRA_INVALIDEZ_PERMANENTE_TOTAL_PARCIAL_ACIDENTE_DEI"),
    
    DESPESAS_EXTRA_MORTE_DEM("DESPESAS_EXTRA_MORTE_DEM"),
    
    DESPESAS_MEDICAS_HOSPITALARES_ODONTOLOGICAS("DESPESAS_MEDICAS_HOSPITALARES_ODONTOLOGICAS"),
    
    DESPESAS_MEDICAS_HOSPITALARES_ODONTOLOGICAS_BRASIL("DESPESAS_MEDICAS_HOSPITALARES_ODONTOLOGICAS_BRASIL"),
    
    DESPESAS_MEDICAS_HOSPITALARES_ODONTOLOGICAS_EXTERIOR("DESPESAS_MEDICAS_HOSPITALARES_ODONTOLOGICAS_EXTERIOR"),
    
    DIARIA_INCAPACIDADE_TOTAL_TEMPORARIA("DIARIA_INCAPACIDADE_TOTAL_TEMPORARIA"),
    
    DIARIA_INTERNACAO_HOSPITALAR("DIARIA_INTERNACAO_HOSPITALAR"),
    
    INTERNACAO_HOSPITALAR("INTERNACAO_HOSPITALAR"),
    
    DIARIAS_INCAPACIDADE_PECUNIARIA_DIP("DIARIAS_INCAPACIDADE_PECUNIARIA_DIP"),
    
    DOENCA_GRAVE("DOENCA_GRAVE"),
    
    DOENCA_CONGENITA_FILHOS_DCF("DOENCA_CONGENITA_FILHOS_DCF"),
    
    FRATURA_OSSEA("FRATURA_OSSEA"),
    
    DOENCAS_TROPICAIS("DOENCAS_TROPICAIS"),
    
    INCAPACIDADE_TOTAL_OU_TEMPORARIA("INCAPACIDADE_TOTAL_OU_TEMPORARIA"),
    
    INVALIDEZ_PERMANENTE_TOTAL_PARCIAL("INVALIDEZ_PERMANENTE_TOTAL_PARCIAL"),
    
    INVALIDEZ_TOTAL_ACIDENTE("INVALIDEZ_TOTAL_ACIDENTE"),
    
    INVALIDEZ_PARCIAL_ACIDENTE("INVALIDEZ_PARCIAL_ACIDENTE"),
    
    INVALIDEZ_FUNCIONAL_PERMANENTE_DOENCA("INVALIDEZ_FUNCIONAL_PERMANENTE_DOENCA"),
    
    INVALIDEZ_LABORATIVA_DOENCA("INVALIDEZ_LABORATIVA_DOENCA"),
    
    MORTE("MORTE"),
    
    MORTE_ACIDENTAL("MORTE_ACIDENTAL"),
    
    MORTE_CONJUGE("MORTE_CONJUGE"),
    
    MORTE_FILHOS("MORTE_FILHOS"),
    
    MORTE_ADIATAMENTO_DOENCA_ESTAGIO_TERMINAL("MORTE_ADIATAMENTO_DOENCA_ESTAGIO_TERMINAL"),
    
    PAGAMENTO_ANTECIPADO_ESPECIAL_DOENCA_PROFISSIONAL_PAED("PAGAMENTO_ANTECIPADO_ESPECIAL_DOENCA_PROFISSIONAL_PAED"),
    
    PERDA_DA_AUTONOMIA_PESSOAL("PERDA_DA_AUTONOMIA_PESSOAL"),
    
    PERDA_INVOLUNTARIA_EMPREGO("PERDA_INVOLUNTARIA_EMPREGO"),
    
    QUEIMADURA_GRAVE("QUEIMADURA_GRAVE"),
    
    REGRESSO_ANTECIPADO_SANITARIO("REGRESSO_ANTECIPADO_SANITARIO"),
    
    RENDA_INCAPACIDADE_TEMPORARIA("RENDA_INCAPACIDADE_TEMPORARIA"),
    
    RESCISAO_CONTRATUAL_CASO_MORTE_RCM("RESCISAO_CONTRATUAL_CASO_MORTE_RCM"),
    
    RESCISAO_TRABALHISTA("RESCISAO_TRABALHISTA"),
    
    SERVICO_AUXILIO_FUNERAL("SERVICO_AUXILIO_FUNERAL"),
    
    SOBREVIVENCIA("SOBREVIVENCIA"),
    
    TRANSPLANTE_ORGAOS("TRANSPLANTE_ORGAOS"),
    
    TRANSLADO("TRANSLADO"),
    
    TRANSLADO_MEDICO("TRANSLADO_MEDICO"),
    
    TRANSLADO_CORPO("TRANSLADO_CORPO"),
    
    VERBA_RESCISORIA("VERBA_RESCISORIA"),
    
    OUTRAS("OUTRAS");

    private String value;

    CoverageEnum(String value) {
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
    public static CoverageEnum fromValue(String value) {
      for (CoverageEnum b : CoverageEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("coverage")
  private CoverageEnum coverage;

  @JsonProperty("coverageOthers")
  private List<String> coverageOthers = null;

  @JsonProperty("coverageAttributes")
  private PersonCoverageAttributes coverageAttributes;

  public PersonProductsCoverages coverage(CoverageEnum coverage) {
    this.coverage = coverage;
    return this;
  }

  /**
   * Get coverage
   * @return coverage
  */


  public CoverageEnum getCoverage() {
    return coverage;
  }

  public void setCoverage(CoverageEnum coverage) {
    this.coverage = coverage;
  }

  public PersonProductsCoverages coverageOthers(List<String> coverageOthers) {
    this.coverageOthers = coverageOthers;
    return this;
  }

  public PersonProductsCoverages addCoverageOthersItem(String coverageOthersItem) {
    if (this.coverageOthers == null) {
      this.coverageOthers = new ArrayList<>();
    }
    this.coverageOthers.add(coverageOthersItem);
    return this;
  }

  /**
   * Get coverageOthers
   * @return coverageOthers
  */


  public List<String> getCoverageOthers() {
    return coverageOthers;
  }

  public void setCoverageOthers(List<String> coverageOthers) {
    this.coverageOthers = coverageOthers;
  }

  public PersonProductsCoverages coverageAttributes(PersonCoverageAttributes coverageAttributes) {
    this.coverageAttributes = coverageAttributes;
    return this;
  }

  /**
   * Get coverageAttributes
   * @return coverageAttributes
  */

  public PersonCoverageAttributes getCoverageAttributes() {
    return coverageAttributes;
  }

  public void setCoverageAttributes(PersonCoverageAttributes coverageAttributes) {
    this.coverageAttributes = coverageAttributes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonProductsCoverages personProductsCoverages = (PersonProductsCoverages) o;
    return Objects.equals(this.coverage, personProductsCoverages.coverage) &&
        Objects.equals(this.coverageOthers, personProductsCoverages.coverageOthers) &&
        Objects.equals(this.coverageAttributes, personProductsCoverages.coverageAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coverage, coverageOthers, coverageAttributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonProductsCoverages {\n");
    
    sb.append("    coverage: ").append(toIndentedString(coverage)).append("\n");
    sb.append("    coverageOthers: ").append(toIndentedString(coverageOthers)).append("\n");
    sb.append("    coverageAttributes: ").append(toIndentedString(coverageAttributes)).append("\n");
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

