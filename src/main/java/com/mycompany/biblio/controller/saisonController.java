package com.mycompany.biblio.controller;

import com.mycompany.biblio.business.SaisonEJB;
import com.mycompany.biblio.model.Saison;
import com.mycompany.biblio.model.Serie;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.ListDataModel;


@ManagedBean
@SessionScoped
public class saisonController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private SaisonEJB SaisonEJB ;

    private HtmlDataTable dataTable;

    private Saison saison = new Saison();
    private ListDataModel saisonList;

    private void updateSerieList() {
        saisonList = new ListDataModel(SaisonEJB.findAll());
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNew() {
        saison = new Saison();
        return "newSerie.xhtml";
    }

    public String doCreate() {
        SaisonEJB.create(saison);
        return "listSeries.xhtml";
    }

    public String doDelete() {
        List<Saison> saisons = (List<Saison>)saisonList.getWrappedData();
        SaisonEJB.delete(onlySelected(saisons));
        return "listSeries.xhtml";
    }

    private List<Saison> onlySelected(List<Saison> list) {
        for (Iterator<Saison> it = list.iterator(); it.hasNext(); ) {
            if (!(it.next().isSelected()))
                it.remove();
        }
        return list;
    }

    public String doEdit() {
        saison = (Saison)saisonList.getRowData();
        return "editSerie.xhtml";
    }

    public String doAddSaison() {
        saison = (Saison)saisonList.getRowData();
        return "newSaisonEpisode.xhtml";
    }

    public String doSave() {
        SaisonEJB.update(saison);
        return "listSeries.xhtml";
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Saison getSerie() {
        return saison;
    }

    public void setSerie(Serie serie) {
        this.saison = saison;
    }

    public ListDataModel getSerieList() {
        updateSerieList();
        return saisonList;
    }

    public void setSerieList(ListDataModel saisonList) {
        this.saisonList = saisonList;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }


}