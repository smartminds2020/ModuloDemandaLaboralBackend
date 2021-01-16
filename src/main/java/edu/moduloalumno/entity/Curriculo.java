
package edu.moduloalumno.entity;

import java.io.Serializable;

/**
 *
 * @author pc
 * curriculo_id, id_programa, estado_id, curriculo_desc, curriculo_ultimo, tcurriculo_id
 */
public class Curriculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer curriculo_id;
        private Integer id_programa;
        private Integer estado_id;
        private String curriculo_desc;
        private String curriculo_ultimo;
        private Integer tcurriculo_id;

    public Integer getCurriculo_id() {
        return curriculo_id;
    }

    public void setCurriculo_id(Integer curriculo_id) {
        this.curriculo_id = curriculo_id;
    }

    public Integer getId_programa() {
        return id_programa;
    }

    public void setId_programa(Integer id_programa) {
        this.id_programa = id_programa;
    }

    public Integer getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(Integer estado_id) {
        this.estado_id = estado_id;
    }

    public String getCurriculo_desc() {
        return curriculo_desc;
    }

    public void setCurriculo_desc(String curriculo_desc) {
        this.curriculo_desc = curriculo_desc;
    }

    public String getCurriculo_ultimo() {
        return curriculo_ultimo;
    }

    public void setCurriculo_ultimo(String curriculo_ultimo) {
        this.curriculo_ultimo = curriculo_ultimo;
    }

    public Integer getTcurriculo_id() {
        return tcurriculo_id;
    }

    public void setTcurriculo_id(Integer tcurriculo_id) {
        this.tcurriculo_id = tcurriculo_id;
    }       	

}

