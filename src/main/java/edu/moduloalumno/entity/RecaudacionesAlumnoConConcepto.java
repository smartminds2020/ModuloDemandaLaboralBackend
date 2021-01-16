package edu.moduloalumno.entity;

import java.util.Date;

public class RecaudacionesAlumnoConConcepto {
	
	private Integer idRec;
	
	private Integer idAlum;
	
	private String apeNom;
	
	private Integer ciclo;
	
	private String concepto;
	
	private Integer idconcepto;
    
	private String numero;
    
	private String dni;

	private String nombre;
    
    private String moneda;
    
    private String moneda2;
    
    private double importe;
    
    private float importe_tc;
    
    private Date fecha;
    
    private String anio_ingreso;
    
    private Integer idPrograma;
    
    private String nomPrograma;
    
    private String sigla_programa;
    
    private String codAlumno;
    
    private String estado;
    
    private String descripcion_ubi;
    
    private String descripcion_tipo;
    
    private String estado_civil;
	
	private boolean validado;
	
	private String repitencia;
	
	private String id_tip_grado;
	
	
	
    
    public String getId_tip_grado() {
		return id_tip_grado;
	}

	public void setId_tip_grado(String id_tip_grado) {
		this.id_tip_grado = id_tip_grado;
	}

	public String getRepitencia() {
		return repitencia;
	}

	public void setRepitencia(String repitencia) {
		this.repitencia = repitencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	private String observacion;
    

	public Integer getIdRec() {
		return idRec;
	}

	public void setIdRec(Integer idRec) {
		this.idRec = idRec;
	}

	public Integer getCiclo() {
		return ciclo;
	}

	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	public Integer getIdAlum() {
		return idAlum;
	}

	public void setIdAlum(Integer idAlum) {
		this.idAlum = idAlum;
	}

	public String getApeNom() {
		return apeNom;
	}

	public void setApeNom(String apeNom) {
		this.apeNom = apeNom;
	}
	
	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	
	public String getMoneda2() {
		return moneda2;
	}

	public void setMoneda2(String moneda2) {
		this.moneda2 = moneda2;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Integer idPrograma) {
		this.idPrograma = idPrograma;
	}
	
	public String getNomPrograma() {
		return nomPrograma;
	}

	public void setNomPrograma(String nomPrograma) {
		this.nomPrograma = nomPrograma;
	}
	
	public String getSigla_programa() {
		return sigla_programa;
	}

	public void setSigla_programa(String sigla_programa) {
		this.sigla_programa = sigla_programa;
	}

	public String getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public Integer getIdconcepto() {
		return idconcepto;
	}

	public void setIdconcepto(Integer idconcepto) {
		this.idconcepto = idconcepto;
	}

	public String getDescripcion_ubi() {
		return descripcion_ubi;
	}

	public void setDescripcion_ubi(String descripcion_ubi) {
		this.descripcion_ubi = descripcion_ubi;
	}

	public String getDescripcion_tipo() {
		return descripcion_tipo;
	}

	public void setDescripcion_tipo(String descripcion_tipo) {
		this.descripcion_tipo = descripcion_tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRec == null) ? 0 : idRec.hashCode());
		return result;
	}

	public String getAnio_ingreso() {
		return anio_ingreso;
	}

	public void setAnio_ingreso(String anio_ingreso) {
		this.anio_ingreso = anio_ingreso;
	}

	public float getImporte_tc() {
		return importe_tc;
	}

	public void setImporte_tc(float importe_tc) {
		this.importe_tc = importe_tc;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecaudacionesAlumnoConConcepto other = (RecaudacionesAlumnoConConcepto) obj;
		if (idRec == null) {
			if (other.idRec != null)
				return false;
		} else if (!idRec.equals(other.idRec))
			return false;
		return true;
	}
	
	public boolean getValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	
	
	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	@Override
	public String toString() {
		return "RecaudacionesAlumnoConConcepto [idRec=" + idRec + ", idAlum=" + idAlum + ", apeNom=" + apeNom
				+ ", ciclo=" + ciclo + ", concepto=" + concepto + ", idconcepto=" + idconcepto + ", numero=" + numero
				+ ", dni=" + dni + ", nombre=" + nombre + ", moneda=" + moneda + ", moneda2=" + moneda2 + ", importe="
				+ importe + ", importe_tc=" + importe_tc + ", fecha=" + fecha + ", anio_ingreso=" + anio_ingreso
				+ ", idPrograma=" + idPrograma + ", nomPrograma=" + nomPrograma + ", sigla_programa=" + sigla_programa
				+ ", codAlumno=" + codAlumno + ", estado=" + estado + ", descripcion_ubi=" + descripcion_ubi
				+ ", descripcion_tipo=" + descripcion_tipo + ", estado_civil=" + estado_civil + ", validado=" + validado
				+ ", repitencia=" + repitencia + ", id_tip_grado=" + id_tip_grado + ", observacion=" + observacion
				+ "]";
	}

	
	
	
}
