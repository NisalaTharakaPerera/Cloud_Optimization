package org.acme.cloudoptimization.domain.solver;

import java.util.Comparator;

import org.acme.cloudoptimization.domain.CloudProcess;

public class CloudProcessDifficultyComparator implements Comparator<CloudProcess> {

    private static final Comparator<CloudProcess> COMPARATOR = Comparator.comparingInt(CloudProcess::getRequiredMultiplicand)
            .thenComparingLong(CloudProcess::getId);

    @Override
    public int compare(CloudProcess a, CloudProcess b) {
        return COMPARATOR.compare(a, b);
    }

}
