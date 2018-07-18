package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Mercado
 */
@Validated

public class Mercado  extends ResourceSupport {
  @JsonProperty("idMercado")
  private String idMercado = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("sector")
  private String sector = null;

  @JsonProperty("descripcion")
  private String descripcion = null;

  @JsonIgnore
  private List<Portafolio> portafolio = new ArrayList<>();

  public Mercado idMercado(String idMercado) {
    this.idMercado = idMercado;
    return this;
  }

  /**
   * Get idMercado
   * @return idMercado
  **/
  @ApiModelProperty(example = "m123", required = true, value = "")
  @NotNull


  public String getIdMercado() {
    return idMercado;
  }

  public void setIdMercado(String idMercado) {
    this.idMercado = idMercado;
  }

  public Mercado nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  **/
  @ApiModelProperty(example = "Energético", required = true, value = "")
  @NotNull


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Mercado sector(String sector) {
    this.sector = sector;
    return this;
  }

  /**
   * Get sector
   * @return sector
  **/
  @ApiModelProperty(example = "Energía", required = true, value = "")
  @NotNull


  public String getSector() {
    return sector;
  }

  public void setSector(String sector) {
    this.sector = sector;
  }

  public Mercado descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
  **/
  @ApiModelProperty(example = "Mercado energético", required = true, value = "")
  @NotNull


  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mercado mercado = (Mercado) o;
    return Objects.equals(this.idMercado, mercado.idMercado) &&
        Objects.equals(this.nombre, mercado.nombre) &&
        Objects.equals(this.sector, mercado.sector) &&
        Objects.equals(this.descripcion, mercado.descripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idMercado, nombre, sector, descripcion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mercado {\n");
    
    sb.append("    idMercado: ").append(toIndentedString(idMercado)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    sector: ").append(toIndentedString(sector)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
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

