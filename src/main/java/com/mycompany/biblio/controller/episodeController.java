package com.mycompany.biblio.controller;

import com.mycompany.biblio.business.EpisodeEJB;
import com.mycompany.biblio.model.Episode;
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
public class episodeController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private EpisodeEJB EpisodeEJB ;

    private HtmlDataTable dataTable;

    private Episode episode = new Episode();
    private ListDataModel episodeList;

    private void updateEpisodeList() {
        episodeList = new ListDataModel(EpisodeEJB.findAll());
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNew() {
        episode = new Episode();
        return "newSerie.xhtml";
    }

    public String doCreate() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
        Long id = Long.parseLong(myRequest.getParameter("saison_id"));

        EpisodeEJB.create(episode,id);
        return "newSaison.xhtml";
    }

    public String doEdit() {
        episode = (Episode)episodeList.getRowData();
        return "editEpisode.xhtml";
    }

    public String doAddEpisode() {
        episode = (Episode)episodeList.getRowData();
        return "newEpisodeEpisode.xhtml";
    }

    public String doSave() {
        EpisodeEJB.update(episode);
        return "listSeries.xhtml";
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public ListDataModel getEpisodeList() {
        updateEpisodeList();
        return episodeList;
    }

    public void setEpisodeList(ListDataModel episodeList) {
        this.episodeList = episodeList;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }


}