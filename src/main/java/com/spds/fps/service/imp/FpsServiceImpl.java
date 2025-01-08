package com.spds.fps.service.imp;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.Fps;
import com.spds.fps.repository.FpsRepository;
import com.spds.fps.service.FpsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/***
 *
 * @author muhammad talib This class was creaded on 08-Jan-2025.
 */
@Slf4j
@Service
public class FpsServiceImpl implements FpsService {

    @Autowired
    private FpsRepository fpsRepository;

    @Override
    public Fps saveAndUpdateFps(Fps fps) {
        return fpsRepository.save(fps);
    }

    @Override
    public Fps getFpsById(Long id) {
        return fpsRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Fps is not found" + id));
    }

    @Override
    public List<Fps> getAllFps() {
        return fpsRepository.findAll();
    }

    @Override
    public GenericResponse deleteFpsById(Long id) {
        GenericResponse response = new GenericResponse();
        Optional<Fps> fpsDetails = fpsRepository.findByIdAndActiveTrueAndDeletedFalse(id);

        if (fpsDetails.isEmpty()) {
            log.error("Fps details not found..!!!{} ", id);
            response.setError(true);
            response.setErrorMsg("Fps details not found..!!! {id} " + id);
            response.setData(fpsDetails);
            return response;
        }
        fpsDetails.get().setDeleted(true);
        fpsDetails.get().setActive(false);
        Fps fpdData = fpsRepository.save(fpsDetails.get());
        log.info("FPS details Delete successfully..!!!{}", id);
        response.setError(false);
        response.setSuccessMsg("Delete successfully..!!! {id} " + id);
        response.setData(fpdData);
        return response;
    }
}
