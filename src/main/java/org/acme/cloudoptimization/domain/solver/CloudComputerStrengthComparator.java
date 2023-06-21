package org.acme.cloudoptimization.domain.solver;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

import java.util.Collections;
import java.util.Comparator;

import org.acme.cloudoptimization.domain.CloudComputer;

public class CloudComputerStrengthComparator implements Comparator<CloudComputer> {

    private static final Comparator<CloudComputer> COMPARATOR = comparingInt(CloudComputer::getMultiplicand)
            .thenComparing(Collections.reverseOrder(comparing(CloudComputer::getCost))) // Descending (but this is debatable)
            .thenComparingLong(CloudComputer::getId);

    @Override
    public int compare(CloudComputer a, CloudComputer b) {
        return COMPARATOR.compare(a, b);
    }
}
