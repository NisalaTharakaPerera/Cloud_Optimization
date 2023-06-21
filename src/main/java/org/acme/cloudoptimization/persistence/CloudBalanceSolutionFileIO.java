package org.acme.cloudoptimization.persistence;

import org.acme.cloudoptimization.domain.CloudBalance;
import org.optaplanner.persistence.jackson.impl.domain.solution.JacksonSolutionFileIO;

public class CloudBalanceSolutionFileIO extends JacksonSolutionFileIO<CloudBalance> {

    public CloudBalanceSolutionFileIO() {
        super(CloudBalance.class);
    }
}
