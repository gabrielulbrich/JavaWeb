/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package views;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import java.util.logging.Level;
import java.util.logging.Logger;

import models.FabricanteModel;
import models.VeiculoListaModel;

@ManagedBean
@ViewScoped
public class VeiculoListaView implements Serializable {
	     
 
	private int cod_veiculo;  
    private int cod_fabricante; // +getter +setter
	private int cod_modelo;
	private String fabricante;
	private String modelo;
	private String quantidade;
	private String cor;
	private String descricao;
	private String placa;
	
	public ArrayList veiculosListFromDB;
 
    
     
    @PostConstruct
    public void init() {
    	veiculosListFromDB = VeiculoListaModel.getStudentsListFromDB();
    }
    
    public ArrayList veiculosList() {
    	System.out.println("selecionou");
    	veiculosListFromDB = VeiculoListaModel.getStudentsListFromDB();
        return veiculosListFromDB;
    }
     
//    public String saveStudentDetails(StudentBean newStudentObj) {
//        return VeiculoListaModel.saveStudentDetailsInDB(newStudentObj);
//    }
//     
//    public String editStudentRecord(int studentId) {
//        return VeiculoListaModel.editStudentRecordInDB(studentId);
//    }
//     
//    public String updateStudentDetails(StudentBean updateStudentObj) {
//        return VeiculoListaModel.updateStudentDetailsInDB(updateStudentObj);
//    }
//     
    public void deletarVeiculo(int cod_veiculo) {
        VeiculoListaModel.deletarVeiculo(cod_veiculo);
    	FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Veiculo deletado com sucesso!");
		facesContext.addMessage(null, facesMessage);
    }
    
    public String editarVeiculo(int cod_veiculo) {
    	return VeiculoListaModel.editStudentRecordInDB(cod_veiculo);
    }
    
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
    
	public int getCod_fabricante() {
		return cod_fabricante;
	}

	public void setCod_fabricante(int cod_fabricante) {
		this.cod_fabricante = cod_fabricante;
	}
    
    public int getCod_veiculo() {
		return cod_veiculo;
	}

	public void setCod_veiculo(int cod_veiculo) {
		this.cod_veiculo = cod_veiculo;
	}

	public int getCod_modelo() {
		return cod_modelo;
	}

	public void setCod_modelo(int cod_modelo) {
		this.cod_modelo = cod_modelo;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
 

    
}