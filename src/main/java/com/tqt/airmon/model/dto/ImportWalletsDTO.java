package com.tqt.airmon.model.dto;

import com.tqt.airmon.model.Address;
import lombok.Data;

import java.util.List;

@Data
public class ImportWalletsDTO {
    private Long idProfile;
    private List<Address> listWallet;

}
