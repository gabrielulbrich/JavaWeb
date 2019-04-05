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
import javax.faces.model.SelectItem;

import models.FabricanteModel;

@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {

    FabricanteModel fab = new FabricanteModel();
    
    List<FabricanteModel> fabricanteLista = fab.getList();    
    private String selectedItem; // +getter +setter
    private List<SelectItem> availableItems;
    
    @PostConstruct
    public void init() {
    	
    	availableItems = new ArrayList<SelectItem>();
    	for(FabricanteModel fabricante: fabricanteLista){
    		availableItems.add(new SelectItem(fabricante.getCod_fabricante(), fabricante.getFabricante()));
    	}
 	    
    }

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}

	public List<SelectItem> getAvailableItems() {
		return availableItems;
	}
}