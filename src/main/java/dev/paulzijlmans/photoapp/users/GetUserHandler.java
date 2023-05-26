package dev.paulzijlmans.photoapp.users;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.JsonObject;

import java.util.Map;

public class GetUserHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        Map<String, String> pathParamaters = input.getPathParameters();
        String userId = pathParamaters.get("userId");

        JsonObject returnValue = new JsonObject();
        returnValue.addProperty("firstName", "John");
        returnValue.addProperty("lastName", "Snow");
        returnValue.addProperty("is", userId);

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.withStatusCode(200).withBody(returnValue.toString());

        return response;
    }
}
