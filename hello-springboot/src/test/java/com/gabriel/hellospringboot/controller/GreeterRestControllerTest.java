package com.gabriel.hellospringboot.controller;

import com.gabriel.hellospringboot.model.BackendDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.springframework.web.client.RestTemplate;

public class GreeterRestControllerTest {

    /*
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private GreeterRestController controller;
    private RestTemplate mockedRestTemplate;
    private String mockedSaying;
    private String mockedBackendServiceHost;
    private int mockedBackEndServicePort;

    @Before
    public void setUp() {
        this.controller = new GreeterRestController();
        this.mockedRestTemplate = PowerMockito.mock(RestTemplate.class);
        this.mockedSaying = "Test Saying";
        this.mockedBackEndServicePort = 8080;
        this.mockedBackendServiceHost = "Test Host";

        Whitebox.setInternalState(this.controller, "restTemplate", this.mockedRestTemplate);
    }

    @Test
    public void deveRetornarMensagemAmigavelQuandoAlgumaExceptionForLancada() {
        this.exception.expect(Exception.class);
        this.exception.expectMessage("error on calling backend Service");

        PowerMockito.when(this.mockedRestTemplate.getForObject(Mockito.anyString(), Mockito.any(), Mockito.anyInt())).thenThrow(Exception.class);

        this.controller.greeting();
    }

    @Test
    public void deveRetornarMensagemBaseadoNoIpENaMensagemGreetingRecebidaNoPath() {
        BackendDTO response = new BackendDTO();
        response.setGreeting(this.mockedSaying);
        response.setIp("192.168.0.1");
        response.setTime(123123);
        PowerMockito.doReturn(response).when(this.mockedRestTemplate).getForObject(Mockito.anyString(), Mockito.any(), Mockito.anyInt());
        this.controller.setBackendServicePort(8080);
        this.controller.setBackendServiceHost("localhost");


        String expectedReturn = response.getGreeting() + " at host " + response.getIp();


        Assert.assertEquals(expectedReturn, this.controller.greeting());


    }
    */

}