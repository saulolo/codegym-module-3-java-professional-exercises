package org.educatiom.lesson10_HttpClient;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpClient.Redirect;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.Authenticator;
import java.time.Duration;

public class HttpClientExample {

    //Enfoque declarativo, el mas conveniente: ya que Esta es la única forma oficial y válida de construir un HttpClient
    // en Java moderno (desde Java 11 en adelante), usando el patrón builder.

    HttpClient client = HttpClient.newBuilder()
    .version(Version.HTTP_1_1)
    .followRedirects(Redirect.NORMAL)
    .connectTimeout(Duration.ofSeconds(20))
    .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
    .authenticator(Authenticator.getDefault())
    .build();

    /*Cuando se utiliza el enfoque declarativo en el código, cambian dos cosas. En primer lugar , todos los métodos de
    clase HttpClient devuelven su propio objeto , lo que le permite organizar el código en forma de cadenas.
    */

    //Estilo clásico pero ya no soprtado des pues de java 11
    /*
    HttpClient client = HttpClient.new();
    client.setVersion(Version.HTTP_1_1);
    client.setFollowRedirects(Redirect.NORMAL);
    client.setConnectTimeout(Duration.ofSeconds(20));
    client.setProxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)));
    client.setAuthenticator(Authenticator.getDefault());

    y despues de convirtio en esto:
     HttpClient client = HttpClient.new()
    .version(Version.HTTP_1_1)
    .followRedirects(Redirect.NORMAL)
    .connectTimeout(Duration.ofSeconds(20))
    .authenticator(Authenticator.getDefault());
    */




}
