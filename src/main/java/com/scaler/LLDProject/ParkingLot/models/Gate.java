package com.scaler.LLDProject.ParkingLot.models;

public class Gate {
    private Long number;
    private Operator operator;
    private GateType gateType;
    private GateStatus status;

    public Gate(Long number, GateType gateType, GateStatus status) {
        this.number = number;
//        this.operator = operator;
        this.gateType = gateType;
        this.status = status;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }
}
