package org.springframework.cloud.servicebroker.controller;

import org.junit.Before;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.fixture.ServiceInstanceBindingFixture;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class ServiceInstanceBindingIntegrationTest extends ControllerIntegrationTest {
	protected UriComponentsBuilder uriBuilder;

	protected CreateServiceInstanceBindingRequest createRequest;
	protected DeleteServiceInstanceBindingRequest deleteRequest;

	@Before
	public void setupBase() {
		uriBuilder = UriComponentsBuilder.fromPath("/v2/service_instances/")
				.pathSegment("service-instance-one-id", "service_bindings");

		createRequest = ServiceInstanceBindingFixture.buildCreateAppBindingRequest();

		deleteRequest = ServiceInstanceBindingFixture.buildDeleteServiceInstanceBindingRequest();
	}

	protected String buildUrl(CreateServiceInstanceBindingRequest request) {
		return uriBuilder.path(request.getBindingId()).toUriString();
	}

	protected String buildUrl(DeleteServiceInstanceBindingRequest request) {
		return uriBuilder.path(request.getBindingId())
				.queryParam("service_id", request.getServiceDefinitionId())
				.queryParam("plan_id", request.getPlanId())
				.toUriString();
	}
}
