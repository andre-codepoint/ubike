package com.alevel.java.ubike.report;

import com.alevel.java.ubike.exception.UbikeReportException;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.function.Supplier;

public class QuantityRides implements Report<Integer> {

    private final String nickname;

    private final Supplier<Connection> connectionSupplier;


    public QuantityRides(Supplier<Connection> connectionProvider, String nickname) {
        this.nickname = nickname;
        this.connectionSupplier = connectionProvider;
    }

    @Override
    public Integer load() throws UbikeReportException {


        String sql = """
                select count(riders) as result
                from rides, riders where riders= ? 
                """;

        try (PreparedStatement query = connectionSupplier.get().prepareStatement(sql)) {
            query.setString(1, nickname);

            ResultSet resultSet = query.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                throw new UbikeReportException("No result found");
            }
        } catch (SQLException e) {
            throw new UbikeReportException(e);
        }
    }
}
