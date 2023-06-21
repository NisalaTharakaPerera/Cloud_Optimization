package org.acme.cloudoptimization.common.swingui;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @see LabeledComboBoxRenderer
 */
public interface Labeled {

    @JsonIgnore
    String getLabel();

}
