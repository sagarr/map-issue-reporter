package com.rohankar.playground.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohankar.playground.bean.AnomalyReport;
import com.rohankar.playground.repository.MapAnomalyReportStore;

/**
 * @author Sagar Rohankar
 */
@Service
public class MapAnomalyReportService {

    @Autowired
    private MapAnomalyReportStore mapAnomalyReportStore;

    public Collection<AnomalyReport> getReports() {
        return mapAnomalyReportStore.retrieveReports();
    }

}
