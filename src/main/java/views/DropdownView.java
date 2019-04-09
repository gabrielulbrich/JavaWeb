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

@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {
	
	private String result;
	//private static final Logger logger = Logger.getLogger(DropdownView.class);

    FabricanteModel fab = new FabricanteModel();
    
    List<FabricanteModel> fabricanteLista = fab.getList();   
    List<FabricanteModel> fabricanteModelo;  
    private String selectedFabricante; // +getter +setter
	private String selectedModelo;
	private List<SelectItem> availableItems;
	private List<SelectItem> availableModelos;
    
    @PostConstruct
    public void init() {
    	
    	availableItems = new ArrayList<SelectItem>();
    	for(FabricanteModel fabricante: fabricanteLista){
    		availableItems.add(new SelectItem(fabricante.getCod_fabricante(), fabricante.getFabricante()));
    	}
 	    
    }
    
    public void onChange(AjaxBehaviorEvent event) {    	

    	int fabricanteId = Integer.parseInt(selectedFabricante);
    	fab.setFabricanteId(fabricanteId);
    	fabricanteModelo = fab.getModelos();
    	availableModelos = new ArrayList<SelectItem>();
    	for(FabricanteModel modelo: fabricanteModelo){
    		availableModelos.add(new SelectItem(modelo.getCod_modelo(), modelo.getModelo()));
    	}

    }
    


	public List<SelectItem> getAvailableItems() {
		return availableItems;
	}
	
    public String getSelectedFabricante() {
		return selectedFabricante;
	}

	public void setSelectedFabricante(String selectedFabricante) {
		this.selectedFabricante = selectedFabricante;
	}

	public String getSelectedModelo() {
		return selectedModelo;
	}

	public void setSelectedModelo(String selectedModelo) {
		this.selectedModelo = selectedModelo;
	}

	public List<SelectItem> getAvailableModelos() {
		return availableModelos;
	}
}