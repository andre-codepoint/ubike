package com.alevel.java.ubike.cli;

import com.alevel.java.ubike.exception.UbikeReportException;
import com.alevel.java.ubike.report.ReportFactory;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class QuantityRidesForNicknameCLI implements InteractiveCLI {

    private final ReportFactory reportFactory;

    public QuantityRidesForNicknameCLI(ReportFactory reportFactory) {
        this.reportFactory = reportFactory;
    }

    @Override
    public void run() throws UbikeReportException {
        var scanner = new Scanner(System.in);

        System.out.println("Please, enter nickname of rider'");

        String string = scanner.nextLine();

        Integer result = reportFactory.quantityRides(string).load();

        System.out.printf("The quantity of riders with nickname %s is %d", string, result);
    }
}
