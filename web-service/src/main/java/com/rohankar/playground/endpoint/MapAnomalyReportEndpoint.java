package com.rohankar.playground.endpoint;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohankar.playground.bean.AnomalyReport;
import com.rohankar.playground.service.MapAnomalyReportService;

/**
 * @author Sagar Rohankar
 */
@Controller
@RequestMapping("/reports")
public class MapAnomalyReportEndpoint {

    @Autowired
    private MapAnomalyReportService reportService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Collection<AnomalyReport> getReports() {
        return reportService.getReports();
    }

}
