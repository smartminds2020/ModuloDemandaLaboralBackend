package edu.moduloalumno.entity;

import java.io.Serializable;

public class PerfilEgreso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int perfilegreso_id;
	
	private int estado_id;
	
	private int curriculo_id;
	
	private String perfilegreso_desc;
	
	private int perfilegreso_norden;

    public int getPerfilegreso_id() {
        return perfilegreso_id;
    }

    public void setPerfilegreso_id(int perfilegreso_id) {
        this.perfilegreso_id = perfilegreso_id;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public int getCurriculo_id() {
        return curriculo_id;
    }

    public void setCurriculo_id(int curriculo_id) {
        this.curriculo_id = curriculo_id;
    }

    public String getPerfilegreso_desc() {
        return perfilegreso_desc;
    }

    public void setPerfilegreso_desc(String perfilegreso_desc) {
        this.perfilegreso_desc = perfilegreso_desc;
    }

    public int getPerfilegreso_norden() {
        return perfilegreso_norden;
    }

    public void setPerfilegreso_norden(int perfilegreso_norden) {
        this.perfilegreso_norden = perfilegreso_norden;
    }

	
	
	
}
