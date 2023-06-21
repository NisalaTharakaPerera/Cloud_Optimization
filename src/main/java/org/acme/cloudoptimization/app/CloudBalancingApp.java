package org.acme.cloudoptimization.app;

import org.acme.cloudoptimization.domain.CloudBalance;
import org.acme.cloudoptimization.persistence.CloudBalanceSolutionFileIO;
import org.acme.cloudoptimization.swingui.CloudBalancingPanel;
import org.acme.cloudoptimization.common.app.CommonApp;
import org.optaplanner.persistence.common.api.domain.solution.SolutionFileIO;

/**
 * For an easy example, look at {@link CloudBalancingHelloWorld} instead.
 */
import org.acme.cloudoptimization.domain.CloudBalance;
import org.acme.cloudoptimization.score.CloudBalancingConstraintProvider;
import org.acme.cloudoptimization.persistence.CloudBalancingGenerator;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.api.solver.SolverStatus;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CloudBalancingApp {

    public static final String DATA_DIR_NAME = "data";

    private Solver<CloudBalance> solver;
    private CloudBalance cloudBalance;

    public CloudBalance solve() {
        if (solver == null) {
            solver = buildSolver();
            solver.solve(cloudBalance);
        } else if (solver.isSolving()) {
            solver.terminateEarly();
        } else {
            solver.solve(cloudBalance);
        }
        return cloudBalance;
    }

    public String getSolverStatus() {
        if (solver == null) {
            return "Solver not initialized.";
        } else if (solver.isSolving()) {
            return "Solver is currently solving.";
        } else {
            return "Solver is not currently solving.";
        }
    }


    public void setCloudBalance(CloudBalance cloudBalance) {
        this.cloudBalance = cloudBalance;
        solver = null; // Reset the solver when a new problem is set
    }

    public void terminateSolver() {
        if (solver != null && solver.isSolving()) {
            solver.terminateEarly();
        }
    }

    private Solver<CloudBalance> buildSolver() {
        SolverFactory<CloudBalance> solverFactory = SolverFactory.createFromXmlResource("solverConfig.xml");
        return solverFactory.buildSolver();
    }
}

