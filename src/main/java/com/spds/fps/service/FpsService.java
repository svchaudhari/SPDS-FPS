package com.spds.fps.service;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.Fps;

import java.util.List;


/**
 * @author muhammad talib
 * This class was creaded on 08-Jan-2025.
 */

public interface FpsService {

    Fps saveAndUpdateFps(Fps fps);

    Fps getFpsById(Long id);

    List<Fps> getAllFps();

    GenericResponse deleteFpsById(Long id);
}
