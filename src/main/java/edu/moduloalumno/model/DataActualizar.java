package edu.moduloalumno.model;

public class DataActualizar {

	private String idRec;
	private String fecha;
	private String id_concepto;
	private String id_moneda;
	private String recibo;
	private String ciclo;
	private String importe;
	private String ubicacion;
	private String ctabanco;
	private String validado;
	private String repitencia;

	private Integer id_tipo_recaudacion;

	public Integer getId_tipo_recaudacion() {
		return id_tipo_recaudacion;
	}

	public void setId_tipo_recaudacion(Integer id_tipo_recaudacion) {
		this.id_tipo_recaudacion = id_tipo_recaudacion;
	}

	public String getRepitencia() {
		return repitencia;
	}

	public void setRepitencia(String repitencia) {
		this.repitencia = repitencia;
	}

	public String getId_concepto() {
		return id_concepto;
	}

	public void setId_concepto(String id_concepto) {
		this.id_concepto = id_concepto;
	}

	public String getIdRec() {
		return idRec;
	}

	public void setIdRec(String idRec) {
		this.idRec = idRec;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(String id_moneda) {
		this.id_moneda = id_moneda;
	}

	public String getRecibo() {
		return recibo;
	}

	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getCtabanco() {
		return ctabanco;
	}

	public void setCtabanco(String ctabanco) {
		this.ctabanco = ctabanco;
	}

	public String getValidado() {
		return validado;
	}

	public void setValidado(String validado) {
		this.validado = validado;
	}

	@Override
	public String toString() {
		return "DataActualizar [idRec=" + idRec + ", fecha=" + fecha + ", id_concepto=" + id_concepto + ", id_moneda="
				+ id_moneda + ", recibo=" + recibo + ", ciclo=" + ciclo + ", importe=" + importe + ", ubicacion="
				+ ubicacion + ", ctabanco=" + ctabanco + ", validado=" + validado + ", repitencia=" + repitencia
				+ ", id_tipo_recaudacion=" + id_tipo_recaudacion + "]";
	}

	

}
