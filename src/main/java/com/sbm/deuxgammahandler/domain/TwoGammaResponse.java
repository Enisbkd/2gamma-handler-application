package com.sbm.deuxgammahandler.domain;

public class TwoGammaResponse {

    private String validUntil;
    private Integer spe_txeuropt;

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public Integer getSpe_txeuropt() {
        return spe_txeuropt;
    }

    public void setSpe_txeuropt(Integer spe_txeuropt) {
        this.spe_txeuropt = spe_txeuropt;
    }

    public TwoGammaResponse(Integer spe_txeuropt, String validUntil) {
        this.spe_txeuropt = spe_txeuropt;
        this.validUntil = validUntil;
    }

    @Override
    public String toString() {
        return "TwoGammaResponse{" + "validUntil='" + validUntil + '\'' + ", spe_txeuropt='" + spe_txeuropt + '\'' + '}';
    }
}
