package org.donstu;

import org.donstu.async.Company;
import org.donstu.async.GetCompanyListResponse;
import org.donstu.async.HhService;
import org.donstu.async.HhService_Service;
import org.donstu.handler.HhAsyncHandler;

import javax.xml.namespace.QName;
import javax.xml.ws.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ServiceClientAsync {
    private static final QName FQDN = new QName("https://donstu.org/hh", "HhService");

    private static URL getWsdlUrl(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public void processCompanyList(URL url) {
        HhService_Service svc = new HhService_Service(url, FQDN);
        HhService port = svc.getHhPort();
        Response<GetCompanyListResponse> response = port.getCompanyListAsync();

        while (!response.isDone()) {
            System.out.println("Pooling the result...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            List<Company> companies = response.get().getReturn();
            companies.forEach(company -> System.out.println("Company{" +
                    "name='" + company.getName() + '\'' +
                    ", description='" + company.getDescription() + '\'' +
                    ", address='" + company.getAddress() + '\'' +
                    ", phone='" + company.getPhoneNumber() + '\'' +
                    '}'));
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void processCompanyListCallback(URL url) {
        HhService_Service svc = new HhService_Service(url, FQDN);
        HhService port = svc.getHhPort();
        HhAsyncHandler handler = new HhAsyncHandler();
        Future<?> response = port.getCompanyListAsync(handler);
        try {
            Thread.sleep(5000);
            System.out.println("Waited 5s");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        URL wsdlUrl = getWsdlUrl("http://127.0.0.1:8088/hh?wsdl");
        ServiceClientAsync client = new ServiceClientAsync();
        client.processCompanyList(wsdlUrl);
        client.processCompanyListCallback(wsdlUrl);
    }
}
