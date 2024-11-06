package com.sbm.deuxgammahandler.service;

import com.sbm.deuxgammahandler.domain.TwoGammaResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnvParamTableService {

    private static final Logger log = LoggerFactory.getLogger(EnvParamTableService.class);

    private final EntityManager entityManager;

    public EnvParamTableService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public int updateValidUntil(String validUntil) {
        Query query = entityManager.createNativeQuery(
            "UPDATE DGDINFRA.ENVPARAM x " + " SET x.LIPARAM= :VALIDUNTIL" + " WHERE x.COTYPARAM='FIDEXP' " + " AND x.COPARAM='FID'"
        );
        query.setParameter("VALIDUNTIL", validUntil);
        log.debug("Updating validUntil with value : " + validUntil);

        return query.executeUpdate();
    }

    public TwoGammaResponse getResponse() {
        return new TwoGammaResponse(calculate_spe_txeuropt(), getValidUntil());
    }

    public Integer calculate_spe_txeuropt() {
        Query query = entityManager.createNativeQuery(
            "SELECT LIPARAM as SPE_LIPARAM from DGDINFRA.ENVPARAM WHERE COTYPARAM = 'TRANSFEP'  AND COPARAM = 'SLDRET'"
        );
        Integer result = resultChecker(query.getSingleResult());
        log.debug("Result of spe_txeuropt : " + result);
        return result;
    }

    public String getValidUntil() {
        Query query = entityManager.createNativeQuery(
            "SELECT LIPARAM as SPE_LIPARAM from DGDINFRA.ENVPARAM WHERE COTYPARAM = 'FIDEXP'  AND COPARAM = 'FID'"
        );
        String result = query.getSingleResult().toString();
        log.debug("validUntil : " + result);
        return result;
    }

    public Integer resultChecker(Object result) {
        return Optional.ofNullable(result)
            .map(Object::toString)
            .map(str -> {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException e) {
                    return 0;
                }
            })
            .orElse(0);
    }
}
