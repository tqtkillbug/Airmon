package com.tqt.airmon.service;

import com.tqt.airmon.model.Address;
import com.tqt.airmon.model.Profile;
import com.tqt.airmon.model.dto.ImportWalletsDTO;
import com.tqt.airmon.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private ProfileService profileService;

    public Address insert(Address address){
        Address existingWallet = repository.findByPublicKey(address.getPublicKey());
        if (existingWallet == null){
            return repository.save(address);
        } else{
            return null;
        }
    }

    public List<Address> getAll(){
        List<Address> listWallet = repository.findAll();
        listWallet.forEach(w -> {
            if (w.getPrivateKey() == null) {
                w.setPrivateKey("****NONSET****");
            } else{
                w.setPrivateKey("*******************");
            }
        } );
        return repository.findAll();
    }

    public List<Address> getListAddressByProfileId(Long id){
        return repository.findAllByProfileId(id);
    }

    public Address getById(Long id) {
        return repository.findById(id).get();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Address updateWallet(Long id, Address profileUpdate) {
        Address existingWallet = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Source not found"));
        existingWallet.setAccountName(profileUpdate.getAccountName());
        existingWallet.setProfile(profileUpdate.getProfile());
        existingWallet.setPublicKey(profileUpdate.getPublicKey());
        if (!profileUpdate.getPrivateKey().contains("*")){
             existingWallet.setPrivateKey(profileUpdate.getPrivateKey());
        }
        existingWallet.setType(profileUpdate.getType());
        existingWallet.setChain(profileUpdate.getChain());
        existingWallet.setNote(profileUpdate.getNote());
        return repository.save(existingWallet);
    }

    public List<String> exportListPublickey(Long profileId, String type){
      List<Address> list;
      if (profileId != 0 && !type.isEmpty()){
          list = repository.findAllByProfileIdAndType(profileId,type);
      } else if (profileId != 0){
          list = repository.findAllByProfileId(profileId);
      } else if (!type.isEmpty()){
          list = repository.findAllByType(type);
      } else {
          list = repository.findAll();
      }
      return list.stream().map(Address::getPublicKey).collect(Collectors.toList());
    }

    public void importListWallet(ImportWalletsDTO importWalletsDTO) {
        Profile profile = profileService.getById(importWalletsDTO.getIdProfile());
        List<Address> addressList = importWalletsDTO.getListWallet();
        for (Address address : addressList) {
            address.setProfile(profile);
            address.setChain("METAMASK");
            address.setType("N/A");
        }
        repository.saveAll(addressList);
    }
}
