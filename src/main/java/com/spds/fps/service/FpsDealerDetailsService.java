package com.spds.fps.service;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsDealerDetails;

import java.util.List;

public interface FpsDealerDetailsService {


    FpsDealerDetails saveAndUpdateFpsDealerDetails(FpsDealerDetails fpsDealerDetails);

    FpsDealerDetails getFpsDealerDetailsById(Long id);

    List<FpsDealerDetails> getAllFpsDealerDetails();

    GenericResponse deleteFpsDealerDetailsById(Long id);

    FpsDealerDetails getFpsDealerDetailsByFpsId(Long fpsId);
}
