package com.sag.fin.wealthmgmt.route;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import spark.Request;
import spark.Response;
import spark.Route;

import com.sag.fin.wealthmgmt.core.UserMgmt;
import com.sag.fin.wealthmgmt.model.*;
@Api
@Path("/user/{id}")
@Produces("application/json")

public class GetUser implements Route {
	@GET
	@ApiOperation(value = "Get User Profile", nickname = "GetUserRoute")
	@ApiImplicitParams({ //
			@ApiImplicitParam(required = true, dataType = "string", name = "id", paramType = "path") //
	}) //
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=User.class), //
			@ApiResponse(code = 400, message = "Invalid input data", response=ApiError.class), //
			@ApiResponse(code = 401, message = "Unauthorized", response=ApiError.class), //
			@ApiResponse(code = 404, message = "User not found", response=ApiError.class) //
	})
	public String handle(@ApiParam(hidden = true) Request request, @ApiParam(hidden = true) Response response) throws Exception {
		return UserMgmt.getInstance().getUser(request);
	}
	

}