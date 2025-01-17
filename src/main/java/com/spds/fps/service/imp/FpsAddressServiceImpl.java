package com.spds.fps.service.imp;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsAddress;
import com.spds.fps.repository.FpsAddressRepository;
import com.spds.fps.service.FpsAddressService;
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
public class FpsAddressServiceImpl implements FpsAddressService {

    @Autowired
    private FpsAddressRepository fpsAddressRepository;

    @Override
    public FpsAddress saveAndUpdateFpsAddress(FpsAddress fpsAddress) {
        return fpsAddressRepository.save(fpsAddress);
    }

    @Override
    public FpsAddress getFpsAddressById(Long id) {
        return fpsAddressRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Fps address not found..!!!" + id));
    }

    @Override
    public List<FpsAddress> getAllFpsAddress(Boolean isActive) {
        if (isActive == null || isActive == true) {
            return fpsAddressRepository.findAllByActiveTrueAndDeletedFalse();
        } else {
            return fpsAddressRepository.findAllByDeletedFalse();
        }
    }

    @Override
    public GenericResponse deleteFpsAddressById(Long id) {
        GenericResponse response = new GenericResponse();
        Optional<FpsAddress> fpsDocumentDetails = fpsAddressRepository.findByIdAndActiveTrueAndDeletedFalse(id);
        if (fpsDocumentDetails.isEmpty()) {
            log.error("Fps address not found..!!!{} ", id);
            response.setError(true);
            response.setErrorMsg("Fps address not found..!!! " + id);
            response.setData(fpsDocumentDetails);
            return response;
        }
        fpsDocumentDetails.get().setDeleted(true);
        fpsDocumentDetails.get().setActive(false);
        fpsAddressRepository.save(fpsDocumentDetails.get());
        log.info("FPS address delete successfully..!!!{} ", id);
        response.setError(false);
        response.setSuccessMsg("Delete successfully " + id);
        response.setData(fpsDocumentDetails);
        return response;
    }

    @Override
    public List<FpsAddress> getFpsAddressByFpsId(Long fpsId) {
        return fpsAddressRepository.findByFpsIdAndActiveTrueAndDeletedFalse(fpsId);
    }
}
