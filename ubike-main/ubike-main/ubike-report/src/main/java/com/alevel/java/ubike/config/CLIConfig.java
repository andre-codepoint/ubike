package com.alevel.java.ubike.config;

import com.alevel.java.ubike.cli.AverageRideDurationForDateCLI;
import com.alevel.java.ubike.cli.InteractiveCLI;
import com.alevel.java.ubike.cli.QuantityRidesForNicknameCLI;
import com.alevel.java.ubike.cli.ReportSelectionCLI;
import com.alevel.java.ubike.report.ReportFactory;

import java.util.Map;

public class CLIConfig {

    private Map<String, InteractiveCLI> reports(ReportFactory reportFactory) {

        Map<String, InteractiveCLI> map = Map.of(
                "avg per day", new AverageRideDurationForDateCLI(reportFactory),
                "riders quantity", new QuantityRidesForNicknameCLI(reportFactory)
                );
        return map;
    }

    public InteractiveCLI cli(ReportFactory reportFactory) {
        return new ReportSelectionCLI(reports(reportFactory));
    }



}
