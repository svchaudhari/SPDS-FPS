package com.spds.fps.service;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsDealerDetails;

import java.util.List;


/**
 * @author muhammad talib
 * This class was creaded on 08-Jan-2025.
 */

public interface FpsDealerDetailsService {


    FpsDealerDetails saveAndUpdateFpsDealerDetails(FpsDealerDetails fpsDealerDetails);

    FpsDealerDetails getFpsDealerDetailsById(Long id);

    List<FpsDealerDetails> getAllFpsDealerDetails(Boolean isActive);

    GenericResponse deleteFpsDealerDetailsById(Long id);

    FpsDealerDetails getFpsDealerDetailsByFpsId(Long fpsId);
}
