package com.spds.fps.service;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsAddress;

import java.util.List;

public interface FpsAddressService {

    FpsAddress saveAndUpdateFpsAddress(FpsAddress fpsAddress);

    FpsAddress getFpsAddressById(Long id);

    List<FpsAddress> getAllFpsAddress();

    GenericResponse deleteFpsAddressById(Long id);

    List<FpsAddress> getFpsAddressByFpsId(Long fpsId);
}
