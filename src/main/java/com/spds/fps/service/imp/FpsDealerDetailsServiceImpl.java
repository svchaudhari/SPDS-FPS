package com.spds.fps.service.imp;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsDealerDetails;
import com.spds.fps.repository.FpsDealerDetailsRepository;
import com.spds.fps.service.FpsDealerDetailsService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
public class FpsDealerDetailsServiceImpl implements FpsDealerDetailsService {

    @Autowired
    private FpsDealerDetailsRepository fpsDealerDetailsRepository;

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public FpsDealerDetails saveAndUpdateFpsDealerDetails(FpsDealerDetails fpsDealerDetails) {
        Query query = entityManager.createNativeQuery("SELECT nextval('fps.fps_dealer_details_shop_no_seq')");
        Long shopNo = ((Number) query.getSingleResult()).longValue();
        fpsDealerDetails.setShopNo(shopNo);
        return fpsDealerDetailsRepository.save(fpsDealerDetails);
    }

    @Override
    public FpsDealerDetails getFpsDealerDetailsById(Long id) {
        return fpsDealerDetailsRepository.findById(id).orElseThrow(() -> new NoSuchElementException("FPS dealer details not found..!!!" + id));
    }

    @Override
    public List<FpsDealerDetails> getAllFpsDealerDetails(Boolean isActive) {
        if (isActive == null || isActive == true) {
            return fpsDealerDetailsRepository.findAllByActiveTrueAndDeletedFalse();
        } else {
            return fpsDealerDetailsRepository.findAllByDeletedFalse();
        }
    }

    @Override
    public GenericResponse deleteFpsDealerDetailsById(Long id) {
        GenericResponse response = new GenericResponse();
        Optional<FpsDealerDetails> fpsDealerDetails = fpsDealerDetailsRepository.findByIdAndActiveTrueAndDeletedFalse(id);
        if (fpsDealerDetails.isEmpty()) {
            log.error("Fps dealer details not found..!!!{} ", id);
            response.setError(true);
            response.setErrorMsg("Fps dealer details not found..!!! " + id);
            response.setData(fpsDealerDetails);
            return response;
        }
        fpsDealerDetails.get().setDeleted(true);
        fpsDealerDetails.get().setActive(false);
        fpsDealerDetailsRepository.save(fpsDealerDetails.get());
        log.info("FPS dealer details delete successfully..!!!{} ", id);
        response.setError(false);
        response.setSuccessMsg("Delete successfully..!!! " + id);
        response.setData(fpsDealerDetails);
        return response;
    }

    @Override
    public FpsDealerDetails getFpsDealerDetailsByFpsId(Long fpsId) {
        return fpsDealerDetailsRepository.findByFpsIdAndActiveTrueAndDeletedFalse(fpsId).orElseThrow(() -> new NoSuchElementException("FPS dealer details not found..!!!" + fpsId));
    }
}
