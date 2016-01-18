/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.matthiasko.myapplication.backend;

import com.example.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.matthiasko.example.com",
    ownerName = "backend.myapplication.matthiasko.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    @ApiMethod(name = "loadJoke")
    public MyBean loadJoke(@Named("name") String name) {
        MyBean response = new MyBean();

        Joker myJoker = new Joker();

        String joke = myJoker.getJoke();

        response.setData(joke);

        return response;
    }

}
