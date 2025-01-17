package com.spds.fps.service;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsMaster;

import java.util.List;


/**
 * @author muhammad talib
 * This class was creaded on 08-Jan-2025.
 */

public interface FpsService {

    FpsMaster saveAndUpdateFps(FpsMaster fps);

    FpsMaster getFpsById(Long id);

    List<FpsMaster> getAllFps(Boolean isActive);

    GenericResponse deleteFpsById(Long id);
}
