package edu.upm.midas.metamap.model;
import edu.upm.midas.metamap.model.receiver.ConfigReceiver;

import java.util.List;

/**
 * Created by gerardo on 14/07/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project metamap_rest
 * @className Response
 * @see
 */
public class Response {

    private String textId;
    private List<Concept> conceptList;
    private ConfigReceiver configReceiver;


    public String getTextId() {
        return textId;
    }

    public void setTextId(String textId) {
        this.textId = textId;
    }

    public List<Concept> getConceptList() {
        return conceptList;
    }

    public void setConceptList(List<Concept> conceptList) {
        this.conceptList = conceptList;
    }

    public ConfigReceiver getConfigReceiver() {
        return configReceiver;
    }

    public void setConfigReceiver(ConfigReceiver configReceiver) {
        this.configReceiver = configReceiver;
    }
}
