package com.sag.fin.wealthmgmt;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import spark.Route;

@SwaggerDefinition(host = "localhost:4567", //
info = @Info(description = "API For Managing Investment , Retirement and Private WealthManagmeent.", //
version = "V1.0", //
title = "SAG Investment Banking", //
contact = @Contact(name = "info@softwareag.com", url = "http://www.softwareag.com") ) , //
schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS }, //
consumes = { "application/json" }, //
produces = { "application/json" }, //
tags = { @Tag(name = "swagger") })
public class Application {
	public static final String APP_PACKAGE = "com.sag.fin.wealthmgmt";

	public static void main(String[] args) {

		try {
			// Quite unsafe!
			before(new CorsFilter());
			new OptionsController();

			// Scan classes with @Api annotation and add as routes
			RouteBuilder.setupRoutes(APP_PACKAGE);

			// Build swagger json description
			final String swaggerJson = SwaggerParser.getSwaggerJson(APP_PACKAGE);
			get("/swagger", (req, res) -> {
				return swaggerJson;
			});

		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

}
