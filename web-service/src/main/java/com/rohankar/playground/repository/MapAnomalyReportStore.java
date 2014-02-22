package com.rohankar.playground.repository;

import java.util.Collection;

import com.rohankar.playground.bean.AnomalyReport;

/**
 * @author Sagar Rohankar
 */
public interface MapAnomalyReportStore {

    Collection<AnomalyReport> retrieveReports();

}
