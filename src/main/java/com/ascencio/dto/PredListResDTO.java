package com.ascencio.dto;

import java.util.List;

public class PredListResDTO {

    private Object meta;
    private List<PrediccionDTO> objects;

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public List<PrediccionDTO> getObjects() {
        return objects;
    }

    public void setObjects(List<PrediccionDTO> objects) {
        this.objects = objects;
    }

}
