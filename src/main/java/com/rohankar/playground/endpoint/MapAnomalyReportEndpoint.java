package com.rohankar.playground.endpoint;

import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rohankar.playground.bean.Coordinates;
import com.rohankar.playground.bean.Report;

/**
 * @author Sagar Rohankar
 */
@Controller
@RequestMapping("/reports")
public class MapAnomalyReportEndpoint {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Report> getReports() {
        final Report report = new Report();
        report.setId("12345");
        report.setAnomalyType("Dead End");
        report.setCoordinates(new Coordinates(1.2323, 51.23221));
        return Collections.singletonList(report);
    }

}
