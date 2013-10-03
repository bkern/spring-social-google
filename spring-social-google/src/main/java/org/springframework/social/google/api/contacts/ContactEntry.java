package org.springframework.social.google.api.contacts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ContactEntry implements Serializable {


    private String gd$etag;

    @JsonProperty("gd$email")
    @JsonDeserialize(as=ArrayList.class, contentAs=EmailContact.class)
    private List<EmailContact> gd$email;


    public String getGd$etag() {
        return gd$etag;
    }

    public void setGd$etag(String gd$etag) {
        this.gd$etag = gd$etag;
    }

    public List<EmailContact> getGd$email() {
        return gd$email;
    }

    public void setGd$email(List<EmailContact> gd$email) {
        this.gd$email = gd$email;
    }
}
