package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Portafolio
 */
@Validated

public class Portafolio  extends ResourceSupport {
  @JsonProperty("idPortafolio")
  private String idPortafolio = null;

  @JsonProperty("idMercado")
  private String idMercado = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("rentabilidad")
  private Integer rentabilidad = null;

  @JsonProperty("cantidadAcciones")
  private Integer cantidadAcciones = null;

  @JsonProperty("valorAccion")
  private Integer valorAccion = null;

  @JsonProperty("estado")
  private String estado = null;

  @JsonIgnore
  private List<Inversion> inversion = new ArrayList<>();

  public Portafolio idPortafolio(String idPortafolio) {
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

  public Portafolio idMercado(String idMercado) {
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

  public Portafolio nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  **/
  @ApiModelProperty(example = "Petróleos SA", required = true, value = "")
  @NotNull


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Portafolio rentabilidad(Integer rentabilidad) {
    this.rentabilidad = rentabilidad;
    return this;
  }

  /**
   * Get rentabilidad
   * @return rentabilidad
  **/
  @ApiModelProperty(example = "20", required = true, value = "")
  @NotNull


  public Integer getRentabilidad() {
    return rentabilidad;
  }

  public void setRentabilidad(Integer rentabilidad) {
    this.rentabilidad = rentabilidad;
  }

  public Portafolio cantidadAcciones(Integer cantidadAcciones) {
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

  public Portafolio valorAccion(Integer valorAccion) {
    this.valorAccion = valorAccion;
    return this;
  }

  /**
   * Get valorAccion
   * @return valorAccion
  **/
  @ApiModelProperty(example = "255000", required = true, value = "")
  @NotNull


  public Integer getValorAccion() {
    return valorAccion;
  }

  public void setValorAccion(Integer valorAccion) {
    this.valorAccion = valorAccion;
  }

  public Portafolio estado(String estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
  **/
  @ApiModelProperty(example = "Abierto", required = true, value = "")
  @NotNull


  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public List<Inversion> getInversion() { return inversion; }

  public void setInversion(List<Inversion> inversion) {
    this.inversion = inversion;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Portafolio portafolio = (Portafolio) o;
    return Objects.equals(this.idPortafolio, portafolio.idPortafolio) &&
        Objects.equals(this.idMercado, portafolio.idMercado) &&
        Objects.equals(this.nombre, portafolio.nombre) &&
        Objects.equals(this.rentabilidad, portafolio.rentabilidad) &&
        Objects.equals(this.cantidadAcciones, portafolio.cantidadAcciones) &&
        Objects.equals(this.valorAccion, portafolio.valorAccion) &&
        Objects.equals(this.estado, portafolio.estado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPortafolio, idMercado, nombre, rentabilidad, cantidadAcciones, valorAccion, estado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Portafolio {\n");
    
    sb.append("    idPortafolio: ").append(toIndentedString(idPortafolio)).append("\n");
    sb.append("    idMercado: ").append(toIndentedString(idMercado)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    rentabilidad: ").append(toIndentedString(rentabilidad)).append("\n");
    sb.append("    cantidadAcciones: ").append(toIndentedString(cantidadAcciones)).append("\n");
    sb.append("    valorAccion: ").append(toIndentedString(valorAccion)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
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

