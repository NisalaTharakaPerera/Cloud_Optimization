package org.acme.cloudoptimization.rest;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.cloudoptimization.domain.CloudBalance;
import org.acme.cloudoptimization.app.CloudBalancingApp;

@Path("/cloud-balancing")
public class CloudBalancingResource {

    @Inject
    CloudBalancingApp cloudBalancingApp;

    @GET
    @Path("/solve")
    public CloudBalance solve() {
        return cloudBalancingApp.solve();
    }

    @GET
    @Path("/status")
    public String getStatus() {
        return "Solver status: " + cloudBalancingApp.getSolverStatus();
    }

    @POST
    @Path("/problem")
    public void setProblem(CloudBalance cloudBalance) {
        cloudBalancingApp.setCloudBalance(cloudBalance);
    }

    // Add more endpoints as needed

    @GET
    @Path("/terminate")
    public void terminateSolver() {
        cloudBalancingApp.terminateSolver();
    }
}
