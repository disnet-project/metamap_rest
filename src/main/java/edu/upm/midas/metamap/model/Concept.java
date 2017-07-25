package edu.upm.midas.metamap.model;

import java.util.List;
import java.util.Objects;

/**
 * Created by gerardo on 18/05/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project ExtractionInformationDiseasesWikipedia
 * @className Concept
 * @see
 */
public class Concept {

    private String cui;/*Código cui*/
    private String name;
    private List<String> semanticType;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public List<String> getSemanticType() {
        return semanticType;
    }

    public void setSemanticType(List<String> semanticType) {
        this.semanticType = semanticType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Concept)) return false;
        Concept concept = (Concept) o;
        return Objects.equals(getCui(), concept.getCui());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCui());
    }

}
