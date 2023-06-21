package org.acme.cloudoptimization.common.persistence;

import java.io.File;

import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.acme.cloudoptimization.common.app.LoggingMain;

/**
 * @param <Solution_> the solution type, the class with the {@link PlanningSolution} annotation
 */
public abstract class AbstractSolutionExporter<Solution_> extends LoggingMain {

    public abstract String getOutputFileSuffix();

    public abstract void writeSolution(Solution_ solution, File outputFile);

    public static abstract class OutputBuilder extends LoggingMain {

    }

}
