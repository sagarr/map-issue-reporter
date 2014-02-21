package com.rohankar.playground.repository;

import java.util.Collection;

import com.rohankar.playground.bean.Report;

/**
 * @author Sagar Rohankar
 */
public interface MapAnomalyReportStore {

    Collection<Report> retrieveReports();

}
