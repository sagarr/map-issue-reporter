package com.rohankar.playground.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rohankar.playground.bean.Coordinates;
import com.rohankar.playground.bean.Report;

/**
 * @author Sagar Rohankar
 */
@Repository
public class InMemoryMapAnomalyReportStore implements MapAnomalyReportStore {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Report> retrieveReports() {
        return jdbcTemplate.query("SELECT * FROM reports", new RowMapper<Report>() {

            @Override
            public Report mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                final int id = rs.getInt(1);
                final String anomalyType = rs.getString(2);
                final double lon = rs.getDouble(3);
                final double lat = rs.getDouble(4);
                final Report report = new Report();
                report.setId(id);
                report.setAnomalyType(anomalyType);
                final Coordinates coordinates = new Coordinates(lon, lat);
                report.setCoordinates(coordinates);
                return report;
            }

        });

        // final Report report = new Report();
        // report.setId("12345");
        // report.setAnomalyType("Dead End");
        // report.setCoordinates(new Coordinates(1.2323, 51.23221));
        // return Collections.singletonList(report);
    }
}
