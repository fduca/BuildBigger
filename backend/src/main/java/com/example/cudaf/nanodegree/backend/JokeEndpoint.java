package com.example.cudaf.nanodegree.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * Created by cudaf on 16/04/2016.
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.nanodegree.cudaf.example.com",
                ownerName = "backend.nanodegree.cudaf.example.com",
                packagePath=""
        )
)
public class JokeEndpoint {

    @ApiMethod(name="generateJoke")
    public Joke generateJoke(Joke joke){
        return joke;
    }


}
