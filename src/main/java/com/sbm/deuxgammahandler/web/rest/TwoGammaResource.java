package com.sbm.deuxgammahandler.web.rest;

import com.sbm.deuxgammahandler.domain.TwoGammaResponse;
import com.sbm.deuxgammahandler.service.EnvParamTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class TwoGammaResource {

    private final EnvParamTableService envParamTableService;

    public TwoGammaResource(EnvParamTableService envParamTableService) {
        this.envParamTableService = envParamTableService;
    }

    @GetMapping("/envparam")
    public TwoGammaResponse getTwoGammaResponse() {
        return envParamTableService.getResponse();
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateEntity(@RequestParam String validUntil) {
        int rowsUpdated = envParamTableService.updateValidUntil(validUntil);

        if (rowsUpdated > 0) {
            return ResponseEntity.ok("validUntil updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("validUntil not found or no changes made");
        }
    }
}
