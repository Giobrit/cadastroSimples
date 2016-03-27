package br.com.cadastro.basico.utils;

import java.util.List;

public class ResponseDTO {
    private Object data;
    private List<ErrorDTO> errors;

    public ResponseDTO() {
    }

    public ResponseDTO(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<ErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDTO> errors) {
        this.errors = errors;
    }
}
