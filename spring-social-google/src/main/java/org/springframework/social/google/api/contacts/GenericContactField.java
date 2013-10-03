package org.springframework.social.google.api.contacts;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GenericContactField implements Serializable {

    @JsonProperty
    private String $t;

    public String get$t() {
        return $t;
    }

    public void set$t(String $t) {
        this.$t = $t;
    }
}
