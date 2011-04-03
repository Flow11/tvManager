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
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;


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

    private int currentSaisonId;

    private void updateSaisonList() {
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
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
        Long id = Long.parseLong(myRequest.getParameter("serie_id"));

        SaisonEJB.create(saison,id);
        return "listSeries.faces";
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
        return "editSaison.xhtml";
    }

    public String doAddSaison() {
        saison = (Saison)saisonList.getRowData();
        return "newEpisode.xhtml";
    }

    public String doSave() {
        SaisonEJB.update(saison);
        return "listSeries.xhtml";
    }

    public String doAddEpisode() {
        return "newEpisode";
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    public ListDataModel getSaisonList() {
        updateSaisonList();
        return saisonList;
    }

    public void setSaisonList(ListDataModel saisonList) {
        this.saisonList = saisonList;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    /**
     * @return the currentSaisonId
     */
    public int getCurrentSaisonId() {
        return currentSaisonId;
    }

    /**
     * @param currentSaisonId the currentSaisonId to set
     */
    public void setCurrentSaisonId(int currentSaisonId) {
        this.currentSaisonId = currentSaisonId;
    }


}