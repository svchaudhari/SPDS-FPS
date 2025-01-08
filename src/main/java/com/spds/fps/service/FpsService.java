package com.spds.fps.service;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.Fps;

import java.util.List;

public interface FpsService {

    Fps saveAndUpdateFps(Fps fps);

    Fps getFpsById(Long id);

    List<Fps> getAllFps();

    GenericResponse deleteFpsById(Long id);
}
