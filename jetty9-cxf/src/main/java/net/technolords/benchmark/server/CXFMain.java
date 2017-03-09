package net.technolords.benchmark.server;

import java.io.IOException;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.technolords.benchmark.server.api.CountriesResource;

public class CXFMain {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public void configureAndRun() throws InterruptedException, IOException {
        LOGGER.info("Starting server...");
        JAXRSServerFactoryBean jaxrsServerFactoryBean = new JAXRSServerFactoryBean();
        this.configureFactory(jaxrsServerFactoryBean);
        Server server = jaxrsServerFactoryBean.create();
        server.start();
    }

    private void configureFactory(JAXRSServerFactoryBean jaxrsServerFactoryBean) throws IOException {
        jaxrsServerFactoryBean.setResourceClasses(CountriesResource.class);
        jaxrsServerFactoryBean.setAddress("http://localhost:9090/");
    }

    public static void main(String[] args) throws Exception {
        CXFMain cxfMain = new CXFMain();
        cxfMain.configureAndRun();
    }

}
