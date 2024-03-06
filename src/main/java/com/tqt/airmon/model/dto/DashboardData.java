package com.tqt.airmon.model.dto;

import lombok.Data;
import org.HdrHistogram.LinearIterator;

@Data
public class DashboardData {
    private int totalWallet;
    private int totalProject;
    private int totalProjectDoing;
    private int totalProjectNew;
    private int totalProjectExpired;
    private int totalProjectPending;
    private int totalProjectClose;
    private int totalProfile;
}
