package org.cyclops.integratedrest.http.request.handler;

import com.google.gson.JsonObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.cyclops.integratedrest.api.http.request.IRequestHandler;
import org.cyclops.integratedrest.json.JsonUtil;

/**
 * The default request handler for the index page.
 * @author rubensworks
 */
public class IndexRequestHandler implements IRequestHandler {
    @Override
    public HttpResponseStatus handle(String[] path, HttpRequest request, JsonObject responseObject) {
        if (path.length > 0) {
            return HttpResponseStatus.NOT_FOUND;
        }

        responseObject.addProperty("elements", JsonUtil.absolutizePath("element"));
        responseObject.addProperty("networks", JsonUtil.absolutizePath("network"));
        responseObject.addProperty("parts", JsonUtil.absolutizePath("registry/part"));
        responseObject.addProperty("aspects", JsonUtil.absolutizePath("registry/aspect"));
        responseObject.addProperty("valueTypes", JsonUtil.absolutizePath("registry/value"));
        responseObject.addProperty("items", JsonUtil.absolutizePath("registry/item"));
        responseObject.addProperty("blocks", JsonUtil.absolutizePath("registry/block"));
        responseObject.addProperty("fluids", JsonUtil.absolutizePath("registry/fluid"));
        responseObject.addProperty("mods", JsonUtil.absolutizePath("registry/mod"));

        return HttpResponseStatus.OK;
    }
}
