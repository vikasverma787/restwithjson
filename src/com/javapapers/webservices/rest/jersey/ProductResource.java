package com.javapapers.webservices.rest.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class ProductResource {

	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	String id;

	ProductService productService;

	public ProductResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		productService = new ProductService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Product getProduct() {
		Product product = productService.getProduct(id);
		return product;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public Product getProductAsHtml() {
		Product product = productService.getProduct(id);
		return product;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putProduct(JAXBElement<Product> productElement) {
		Product product = productElement.getValue();
		Response response;
		if (productService.getProducts().containsKey(product.getId())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		productService.createProduct(product);
		return response;
	}

	@DELETE
	public void deleteProduct() {
		productService.deleteProduct(id);
	}

}