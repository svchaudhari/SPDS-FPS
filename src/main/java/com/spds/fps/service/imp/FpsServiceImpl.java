package com.spds.fps.service.imp;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsMaster;
import com.spds.fps.repository.FpsMasterRepository;
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
    private FpsMasterRepository fpsRepository;

    @Override
    public FpsMaster saveAndUpdateFps(FpsMaster fps) {
        return fpsRepository.save(fps);
    }

    @Override
    public FpsMaster getFpsById(Long id) {
        return fpsRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Fps is not found" + id));
    }

    @Override
    public List<FpsMaster> getAllFps(Boolean isActive) {

        if (isActive == null || isActive == true) {
            return fpsRepository.findAllByActiveTrueAndDeletedFalse();
        } else {
            return fpsRepository.findAllByDeletedFalse();
        }
    }


    @Override
    public GenericResponse deleteFpsById(Long id) {
        GenericResponse response = new GenericResponse();
        Optional<FpsMaster> fpsDetails = fpsRepository.findByIdAndActiveTrueAndDeletedFalse(id);

        if (fpsDetails.isEmpty()) {
            log.error("Fps details not found..!!!{} ", id);
            response.setError(true);
            response.setErrorMsg("Fps details not found..!!! {id} " + id);
            response.setData(fpsDetails);
            return response;
        }
        fpsDetails.get().setDeleted(true);
        fpsDetails.get().setActive(false);
        FpsMaster fpdData = fpsRepository.save(fpsDetails.get());
        log.info("FPS details Delete successfully..!!!{}", id);
        response.setError(false);
        response.setSuccessMsg("Delete successfully..!!! {id} " + id);
        response.setData(fpdData);
        return response;
    }
}
