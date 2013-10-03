package org.springframework.social.google.api.contacts;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Feed implements Serializable {
    @JsonProperty
    private GenericContactField title;
    @JsonProperty
    private GenericContactField id;


    @JsonProperty("entry")
    @JsonDeserialize(as = ArrayList.class, contentAs = ContactEntry.class)
    private List<ContactEntry> entry;

    public GenericContactField getTitle() {
        return title;
    }

    public void setTitle(GenericContactField title) {
        this.title = title;
    }

    public GenericContactField getId() {
        return id;
    }

    public void setId(GenericContactField id) {
        this.id = id;
    }

    public List<ContactEntry> getEntry() {
        return entry;
    }

    public void setEntry(List<ContactEntry> entry) {
        this.entry = entry;
    }
}
