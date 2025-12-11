package oop.CorpiCelesti;

import java.io.Serializable;

public enum Tipo implements Serializable {
    SUPERGIGANTEROSSA, GIGANTEROSSA, GIGANTEBLUE, NANAGIALLA, NANAROSSA, NANABIANCA, NANABRUNA, STELLADINEUTRONI, PULSAR;

    @Override
    public String toString(){
        return switch(this) {
            case SUPERGIGANTEROSSA -> "SUPERGIGANTEROSSA";
            case GIGANTEROSSA -> "GIGANTEROSSA";
            case GIGANTEBLUE -> "GIGANTEBLUE";
            case NANAGIALLA -> "NANAGIALLA";
            case NANAROSSA -> "NANAROSSA";
            case NANABIANCA -> "NANABIANCA";
            case NANABRUNA -> "NANABRUNA";
            case STELLADINEUTRONI -> "STELLADINEUTRONI";
            case PULSAR -> "PULSAR";
        };
    }
}
