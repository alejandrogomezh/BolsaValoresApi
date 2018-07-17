package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Inversion
 */
@Validated

public class Inversion  extends ResourceSupport {
  @JsonProperty("idInversion")
  private String idInversion = null;

  @JsonProperty("idPortafolio")
  private String idPortafolio = null;

  @JsonProperty("cantidadAcciones")
  private Integer cantidadAcciones = null;

  public Inversion idInversion(String idInversion) {
    this.idInversion = idInversion;
    return this;
  }

  /**
   * Get idInversion
   * @return idInversion
  **/
  @ApiModelProperty(example = "i123", required = true, value = "")
  @NotNull


  public String getIdInversion() {
    return idInversion;
  }

  public void setIdInversion(String idInversion) {
    this.idInversion = idInversion;
  }

  public Inversion idPortafolio(String idPortafolio) {
    this.idPortafolio = idPortafolio;
    return this;
  }

  /**
   * Get idPortafolio
   * @return idPortafolio
  **/
  @ApiModelProperty(example = "p123", required = true, value = "")
  @NotNull


  public String getIdPortafolio() {
    return idPortafolio;
  }

  public void setIdPortafolio(String idPortafolio) {
    this.idPortafolio = idPortafolio;
  }

  public Inversion cantidadAcciones(Integer cantidadAcciones) {
    this.cantidadAcciones = cantidadAcciones;
    return this;
  }

  /**
   * Get cantidadAcciones
   * @return cantidadAcciones
  **/
  @ApiModelProperty(example = "10000", required = true, value = "")
  @NotNull


  public Integer getCantidadAcciones() {
    return cantidadAcciones;
  }

  public void setCantidadAcciones(Integer cantidadAcciones) {
    this.cantidadAcciones = cantidadAcciones;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Inversion inversion = (Inversion) o;
    return Objects.equals(this.idInversion, inversion.idInversion) &&
        Objects.equals(this.idPortafolio, inversion.idPortafolio) &&
        Objects.equals(this.cantidadAcciones, inversion.cantidadAcciones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idInversion, idPortafolio, cantidadAcciones);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Inversion {\n");
    
    sb.append("    idInversion: ").append(toIndentedString(idInversion)).append("\n");
    sb.append("    idPortafolio: ").append(toIndentedString(idPortafolio)).append("\n");
    sb.append("    cantidadAcciones: ").append(toIndentedString(cantidadAcciones)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

